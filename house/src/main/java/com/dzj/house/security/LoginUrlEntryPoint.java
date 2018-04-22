package com.dzj.house.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * 基于角色登陆入口控制器
 * 
 * @author DZJ
 *
 */
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

	private final Map<String, String> authEntryPointMap;// 登陆入口
	private final Map<String, String> authEntrySuccessPointMap;// 登陆成功入口

	private PathMatcher pathMatcher = new AntPathMatcher();

	public LoginUrlEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
		authEntryPointMap = new HashMap<>();
		authEntryPointMap.put("/user/**", "/user/login.html");// 用户登陆入口映射
		authEntryPointMap.put("/admin/**", "/admin/toLogin");// admin登陆入口映射

		authEntrySuccessPointMap = new HashMap<>();
		authEntrySuccessPointMap.put("/user/**", "/user/front/index.html");
		authEntrySuccessPointMap.put("/admin/**", "/admin/toCenter");
	}

	/**
	 * 根据请求跳转到指定的页面
	 */
	protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) {

		String uri = request.getRequestURI().replace(request.getContextPath(), "");
		for (Map.Entry<String, String> authEntry : this.authEntryPointMap.entrySet()) {
			if (this.pathMatcher.match(authEntry.getKey(), uri)) {
				return authEntry.getValue();
			}
		}

		return super.determineUrlToUseForThisRequest(request, response, exception);
	}

	protected String determineUrlToSuccess(HttpServletRequest request, HttpServletResponse response) {

		String uri = request.getRequestURI().replace(request.getContextPath(), "");
		for (Map.Entry<String, String> authEntry : this.authEntrySuccessPointMap.entrySet()) {
			if (this.pathMatcher.match(authEntry.getKey(), uri)) {
				return authEntry.getValue();
			}
		}
		return uri;

	}

}
