package com.dzj.house.security;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.dzj.house.entity.User;
import com.dzj.house.service.UserService;

/**
 * 登陆成功 根据角色跳转页面
 * @author DZJ
 *
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	public LoginSuccessHandler() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private UserService userService;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User userdetail = (User) authentication.getPrincipal();
		
		User user = new User();
		user.setName(userdetail.getName());
		user.setPassword(userdetail.getPassword());
		user.setUserId(userdetail.getUserId());
		user.setPhoneNumber(userdetail.getPhoneNumber());
		user.setStatus(userdetail.getStatus());
		
		
		userService.addUserToRedis(response, user);
		
		String successUrl = determineTargetUrl(authentication);
		super.setDefaultTargetUrl(successUrl);
		super.onAuthenticationSuccess(request, response, authentication);
	}

	 protected String determineTargetUrl(Authentication authentication) {  
	        boolean isUser = false;  
	        boolean isAdmin = false;  
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();  
	        for (GrantedAuthority grantedAuthority : authorities) {  
	            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {  
	                isUser = true;  
	                break;  
	            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {  
	                isAdmin = true;  
	                break;  
	            }  
	        }  
	   
	        if (isUser) {  
	            return "/user/front/index.html";  
	        } else if (isAdmin) {  
	            return "/admin/toCenter";  
	        } else {  
	            throw new IllegalStateException();  
	        }  
	    }  
	   
	
}
