package org.arpicoinsurance.groupit.complaint.main.service;

import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;

public interface ComplaintStageDetailsService {
	public ComplaintStageDetailsModel update(ComplaintStageDetailsModel complaintStageDetailsModel,String stageName)throws Exception;
}
