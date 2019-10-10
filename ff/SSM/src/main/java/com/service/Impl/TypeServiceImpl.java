package com.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TypeDao;
import com.pojo.Type;
import com.service.TypeService;

@Service("typeService")
@Transactional(propagation = Propagation.REQUIRED,isolation =Isolation.DEFAULT) //设置隔离级别
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDao typeDao;
	@Override
	public List<Type> getAll() {
		
		return typeDao.selectAll();
	}

	@Override
	public int addType(Type type) {
		return typeDao.add(type);
	}

	@Override
	public void updateType(Type type) {
		typeDao.update(type);
	}

	@Override
	public int deleteType(int id) {
		return typeDao.deleteType(id);
	}

}
