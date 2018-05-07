package com.dzj.house.service;

import java.util.List;

import com.dzj.house.Exception.HouseSearchException;
import com.dzj.house.dto.FrontHouseListDto;
import com.dzj.house.dto.HouseSearchDto;
import com.dzj.house.dto.RentDto;

public interface HouseSearchService {

	/**
	 * 根据查询条件返回相对应的数据
	 * @param rentDto
	 * @return
	 */
	HouseSearchDto searchHouseInfo(RentDto rentDto) throws HouseSearchException;
}
