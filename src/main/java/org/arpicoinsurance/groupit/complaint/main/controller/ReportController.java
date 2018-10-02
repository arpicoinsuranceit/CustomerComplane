package org.arpicoinsurance.groupit.complaint.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.arpicoinsurance.groupit.complaint.main.dto.CustomerComplaintReportDto;
import org.arpicoinsurance.groupit.complaint.main.dto.RootCauseAnalysisReportDto;
import org.arpicoinsurance.groupit.complaint.main.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping("report_main")
	public String viewReportPage(ModelAndView modelAndView) {
		return "report/report_main";
	}
	
	@RequestMapping("report/customer_complaints_report")
	public String viewComplaintReportPage(ModelAndView modelAndView) {
		return "report/customer_complaints_report";
	}
	
	@RequestMapping("report/performance_report")
	public String viewPerformanceReportPage(ModelAndView modelAndView) {
		return "report/performance_report";
	}
	
	@RequestMapping("report/age_analysis_report")
	public String viewAgeAnalysisReportPage(ModelAndView modelAndView) {
		return "report/age_analysis_report";
	}
	
	@RequestMapping("report/rootcause_analysis_report")
	public String viewRootCauseAnalysisReportPage(ModelAndView modelAndView) {
		return "report/rootcause_analysis_report";
	}
	
	@RequestMapping(value="report_customer_complaints",method=RequestMethod.POST)
	@ResponseBody
	public String getCustomerComplaintReport(@RequestParam("from_date")String fromDate,@RequestParam("to_date")String toDate,HttpSession session) {
		System.out.println(fromDate);
		System.out.println(toDate);
		
		try {
			
			List<CustomerComplaintReportDto> complaintReportDtos= reportService.getCustomerComplaintReport(fromDate, toDate);
			session.setAttribute("comlaintReportdata", complaintReportDtos);
			session.setAttribute("complaintReport_fromDate", fromDate);
			session.setAttribute("complaintReport_toDate", toDate);
			
			return "report/customer_complaints_report";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "report_main";
	}
	
	@RequestMapping(value="rootcause_analysis_report",method=RequestMethod.POST)
	@ResponseBody
	public String getRootCauseAnalysisReport(@RequestParam("from_date")String fromDate,@RequestParam("to_date")String toDate,HttpSession session) {
		System.out.println(fromDate);
		System.out.println(toDate);
		
		try {
			
			List<RootCauseAnalysisReportDto> rootCauseReportDtos= reportService.getRootCauseAnalysisReport(fromDate, toDate);
			session.setAttribute("rootCauseReportdata", rootCauseReportDtos);
			session.setAttribute("rootCauseReport_fromDate", fromDate);
			session.setAttribute("rootCauseReport_toDate", toDate);
			
			return "report/rootcause_analysis_report";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "report_main";
	}
	
	
}
