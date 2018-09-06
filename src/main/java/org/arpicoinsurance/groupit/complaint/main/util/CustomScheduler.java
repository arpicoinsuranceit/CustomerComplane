package org.arpicoinsurance.groupit.complaint.main.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;
import org.arpicoinsurance.groupit.complaint.main.model.StageModel;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintService;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintStageDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomScheduler {
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private ComplaintStageDetailsService complaintStageDetailsService;
	
	private static final Logger log = LoggerFactory.getLogger(CustomScheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedDelay  = (1000*60*60*24))
    public void reportCurrentTime() {
		try {
			List<ComplaintDto> complaintDtos=complaintService.viewAllComplaint();
			for (ComplaintDto complaintDto : complaintDtos) {
				LocalDate nowDate=LocalDate.now();
				
				LocalDate createDate=LocalDate.parse(complaintDto.getComplaintCreateDate());
				
				long monthDiff=ChronoUnit.MONTHS.between(createDate, nowDate);
				
				if(monthDiff >= 2) {
					complaintDto.setComplaintStatus(AppConstant.COMPLAINT_STATUS_FULLY);
					complaintService.updateComplaint(complaintDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
	
	
	@Scheduled(fixedDelay  = (1000*60*60*24))
    public void changeComplaintStatus() {
		try {
			List<ComplaintDto> complaintDtos=complaintService.viewAllComplaint();
			for (ComplaintDto complaintDto : complaintDtos) {
				
				List<ComplaintStageDetailsModel> complaintStageDetailsModels=complaintStageDetailsService.findByComplaintOrderByCreateDateDesc(complaintDto);
				
				if (complaintStageDetailsModels != null) {
					ComplaintStageDetailsModel stageDetailsModel=complaintStageDetailsModels.get(0);
					StageModel stageModel=stageDetailsModel.getStage();
					if(stageModel.getStageName().equals("WAITING_CUST_RESPOND")) {
						System.out.println(stageModel.getStageName());
						LocalDate nowDate=LocalDate.now();
						
						LocalDate createDate=LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(stageDetailsModel.getCreateDate()));
						
						long dayDiff=ChronoUnit.DAYS.between(createDate, nowDate);
						
						if(dayDiff > 7) {
							complaintDto.setComplaintStatus(AppConstant.COMPLAINT_STATUS_NOT);
							complaintService.updateComplaint(complaintDto);
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        log.info("The time is now set not resolved{}", dateFormat.format(new Date()));
    }
	
}
