package com.dzj.house.controller.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzj.house.entity.SupportAddress;
import com.dzj.house.enums.ResultEnum;
import com.dzj.house.response.ResponseResult;
import com.dzj.house.service.SupportAddressService;

@RestController
@RequestMapping(value="/front")
public class IndexController {

	@Autowired
	private SupportAddressService supportAddressService;

	@GetMapping(value="/getcity")
	public ResponseResult<List<Map<String, List<SupportAddress>>>> getCity(){
		
		List<SupportAddress> addressList =supportAddressService.getCity();
		
	
		
		
		
		List<Map<String, List<SupportAddress>>> responseList =new ArrayList<Map<String, List<SupportAddress>>>();
		
		for (SupportAddress supportAddress : addressList) {
					
			Map<String, List<SupportAddress>> modelMap = new HashMap<>();
			List<SupportAddress> putaddress= new ArrayList<>();
			
			char prefix=supportAddress.getCityEnName().charAt(0);
			for (SupportAddress address : addressList) {
				if(prefix == address.getCityEnName().charAt(0)) {
					putaddress.add(address);
				}
			}
			modelMap.put(prefix+"", putaddress);
			responseList.add(modelMap);
		}
		 Set<Map<String, List<SupportAddress>>> h = new HashSet<Map<String, List<SupportAddress>>>(responseList);  
		 responseList.clear();
		 responseList.addAll(h);
		
		return new ResponseResult<List<Map<String,List<SupportAddress>>>>(responseList, ResultEnum.SUCCESS);
		
	}
}
