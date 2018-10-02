package org.arpicoinsurance.groupit.complaint.main.dto;

public class PerformanceReportDto {
	
	private String description;
	private Integer presentPeriod;
	private Integer previousPeriod;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPresentPeriod() {
		return presentPeriod;
	}
	public void setPresentPeriod(Integer presentPeriod) {
		this.presentPeriod = presentPeriod;
	}
	public Integer getPreviousPeriod() {
		return previousPeriod;
	}
	public void setPreviousPeriod(Integer previousPeriod) {
		this.previousPeriod = previousPeriod;
	}
	@Override
	public String toString() {
		return "PerformanceReportDto [description=" + description + ", presentPeriod=" + presentPeriod
				+ ", previousPeriod=" + previousPeriod + "]";
	}
	
	
	

}
