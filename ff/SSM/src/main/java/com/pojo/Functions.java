package com.pojo;

import java.util.HashSet;
import java.util.Set;

public class Functions implements Comparable<Functions>{

	private int Id ;
	private String name;
	private int parentid;
	private boolean isleaf;
	
	//关联属性
	private Set ais= new HashSet<>();
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public boolean isIsleaf() {
		return isleaf;
	}

	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}

	public Set getAis() {
		return ais;
	}

	public void setAis(Set ais) {
		this.ais = ais;
	}

	
	@Override
	public int compareTo(Functions o) {
		/**
		 * 用于排序时将两个functions 对象的id进行比较，返回的是一个正负数
		 */
		return ((Integer)this.getId()).compareTo((Integer)(o.getId()));
	}
	

}
