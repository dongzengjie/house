package com.dzj.house.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin")
public class ToPage {
	/**
	 * 后台登陆页面
	 * @return
	 */
	@RequestMapping(value="/toLogin",method=RequestMethod.GET)
	public String toAdminLoginPage() {
		return "admin/login";
		
	}
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping(value="/toCenter",method=RequestMethod.GET)
	public String toAdminCenter() {
		return "admin/index";
		
	}
	/**
	 * 新增房屋页面
	 * @return
	 */
	@RequestMapping(value="/toaddHouse",method=RequestMethod.GET)
	public String toAdminAddHouse() {
		return "admin/house-add";
		
	}
	
	/**
	 * 新增房屋图片页面
	 * @return
	 */
	@RequestMapping(value="/toaddHousePicture",method=RequestMethod.GET)
	public String toAdminHousePicture() {
		return "admin/house-picture";
		
	}
	
	@RequestMapping(value="/toaouse",method=RequestMethod.GET)
	public String ttest() {
		return "admin/house-add";
		
	}
	/**
	 * 房屋列表
	 * @return
	 */
	@RequestMapping(value="/toproducelist",method=RequestMethod.GET)
	public String toproducelist() {
		return "admin/house-list";
	}
	/**
	 * 图片列表
	 * @return
	 */
	@RequestMapping(value="/topictureshow",method=RequestMethod.GET)
	public String topictureshow() {
		return "admin/picture-show";
	}
	
}
