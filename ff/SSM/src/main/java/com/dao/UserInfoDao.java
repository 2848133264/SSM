package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.pojo.UserInfo;
import com.pojo.UserInfoDynaSqlProvider;

public interface UserInfoDao {
	
	/**
	 * 获取系统的合法用户，数据表User_info 中status 字段为 1 的客户列表
	 */
	@Select("select * from user_info where status =1")
	public List<UserInfo> getValidUser();
	
	/**
	 * 客户id 获取客户对象
	 */
	@Select("select * from user_info where id = #{id}")
	public UserInfo getUserInfoById(int id);

	/**
	 * 分页获取客户信息
	 */
	@SelectProvider(type = UserInfoDynaSqlProvider.class,method="selectWithParam")
	public List<UserInfo> selectByPage(Map<String, Object> params);
	
	/**
	 * 根据条件查询客户总数
	 */
	@SelectProvider(type=UserInfoDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	/**
	 * 更新客户信息(禁用和启用)
	 */
	@Update("update user_info set status=#{flag} where id in (${ids})")
	public void updateState(@Param("ids") String ids,@Param("flag") int flag);
	
	/**
	 * 删除用户
	 */
	@Delete("delete from user_info where id =#{id}")
	public void deleteUser(int id);
}
