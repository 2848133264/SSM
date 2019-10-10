package com.service;

import com.pojo.AdminInfo;

public interface AdminInfoService {
	//登入验证
	public AdminInfo login(AdminInfo ai);
	//根据管理员编号，获取管理员对象及关联的功能权限
	public AdminInfo getAdminInfoAndFunctions(Integer id);

}
