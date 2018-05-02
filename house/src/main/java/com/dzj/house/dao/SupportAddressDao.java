package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dzj.house.entity.SupportAddress;


@Mapper
public interface SupportAddressDao {

	/**
	 * 获取所有市/省的信息
	 * @return
	 */
	List<SupportAddress> getCity(String level);
	
	/**
	 * 根据级别和归属 查询区县信息
	 * @param level
	 * @param belongTo
	 * @return
	 */
	List<SupportAddress> getRegion(@Param("level") String level,@Param("belongTo") String belongTo);
	
	
}
