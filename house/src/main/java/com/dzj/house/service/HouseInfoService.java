package com.dzj.house.service;

import java.util.List;

import com.dzj.house.Exception.HouseInfoException;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.HousePicture;
import com.dzj.house.entity.HouseSubscribe;

public interface HouseInfoService {

	/**
	 * 添加房源信息
	 * @throws HouseInfoException
	 */
	public void addHouseInfo(House house,HouseDetail houseDetail) throws HouseInfoException;
	
	/**
	 * 添加房屋图片
	 * @param housePicture
	 */
	public void addHousePicture(List<HousePicture> housePictureList) throws HouseInfoException ;
}
