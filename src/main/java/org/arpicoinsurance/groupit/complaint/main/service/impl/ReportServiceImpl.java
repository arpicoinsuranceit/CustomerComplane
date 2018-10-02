package org.arpicoinsurance.groupit.complaint.main.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.arpicoinsurance.groupit.complaint.main.dao.CategoryDao;
import org.arpicoinsurance.groupit.complaint.main.dao.ComplaintDao;
import org.arpicoinsurance.groupit.complaint.main.dto.AgeAnalysisReportDto;
import org.arpicoinsurance.groupit.complaint.main.dto.CustomerComplaintReportDto;
import org.arpicoinsurance.groupit.complaint.main.dto.PerformanceReportDto;
import org.arpicoinsurance.groupit.complaint.main.dto.RootCauseAnalysisReportDto;
import org.arpicoinsurance.groupit.complaint.main.model.CategoryModel;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintModel;
import org.arpicoinsurance.groupit.complaint.main.service.ReportService;
import org.arpicoinsurance.groupit.complaint.main.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ComplaintDao complaintDao;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<CustomerComplaintReportDto> getCustomerComplaintReport(String fromDate, String toDate)
			throws Exception {

		/* Get category list from DB */
		List<CategoryModel> categoryModels = (List<CategoryModel>) categoryDao.findAll();

		List<CustomerComplaintReportDto> complaintReportDtos = new ArrayList<>();

		categoryModels.forEach(ca -> {
			CustomerComplaintReportDto complaintReportDto = new CustomerComplaintReportDto();
			complaintReportDto.setComplaintCategory(ca.getCategoryName());
			complaintReportDto.setComOutAtBegining(0);
			complaintReportDto.setComReceiDuringPeriod(0);
			complaintReportDto.setComClosedFullyResolved(0);
			complaintReportDto.setComClosedNotResolved(0);
			complaintReportDto.setComClosedPartResolved(0);
			complaintReportDto.setComOutAtEnd(0);

			complaintReportDtos.add(complaintReportDto);

		});

		List<ComplaintModel> complaintModels = (List<ComplaintModel>) complaintDao.findAll();

		if (complaintModels != null) {
			complaintModels.forEach(cm -> {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				System.out.println(fromDate);

				try {
					Date from_date = sdf.parse(fromDate);
					Date create_date = cm.getCreateDate();
					Date to_date = sdf.parse(toDate);

					System.out.println(from_date + "," + create_date);

					/* set no of complaint outstanding at beginning of period */

					if (create_date.before(from_date)) {
						if (cm.getComplaintStatus().equalsIgnoreCase(AppConstant.COMPLAINT_STATUS_NOT)) {

							complaintReportDtos.forEach(cr -> {
								Integer outBegining = 0;
								if (cr.getComplaintCategory().equalsIgnoreCase(cm.getCategory().getCategoryName())) {
									outBegining = cr.getComOutAtBegining() + 1;
									cr.setComOutAtBegining(outBegining);
								}
							});
						}
					}

					/* set no of complaint received during the period */
					if ((create_date.after(from_date) || create_date.equals(from_date))
							&& (create_date.before(to_date) || create_date.equals(to_date))) {
						complaintReportDtos.forEach(cr -> {
							Integer rcvdDuring = 0;
							Integer closedDuringFully = 0;
							Integer closedDuringPart = 0;
							Integer closedDuringNot = 0;
							if (cr.getComplaintCategory().equalsIgnoreCase(cm.getCategory().getCategoryName())) {
								rcvdDuring = cr.getComReceiDuringPeriod() + 1;
								cr.setComReceiDuringPeriod(rcvdDuring);

								if (cm.getComplaintStatus().equalsIgnoreCase(AppConstant.COMPLAINT_STATUS_NOT)) {
									closedDuringNot = cr.getComClosedNotResolved() + 1;
									cr.setComClosedNotResolved(closedDuringNot);

								} else if (cm.getComplaintStatus()
										.equalsIgnoreCase(AppConstant.COMPLAINT_STATUS_FULLY)) {
									closedDuringFully = cr.getComClosedFullyResolved() + 1;
									cr.setComClosedFullyResolved(closedDuringFully);

								} else if (cm.getComplaintStatus()
										.equalsIgnoreCase(AppConstant.COMPLAINT_STATUS_PARTIALLY)) {
									closedDuringPart = cr.getComClosedPartResolved() + 1;
									cr.setComClosedPartResolved(closedDuringPart);

								}

							}

							System.out.println(cr.toString());

						});
					}

					/* set no of complaint outstanding at end of period */

					if (create_date.after(to_date)) {
						if (cm.getComplaintStatus().equalsIgnoreCase(AppConstant.COMPLAINT_STATUS_NOT)) {

							complaintReportDtos.forEach(cr -> {
								Integer outEnd = 0;
								if (cr.getComplaintCategory().equalsIgnoreCase(cm.getCategory().getCategoryName())) {
									outEnd = cr.getComOutAtEnd() + 1;
									cr.setComOutAtEnd(outEnd);
								}

								System.out.println(cr.toString());
							});
						}
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}

				System.out.println(cm.getCreateDate());
			});
		}

		CustomerComplaintReportDto complaintReportDto = new CustomerComplaintReportDto();
		complaintReportDto.setComplaintCategory("TOTAL");
		complaintReportDto.setComOutAtBegining(0);
		complaintReportDto.setComReceiDuringPeriod(0);
		complaintReportDto.setComClosedFullyResolved(0);
		complaintReportDto.setComClosedNotResolved(0);
		complaintReportDto.setComClosedPartResolved(0);
		complaintReportDto.setComOutAtEnd(0);

		complaintReportDtos.forEach(cr -> {
			complaintReportDto.setComOutAtBegining(complaintReportDto.getComOutAtBegining() + cr.getComOutAtBegining());
			complaintReportDto.setComReceiDuringPeriod(
					complaintReportDto.getComReceiDuringPeriod() + cr.getComReceiDuringPeriod());
			complaintReportDto.setComClosedFullyResolved(
					complaintReportDto.getComClosedFullyResolved() + cr.getComClosedFullyResolved());
			complaintReportDto.setComClosedNotResolved(
					complaintReportDto.getComClosedNotResolved() + cr.getComClosedNotResolved());
			complaintReportDto.setComClosedPartResolved(
					complaintReportDto.getComClosedPartResolved() + cr.getComClosedPartResolved());
			complaintReportDto.setComOutAtEnd(complaintReportDto.getComOutAtEnd() + cr.getComOutAtEnd());

		});

		complaintReportDtos.add(complaintReportDto);

		return complaintReportDtos;
	}

	@Override
	public List<RootCauseAnalysisReportDto> getRootCauseAnalysisReport(String fromDate, String toDate)
			throws Exception {
		/* Get category list from DB */
		List<CategoryModel> categoryModels = (List<CategoryModel>) categoryDao.findAll();

		List<RootCauseAnalysisReportDto> rootCauseAnalysisReportDtos = new ArrayList<>();

		categoryModels.forEach(ca -> {
			RootCauseAnalysisReportDto rootCauseAnalysisReportDto = new RootCauseAnalysisReportDto();
			rootCauseAnalysisReportDto.setComplaintCategory(ca.getCategoryName());

			rootCauseAnalysisReportDtos.add(rootCauseAnalysisReportDto);

		});

		List<ComplaintModel> complaintModels = (List<ComplaintModel>) complaintDao.findAll();

		if (complaintModels != null) {
			complaintModels.forEach(cm -> {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				System.out.println(fromDate);

				try {
					Date from_date = sdf.parse(fromDate);
					Date create_date = cm.getCreateDate();
					Date to_date = sdf.parse(toDate);
					
					if ((create_date.after(from_date) || create_date.equals(from_date))
							&& (create_date.before(to_date) || create_date.equals(to_date))) {
						
						rootCauseAnalysisReportDtos.forEach(cr -> {
							if (cr.getComplaintCategory().equalsIgnoreCase(cm.getCategory().getCategoryName())) {
								
								if(cm.getComplaintAction() != null  && cm.getComplaintAction() != "") {
									cr.getAction().add(cm.getComplaintAction());
								}
								
								if(cm.getComplaintRootCause() != null  && cm.getComplaintRootCause() != "") {
									cr.getRootCause().add(cm.getComplaintRootCause());
								}
								
							}
							
						});
						
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}

			});

		}

		return rootCauseAnalysisReportDtos;
	}

	@Override
	public List<PerformanceReportDto> getPerformanceReport(String fromDate, String toDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgeAnalysisReportDto> getAgeAnalysisReport(String fromDate, String toDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
