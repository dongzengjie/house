package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dzj.house.dto.FrontHouseListDto;
import com.dzj.house.dto.HouseDto;
import com.dzj.house.dto.RentDto;
import com.dzj.house.dto.SearchDto;
import com.dzj.house.elasticSearch.HouseIndexTemple;
import com.dzj.house.entity.House;
@Mapper
public interface HouseDao {
	
	/**
	 * 添加房屋信息
	 * @param house
	 * @return
	 */
	int insertHouse(House house);
	
	/**
	 * 查询所有房屋信息通过用户id
	 * @return
	 */
	List<House> queryAllHouseByUserId(long userId);
	
	House queryHouseByHouseId(@Param("houseId")long houseId,@Param("userId") long userId);
	
	List<FrontHouseListDto>  getFrontHouseList(@Param("searchDto")SearchDto searchDto,@Param("rowIndex") int rowIndex,@Param("pageSize")int pageSize);
	/**
	 * 返回查询记录数
	 * @param searchDto
	 * @return
	 */
	int getSearchCount(@Param("searchDto")SearchDto searchDto);
	
	int updateFrontPicture(@Param("path") String path,@Param("houseId") long houseId, @Param("userId") long userId);
	/**
	 * es 索引模板
	 * @param houseId
	 * @return
	 */
	HouseIndexTemple queryHouseIndexByHouseId(long houseId);
	
	/**
	 * 更新house
	 * @param house
	 * @param userId
	 * @return
	 */
	int updateHouse(@Param("house") House house,@Param("userId")long userId);
	
	/**
	 * 根据houseId集合查询
	 * @param houseIds
	 * @return
	 */
	List<FrontHouseListDto>  getFrontHouseListByHouseIds(List<Long> houseIds);
	
	HouseDto queryHouseDtoById(@Param("houseId")long houseId,@Param("userId") long userId);
}
