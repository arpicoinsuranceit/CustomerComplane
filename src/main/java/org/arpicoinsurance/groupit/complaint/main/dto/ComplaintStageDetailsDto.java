package org.arpicoinsurance.groupit.complaint.main.dto;

import java.util.ArrayList;
import java.util.List;

public class ComplaintStageDetailsDto {
	private Integer complaintStageDetailId;
	private String description;
	
	private List<ImageDto> images=new ArrayList<>();
	private StageDto stage;
	private ComplaintDto complaint;

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
	public List<ImageDto> getImages() {
		return images;
	}
	public void setImages(List<ImageDto> images) {
		this.images = images;
	}

	public StageDto getStage() {
		return stage;
	}
	public void setStage(StageDto stage) {
		this.stage = stage;
	}

	public ComplaintDto getComplaint() {
		return complaint;
	}
	public void setComplaint(ComplaintDto complaint) {
		this.complaint = complaint;
	}
	@Override
	public String toString() {
		return "ComplaintStageDetails [complaintStageDetailId=" + complaintStageDetailId + ", description="
				+ description + ", images=" + images + ", stage=" + stage + ", complaint=" + complaint + "]";
	}
	
	
}
