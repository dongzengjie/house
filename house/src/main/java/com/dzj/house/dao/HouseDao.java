package com.dzj.house.dao;

import java.util.List;

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
	
	/**
	 * 查询所有房屋信息通过用户id
	 * @return
	 */
	List<House> queryAllHouseByUserId(long userId);
}
