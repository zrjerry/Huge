package com.huge.web.pojo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;

public class User implements Serializable{
	private Long id;
	// 身份证号
	private String identityId;	
	// 性别
	private String gender;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 真实姓名
	private String realname;
	// 创建时间
	private String createTime;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", identityId=" + identityId + ", gender=" + gender + ", username=" + username
				+ ", password=" + password + ", realname=" + realname + ", createTime=" + createTime + ", email="
				+ email + "]";
	}
}
