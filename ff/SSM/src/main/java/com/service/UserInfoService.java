package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.UserInfo;
import com.pojo.utils.Pager;


public interface UserInfoService {

	//获取合法用户
	public List<UserInfo> getValidUser();
	
	//获取客户id
	public UserInfo getUserInfoById(int id);
	
	//分页显示用户
	public List<UserInfo> findUserInfo(UserInfo userInfo,Pager pager);
	
	//客户计数
	Integer count(Map<String, Object> params);
	
	//修改指定编号的用户状态
	void modifyStatus(String ids,int flag);
	
	//删除客户
	void deleteUser(int id);
	
}
