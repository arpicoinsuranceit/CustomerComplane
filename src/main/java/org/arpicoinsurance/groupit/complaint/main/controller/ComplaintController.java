package org.arpicoinsurance.groupit.complaint.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.dto.CustomerDto;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ComplaintController {
	
	@Autowired
	private ComplaintService complaintService;

	@RequestMapping("/complaint")
	public String viewComplaintPage() {
		return "complaint/complaint";
	}
	
	@RequestMapping("/addcomplaint")
	public String viewAddComplaintPage() {
		return "complaint/addcomplaint";
	}
	
	@RequestMapping(value = "/view_complaint_dt", method = RequestMethod.GET)
	@ResponseBody
	public Map viewCustomerData(HttpSession httpSession) throws Exception {
		
		List<ComplaintDto> complaintDtos =complaintService.viewAllComplaint();
		List complaintList = new ArrayList<>();
		
		for (ComplaintDto complaintDto : complaintDtos) {
			Map<String, Object> entity = new HashMap<>();
			entity.put("name", complaintDto.getCustomerDto().getCustomerName());
			entity.put("nic", complaintDto.getCustomerDto().getCustomerNic());
			entity.put("email", complaintDto.getCustomerDto().getCustomerEmail());
			entity.put("mobile", complaintDto.getCustomerDto().getCustomerMobile());
			entity.put("reference", complaintDto.getComplaintReference());
			entity.put("category", complaintDto.getComplaintReference());
			entity.put("subject", complaintDto.getComplaintSubject());
			entity.put("message", complaintDto.getComplaintMessage());
			entity.put("edit", "<button type=\"button\" rel=\"tooltip\" title=\"Edit Task\" onclick=\"editComplaint('"+complaintDto.getComplaintId()+"')\" class=\"btn btn-primary btn-link btn-sm\"> <i class=\"material-icons\">edit</i>" + 
					"</button>");
			complaintList.add(entity);
		}
		
		Map responseMap = new HashMap<>();
		responseMap.put("data", complaintList);
		return responseMap;
		
	}
	
	@RequestMapping(value = "/send_complaint", method = RequestMethod.POST )
	@ResponseBody
	public String saveComplaint(@RequestParam("customerName") String customerName,@RequestParam("customerNic") String customerNic,
			@RequestParam("customerEmail") String customerEmail,@RequestParam("customerMobile") String customerMobile,
			@RequestParam("polNo") String polNo,@RequestParam("comCategory") String comCategory,
			@RequestParam("comSubject") String comSubject,@RequestParam("comMessage") String comMessage,
			@RequestParam("attachment") MultipartFile[] multipartFile) {
		
		CustomerDto customerDto=new CustomerDto();
		customerDto.setCustomerName(customerName);
		customerDto.setCustomerMobile(customerMobile);
		customerDto.setCustomerNic(customerNic);
		customerDto.setCustomerEmail(customerEmail);
		
		ComplaintDto complaintDto=new ComplaintDto();
		complaintDto.setComplaintReference(polNo);
		complaintDto.setCategoryId(Integer.valueOf(comCategory));
		complaintDto.setComplaintSubject(comSubject);
		complaintDto.setComplaintMessage(comMessage);
		
		
		try {
			return  complaintService.saveComplaint(complaintDto, customerDto, multipartFile);
		} catch (Exception e) {
			e.printStackTrace();
			return "204";
		}
	}
	
	
	@RequestMapping(value = "/search_complaint", method = RequestMethod.POST )
	@ResponseBody
	public List<ComplaintDto> searchComplaintByStatus(@RequestParam("complaintStatus") String complaintStatus) {
		
		try {
			return complaintService.findByComplaintStatus(complaintStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/accept_complaint", method = RequestMethod.POST)
	@ResponseBody
	public String acceptComplaints(@RequestParam("complaints") ArrayList<Integer> idList) {
		
		try {
			return complaintService.updateComplaintStatus(idList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
