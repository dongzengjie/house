package com.dzj.house.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.User;

@Mapper
public interface UserDao {

	/**
	 * 根据用户名获取用户
	 * @param name
	 * @return
	 */
	User getUserByUserName(String name);
}

