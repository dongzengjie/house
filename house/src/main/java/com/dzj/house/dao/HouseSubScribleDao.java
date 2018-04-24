package com.dzj.house.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.HouseSubscribe;

@Mapper
public interface HouseSubScribleDao {

	int insertHouseSubScrible(HouseSubscribe houseSubScrible);
}
