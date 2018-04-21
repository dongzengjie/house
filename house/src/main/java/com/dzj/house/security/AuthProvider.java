package com.dzj.house.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.dzj.house.Exception.LoginException;
import com.dzj.house.entity.User;
import com.dzj.house.enums.LoginEnum;
import com.dzj.house.service.UserService;

/**
 * 自定义认证实现
 * @author DZJ
 *
 */
public class AuthProvider implements AuthenticationProvider {


	@Autowired
	private UserService userService;
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		User user = userService.getUserByName(userName);
		if(password.equals(user.getPassword())) {
			user.getAuthorities();
			return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		}
		throw new LoginException(LoginEnum.PASSWORD_ERROR);
	
	}


	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
