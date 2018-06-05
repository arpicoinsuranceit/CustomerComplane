package org.arpicoinsurance.groupit.complaint.main.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryDto {
	private Integer categoryId;
	private String categoryName;
	private Integer isActive;
	private Date createDate;
	private Date updateDate;
	private List<ComplaintDto> complaints=new ArrayList<>();
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public List<ComplaintDto> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<ComplaintDto> complaints) {
		this.complaints = complaints;
	}
	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryName=" + categoryName + ", isActive=" + isActive
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", complaints=" + complaints + "]";
	}
	
	
	
}
