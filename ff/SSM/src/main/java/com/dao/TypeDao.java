package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pojo.Type;

public interface TypeDao {
	
	/**
	 * 显示所有的额商品信息
	 * @return
	 */
	@Select("select * from type")
	public List<Type> selectAll();
	
	/**
	 * 根据类型编号查商品信息
	 * @param id
	 * @return
	 */
	@Select("select * from type where id=#{id}")
	Type selectById(int id);
	/**
	 * 添加商品类型
	 * @param type
	 * @return
	 */
	@Insert("insert into type(name) value(#{name})")
	@Options(useGeneratedKeys =true,keyProperty="id")
	public int add(Type type);
	
	/**
	 * 更新商品类型
	 * @param type
	 * @return
	 */
	@Update("update type set name = #{name} where id = #{id}")
	public int update(Type type);
	
	/**
	 * 
	 * 删除商品类型
	 * @param id
	 * @return
	 */
	@Delete("delete from type where id=#{id}")
	public  int deleteType(int id);
}
