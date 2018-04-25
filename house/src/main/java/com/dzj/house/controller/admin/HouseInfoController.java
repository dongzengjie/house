package com.dzj.house.controller.admin;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzj.house.dto.HouseDto;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.User;
import com.dzj.house.enums.ResultEnum;
import com.dzj.house.response.ResponseResult;
import com.dzj.house.service.HouseInfoService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/admin")
public class HouseInfoController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private HouseInfoService houseInfoService;

	
	@PostMapping(value="/addHouseInfo")
	public ResponseResult addHouseInfo(User user,@RequestBody HouseDto houseDto ){
		
		/*User user =new User();
		user.setUserId(1l);*/
		
		House house =modelMapper.map(houseDto, House.class);
		HouseDetail houseDetail =modelMapper.map(houseDto, HouseDetail.class);
		houseInfoService.addHouseInfo(house, houseDetail, user);
		
		return  new ResponseResult(ResultEnum.SUCCESS);
		
	}
}
