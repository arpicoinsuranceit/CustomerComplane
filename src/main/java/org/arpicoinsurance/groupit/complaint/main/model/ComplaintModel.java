package org.arpicoinsurance.groupit.complaint.main.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="complaint")
public class ComplaintModel {
	private Integer complaintId;
	private String complaintReferanceNo;
	private String complaintSubject;
	private String complaintMessage;
	private String complaintReference;
	private String complaintRootCause;
	private String complaintAction;
	private String complaintStatus;
	private String complaintType;
	private String complaintMode;
	private Date acknowledgementDate;
	private Date createDate;
	private Date updateDate;
	
	
	@Column(name="customer",nullable=false)
	private CustomerModel customer;
	@Column(name="category",nullable=false)
	private CategoryModel category;
	
	private List<ComplaintStageDetailsModel> complaintsDetails=new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintReferanceNo() {
		return complaintReferanceNo;
	}
	public void setComplaintReferanceNo(String complaintReferanceNo) {
		this.complaintReferanceNo = complaintReferanceNo;
	}
	
	public String getComplaintMode() {
		return complaintMode;
	}
	public void setComplaintMode(String complaintMode) {
		this.complaintMode = complaintMode;
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
	
	@ManyToOne
	public CustomerModel getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
	@ManyToOne
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy="complaint")
	public List<ComplaintStageDetailsModel> getComplaintsDetails() {
		return complaintsDetails;
	}
	public void setComplaintsDetails(List<ComplaintStageDetailsModel> complaintsDetails) {
		this.complaintsDetails = complaintsDetails;
	}

	public Date getAcknowledgementDate() {
		return acknowledgementDate;
	}
	public void setAcknowledgementDate(Date acknowledgementDate) {
		this.acknowledgementDate = acknowledgementDate;
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
	
}
