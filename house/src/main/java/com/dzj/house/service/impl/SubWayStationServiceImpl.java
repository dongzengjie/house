package com.dzj.house.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dzj.house.dao.SubWayStationDao;
import com.dzj.house.entity.SubwayStation;
import com.dzj.house.service.SubWayStationService;

@Service
public class SubWayStationServiceImpl implements SubWayStationService {

	@Autowired
	private SubWayStationDao subWayStationDao;
	
	public List<SubwayStation> getSubWayStationByStationId(long subWayId) {
		// TODO Auto-generated method stub
		return subWayStationDao.getSubWayStationByStationId(subWayId);
	}

}
