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
					 System.out.println("��ţ�"+u.getUsercode());
					 System.out.println("������"+u.getUserName());
					 System.out.println("���룺"+u.getPassword());
					 System.out.println("�Ա�"+u.getAge());
				 }
			 }
			 //return "�һ�ȡ���ˡ�"+i+"����";
		 }else{
			 //return"û�а���������";
		 }
		 return users;
	};
	
	public UserInfo getUserByName(String userName){
		return userInfoDao.getUserByName(userName);
		 
	}
}
