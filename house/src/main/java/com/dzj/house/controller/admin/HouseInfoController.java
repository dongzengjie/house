package com.dzj.house.controller.admin;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dzj.house.dao.HouseDao;
import com.dzj.house.dto.HouseDto;
import com.dzj.house.dto.HouseResponseDto;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.HousePicture;
import com.dzj.house.entity.User;
import com.dzj.house.enums.ResultEnum;
import com.dzj.house.response.ResponseResult;
import com.dzj.house.service.HouseInfoService;
import com.dzj.house.util.ImageUtil;


@RestController
@RequestMapping(value = "/admin")
public class HouseInfoController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private HouseInfoService houseInfoService;
	
	

	@PostMapping(value = "/addHouseInfo")
	public ResponseResult addHouseInfo(User user, @RequestBody HouseDto houseDto) {

		/*
		 * User user =new User(); user.setUserId(1l);
		 */

		House house = modelMapper.map(houseDto, House.class);
		HouseDetail houseDetail = modelMapper.map(houseDto, HouseDetail.class);
		houseInfoService.addHouseInfo(house, houseDetail, user);

		return new ResponseResult(ResultEnum.SUCCESS);

	}
	@GetMapping(value="/gethousedto/{houseId}")
	public ResponseResult<HouseDto> getHouseDtoByHouseId(User user ,@PathVariable("houseId")long houseId){
		HouseDto houseDto = houseInfoService.queryHouseDtoByHouseId(houseId, user);

		return new ResponseResult<HouseDto>(houseDto, ResultEnum.SUCCESS);
		
	}

	@GetMapping(value = "/gethouseinfo/{pageIndex}/{pageSize}")
	public ResponseResult<HouseResponseDto> getHouseInfo(@PathVariable("pageIndex") int pageIndex,
			@PathVariable("pageSize") int pageSize,User user) {
		
		HouseResponseDto houseResponseDto =houseInfoService.getHouseAndPictureList(pageIndex, pageSize,user.getUserId());
		
		return new ResponseResult<HouseResponseDto>(houseResponseDto, ResultEnum.SUCCESS);

	}
	
	
	@PostMapping(value="/addhousepicture", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public void addhousepicture(@RequestParam("file") MultipartFile file,HttpServletRequest request,User user) {
		String houseId=request.getParameter("houseId");
		
		
		HousePicture housePicture =new HousePicture();
		housePicture.setHouseId(Long.valueOf(houseId));
		houseInfoService.addHousePicture(housePicture, file,user);

	}
	
	
	@PostMapping(value="/frontpicture", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public void frontpicture(@RequestParam("file") MultipartFile file,HttpServletRequest request,User user) {
		String houseId=request.getParameter("houseId");
		System.out.println("进入");
		houseInfoService.updateFrontPicture(file, Long.parseLong(houseId), user);
	}
	
	
	@GetMapping(value="/getpicturelist/{houseId}")
	public ResponseResult<List<HousePicture>> getHousePictureList(@PathVariable long houseId){
		List<HousePicture> housePictures =houseInfoService.getPictureListByhouseId(houseId);
		
		
		return new ResponseResult<List<HousePicture>>(housePictures, ResultEnum.SUCCESS);
		
	}
	/**
	 * 更新房源信息
	 * @param user
	 * @param houseDto
	 */
	@PostMapping(value="/updatehouse")
	public void updateHouseInfo(User user,@RequestBody HouseDto houseDto) {
	
	}
	/**
	 * 更新状态
	 * @param user
	 * @param houseDto
	 */
	@PostMapping(value="/updatehousestatus")
	public ResponseResult updateHouseStatus(User user,@RequestBody House house) {
		houseInfoService.updateHouseStatus(user.getUserId(), house);
		return new ResponseResult<>(ResultEnum.SUCCESS);
	}
	
	
}
