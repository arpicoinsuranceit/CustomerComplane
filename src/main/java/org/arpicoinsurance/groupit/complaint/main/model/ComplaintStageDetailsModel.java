package org.arpicoinsurance.groupit.complaint.main.model;

import java.util.ArrayList;
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
@Table(name="complaint_stage_detail")
public class ComplaintStageDetailsModel {
	private Integer complaintStageDetailId;
	private String description;
	
	private List<ImageModel> images=new ArrayList<>();
	@Column(name="stage",nullable=false)
	private StageModel stage;
	@Column(name="complaint",nullable=false)
	private ComplaintModel complaint;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getComplaintStageDetailId() {
		return complaintStageDetailId;
	}
	public void setComplaintStageDetailId(Integer complaintStageDetailId) {
		this.complaintStageDetailId = complaintStageDetailId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany(mappedBy="complaintStageDetails")
	public List<ImageModel> getImages() {
		return images;
	}
	public void setImages(List<ImageModel> images) {
		this.images = images;
	}
	@ManyToOne
	public StageModel getStage() {
		return stage;
	}
	public void setStage(StageModel stage) {
		this.stage = stage;
	}
	@ManyToOne
	public ComplaintModel getComplaint() {
		return complaint;
	}
	public void setComplaint(ComplaintModel complaint) {
		this.complaint = complaint;
	}
	@Override
	public String toString() {
		return "ComplaintStageDetails [complaintStageDetailId=" + complaintStageDetailId + ", description="
				+ description + ", images=" + images + ", stage=" + stage + ", complaint=" + complaint + "]";
	}
	
	
}
