package com.dzj.house.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.dzj.house.entity.User;
import com.dzj.house.service.UserService;
import com.dzj.house.service.impl.UserServiceImpl;
@Service
public class UserArgementResolver implements HandlerMethodArgumentResolver {

	@Autowired
	private UserService userService;
	
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz= parameter.getParameterType();
		return clazz == User.class;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request =webRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		String requestToken = request.getParameter(UserServiceImpl.COOKIER_TOKEN);
		String cookieToken = getCookieToken(request, UserServiceImpl.COOKIER_TOKEN);
		String token = StringUtils.isEmpty(requestToken)?cookieToken:requestToken;
		
		return userService.getUserByTokenFromRedis(response, token);
	}
	
	private String getCookieToken(HttpServletRequest request,String key ) {
		
		Cookie [] cookie = request.getCookies();
		if(cookie ==null || cookie.length <=0) {
			return null;
		}
		
		for (Cookie cookieInfo : cookie) {
			if(cookieInfo.getName().equals(key)) {
				return cookieInfo.getValue();
			}
		}
		return null;
		
	}

}
