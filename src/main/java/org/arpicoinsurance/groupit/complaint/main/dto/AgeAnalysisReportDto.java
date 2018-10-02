package org.arpicoinsurance.groupit.complaint.main.dto;

public class AgeAnalysisReportDto {
	
	private String duration;
	private Integer complaintOutstanding;
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getComplaintOutstanding() {
		return complaintOutstanding;
	}
	public void setComplaintOutstanding(Integer complaintOutstanding) {
		this.complaintOutstanding = complaintOutstanding;
	}
	@Override
	public String toString() {
		return "AgeAnalysisReportDto [duration=" + duration + ", complaintOutstanding=" + complaintOutstanding + "]";
	}
	

}
