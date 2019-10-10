package com.service;

import java.util.List;

import com.pojo.Type;

public interface TypeService {
	
	//获得所有的额商品类型
	public List<Type> getAll();
	
	//添加商品的类型
	public int addType(Type type);
	
	//更新商品类型
	public void updateType(Type type);
	
	public  int deleteType(int id);
}
