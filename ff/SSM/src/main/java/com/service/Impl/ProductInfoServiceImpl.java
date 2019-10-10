package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductInfoDao;
import com.pojo.ProductInfo;
import com.pojo.utils.Pager;
import com.service.ProductInfoService;

@Service("productInfoService")
@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)

public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	ProductInfoDao productInfoDao;
	@Override
	public List<ProductInfo> findProductInfo(ProductInfo productInfo, Pager pager) {
		
		// 创建params 
		Map<String, Object> params =  new HashMap<String,Object>();
		// 将封装查询条件的productInfo对象放入到param中
		params.put("productInfo", productInfo);
		// 获得总条数
		int recordCount = productInfoDao.count(params);
		
		pager.setRowCount(recordCount);
		if(recordCount  > 0){
			params.put("pager", pager);
		}
		return productInfoDao.selectByPage(params);
	}

	@Override
	public Integer count(Map<String, Object> params) {
		return productInfoDao.count(params);
	}

	@Override
	public void addProductInfo(ProductInfo pi) {
		productInfoDao.save(pi);
	}

	@Override
	public void modifyProductInfo(ProductInfo pi) {
		productInfoDao.edit(pi);
	}

	@Override
	public void modifyStatus(String ids, int flag) {
		productInfoDao.updateState(ids, flag);
	}

	@Override
	public List<ProductInfo> getOnSaleProduct() {
		return productInfoDao.getOnSaleProduct();
	}

	@Override
	public ProductInfo getProductInfoById(int id) {
		return productInfoDao.getProductInfoById(id);
	}

	@Override
	public void deleteProductInfo(int id) {
		productInfoDao.deleteProduct(id);
	}

}
