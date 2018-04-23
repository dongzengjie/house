package com.dzj.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzj.house.dao.SubWayDao;
import com.dzj.house.entity.Subway;
import com.dzj.house.service.SubWayService;
@Service
public class SubWayServiceImpl implements SubWayService{

	@Autowired
	private SubWayDao subWayDao;
	
	@Override
	public List<Subway> getSubWayByCityName(String cityEnName) {
		
		return subWayDao.getSubWayByCityName(cityEnName);
	}

}
