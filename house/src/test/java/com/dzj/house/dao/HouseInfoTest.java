package com.dzj.house.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dzj.house.dto.HouseDto;
import com.dzj.house.dto.HouseListDto;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.HousePicture;
import com.dzj.house.entity.HouseSubscribe;
import com.dzj.house.enums.HouseStatusEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseInfoTest {
	@Autowired
	private HouseDao houseDao;
	@Autowired
	private HouseDetailDao houseDetailDao;
	@Autowired
	private HouseSubScribleDao houseSubScribleDao;
	@Autowired
	private HousePictureDao housePictureDao;
	@Autowired
	private HouseListDtoDao houseListDtoDao;
	@Test
	public void test() {
		
		
		House house =new House();
		house.setArea(55);
		house.setHouseId(17L);
		house.setStatus(HouseStatusEnum.UNDER.getCode());
		int i =houseDao.updateHouse(house, 1l);
		System.out.println(i);
		
	}
}
