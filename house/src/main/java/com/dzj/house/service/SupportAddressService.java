package com.dzj.house.service;

import java.util.List;



import com.dzj.house.entity.SupportAddress;

public interface SupportAddressService {
	
	/**
	 * 获取所有的市/省
	 * @return
	 */
	List<SupportAddress> getCity();
	
	/**
	 * 根据级别和归属 查询区县信息
	 * @param level
	 * @param belongTo
	 * @return
	 */
	List<SupportAddress> getRegion(  String belongTo);
}
