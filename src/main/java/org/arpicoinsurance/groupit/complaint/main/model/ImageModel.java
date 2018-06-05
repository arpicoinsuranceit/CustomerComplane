package org.arpicoinsurance.groupit.complaint.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class ImageModel {
	
	private Integer imageId;
	private String imagePath;
	
	@Column(name="complaintStageDetails",nullable=false)
	private ComplaintStageDetailsModel complaintStageDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@ManyToOne
	public ComplaintStageDetailsModel getComplaintStageDetails() {
		return complaintStageDetails;
	}
	public void setComplaintStageDetails(ComplaintStageDetailsModel complaintStageDetails) {
		this.complaintStageDetails = complaintStageDetails;
	}
	@Override
	public String toString() {
		return "ImageModel [imageId=" + imageId + ", imagePath=" + imagePath + ", complaintStageDetails="
				+ complaintStageDetails + "]";
	}
	

}
