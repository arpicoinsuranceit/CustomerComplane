package org.arpicoinsurance.groupit.complaint.main.service;

import java.util.ArrayList;
import java.util.List;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.dto.CustomerDto;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;
import org.springframework.web.multipart.MultipartFile;

public interface ComplaintService {
	
	public String saveComplaint(ComplaintDto complaintDto,CustomerDto customerDto,MultipartFile[] multipartFiles)throws Exception;
	
	public List<ComplaintDto> viewAllComplaint()throws Exception;
	
	public String updateComplaint(ComplaintDto complaintDto,MultipartFile[] multipartFiles)throws Exception;
	
	public String updateComplaint(ComplaintDto complaintDto)throws Exception;
	
	public String updateComplaintStatus(ArrayList<Integer> idList)throws Exception;
	
	public String uploadImage(MultipartFile multipartFile,Integer complaintId,ComplaintStageDetailsModel complaintStageDetailsModel)throws Exception;

	public List<ComplaintDto> findByComplaintStatus(String complaintStatus) throws Exception;
	
	public ComplaintDto findByComplaintId(Integer id) throws Exception;
}
