package com.dzj.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzj.house.dao.SupportAddressDao;
import com.dzj.house.entity.SupportAddress;
import com.dzj.house.enums.CityLevel;
import com.dzj.house.service.SupportAddressService;
@Service
public class SupportAddressServiceImpl implements SupportAddressService{

	@Autowired
	private SupportAddressDao supportAddressDao;
	
	public List<SupportAddress> getCity() {
		
		return supportAddressDao.getCity(CityLevel.CITY.getLevel());
	}

	public List<SupportAddress> getRegion(String belongTo) {
		
		return supportAddressDao.getRegion(CityLevel.REGION.getLevel(), belongTo);
	}

}
