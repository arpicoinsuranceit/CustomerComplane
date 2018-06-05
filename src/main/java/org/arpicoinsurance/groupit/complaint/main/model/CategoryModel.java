package org.arpicoinsurance.groupit.complaint.main.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryModel {
	private Integer categoryId;
	private String categoryName;
	private Integer isActive;
	private Date createDate;
	private Date updateDate;
	
	private List<ComplaintModel> complaints=new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@OneToMany(mappedBy="category")
	public List<ComplaintModel> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<ComplaintModel> complaints) {
		this.complaints = complaints;
	}
	@Override
	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", categoryName=" + categoryName + ", isActive=" + isActive
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", complaints=" + complaints + "]";
	}
	
	
	
}
