package com.huge.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jt.common.po.BasePojo;
@Table(name="tb_item_cat")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ItemCat extends BasePojo{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;//必须使用封装
	//对于通用mapper,在调用方法时,很多情况
	//都会使用默认值,long的默认值0l,Long
	//的默认值是null,在where条件拼接时
	//null值忽略,0l被翻译成id=0
	private Long parentId;
	private String name;
	private Integer status;
	private Integer sortOrder;
	private Boolean isParent;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	//在json字符串中出现text属性,值就是name
	public String getText(){
		return name;
	}
	//在json字符串中出现state属性,值为open 或close字符串
	public String getState(){
		//三目运算
		return isParent? "closed":"open";
	}
	
}
