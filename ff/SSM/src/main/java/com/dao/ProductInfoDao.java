package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.pojo.ProductInfo;
import com.pojo.ProductInfoDynaSqlProvider;

public interface ProductInfoDao {
	
	/**
	 * 分页获取这个商品的数据
	 */
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="name",property="name"),
		@Result(column="brand",property="brand"),
		@Result(column="pic",property="pic"),
		@Result(column="num",property="num"),
		@Result(column="price",property="price"),
		@Result(column="intro",property="intro"),
		@Result(column="status",property="status"),
		@Result(column="tid",property="type",one=@One(select=""
				+ "com.dao.TypeDao.selectById",fetchType=FetchType.EAGER)),
		
	})
	@SelectProvider(type=ProductInfoDynaSqlProvider.class,method="selectWithParam")
	List<ProductInfo> selectByPage(Map<String, Object> params);
	
	/**
	 * 根据条件查询商品的总数
	 */
	@SelectProvider(type=ProductInfoDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	/**
	 * 添加商品
	 * @param pi
	 */
	@Insert("insert into product_info(code,name,tid,brand,pic,num,price,intro,status)"
			+ " values(#{code},#{name},#{type.id},#{brand},#{pic},#{num},#{price},#{intro},#{status})")
	void save(ProductInfo pi);
	
	/**
	 * 修改商品
	 * @param pi
	 */
	@Update("update product_info set  "
			+ " code=#{code},name=#{name},"
			+ "tid=#{type.id},brand=#{brand},"
			+ "pic=#{pic},num=#{num},"
			+ "price=#{price},intro=#{intro},"
			+ "status=#{status} where id=#{id}")
	void edit(ProductInfo pi);
	
	/**
	 *  删除产品信息
	 * @param id
	 */
	@Delete("delete from product_info where id=#{id}")
	void deleteProduct(int id);
	
	/**
	 * 更新商品状态
	 * @param ids
	 * @param flag
	 */
	@Update("update product_info set status=#{flag} where id in (${ids})")
	void updateState(@Param("ids") String ids,@Param("flag") int flag);
	
	/**
	 * 获取在售商品列表
	 * @return
	 */
	@Select("select * from product_info where status = 1")
	List<ProductInfo> getOnSaleProduct();
	
	/**
	 * 根据id 获取商品信息
	 * @param id
	 * @return
	 */
	@Select("select * from product_info where id = #{id}")
	ProductInfo getProductInfoById(int id);

}
