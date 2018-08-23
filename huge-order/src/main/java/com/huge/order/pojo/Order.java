package com.huge.order.pojo;

import java.io.Serializable;

public class Order implements Serializable{
	// 订单id
	private String orderId;
	// 用户id
	private int userId;
	
	private int busId;
	
	private int status;
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
