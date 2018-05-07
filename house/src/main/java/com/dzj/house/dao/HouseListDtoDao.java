package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dzj.house.dto.HouseListDto;

@Mapper
public interface HouseListDtoDao {

	/**
	 * 获取部分房源信息和图片
	 * @return
	 */
	List<HouseListDto> getHouseListDto(@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize,@Param("userId") long userId);
	
	int getCount(long userId);
}
