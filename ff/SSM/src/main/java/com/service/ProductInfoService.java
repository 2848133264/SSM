package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.ProductInfo;
import com.pojo.utils.Pager;

public interface ProductInfoService {
	
	// 分页显示数据
	List<ProductInfo> findProductInfo(ProductInfo productInfo,Pager pager);
	
	//商品计数
	Integer count(Map<String,Object> params);
	
	//添加商品
	public void addProductInfo(ProductInfo pi);
	
	//删除商品
	
	public void deleteProductInfo(int id);
	
	//修改商品
	public void modifyProductInfo(ProductInfo pi);
	
	//更新商品的状态
	void modifyStatus(String ids,int flag);
	
	//获得在售商品
	List<ProductInfo> getOnSaleProduct();
	
	//根据商品的id 获取商品对象
	ProductInfo getProductInfoById(int id);
	
	
}
