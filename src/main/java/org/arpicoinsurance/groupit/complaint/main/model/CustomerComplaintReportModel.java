package org.arpicoinsurance.groupit.complaint.main.model;

public class CustomerComplaintReportModel {
	private String complaintCategory;
	private Integer comOutAtBegining;
	private Integer comReceiDuringPeriod;
	private Integer comClosedFullyResolved;
	private Integer comClosedPartResolved;
	private Integer comClosedNotResolved;
	private Integer comOutAtEnd;
	
	
	public String getComplaintCategory() {
		return complaintCategory;
	}
	public void setComplaintCategory(String complaintCategory) {
		this.complaintCategory = complaintCategory;
	}
	public Integer getComOutAtBegining() {
		return comOutAtBegining;
	}
	public void setComOutAtBegining(Integer comOutAtBegining) {
		this.comOutAtBegining = comOutAtBegining;
	}
	public Integer getComReceiDuringPeriod() {
		return comReceiDuringPeriod;
	}
	public void setComReceiDuringPeriod(Integer comReceiDuringPeriod) {
		this.comReceiDuringPeriod = comReceiDuringPeriod;
	}
	public Integer getComClosedFullyResolved() {
		return comClosedFullyResolved;
	}
	public void setComClosedFullyResolved(Integer comClosedFullyResolved) {
		this.comClosedFullyResolved = comClosedFullyResolved;
	}
	public Integer getComClosedPartResolved() {
		return comClosedPartResolved;
	}
	public void setComClosedPartResolved(Integer comClosedPartResolved) {
		this.comClosedPartResolved = comClosedPartResolved;
	}
	public Integer getComClosedNotResolved() {
		return comClosedNotResolved;
	}
	public void setComClosedNotResolved(Integer comClosedNotResolved) {
		this.comClosedNotResolved = comClosedNotResolved;
	}
	public Integer getComOutAtEnd() {
		return comOutAtEnd;
	}
	public void setComOutAtEnd(Integer comOutAtEnd) {
		this.comOutAtEnd = comOutAtEnd;
	}
	
	@Override
	public String toString() {
		return "CustomerComplaintReportModel [complaintCategory=" + complaintCategory + ", comOutAtBegining="
				+ comOutAtBegining + ", comReceiDuringPeriod=" + comReceiDuringPeriod + ", comClosedFullyResolved="
				+ comClosedFullyResolved + ", comClosedPartResolved=" + comClosedPartResolved
				+ ", comClosedNotResolved=" + comClosedNotResolved + ", comOutAtEnd=" + comOutAtEnd + "]";
	}
	
	
	
}
