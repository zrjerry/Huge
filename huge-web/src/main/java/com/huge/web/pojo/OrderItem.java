package com.huge.web.pojo;

public class OrderItem {
	// busid
	private Long busId;
	// 订单id
	private Long orderId;
	// 数量
	private Integer num;
	// 价格
	private Long price;
	// 总费用
	private Long totalFee;;
	
	
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	
}
