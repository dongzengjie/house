package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.HousePicture;
@Mapper
public interface HousePictureDao {

	/**
	 * 批量添加
	 * @param housePictureList
	 * @return
	 */
	int insertHousePicture(List<HousePicture> housePictureList);
	
	int addHousePicture(HousePicture housePicture);
	
	/**
	 * 根据房屋id获取图片列表
	 * @param houseId
	 * @return
	 */
	List<HousePicture> getPictureListByhouseId(long houseId);
}
