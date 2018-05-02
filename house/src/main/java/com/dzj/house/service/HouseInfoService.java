package com.dzj.house.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dzj.house.Exception.HouseInfoException;
import com.dzj.house.dto.HouseResponseDto;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.HousePicture;
import com.dzj.house.entity.HouseSubscribe;
import com.dzj.house.entity.User;

public interface HouseInfoService {

	/**
	 * 添加房源信息
	 * @throws HouseInfoException
	 */
	public void addHouseInfo(House house,HouseDetail houseDetail,User user) throws HouseInfoException;
	
	/**
	 * 添加房屋图片
	 * @param housePicture
	 */
	public void addHousePicture(HousePicture housePicture,MultipartFile file,User user) throws HouseInfoException ;
	
	/**
	 * 返回房屋，图片信息
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	HouseResponseDto getHouseAndPictureList(int pageIndex,int pageSize,long userId) throws HouseInfoException;
	
	
	List<HousePicture> getPictureListByhouseId(long houseId);
}
