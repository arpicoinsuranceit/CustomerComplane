package org.arpicoinsurance.groupit.complaint.main.service;

import java.util.List;

import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;

public interface ComplaintStageDetailsService {
	
	public ComplaintStageDetailsModel update(ComplaintStageDetailsModel complaintStageDetailsModel,String stageName)throws Exception;

	public List<ComplaintStageDetailsModel> findByComplaintOrderByCreateDateDesc(ComplaintDto complaintDto)throws Exception;

}
