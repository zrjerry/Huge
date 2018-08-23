package com.huge.order.pojo;

public class OrderItem {
	// 订单id
	private String orderId;
	// 用户id
	private int userId;
		
	private int busId;
		
	private int status;
	
	private String startStation;
	private String endStation;
	private String startDate;
	private String costTimeCarstyle;
	private int id;
	private int leftTicket;
	private int price;
	private String startCity;
	private String endCity;
	private String startTime;
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
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getCostTimeCarstyle() {
		return costTimeCarstyle;
	}
	public void setCostTimeCarstyle(String costTimeCarstyle) {
		this.costTimeCarstyle = costTimeCarstyle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLeftTicket() {
		return leftTicket;
	}
	public void setLeftTicket(int leftTicket) {
		this.leftTicket = leftTicket;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getEndCity() {
		return endCity;
	}
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", userId=" + userId + ", busId=" + busId + ", status=" + status
				+ ", startStation=" + startStation + ", endStation=" + endStation + ", startDate=" + startDate
				+ ", costTimeCarstyle=" + costTimeCarstyle + ", id=" + id + ", leftTicket=" + leftTicket + ", price="
				+ price + ", startCity=" + startCity + ", endCity=" + endCity + ", startTime=" + startTime + "]";
	}
	
	
	
}
