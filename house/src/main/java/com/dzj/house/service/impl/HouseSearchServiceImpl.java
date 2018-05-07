package com.dzj.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzj.house.Exception.HouseSearchException;
import com.dzj.house.dao.HouseDao;
import com.dzj.house.dto.FrontHouseListDto;
import com.dzj.house.dto.HouseSearchDto;
import com.dzj.house.dto.RentDto;
import com.dzj.house.dto.SearchDto;
import com.dzj.house.enums.HouseSearchEnum;
import com.dzj.house.service.HouseSearchService;
import com.dzj.house.util.PageCalculator;
import com.dzj.house.util.RentDtoChangeUtil;

@Service
public class HouseSearchServiceImpl implements HouseSearchService{

	@Autowired
	private HouseDao houseDao;
	
	public HouseSearchDto searchHouseInfo(RentDto rentDto) throws HouseSearchException{
		SearchDto searchDto =RentDtoChangeUtil.change(rentDto);
		//int rowIndex= PageCalculator.calculatorRowindex(searchDto.getStart(), searchDto.getSize());
		 List<FrontHouseListDto> frontHouseListDto = houseDao.getFrontHouseList(searchDto, searchDto.getStart(), searchDto.getSize());
		 int total =houseDao.getSearchCount(searchDto);
		 if(frontHouseListDto==null) {
			 throw new HouseSearchException(HouseSearchEnum.HOUSE_SEARCH_ERROR);
		 }
		 HouseSearchDto houseSearchDto =new HouseSearchDto();
		 houseSearchDto.setFrontHouseListDtoList(frontHouseListDto);
		 houseSearchDto.setTotal(total);
		 houseSearchDto.setCityCnName(frontHouseListDto.get(0).getCityCnName());
		return houseSearchDto;
	}

}
