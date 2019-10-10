package com.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.pojo.AdminInfo;

public interface AdminInfoDao {
	/**
	 * 管理员登入
	 */
	@Select("select * from admin_info where name=#{name} and pwd=#{pwd}")
	public AdminInfo selectByNameAndPwd(AdminInfo ai);
	
	
	/**
	 * 根据管理员id 获取管理员对象及联动的功能集合
	 */
	@Select("select * from admin_info where id=#{id}")
	@Results({
		@Result(id =true,column="id",property = "id"),
		@Result(column = "pwd",property = "pwd"),
		@Result(column="id" ,property="fs",many=@Many(select="com.dao.FunctionDao.selectByAdminId",fetchType=FetchType.EAGER))
	})
	AdminInfo selectById(Integer id);
}
