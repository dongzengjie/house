package com.dzj.house.service;

import java.util.List;

import com.dzj.house.entity.Subway;

public interface SubWayService {

	/**
	 * 获取城市对应的地铁线路
	 * @param cityEnName
	 * @return
	 */
	List<Subway> getSubWayByCityName(String cityEnName);
}
