package com.dzj.house.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.dzj.house.Exception.LoginException;
import com.dzj.house.dao.RoleDao;
import com.dzj.house.dao.UserDao;

import com.dzj.house.entity.Role;
import com.dzj.house.entity.User;
import com.dzj.house.enums.LoginEnum;
import com.dzj.house.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	public User getUserByName(String name) throws LoginException {
		User user = userDao.getUserByUserName(name);
		if(user == null) {
			throw new LoginException(LoginEnum.USER_NULL);
		}
		
		List<Role> roles =roleDao.getRoleByUserId(user.getUserId());
		if(roles == null || roles.isEmpty()) {
			throw new LoginException(LoginEnum.SECURITY_ILLEGAL);
		}
		List<GrantedAuthority> authorities =new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
			
		}
		user.setAuthorityList(authorities);
		return user;
	}

}
