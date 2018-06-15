package org.arpicoinsurance.groupit.complaint.main.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ComplaintDto {
	private Integer complaintId;
	private String complaintSubject;
	private String complaintMessage;
	private String complaintReference;
	private String complaintRootCause;
	private String complaintAction;
	private String complaintStatus;
	private String complaintType;
	private String complaintCreateDate;
	private String acknowledgementDate;
	
	private Integer customerId;

	private Integer categoryId;
	
	private CustomerDto customerDto;
	private CategoryDto categoryDto;
	
	private List<ComplaintStageDetailsDto> complaintsDetails=new ArrayList<>();

	public Integer getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}
	public String getComplaintSubject() {
		return complaintSubject;
	}
	public void setComplaintSubject(String complaintSubject) {
		this.complaintSubject = complaintSubject;
	}
	public String getComplaintMessage() {
		return complaintMessage;
	}
	public void setComplaintMessage(String complaintMessage) {
		this.complaintMessage = complaintMessage;
	}
	public String getComplaintReference() {
		return complaintReference;
	}
	public void setComplaintReference(String complaintReference) {
		this.complaintReference = complaintReference;
	}
	public String getComplaintRootCause() {
		return complaintRootCause;
	}
	public void setComplaintRootCause(String complaintRootCause) {
		this.complaintRootCause = complaintRootCause;
	}
	public String getComplaintAction() {
		return complaintAction;
	}
	public void setComplaintAction(String complaintAction) {
		this.complaintAction = complaintAction;
	}
	
	public String getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public CustomerDto getCustomerDto() {
		return customerDto;
	}
	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}
	public CategoryDto getCategoryDto() {
		return categoryDto;
	}
	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}
	public List<ComplaintStageDetailsDto> getComplaintsDetails() {
		return complaintsDetails;
	}
	public void setComplaintsDetails(List<ComplaintStageDetailsDto> complaintsDetails) {
		this.complaintsDetails = complaintsDetails;
	}
	
	public String getComplaintCreateDate() {
		return complaintCreateDate;
	}
	public void setComplaintCreateDate(String complaintCreateDate) {
		this.complaintCreateDate = complaintCreateDate;
	}
	public String getAcknowledgementDate() {
		return acknowledgementDate;
	}
	public void setAcknowledgementDate(String acknowledgementDate) {
		this.acknowledgementDate = acknowledgementDate;
	}
	@Override
	public String toString() {
		return "ComplaintDto [complaintId=" + complaintId + ", complaintSubject=" + complaintSubject
				+ ", complaintMessage=" + complaintMessage + ", complaintReference=" + complaintReference
				+ ", complaintRootCause=" + complaintRootCause + ", complaintAction=" + complaintAction
				+ ", complaintStatus=" + complaintStatus + ", complaintType=" + complaintType + ", complaintCreateDate="
				+ complaintCreateDate + ", acknowledgementDate=" + acknowledgementDate + ", customerId=" + customerId
				+ ", categoryId=" + categoryId + ", customerDto=" + customerDto + ", categoryDto=" + categoryDto
				+ ", complaintsDetails=" + complaintsDetails + "]";
	}
	
	
	
	
}
