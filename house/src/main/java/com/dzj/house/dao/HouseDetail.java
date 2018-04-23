package com.dzj.house.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseDetail {

	int insertHouseDetail(HouseDetail houseDetail);
}
