package com.dzj.house.service;

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
}
