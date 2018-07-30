package org.arpicoinsurance.groupit.complaint.main.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomScheduler {
	
	@Autowired
	private ComplaintService complaintService;
	
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
					complaintService.updateComplaint(complaintDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
	
}
