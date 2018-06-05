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
@Table(name="customer")
public class CustomerModel{
	private Integer customerId;
	private String customerName;
	private String customerNic;
	private String customerEmail;
	private String customerMobile;
	private Date createDate;
	private Date updateDate;
	
	private List<ComplaintModel> complaints=new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNic() {
		return customerNic;
	}
	public void setCustomerNic(String customerNic) {
		this.customerNic = customerNic;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
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
	
	@OneToMany(mappedBy="customer")
	public List<ComplaintModel> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<ComplaintModel> complaints) {
		this.complaints = complaints;
	}
	@Override
	public String toString() {
		return "CustomerModel [customerId=" + customerId + ", customerName=" + customerName + ", customerNic="
				+ customerNic + ", customerEmail=" + customerEmail + ", customerMobile=" + customerMobile
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", complaints=" + complaints + "]";
	}
	
	
	
	
}
