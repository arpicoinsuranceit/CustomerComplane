package org.arpicoinsurance.groupit.complaint.main.controller;


import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintStageDetailsDto;
import org.arpicoinsurance.groupit.complaint.main.dto.CustomerDto;
import org.arpicoinsurance.groupit.complaint.main.dto.ImageDto;
import org.arpicoinsurance.groupit.complaint.main.dto.StageDto;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintService;
import org.arpicoinsurance.groupit.complaint.main.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private ImageService imageService;

	@RequestMapping("/complaint")
	public String viewComplaintPage() {
		return "complaint/complaint";
	}

	@RequestMapping("/addcomplaint")
	public String viewAddComplaintPage() {
		return "complaint/addcomplaint";
	}

	@RequestMapping("/updatecomplaint/{id}")
	public String viewUpdateComplaintPage(@PathVariable Integer id, HttpSession httpSession) {
		System.out.println("called update ...");
		try {
			ComplaintDto complaintDto = complaintService.findByComplaintId(id);
			System.out.println(complaintDto.toString());

			httpSession.setAttribute("editComplaint", complaintDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpSession.setAttribute("editId", id);
		return "complaint/updatecomplaint";
	}

	@RequestMapping("/viewcomplaint/{id}")
	public String viewComplaintPage(@PathVariable Integer id, HttpSession httpSession) {
		System.out.println("called view ...");
		try {
			ComplaintDto complaintDto = complaintService.findByComplaintId(id);
			System.out.println(complaintDto.toString());

			httpSession.setAttribute("viewComplaint", complaintDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpSession.setAttribute("viewId", id);
		return "complaint/viewcomplaint";
	}

	@RequestMapping(value = "/view_complaint_dt", method = RequestMethod.GET)
	@ResponseBody
	public Map viewCustomerData(HttpSession httpSession) throws Exception {

		List<ComplaintDto> complaintDtos = complaintService.viewAllComplaint();
		List complaintList = new ArrayList<>();

		for (ComplaintDto complaintDto : complaintDtos) {
			Map<String, Object> entity = new HashMap<>();
			entity.put("name", complaintDto.getCustomerDto().getCustomerName());
			entity.put("nic", complaintDto.getCustomerDto().getCustomerNic());
			entity.put("email", complaintDto.getCustomerDto().getCustomerEmail());
			entity.put("mobile", complaintDto.getCustomerDto().getCustomerMobile());
			entity.put("reference", complaintDto.getComplaintReference());
			entity.put("category", complaintDto.getCategoryDto().getCategoryName());
			entity.put("subject", complaintDto.getComplaintSubject());
			entity.put("message", complaintDto.getComplaintMessage());
			entity.put("edit",
					"<button type=\"button\" rel=\"tooltip\" title=\"Edit Task\" onclick=\"editComplaint('"
							+ complaintDto.getComplaintId()
							+ "')\" class=\"btn btn-blue btn-link btn-sm\"> <i class=\"material-icons\">edit</i>"
							+ "</button>");
			entity.put("view", "<button type=\"button\" rel=\"tooltip\" title=\"View\" onclick=\"viewComplaint('"
					+ complaintDto.getComplaintId()
					+ "')\" class=\"btn btn-blue btn-link btn-sm\"> <i class=\"material-icons\">view_headline</i>"
					+ "</button>");
			complaintList.add(entity);
		}

		Map responseMap = new HashMap<>();
		responseMap.put("data", complaintList);
		return responseMap;

	}

	@RequestMapping(value = "/send_complaint", method = RequestMethod.POST)
	@ResponseBody
	public String saveComplaint(@RequestParam("customerName") String customerName,
			@RequestParam("customerNic") String customerNic, @RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerMobile") String customerMobile, @RequestParam("polNo") String polNo,
			@RequestParam("comCategory") String comCategory, @RequestParam("comSubject") String comSubject,
			@RequestParam("comMessage") String comMessage, @RequestParam("attachment") MultipartFile[] multipartFile) {

		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerName(customerName);
		customerDto.setCustomerMobile(customerMobile);
		customerDto.setCustomerNic(customerNic);
		customerDto.setCustomerEmail(customerEmail);

		ComplaintDto complaintDto = new ComplaintDto();
		complaintDto.setComplaintReference(polNo);
		complaintDto.setCategoryId(Integer.valueOf(comCategory));
		complaintDto.setComplaintSubject(comSubject);
		complaintDto.setComplaintMessage(comMessage);

		try {
			return complaintService.saveComplaint(complaintDto, customerDto, multipartFile);
		} catch (Exception e) {
			e.printStackTrace();
			return "204";
		}
	}

	@RequestMapping(value = "/search_complaint", method = RequestMethod.POST)
	@ResponseBody
	public List<ComplaintDto> searchComplaintByStatus(@RequestParam("complaintStatus") String complaintStatus,HttpSession httpSession) {

		try {
			List<ComplaintDto> complaintDto= complaintService.findByComplaintStatus(complaintStatus);
			httpSession.setAttribute(complaintStatus, complaintDto.size());
			return complaintDto;
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

	@RequestMapping(value = "/update_complaint", method = RequestMethod.POST)
	@ResponseBody
	public String updateComplaint(@RequestParam("customerName") String customerName,
			@RequestParam("customerNic") String customerNic, @RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerMobile") String customerMobile, @RequestParam("comRef") String polNo,
			@RequestParam("comCategory") String comCategory, @RequestParam("comSubject") String comSubject,
			@RequestParam("comMessage") String comMessage, @RequestParam("comStatus") String comStatus,
			@RequestParam("comRootCause") String comRootCause, @RequestParam("comAction") String comAction,
			@RequestParam("comStage") String comStage, @RequestParam("comStageDesc") String comStageDesc,
			@RequestParam("attachment") MultipartFile[] multipartFile, HttpSession httpSession) {

		System.out.println("called update complaint...");
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerName(customerName);
		customerDto.setCustomerMobile(customerMobile);
		customerDto.setCustomerNic(customerNic);
		customerDto.setCustomerEmail(customerEmail);

		ComplaintDto complaintDto = new ComplaintDto();
		complaintDto.setComplaintId((Integer) httpSession.getAttribute("editId"));
		complaintDto.setComplaintReference(polNo);
		// complaintDto.setCategoryId(Integer.valueOf(comCategory));
		complaintDto.setComplaintSubject(comSubject);
		complaintDto.setComplaintMessage(comMessage);
		complaintDto.setComplaintStatus(comStatus);
		complaintDto.setComplaintRootCause(comRootCause);
		complaintDto.setComplaintAction(comAction);

		StageDto stageDto = new StageDto();
		stageDto.setStageId(Integer.valueOf(comStage));

		ComplaintStageDetailsDto complaintStageDetailsDto = new ComplaintStageDetailsDto();
		complaintStageDetailsDto.setDescription(comStageDesc);
		complaintStageDetailsDto.setStage(stageDto);

		List<ComplaintStageDetailsDto> complaintStageDetailsDtos = new ArrayList<>();
		complaintStageDetailsDtos.add(complaintStageDetailsDto);

		complaintDto.setCustomerDto(customerDto);
		complaintDto.setComplaintsDetails(complaintStageDetailsDtos);

		try {
			return complaintService.updateComplaint(complaintDto, multipartFile);
		} catch (Exception e) {
			e.printStackTrace();
			return "204";
		}

	}

	@RequestMapping(value = "/downloadFile/{id}", method = RequestMethod.GET)
	@ResponseBody
	public HttpServletResponse downloadFile(@PathVariable Integer id, HttpServletResponse response) {
		String extension = "";
		try {
			ImageDto imageDto = imageService.searchImage(id);
			if (imageDto != null) {
				File file = new File(imageDto.getImagePath());

				if (file != null && file.exists()) {
					String name = file.getName();
					extension = name.substring(name.lastIndexOf("."));
				}

				byte[] contents = Files.readAllBytes(file.toPath());

				switch (extension) {
				case "pdf":
					response.setContentType("application/pdf");
					break;
				case "png":
					response.setContentType("image/png");
					break;
				case "jpg":
					response.setContentType("image/jpeg");
					break;
				case "jpeg":
					response.setContentType("image/jpeg");
					break;
				default:
					break;
				}
				response.getOutputStream().write(contents);
				response.getOutputStream().flush();
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
