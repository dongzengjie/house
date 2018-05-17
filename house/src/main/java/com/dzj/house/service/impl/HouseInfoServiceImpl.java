package com.dzj.house.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.sql.PagerUtils;
import com.dzj.house.Exception.HouseInfoException;
import com.dzj.house.dao.HouseDao;
import com.dzj.house.dao.HouseDetailDao;
import com.dzj.house.dao.HouseListDtoDao;
import com.dzj.house.dao.HousePictureDao;
import com.dzj.house.dao.HouseSubScribleDao;
import com.dzj.house.dto.HouseListDto;
import com.dzj.house.dto.HouseResponseDto;
import com.dzj.house.elasticSearch.SearchService;
import com.dzj.house.entity.House;
import com.dzj.house.entity.HouseDetail;
import com.dzj.house.entity.HousePicture;
import com.dzj.house.entity.HouseSubscribe;
import com.dzj.house.entity.User;
import com.dzj.house.enums.HouseInfoEnum;
import com.dzj.house.enums.HouseSearchEnum;
import com.dzj.house.enums.HouseStatusEnum;
import com.dzj.house.enums.RedisOverTime;
import com.dzj.house.redis.RedisService;
import com.dzj.house.service.HouseInfoService;
import com.dzj.house.util.ImageUtil;
import com.dzj.house.util.PageCalculator;
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
	@Autowired
	private HouseListDtoDao houseListDtoDao;
	@Autowired
	private RedisService redisService;
	@Autowired
	private SearchService searchService;//elasticSearch
	
	private static final String HOUSEKEY="HOUSEINFOSERVICE_";
	
	private static final Logger logger =LoggerFactory.getLogger(HouseInfoService.class);
	 
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
		house.setStatus(0);//待审核
		int effect =houseDao.insertHouse(house);
		if(effect <= 0) {
			throw new HouseInfoException(HouseInfoEnum.INSERT_HOUSE_ERROR);
		}
		
		houseDetail.setHouseId(house.getHouseId());
		
	
		//redisService.deleteObject(HOUSEKEY+house.getUserId());//新增数据时删除缓存中的数据
		//redisService.deleteObject(HOUSEKEY+house.getUserId()+"totalCount");//新增数据时删除缓存中的数据
		int houseDetailEffect = houseDetailDao.insertHouseDetail(houseDetail);
		if(houseDetailEffect <=0) {
			throw new HouseInfoException(HouseInfoEnum.INSERT_HOUSEDETAIL_INFO_ERROR);
		}
	//	searchService.index(house.getHouseId());
		
	}

	

	
	public HouseResponseDto getHouseAndPictureList(int pageIndex, int pageSize,long userId) throws HouseInfoException {
		if( pageIndex <0 ||pageSize<1) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_PAGING_ERROR);
		}
		//int rowIndex = PageCalculator.calculatorRowindex(pageIndex, pageSize);
		
		
		List<HouseListDto> houseListDto =null;
		int count=0;
		/*
		if(redisService.hasObject(HOUSEKEY+userId) && redisService.hasObject(HOUSEKEY+userId+"totalCount")) {
			houseListDto =redisService.getObjectValueListByLimit(HOUSEKEY+userId, pageIndex, pageSize,ArrayList.class, HouseListDto.class );
			count = redisService.getObjectValue(HOUSEKEY+userId+"totalCount", Integer.class);
		}else {
			houseListDto= houseListDtoDao.getHouseListDto(pageIndex, pageSize,userId);
			count =houseListDtoDao.getCount(userId);
			redisService.setObjectValue(HOUSEKEY+userId+"totalCount", count, RedisOverTime.OneDay.getOverTime());;
			redisService.setObjectValue(HOUSEKEY+userId, houseListDto, RedisOverTime.OneDay.getOverTime());
		}
		*/
		
		houseListDto= houseListDtoDao.getHouseListDto(pageIndex, pageSize,userId);
		count =houseListDtoDao.getCount(userId);
		if(houseListDto == null || houseListDto.size() <=0) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_SERACH_ERROR);
		}
		
		
		 
		HouseResponseDto houseResponseDto =new HouseResponseDto();
		houseResponseDto.setHouseListDtoList(houseListDto);
		houseResponseDto.setCount(count);
		/*List<HouseListDto> houseListDto= houseListDtoDao.getHouseListDto(rowIndex, pageSize,userId);
		if(houseListDto == null || houseListDto.size() <=0) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_SERACH_ERROR);
		}
		HouseResponseDto houseResponseDto =new HouseResponseDto();
		houseResponseDto.setHouseListDtoList(houseListDto);
		houseResponseDto.setCount(houseListDto.size());*/
		
		
		
		return houseResponseDto;
	}




	@Transactional
	public void addHousePicture(HousePicture housePicture,MultipartFile file,User user) throws HouseInfoException {
		if(file ==null) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		String location=null;
		long houseId= housePicture.getHouseId();
		if( houseId<=0) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		
		try {
			location = ImageUtil.uploadImage(file.getInputStream(), file.getOriginalFilename(), houseId);
		} catch (IOException e) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		
		housePicture.setLocation(location);
		int effect =housePictureDao.addHousePicture(housePicture);
		if(effect <= 0) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		//redisService.deleteObject(HOUSEKEY+user.getUserId());//新增数据时删除缓存中的数据
		//redisService.deleteObject(HOUSEKEY+user.getUserId()+"totalCount");//新增数据时删除缓存中的数据
	}




	
	public List<HousePicture> getPictureListByhouseId(long houseId) {
	
		if(houseId <=0) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_INFO_ERROR);
		}
		 List<HousePicture> housePictures =housePictureDao.getPictureListByhouseId(houseId);
		 if(housePictures ==null || housePictures.size()<=0) {
			 throw new HouseInfoException(HouseInfoEnum.HOUSE_SERACH_ERROR);
		 }
		
		
		return housePictures;
	}




	
	public void updateFrontPicture(MultipartFile file, long houseId, User user) throws HouseInfoException{
		
		if(file ==null) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		String path=null;
	
		if( houseId<=0) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		
		try {
			path = ImageUtil.uploadImage(file.getInputStream(), file.getOriginalFilename(), houseId);
		} catch (IOException e) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		
		int effect = houseDao.updateFrontPicture(path, houseId, user.getUserId());
		if(effect <= 0) {
			throw new HouseInfoException(HouseInfoEnum.HOUSE_ADD_PICTUR_ERROR);
		}
		//redisService.deleteObject(HOUSEKEY+user.getUserId());//新增数据时删除缓存中的数据
	}




	@Transactional
	public void updateHouseStatus(long userId, House house) {
		if(userId<=0) {
			logger.error("用户为空");
			throw new HouseInfoException(HouseInfoEnum.HOUSE_UPDATE_ERROR);
		}
		if(house == null || house.getHouseId() <0) {
			logger.error("房源信息为空");
			throw new HouseInfoException(HouseInfoEnum.HOUSE_UPDATE_ERROR);
		}
		if(house.getStatus() == HouseStatusEnum.PASS.getCode()) {
			searchService.index(house.getHouseId());
		}else {
			searchService.remove(house.getHouseId());
		}
		int effect = houseDao.updateHouse(house, userId);
		if(effect<=0) {
			logger.error("房更新失败");
			throw new HouseInfoException(HouseInfoEnum.HOUSE_UPDATE_ERROR);
		}
		
		
		
		
	}

}
