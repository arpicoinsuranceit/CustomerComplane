package org.arpicoinsurance.groupit.complaint.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ComplaintController {

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
	public Map getAllComplaints(HttpSession httpSession) {
		List complaintList = new ArrayList<>();
		
		Map responseMap = new HashMap<>();
		responseMap.put("data", complaintList);
		return responseMap;
	}
	
	/*@RequestMapping(value = "/view_customer_dt", method = RequestMethod.GET)
	@ResponseBody
	public Map viewCustomerData(HttpSession httpSession) throws Exception {
		
		List<CustomerDto> customerDtos =customerService.getAllCustomers();
		List customerList = new ArrayList<>();
		
		for (CustomerDto customerDto : customerDtos) {
			Map<String, Object> entity = new HashMap<>();
			entity.put("id", customerDto.getCustomer_id());
			System.out.println(customerDto.getCustomer_state().isEmpty() + "state");
			entity.put("name", customerDto.getCustomer_salutation() +" "+ customerDto.getCustomer_first_name());
			String area=!customerDto.getCustomer_area().isEmpty() ? customerDto.getCustomer_area()+", " :"";
			String state=!customerDto.getCustomer_state().isEmpty()? customerDto.getCustomer_state()+", ":"";
			String city=!customerDto.getCustomer_city().isEmpty() ? customerDto.getCustomer_city()+", ":"";
			String country=!customerDto.getCustomer_country().isEmpty()  ? customerDto.getCustomer_country()+". ":"";
			System.out.println(area+state+city+country);
			entity.put("address",area+state+city+country);
			entity.put("tele", customerDto.getCustomer_tele());
			entity.put("mobile", customerDto.getCustomer_mobile());
			entity.put("email", customerDto.getCustomer_email());
			customerList.add(entity);
		}
		
		Map responseMap = new HashMap<>();
		responseMap.put("data", customerList);
		return responseMap;
		
	}*/
	
	@RequestMapping(value = "/send_complaint", method = RequestMethod.POST )
	@ResponseBody
	public String saveComplaint(@RequestParam("customerName") String customerName,@RequestParam("customerNic") String customerNic,
			@RequestParam("customerEmail") String customerEmail,@RequestParam("customerMobile") String customerMobile,
			@RequestParam("polNo") String polNo,@RequestParam("comCategory") String comCategory,
			@RequestParam("comSubject") String comSubject,@RequestParam("comMessage") String comMessage,
			@RequestParam("attachment") MultipartFile multipartFile) {
		
		System.out.println(customerName);
		System.out.println(customerNic);
		System.out.println(customerEmail);
		System.out.println(customerMobile);
		System.out.println(polNo);
		System.out.println(comCategory);
		System.out.println(comSubject);
		System.out.println(comMessage);
		System.out.println(multipartFile);
		return "200";
	}
	

}
