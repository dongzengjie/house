package com.dzj.house.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dzj.house.entity.HouseDetail;

@Mapper
public interface HouseDetailDao {

	int insertHouseDetail(HouseDetail houseDetail);
	
	/**
	 * 更新房屋详情
	 * @param houseDetail
	 * @return
	 */
	int updateHouseDetail(@Param("houseDetail")HouseDetail houseDetail);
	/**
	 * 根据id查询房屋详细信息
	 * @param houseId
	 * @return
	 */
	HouseDetail queryHouseDetailByHouseId(long houseId);
}
