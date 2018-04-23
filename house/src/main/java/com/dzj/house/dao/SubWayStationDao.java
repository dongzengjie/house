package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.SubwayStation;

@Mapper
public interface SubWayStationDao {


	/**
	 * 根据地铁线路id获取地铁站的名称
	 * @param subWayId
	 * @return
	 */
	List<SubwayStation> getSubWayStationByStationId(long subWayId);
}
