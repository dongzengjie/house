package com.dzj.house.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dzj.house.dao.HouseDao;
import com.dzj.house.dao.HouseDetailDao;
import com.dzj.house.dto.RentDto;
import com.dzj.house.dto.SearchDto;
import com.dzj.house.elasticSearch.HouseIndex;
import com.dzj.house.elasticSearch.SearchService;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.User;
import com.dzj.house.enums.HouseStatusEnum;
import com.dzj.house.service.UserService;
import com.dzj.house.util.ImageUtil;


@RestController
@RequestMapping(value="/test")
public class Test {
	@Autowired
	private UserService userserver;
	@Autowired
	private SearchService searchService;
	@Autowired
	private HouseDao houseDao;
	
	@Autowired
	private HouseDetailDao houseDetailDao;

	@PostMapping(value="/upload", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public void test(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		String username=request.getParameter("houseId");
		//String username=(String) request.getAttribute("username");
		System.out.println(username);
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
	@GetMapping(value="/info")
	public void test(HttpServletRequest request) {
		//searchService.index(12L);
		//searchService.remove(12l);
		SearchDto dto =new SearchDto();
		dto.setCityEnName("sh");
		dto.setOrderBy(HouseIndex.LAST_UPDATE_TIME);
		dto.setOrderDirection("desc");
		dto.setRegionEnName("PudongNewArea");
		dto.setStart(0);
		dto.setSize(10);
		List<Long> as = searchService.query(dto);
		for (Long long1 : as) {
			System.out.println(long1);
		}
	}
	@GetMapping(value="/house")
	public void testhouse() {
		House house =new House();
		house.setArea(55);
		house.setHouseId(17L);
		house.setStatus(HouseStatusEnum.UNDER.getCode());
		int i =houseDao.updateHouse(house, 1l);
		System.out.println(i);
	}
	
	@GetMapping(value="/housedetail")
	public void testhousedetail() {
		HouseDetail detail =new HouseDetail();
		detail.setHouseId(11l);
		//detail.setTraffic("便利");
		houseDetailDao.updateHouseDetail(detail);
	}
	
}
