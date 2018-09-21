package org.arpicoinsurance.groupit.complaint.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	
	@RequestMapping("/report_main")
	public String viewReportPage(ModelAndView modelAndView) {
		return "report/report_main";
	}
	
}
