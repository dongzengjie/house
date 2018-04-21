package com.dzj.house.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.dzj.house.security.AuthProvider;
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	/**
	 * http权限控制
	 */
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/toLogin").permitAll()
			.antMatchers("/user/toLogin").permitAll()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
			.and()
			.formLogin()
			.loginProcessingUrl("/login")	
			.and();
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		
	}
	
	/**
	 * 自定义策略
	 * @throws Exception 
	 */
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider()).eraseCredentials(true);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public AuthProvider authProvider() {
		return new AuthProvider();
	}
}
