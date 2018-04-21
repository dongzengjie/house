package com.dzj.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dzj.house.entity.Role;

@Mapper
public interface RoleDao {

	/**
	 * 根据用户id获取角色
	 * @param userId
	 * @return
	 */
	List<Role> getRoleByUserId(Long userId);
}
