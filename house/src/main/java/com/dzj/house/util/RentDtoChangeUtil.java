package com.dzj.house.util;

import com.dzj.house.dto.RentDto;
import com.dzj.house.dto.SearchDto;

public class RentDtoChangeUtil {

	public static SearchDto change(RentDto rentDto) {

		SearchDto searchDto = new SearchDto();
		
		if(rentDto.getRoom().equals("") || rentDto.getRoom().equals("0")) {
			searchDto.setRoom(-1);
		}else {
			searchDto.setRoom(Integer.parseInt(rentDto.getRoom()));
		}
		
		if(rentDto.getSize().equals("")) {
			searchDto.setSize(5);
		}else {
			searchDto.setSize(Integer.parseInt(rentDto.getSize()));
		}
		
		if(rentDto.getStart().equals("")) {
			searchDto.setStart(0);
		}else {
			searchDto.setStart(Integer.parseInt(rentDto.getStart()));
		}
		
		if(rentDto.getSubwayId().equals("") || rentDto.getSubwayId().equals("0")) {
			searchDto.setSubwayId(-1);
		}else {
			searchDto.setSubwayId(Long.parseLong(rentDto.getSubwayId()));
		}
		
		searchDto.setCityEnName(rentDto.getCityEnName());
		
		if(rentDto.getSubwayName() !=null && !rentDto.getSubwayName().equals("")) {
			searchDto.setSubwayName(rentDto.getSubwayName());
		}
		
		if(!rentDto.getDirection().equals("") && !rentDto.getDirection().equals("*")) {
			searchDto.setDirection(rentDto.getDirection());
		}
		
		if(!rentDto.getRegionEnName().equals("") && !rentDto.getRegionEnName().equals("*")) {
			searchDto.setRegionEnName(rentDto.getRegionEnName());
		}
		
		if(!rentDto.getRentWay().equals("") &&!rentDto.getRentWay().equals("*")  ) {
			searchDto.setRentWay(rentDto.getRentWay());
		}
		if(rentDto.getKeywords() != null && !rentDto.getKeywords().equals("")) {
			searchDto.setKeywords(rentDto.getKeywords());
		}
		
		if(!rentDto.getOrderBy().equals("") && !rentDto.getOrderBy().equals("*")) {
			searchDto.setOrderBy(rentDto.getOrderBy());
		}else {
			searchDto.setOrderBy("last_update_time");
		}
		if(!rentDto.getOrderDirection().equals("")&& !rentDto.getOrderDirection().equals("*")) {
			searchDto.setOrderDirection(rentDto.getOrderDirection());
		}else {
			searchDto.setOrderDirection("asc");
		}
		
		if(!rentDto.getAreaBlock().equals("")) {
			switch (rentDto.getAreaBlock()) {
			case "*-50":
				searchDto.setAreaMax(50);
				searchDto.setAreaMin(-1);
				break;
				
			case "50-90":
				searchDto.setAreaMax(90);
				searchDto.setAreaMin(50);
				break;
				
			case "90-*":
				searchDto.setAreaMax(-1);
				searchDto.setAreaMin(90);
				break;
			case "*":
				searchDto.setAreaMax(-1);
				searchDto.setAreaMin(-1);
				break;
			}
		}else {
			searchDto.setAreaMax(-1);
			searchDto.setAreaMin(-1);
		}
	
		if(!rentDto.getPriceBlock().equals("")) {

			switch (rentDto.getPriceBlock()) {
			case "*-1000":
				searchDto.setPriceMax(1000);
				searchDto.setPriceMin(-1);
				break;
				
			case "1000-3000":
				searchDto.setPriceMax(3000);
				searchDto.setPriceMin(1000);
				break;
				
			case "3000-*":
				searchDto.setPriceMax(-1);
				searchDto.setPriceMin(3000);
				break;
			case "*":
				searchDto.setPriceMax(-1);
				searchDto.setPriceMin(-1);
				break;
			}
		}else {
			searchDto.setPriceMax(-1);
			searchDto.setPriceMin(-1);
		}
		
		

		return searchDto;

	}
}
