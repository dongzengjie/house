package com.dzj.house.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.House;
@Mapper
public interface HouseDao {
	
	int insertHouse(House house);
}
