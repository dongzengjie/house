package com.dzj.house.controller.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzj.house.dto.HouseDto;
import com.dzj.house.entity.User;
import com.dzj.house.response.ResponseResult;

@RestController
@RequestMapping(value = "/admin")
public class HouseInfoController {

	@PostMapping(value="/addHouseInfo")
	public ResponseResult<String> addHouseInfo(User user, @RequestBody HouseDto houseDto){
		System.out.println(user.getName());
		return  new ResponseResult<String>("assa", 1221);
		
	}
}
