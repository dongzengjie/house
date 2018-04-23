package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.Subway;

@Mapper
public interface SubWayDao {
	
	/**
	 * 获取城市对应的地铁线路
	 * @param cityEnName
	 * @return
	 */
	List<Subway> getSubWayByCityName(String cityEnName);
}
