package com.dzj.house.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzj.house.Exception.HouseSearchException;
import com.dzj.house.dao.HouseDao;
import com.dzj.house.dto.FrontHouseListDto;
import com.dzj.house.dto.HouseSearchDto;
import com.dzj.house.dto.RentDto;
import com.dzj.house.dto.SearchDto;
import com.dzj.house.elasticSearch.EsResponse;
import com.dzj.house.elasticSearch.SearchService;
import com.dzj.house.enums.HouseSearchEnum;
import com.dzj.house.service.HouseSearchService;
import com.dzj.house.util.PageCalculator;
import com.dzj.house.util.RentDtoChangeUtil;

@Service
public class HouseSearchServiceImpl implements HouseSearchService {

	@Autowired
	private HouseDao houseDao;
	@Autowired
	private SearchService searchService;

	public HouseSearchDto searchHouseInfo(RentDto rentDto) throws HouseSearchException {

		int total = 0;
		HouseSearchDto houseSearchDto = new HouseSearchDto();

		SearchDto searchDto = RentDtoChangeUtil.change(rentDto);
		// int rowIndex= PageCalculator.calculatorRowindex(searchDto.getStart(),
		// searchDto.getSize());

		// 如果有关键词
		if (searchDto.getKeywords() != null && !searchDto.getKeywords().isEmpty()) {

			Map<Long, FrontHouseListDto> map = new HashMap<>();
			EsResponse esResponse = searchService.query(searchDto);
			total = esResponse.getTotal();
			if (esResponse.getHouseIds() == null || esResponse.getHouseIds().size() <= 0) {
				throw new HouseSearchException(HouseSearchEnum.HOUSE_SEARCH_ERROR);
			}
			// 根据索搜引擎查询出来的houseId集合 从mysql中去查询
			List<FrontHouseListDto> houseList = houseDao.getFrontHouseListByHouseIds(esResponse.getHouseIds());

			for (FrontHouseListDto item : houseList) {
				map.put(item.getHouseId(), item);
			}

			List<FrontHouseListDto> listDto = new ArrayList<>();
			// 排序
			for (long houseId : esResponse.getHouseIds()) {
				listDto.add(map.get(houseId));
			}

			houseSearchDto.setFrontHouseListDtoList(listDto);
			houseSearchDto.setTotal(total);
			houseSearchDto.setCityCnName(listDto.get(0).getCityCnName());
			return houseSearchDto;
		}

		List<FrontHouseListDto> frontHouseListDto = houseDao.getFrontHouseList(searchDto, searchDto.getStart(),
				searchDto.getSize());
		total = houseDao.getSearchCount(searchDto);
		if (frontHouseListDto == null) {
			throw new HouseSearchException(HouseSearchEnum.HOUSE_SEARCH_ERROR);
		}

		houseSearchDto.setFrontHouseListDtoList(frontHouseListDto);
		houseSearchDto.setTotal(total);
		houseSearchDto.setCityCnName(frontHouseListDto.get(0).getCityCnName());
		return houseSearchDto;
	}

}
