package org.arpicoinsurance.groupit.complaint.main.dto;

import java.util.ArrayList;

public class RootCauseAnalysisReportDto {
	
	private String complaintCategory;
	private ArrayList<String> rootCause=new ArrayList<>();
	private ArrayList<String> action=new ArrayList<>();
	
	public String getComplaintCategory() {
		return complaintCategory;
	}
	public void setComplaintCategory(String complaintCategory) {
		this.complaintCategory = complaintCategory;
	}
	public ArrayList<String> getRootCause() {
		return rootCause;
	}
	public void setRootCause(ArrayList<String> rootCause) {
		this.rootCause = rootCause;
	}
	public ArrayList<String> getAction() {
		return action;
	}
	public void setAction(ArrayList<String> action) {
		this.action = action;
	}
	
	@Override
	public String toString() {
		return "RootCauseAnalysisReportDto [complaintCategory=" + complaintCategory + ", rootCause=" + rootCause
				+ ", action=" + action + "]";
	}
	
	

}
