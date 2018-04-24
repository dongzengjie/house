package com.dzj.house.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.HousePicture;
import com.dzj.house.entity.HouseSubscribe;

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
	
	@Test
	public void test() {
		/*House house =new House();
		house.setTitle("ddddd");
		house.setTotalFloor(12);
		houseDao.insertHouse(house);
		
		HouseDetail houseDetail =new HouseDetail();
		houseDetail.setHouseId(house.getHouseId());
		houseDetail.setAddress("assa");
		houseDetailDao.insertHouseDetail(houseDetail);
		
		HouseSubscribe houseSubscribe =new HouseSubscribe();
		houseSubscribe.setHouseId(house.getHouseId());
		houseSubscribe.setCreateTime(new Date());
		
		houseSubScribleDao.insertHouseSubScrible(houseSubscribe);
		
		HousePicture housePicture =new HousePicture();
		housePicture.setHouseId(house.getHouseId());
		housePicture.setPath("sasasa");
		
		housePictureDao.insertHousePicture(housePicture);*/
		
/*		HousePicture housePicture =new HousePicture();
		housePicture.setLocation("asas");
		
		HousePicture housePicture1 =new HousePicture();
		housePicture1.setLocation("asas");
		
		HousePicture housePicture2 =new HousePicture();
		housePicture2.setLocation("asas");
		
		List<HousePicture> list =new ArrayList<>();
		list.add(housePicture);
		list.add(housePicture1);
		list.add(housePicture2);
		
		housePictureDao.insertHousePicture(list);*/
		
	}
}
