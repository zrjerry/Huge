package com.huge.web.pojo;

import java.util.Date;
import java.util.List;

import com.jt.common.po.BasePojo;

public class Order extends BasePojo{
	// 订单id
	private String orderId;
	// 付款
	private String payment;
	// 付款类型
	private Integer paymentType;
	// 状态
	private Integer status;
	// 付款时间
	private Date paymentTime;
	// 结束时间
	private Date endTime;
	// 用户id
	private Long userId;
	
	// 订单车票
	private List<OrderItem> orderItems;
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	

	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
