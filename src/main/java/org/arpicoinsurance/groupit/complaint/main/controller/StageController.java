package org.arpicoinsurance.groupit.complaint.main.controller;

import java.util.List;
import org.arpicoinsurance.groupit.complaint.main.dto.StageDto;
import org.arpicoinsurance.groupit.complaint.main.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StageController {
	
	@Autowired
	private StageService stageService;
	
	@RequestMapping(value="/view_stages" , method=RequestMethod.GET)
	@ResponseBody
	public List<StageDto> getAllStages() throws Exception{
		return stageService.viewAllStage();
	}

}
