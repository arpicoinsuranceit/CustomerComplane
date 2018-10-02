package org.arpicoinsurance.groupit.complaint.main.service;

import java.util.List;
import org.arpicoinsurance.groupit.complaint.main.dto.AgeAnalysisReportDto;
import org.arpicoinsurance.groupit.complaint.main.dto.CustomerComplaintReportDto;
import org.arpicoinsurance.groupit.complaint.main.dto.PerformanceReportDto;
import org.arpicoinsurance.groupit.complaint.main.dto.RootCauseAnalysisReportDto;

public interface ReportService {
	
	public List<CustomerComplaintReportDto> getCustomerComplaintReport(String fromDate,String toDate)throws Exception;
	
	public List<RootCauseAnalysisReportDto> getRootCauseAnalysisReport(String fromDate,String toDate)throws Exception;
	
	public List<PerformanceReportDto> getPerformanceReport(String fromDate,String toDate)throws Exception;
	
	public List<AgeAnalysisReportDto> getAgeAnalysisReport(String fromDate,String toDate)throws Exception;
	

}
