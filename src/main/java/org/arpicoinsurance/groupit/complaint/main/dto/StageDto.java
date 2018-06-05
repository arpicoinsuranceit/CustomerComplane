package org.arpicoinsurance.groupit.complaint.main.dto;

import java.util.ArrayList;
import java.util.List;

public class StageDto {
	
	private Integer stageId;
	private String stageName;
	private String stageDescription;
	
	private List<ComplaintStageDetailsDto> complaintsDetails=new ArrayList<>();
	
	public Integer getStageId() {
		return stageId;
	}
	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getStageDescription() {
		return stageDescription;
	}
	public void setStageDescription(String stageDescription) {
		this.stageDescription = stageDescription;
	}

	public List<ComplaintStageDetailsDto> getComplaintsDetails() {
		return complaintsDetails;
	}
	public void setComplaintsDetails(List<ComplaintStageDetailsDto> complaintsDetails) {
		this.complaintsDetails = complaintsDetails;
	}
	@Override
	public String toString() {
		return "StageModel [stageId=" + stageId + ", stageName=" + stageName + ", stageDescription=" + stageDescription
				+ ", complaintsDetails=" + complaintsDetails + "]";
	}
	
	

}
