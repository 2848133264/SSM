package com.pojo;

public class OrderDetail {
	/**
	 * 用于封装订单明细的信息
	 */
	private int id;
	private int oid;
	private OrderInfo oi;
	private int pid;
	private ProductInfo pi;
	
	private int num;//数量
	private double price;//单价
	private double totalprice;//总价格
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public OrderInfo getOi() {
		return oi;
	}
	public void setOi(OrderInfo oi) {
		this.oi = oi;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public ProductInfo getPi() {
		return pi;
	}
	public void setPi(ProductInfo pi) {
		this.pi = pi;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	

}
