package org.arpicoinsurance.groupit.complaint.main.dto;

import java.util.ArrayList;
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
	
	private CustomerDto customer;

	private CategoryDto category;
	
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
	
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	
	
	public List<ComplaintStageDetailsDto> getComplaintsDetails() {
		return complaintsDetails;
	}
	public void setComplaintsDetails(List<ComplaintStageDetailsDto> complaintsDetails) {
		this.complaintsDetails = complaintsDetails;
	}
	@Override
	public String toString() {
		return "ComplaintDto [complaintId=" + complaintId + ", complaintSubject=" + complaintSubject
				+ ", complaintMessage=" + complaintMessage + ", complaintReference=" + complaintReference
				+ ", complaintRootCause=" + complaintRootCause + ", complaintAction=" + complaintAction
				+ ", complaintStatus=" + complaintStatus + ", complaintType=" + complaintType + ", customer=" + customer
				+ ", category=" + category + ", complaintsDetails=" + complaintsDetails + "]";
	}
	
	
	
	
	
	
}
