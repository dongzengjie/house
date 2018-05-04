package com.dzj.house.controller.front;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzj.house.dao.HouseDao;
import com.dzj.house.dto.FrontHouseListDto;
import com.dzj.house.dto.RegionAndSubwayDto;
import com.dzj.house.dto.RentDto;
import com.dzj.house.dto.SearchDto;
import com.dzj.house.enums.ResultEnum;
import com.dzj.house.response.ResponseResult;
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
	
	@GetMapping(value="/getregionandsubway/{cityEnName}")
	public ResponseResult<RegionAndSubwayDto> getRegionAndSubway(@PathVariable("cityEnName") String cityEnName){
		
		RegionAndSubwayDto dto =new RegionAndSubwayDto();
		
		dto.setSupportAddresseList(supportAddressService.getRegion(cityEnName));
		dto.setSubwayList(subWayService.getSubWayByCityName(cityEnName));
		return new ResponseResult<RegionAndSubwayDto>(dto, ResultEnum.SUCCESS);
		
	}
	
	@GetMapping(value="/gethouselist")
	public void getHouseList(HttpServletRequest request,RentDto rentDto) {
		
		SearchDto searchDto =RentDtoChangeUtil.change(rentDto);
	
	}
}
