package com.dzj.house.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.HouseDetail;

@Mapper
public interface HouseDetailDao {

	int insertHouseDetail(HouseDetail houseDetail);
}
