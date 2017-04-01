package com.itxxz.sys.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itxxz.sys.user.entity.UserInfo;
import com.itxxz.sys.user.mapper.UserInfoDao;

@Service
public class UserInfoService implements UserInfoDao {

	@Autowired
	UserInfoDao userInfoDao;
	
	public List<UserInfo> selectAllUsers(){
		 List<UserInfo> users = userInfoDao.selectAllUsers();
		 if(null != users){
			 for(UserInfo u:users){
				 if(u!=null)
				 {
					 System.out.println("编号："+u.getUsercode());
					 System.out.println("姓名："+u.getUserName());
					 System.out.println("密码："+u.getPassword());
					 System.out.println("性别："+u.getAge());
				 }
			 }
			 //return "我获取到了【"+i+"】个";
		 }else{
			 //return"没有啊。。。。";
		 }
		 return users;
	};
	
	public UserInfo getUserByName(String userName){
		return userInfoDao.getUserByName(userName);
		 
	}
}
