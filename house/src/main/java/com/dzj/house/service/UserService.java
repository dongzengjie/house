package com.dzj.house.service;

import javax.servlet.http.HttpServletResponse;

import com.dzj.house.Exception.LoginException;
import com.dzj.house.entity.User;

public interface UserService {
	/**
	 * 根据登录名获取用户信息
	 * @param name
	 * @return
	 * @throws LoginException
	 */
	public User getUserByName(String name) throws LoginException;
	
	/**
	 * 将用户信息加入redis中
	 * @return
	 */
	public String addUserToRedis(HttpServletResponse response,User user);
	
	/**
	 * 根据Token从redis中获取user信息
	 * @param response
	 * @param token
	 * @return
	 */
	public User getUserByTokenFromRedis(HttpServletResponse response,String token);
}
