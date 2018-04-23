package com.dzj.house.controller.admin;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzj.house.dao.SubWayDao;
import com.dzj.house.entity.Subway;
import com.dzj.house.entity.SubwayStation;
import com.dzj.house.entity.SupportAddress;
import com.dzj.house.enums.ResultEnum;
import com.dzj.house.response.ResponseResult;
import com.dzj.house.service.SubWayService;
import com.dzj.house.service.SubWayStationService;
import com.dzj.house.service.SupportAddressService;

@RestController
@RequestMapping(value = "/admin")
public class AddressController {
	@Autowired
	private SubWayService subWayService;
	@Autowired
	private SubWayStationService subWayStationService;
	@Autowired
	private SupportAddressService supportAddressService;

	/**
	 * 获取城市信息
	 * @return
	 */
	@GetMapping(value = "/getcity")
	public ResponseResult<List<SupportAddress>> getCity() {
		List<SupportAddress> supportAddresses = supportAddressService.getCity();

		return new ResponseResult<List<SupportAddress>>(supportAddresses, ResultEnum.SUCCESS);

	}

	/**
	 * 获取区县信息
	 * @param belongTo
	 * @return
	 */
	@GetMapping(value = "/getregion/{belongTo}")
	public ResponseResult<List<SupportAddress>> getRegion(@PathVariable("belongTo") String belongTo) {
		List<SupportAddress> supportAddresses = supportAddressService.getRegion(belongTo);

		return new ResponseResult<List<SupportAddress>>(supportAddresses, ResultEnum.SUCCESS);

	}
	/**
	 * 获取地铁站信息
	 * @param cityEnName
	 * @return
	 */
	@GetMapping(value="/getsubway/{belongTo}")
	public ResponseResult<List<Subway>> getSubWay(@PathVariable("belongTo") String belongTo){
		
		List<Subway> subwaylist =subWayService.getSubWayByCityName(belongTo);
		
		return new ResponseResult<List<Subway>>(subwaylist, ResultEnum.SUCCESS);
		
	}
	/**
	 * 获取地铁站名信息
	 * @param cityEnName
	 * @return
	 */
	@GetMapping(value="/getstation/{subWayId}")
	public ResponseResult<List<SubwayStation>> getstation(@PathVariable("subWayId") long subWayId){
		
		List<SubwayStation> subwayStations = subWayStationService.getSubWayStationByStationId(subWayId);
		
		return new ResponseResult<List<SubwayStation>>(subwayStations, ResultEnum.SUCCESS);
		
	}

}
