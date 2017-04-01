package com.itxxz.sys.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itxxz.sys.user.entity.UserInfo;
import com.itxxz.sys.user.service.UserInfoService;

@Controller
@RequestMapping("userInfo")
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping("/userlistss")
	public ModelAndView UserList(){
		ModelAndView model = new ModelAndView();
		
		List<UserInfo> userList = userInfoService.selectAllUsers();
		model.addObject("userList",userList);
		model.setViewName("/sys/user/show");
		return model;
	}
	
	/**
	 * 登录验证
	 * 作者：螃蟹
	 * 网址：www.itxxz.com
	 * @return
	 */
	@RequestMapping("/logo")
	public ModelAndView logo(String userName,String password){
		System.out.println("用户名："+userName);
		System.out.println("密码:"+password);
		String view ="/error";
		String msg = "用户名或密码错误";
		ModelAndView model = new ModelAndView();
		
		List<UserInfo> userList = userInfoService.selectAllUsers();
		System.out.println("2222222222222222222222222222222");

		if(userList.equals(userName) && userList.equals(password)){
			view = "/success";
			msg="";
		}else{

			UserInfo user = userInfoService.getUserByName(userName);

			if(null != user && userName.equals(user.getUserName()) && password.equals(user.getPassword())){
				view = "/success";
				msg="";
			}
		}
		view = "/success";
		model.addObject("msg",msg);
		model.setViewName(view);
		return model;
	}
}
