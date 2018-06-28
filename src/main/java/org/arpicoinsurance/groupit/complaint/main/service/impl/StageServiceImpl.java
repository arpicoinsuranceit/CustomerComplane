package org.arpicoinsurance.groupit.complaint.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.arpicoinsurance.groupit.complaint.main.dao.StageDao;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintStageDetailsDto;
import org.arpicoinsurance.groupit.complaint.main.dto.StageDto;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;
import org.arpicoinsurance.groupit.complaint.main.model.StageModel;
import org.arpicoinsurance.groupit.complaint.main.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StageServiceImpl implements StageService{

	@Autowired
	private StageDao stageDao;
	
	@Override
	public String saveStage(StageDto stageDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StageDto> viewAllStage() throws Exception {
		List<StageModel> stageModels=(List<StageModel>) stageDao.findAll();
		
		List<StageDto> stageDto=new ArrayList<>();
		
		for (StageModel stageModel : stageModels) {
			StageDto stageDto2=new StageDto();
			stageDto2.setStageDescription(stageModel.getStageDescription());
			stageDto2.setStageId(stageModel.getStageId());
			stageDto2.setStageName(stageModel.getStageName());
			
			/*List<ComplaintStageDetailsDto> complaintStageDetailsDtos=new ArrayList<>();
			for (ComplaintStageDetailsModel stageDetailsModel : stageModel.getComplaintsDetails()) {
				ComplaintStageDetailsDto complaintStageDetailsDto=new ComplaintStageDetailsDto();
			}*/
			
			stageDto.add(stageDto2);
		}
		
		return stageDto;
	}

	@Override
	public String updateStage(StageDto stageDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
