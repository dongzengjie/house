package com.dzj.house.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dzj.house.entity.SupportAddress;
import com.dzj.house.enums.CityLevel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDaoTest {

	@Autowired
	private SupportAddressDao supportAddressDao;
	@Test
	public void getinfo() {
		List<SupportAddress> listaddress = supportAddressDao.getCity(CityLevel.CITY.getLevel());
		for (SupportAddress supportAddress : listaddress) {
			System.out.println(supportAddress.getCityCnName());
			
		}
		
		List<SupportAddress> addresses =supportAddressDao.getRegion(CityLevel.REGION.getLevel(), "sh");
		for (SupportAddress supportAddress : addresses) {
			System.out.println(supportAddress.getCityCnName());
		}
	}
}
