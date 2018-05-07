package com.dzj.house.controller.front;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzj.house.dao.HouseDao;
import com.dzj.house.dto.FrontHouseListDto;
import com.dzj.house.dto.HouseSearchDto;
import com.dzj.house.dto.RegionAndSubwayDto;
import com.dzj.house.dto.RentDto;
import com.dzj.house.dto.SearchDto;
import com.dzj.house.enums.ResultEnum;
import com.dzj.house.response.ResponseResult;
import com.dzj.house.service.HouseSearchService;
import com.dzj.house.service.SubWayService;
import com.dzj.house.service.SupportAddressService;
import com.dzj.house.util.RentDtoChangeUtil;

@RestController
@RequestMapping(value="/front")
public class FrontInfoController {


	
	@Autowired
	private SupportAddressService supportAddressService;
	@Autowired
	private SubWayService subWayService;
	@Autowired
	private HouseSearchService houseSearchService;
	
	@GetMapping(value="/getregionandsubway/{cityEnName}")
	public ResponseResult<RegionAndSubwayDto> getRegionAndSubway(@PathVariable("cityEnName") String cityEnName){
		
		RegionAndSubwayDto dto =new RegionAndSubwayDto();
		
		dto.setSupportAddresseList(supportAddressService.getRegion(cityEnName));
		dto.setSubwayList(subWayService.getSubWayByCityName(cityEnName));
		return new ResponseResult<RegionAndSubwayDto>(dto, ResultEnum.SUCCESS);
		
	}
	
	@GetMapping(value="/gethouselist")
	public ResponseResult<HouseSearchDto> getHouseList(RentDto rentDto) {
		HouseSearchDto  houseSearchDto = houseSearchService.searchHouseInfo(rentDto);
		return new ResponseResult<HouseSearchDto>(houseSearchDto, ResultEnum.SUCCESS);
		
	
	}
}
