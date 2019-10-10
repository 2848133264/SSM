package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pojo.Functions;

public interface FunctionDao {
	/**
	 * 根据管理员 id 获得功能权限
	 */
	@Select("select * from functions  where id in (select fid from powers where aid =#{aid})")
	public List<Functions> selectByAdminId(Integer aid);

}
