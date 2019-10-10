package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.OrderInfoDao;
import com.pojo.OrderDetail;
import com.pojo.OrderInfo;
import com.pojo.utils.Pager;
import com.service.OrderInfoService;

@Service("orderInfoService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class OrderInfoServiceImpl implements OrderInfoService {
	
	@Autowired
	OrderInfoDao orderInfoDao;

	/**
	 * 查找订单信息
	 */
	@Override
	public List<OrderInfo> findOrderInfo(OrderInfo orderInfo, Pager pager) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderInfo", orderInfo);
		int recordCount = orderInfoDao.count(params);
		pager.setRowCount(recordCount);
		if (recordCount > 0) {
			params.put("pager", pager);
		}
		return orderInfoDao.selectByPage(params);
	}

	/**
	 * 获得记录数
	 */
	@Override
	public Integer count(Map<String, Object> params) {
		return orderInfoDao.count(params);
	}

	/**
	 * 添加订单
	 */
	@Override
	public int addOrderDetail(OrderDetail od) {
		return orderInfoDao.saveOrderDetail(od);
	}
	
	/**
	 * 通过id获得订单信息
	 */
	@Override
	public OrderInfo getOrderInfoById(int id) {
		return orderInfoDao.getOrderInfoById(id);
	}

	/**
	 * 通过id查询详细的订单信息
	 */
	@Override
	public List<OrderDetail> getOrderDetailByOid(int oid) {
		return orderInfoDao.getOrderDetailByOid(oid);
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteOrder(int id) {
		int result = 1;
		try {
			orderInfoDao.deleteOrderDetail(id);
			orderInfoDao.deleteOrderInfo(id);
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	/**
	 * 添加
	 */
	@Override
	public int addOrderInfo(OrderInfo oi) {
		return orderInfoDao.saveOrderInfo(oi);
	}
}
