package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminInfoDao;
import com.pojo.AdminInfo;
import com.service.AdminInfoService;

@Service("adminInfoService")

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class AdminInfoServiceImpl implements AdminInfoService {

	@Autowired
	private AdminInfoDao adminInfoDao;
	@Override
	public AdminInfo login(AdminInfo ai) {
		return adminInfoDao.selectByNameAndPwd(ai);
	}

	@Override
	public AdminInfo getAdminInfoAndFunctions(Integer id) {
		
		return adminInfoDao.selectById(id);
	}

	
}
