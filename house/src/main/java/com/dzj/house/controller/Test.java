package com.dzj.house.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dzj.house.entity.User;
import com.dzj.house.service.UserService;
import com.dzj.house.util.ImageUtil;


@RestController
@RequestMapping(value="/test")
public class Test {
	@Autowired
	private UserService userserver;
	
	@PostMapping(value="/upload", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public void test(@RequestParam("file") MultipartFile file) {
	
		System.out.println("成功进入");
		try {
			ImageUtil.uploadImage(file.getInputStream(), file.getOriginalFilename(), 1L);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@GetMapping(value="/redis")
	public String test12(HttpServletResponse response) {
		User user =new User();
		user.setUserId(1l);
		user.setName("test");
		String token =userserver.addUserToRedis(response, user);
		User user1 =userserver.getUserByTokenFromRedis(response, token);
		System.out.println(user1.getName());
		
		return 	userserver.addUserToRedis(response, user);
		
	}
	
	
}
