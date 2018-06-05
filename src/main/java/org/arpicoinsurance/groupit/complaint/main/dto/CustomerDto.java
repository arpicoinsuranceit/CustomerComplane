package org.arpicoinsurance.groupit.complaint.main.dto;

import java.util.Date;

public class CustomerDto{
	private Integer customerId;
	private String customerName;
	private String customerNic;
	private String customerEmail;
	private String customerMobile;
	private Date createDate;
	private Date updateDate;

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
	@Override
	public String toString() {
		return "CustomerDto [customerId=" + customerId + ", customerName=" + customerName + ", customerNic="
				+ customerNic + ", customerEmail=" + customerEmail + ", customerMobile=" + customerMobile
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
	
}
