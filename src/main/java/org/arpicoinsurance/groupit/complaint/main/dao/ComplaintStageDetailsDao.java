package org.arpicoinsurance.groupit.complaint.main.dao;

import java.util.List;

import org.arpicoinsurance.groupit.complaint.main.model.ComplaintModel;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;
import org.arpicoinsurance.groupit.complaint.main.model.StageModel;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintStageDetailsDao extends CrudRepository<ComplaintStageDetailsModel, Integer>{
	
	public ComplaintStageDetailsModel findByComplaintAndStage(ComplaintModel complaint,StageModel stage)throws Exception;
	
	public List<ComplaintStageDetailsModel> findByStage(StageModel stage)throws Exception;
}
