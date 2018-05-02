package com.dzj.house.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserserviceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		String aa="dnhkasakshkd";
		String bb="casawa";
		System.out.println(aa.charAt(0)==bb.charAt(0));
	}
	
}
