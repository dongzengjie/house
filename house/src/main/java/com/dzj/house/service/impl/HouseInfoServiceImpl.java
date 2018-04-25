package com.dzj.house.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzj.house.Exception.HouseInfoException;
import com.dzj.house.dao.HouseDao;
import com.dzj.house.dao.HouseDetailDao;
import com.dzj.house.dao.HousePictureDao;
import com.dzj.house.dao.HouseSubScribleDao;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.HousePicture;
import com.dzj.house.entity.HouseSubscribe;
import com.dzj.house.entity.User;
import com.dzj.house.enums.HouseInfoEnum;
import com.dzj.house.service.HouseInfoService;
@Service
public class HouseInfoServiceImpl implements HouseInfoService{

	@Autowired
	private HouseDao houseDao;
	@Autowired
	private HouseDetailDao houseDetailDao;
	@Autowired
	private HousePictureDao housePictureDao;
	@Autowired
	private HouseSubScribleDao houseSubScribleDao;
	
	@Transactional
	public void addHouseInfo(House house,HouseDetail houseDetail,User user) throws HouseInfoException {
		if(house == null) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_INFO_ERROR);
		}
		if(houseDetail ==null) {
			throw new HouseInfoException(HouseInfoEnum.HOUSEDETAIL_INFO_ERROR);
		}
		
		house.setUserId(user.getUserId());
		house.setCreateTime(new Date());
		house.setLastUpdateTime(new Date());
		int effect =houseDao.insertHouse(house);
		if(effect <= 0) {
			throw new HouseInfoException(HouseInfoEnum.INSERT_HOUSE_ERROR);
		}
		
		houseDetail.setHouseId(house.getHouseId());
		
		int houseDetailEffect = houseDetailDao.insertHouseDetail(houseDetail);
		if(houseDetailEffect <=0) {
			throw new HouseInfoException(HouseInfoEnum.INSERT_HOUSEDETAIL_INFO_ERROR);
		}
		
	}

	@Override
	public void addHousePicture(List<HousePicture> housePictureList) throws HouseInfoException {
		
		
	}

}
