package com.itxxz.sys.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.itxxz.sys.user.entity.UserInfo;

/*@Repository*/
public interface UserInfoDao {

	public List<UserInfo> selectAllUsers();
	
	public UserInfo getUserByName(@Param(value = "userName") String userName);
}
