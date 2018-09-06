package org.arpicoinsurance.groupit.complaint.main.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.arpicoinsurance.groupit.complaint.main.dao.CategoryDao;
import org.arpicoinsurance.groupit.complaint.main.dao.ComplaintStageDetailsDao;
import org.arpicoinsurance.groupit.complaint.main.dao.CustomerDao;
import org.arpicoinsurance.groupit.complaint.main.dao.StageDao;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintModel;
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
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CustomerDao customerDao;

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

	@Override
	public List<ComplaintStageDetailsModel> findByComplaintOrderByCreateDateDesc(ComplaintDto complaintDto) throws Exception {
		
		ComplaintModel complaintModel=new ComplaintModel();
		
		complaintModel.setComplaintId(complaintDto.getComplaintId());
		complaintModel.setComplaintStatus(complaintDto.getComplaintStatus());
		complaintModel.setComplaintRootCause(complaintDto.getComplaintRootCause());
		complaintModel.setComplaintAction(complaintDto.getComplaintAction());
		
		if(complaintDto.getComplaintuUpdateDate() != null) {
			complaintModel.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd").parse(complaintDto.getComplaintuUpdateDate()));
		}
		
		if(complaintDto.getAcknowledgementDate() != null) {
			complaintModel.setAcknowledgementDate(new SimpleDateFormat("yyyy-MM-dd").parse(complaintDto.getAcknowledgementDate()));
		}
		
		complaintModel.setCategory(categoryDao.findOne(complaintDto.getCategoryId()));
		complaintModel.setComplaintMessage(complaintDto.getComplaintMessage());
		complaintModel.setComplaintReference(complaintDto.getComplaintReference());
		complaintModel.setComplaintSubject(complaintDto.getComplaintSubject());
		complaintModel.setComplaintType(complaintDto.getComplaintType());
		complaintModel.setCustomer(customerDao.findOne(complaintDto.getCustomerId()));
		complaintModel.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(complaintDto.getComplaintCreateDate()));
		
		return complaintStageDao.findByComplaintOrderByCreateDateDesc(complaintModel);
	}

}
