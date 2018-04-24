package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.HousePicture;
@Mapper
public interface HousePictureDao {

	int insertHousePicture(List<HousePicture> housePictureList);
}
