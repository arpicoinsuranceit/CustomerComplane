package org.arpicoinsurance.groupit.complaint.main.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stage")
public class StageModel {
	
	private Integer stageId;
	private String stageName;
	private String stageDescription;
	
	private List<ComplaintStageDetailsModel> complaintsDetails=new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	@OneToMany(mappedBy="stage")
	public List<ComplaintStageDetailsModel> getComplaintsDetails() {
		return complaintsDetails;
	}
	public void setComplaintsDetails(List<ComplaintStageDetailsModel> complaintsDetails) {
		this.complaintsDetails = complaintsDetails;
	}
	@Override
	public String toString() {
		return "StageModel [stageId=" + stageId + ", stageName=" + stageName + ", stageDescription=" + stageDescription
				+ ", complaintsDetails=" + complaintsDetails + "]";
	}
	
	

}
