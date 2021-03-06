package com.dzj.house.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
import com.dzj.house.redis.RedisService;
import com.dzj.house.service.UserService;
import com.dzj.house.util.UUIDUtil;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RedisService redisService;
	
	public static final String  COOKIER_TOKEN="token_cookier";
	
	private static final int OVER_TIME=1800;
	
	
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

	@Override
	public String addUserToRedis(HttpServletResponse response, User user) {
		String token = UUIDUtil.getUUID();
		addCookier(token, response,user);
		return token;
	}
	
	private void addCookier(String token , HttpServletResponse response,User user) {
		redisService.setObjectValue(token, user, OVER_TIME);
		
		Cookie cookie =new Cookie(COOKIER_TOKEN, token);
		cookie.setMaxAge(OVER_TIME);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	@Override
	public User getUserByTokenFromRedis(HttpServletResponse response, String token) {
	
		if(token.isEmpty()) {
			return null;
		}
		User user =redisService.getObjectValue(token, User.class);
		/**
		 * 延长cookier的有效时间
		 */
		if(user != null) {
			addCookier(token, response, user);;
		}
		
		return user;
	}

}
