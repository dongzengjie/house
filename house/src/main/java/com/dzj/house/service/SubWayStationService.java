package com.dzj.house.service;

import java.util.List;

import com.dzj.house.entity.SubwayStation;

public interface SubWayStationService {
	/**
	 * 根据地铁线路id获取地铁站的名称
	 * @param subWayId
	 * @return
	 */
	List<SubwayStation> getSubWayStationByStationId(long subWayId);
}
