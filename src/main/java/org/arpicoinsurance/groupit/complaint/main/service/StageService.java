package org.arpicoinsurance.groupit.complaint.main.service;

import java.util.List;
import org.arpicoinsurance.groupit.complaint.main.dto.StageDto;

public interface StageService {
	
	public String saveStage(StageDto stageDto)throws Exception;
	
	public List<StageDto> viewAllStage()throws Exception;
	
	public String updateStage(StageDto stageDto)throws Exception;

}
