package org.arpicoinsurance.groupit.complaint.main.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.arpicoinsurance.groupit.complaint.main.dao.ComplaintStageDetailsDao;
import org.arpicoinsurance.groupit.complaint.main.dao.StageDao;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;
import org.arpicoinsurance.groupit.complaint.main.model.StageModel;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintStageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ComplaintStageDetailsServiceImpl implements ComplaintStageDetailsService{
	
	@Autowired
	private ComplaintStageDetailsDao complaintStageDao;
	
	@Autowired
	private StageDao stageDao;

	@Override
	public ComplaintStageDetailsModel update(ComplaintStageDetailsModel complaintStageDetailsModel,String stageName) throws Exception {
		StageModel stageModel=stageDao.findByStageName(stageName);
		if(stageModel != null) {
			complaintStageDetailsModel.setStage(stageModel);
			complaintStageDetailsModel.setCreateDate(new Date());
			return complaintStageDao.save(complaintStageDetailsModel);
		}
		return null;
	}

}
