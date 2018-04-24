package com.dzj.house.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.House;
@Mapper
public interface HouseDao {
	
	/**
	 * 添加房屋信息
	 * @param house
	 * @return
	 */
	int insertHouse(House house);
}
