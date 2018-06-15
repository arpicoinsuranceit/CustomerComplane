package org.arpicoinsurance.groupit.complaint.main.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.arpicoinsurance.groupit.complaint.main.dao.CategoryDao;
import org.arpicoinsurance.groupit.complaint.main.dao.ComplaintDao;
import org.arpicoinsurance.groupit.complaint.main.dao.ComplaintStageDetailsDao;
import org.arpicoinsurance.groupit.complaint.main.dao.CustomerDao;
import org.arpicoinsurance.groupit.complaint.main.dao.ImageDao;
import org.arpicoinsurance.groupit.complaint.main.dao.StageDao;
import org.arpicoinsurance.groupit.complaint.main.dto.CategoryDto;
import org.arpicoinsurance.groupit.complaint.main.dto.ComplaintDto;
import org.arpicoinsurance.groupit.complaint.main.dto.CustomerDto;
import org.arpicoinsurance.groupit.complaint.main.model.CategoryModel;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintModel;
import org.arpicoinsurance.groupit.complaint.main.model.ComplaintStageDetailsModel;
import org.arpicoinsurance.groupit.complaint.main.model.CustomerModel;
import org.arpicoinsurance.groupit.complaint.main.model.ImageModel;
import org.arpicoinsurance.groupit.complaint.main.model.StageModel;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintService;
import org.arpicoinsurance.groupit.complaint.main.service.ComplaintStageDetailsService;
import org.arpicoinsurance.groupit.complaint.main.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService{
	
	@Autowired
	private ComplaintDao complaintDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private StageDao stageDao;
	
	@Autowired
	private ComplaintStageDetailsDao stageDetailsDao;
	
	@Autowired
	private ComplaintStageDetailsService stageDetailsService;
	

	@Override
	public String saveComplaint(ComplaintDto complaintDto,CustomerDto customerDto,MultipartFile[] multipartFiles) throws Exception {
		
		ComplaintModel complaintModel=new ComplaintModel();
		CategoryModel categoryModel=categoryDao.findOne(complaintDto.getCategoryId());
		
		complaintModel.setComplaintSubject(complaintDto.getComplaintSubject());
		complaintModel.setComplaintMessage(complaintDto.getComplaintMessage());
		complaintModel.setCategory(categoryModel);
		complaintModel.setComplaintReference(complaintDto.getComplaintReference());
		complaintModel.setComplaintStatus(AppConstant.COMPLAINT_STATUS_NEW);
		complaintModel.setComplaintType(AppConstant.COMPLAINT_TYPE_INWRITING);
		complaintModel.setCreateDate(new Date());
		
		CustomerModel  customerModel=new CustomerModel();
		customerModel.setCustomerName(customerDto.getCustomerName());
		customerModel.setCustomerEmail(customerDto.getCustomerEmail());
		customerModel.setCustomerMobile(customerDto.getCustomerMobile());
		customerModel.setCustomerNic(customerDto.getCustomerNic());
		customerModel.setCreateDate(customerDto.getCreateDate());
		
		CustomerModel customerModel2=customerDao.save(customerModel);
		
		ComplaintStageDetailsModel complaintStageDetailsModel=new ComplaintStageDetailsModel();
		
		if(customerModel2!=null) {
			complaintModel.setCustomer(customerModel2);
			ComplaintModel complaintModel2=complaintDao.save(complaintModel);
			
			if(complaintModel2!=null) {
				StageModel stageModel=stageDao.findByStageName(AppConstant.COMPLAINT_STAGE_NEW);
				if(stageModel!=null) {
					complaintStageDetailsModel.setComplaint(complaintModel2);
					complaintStageDetailsModel.setStage(stageModel);
					ComplaintStageDetailsModel complaintStageDetailsModel2=stageDetailsDao.save(complaintStageDetailsModel);
					
					if(complaintStageDetailsModel2!=null) {
						for (MultipartFile multipartFile : multipartFiles) {
							uploadImage(multipartFile, complaintModel2.getComplaintId(), complaintStageDetailsModel2);
						}
					}else {
						return "204";
					}
				}else {
					return "204";
				}
			}else {
				return "204";
			}
		}else {
			return "204";
		}
		
		return "200";
	}

	@Override
	public List<ComplaintDto> viewAllComplaint() throws Exception {
		List<ComplaintModel> complaintModels=(List<ComplaintModel>) complaintDao.findAll();
		List<ComplaintDto> complaintDtos=new ArrayList<>();
		
		CustomerModel customerModel=new CustomerModel();
		CategoryModel categoryModel=new CategoryModel();
		
		for (ComplaintModel complaintModel : complaintModels) {
			
			customerModel=complaintModel.getCustomer();
			CustomerDto customerDto=new CustomerDto();
			
			customerDto.setCustomerId(customerModel.getCustomerId());
			customerDto.setCustomerEmail(customerModel.getCustomerEmail());
			customerDto.setCustomerMobile(customerModel.getCustomerMobile());
			customerDto.setCustomerName(customerModel.getCustomerName());
			customerDto.setCustomerNic(customerModel.getCustomerNic());
			
			categoryModel=complaintModel.getCategory();
			CategoryDto categoryDto=new CategoryDto();
			
			categoryDto.setCategoryId(categoryModel.getCategoryId());
			categoryDto.setCategoryName(categoryModel.getCategoryName());
			categoryDto.setIsActive(categoryModel.getIsActive());
			
			ComplaintDto complaintDto=new ComplaintDto();
			
			complaintDto.setCustomerDto(customerDto);
			complaintDto.setCategoryDto(categoryDto);
			complaintDto.setComplaintAction(complaintModel.getComplaintAction());
			complaintDto.setComplaintId(complaintModel.getComplaintId());
			complaintDto.setComplaintMessage(complaintModel.getComplaintMessage());
			complaintDto.setComplaintReference(complaintModel.getComplaintReference());
			complaintDto.setComplaintRootCause(complaintModel.getComplaintRootCause());
			complaintDto.setComplaintStatus(complaintModel.getComplaintStatus());
			complaintDto.setComplaintType(complaintModel.getComplaintType());
			complaintDto.setComplaintSubject(complaintModel.getComplaintSubject());
			
			complaintDtos.add(complaintDto);
		}
		
		return complaintDtos;
	}

	@Override
	public String updateComplaint(ComplaintDto complaintDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String uploadImage(MultipartFile multipartFile,Integer complaintId,ComplaintStageDetailsModel complaintStageDetailsModel) throws Exception {
		
		ImageModel imageModel=new ImageModel();
		
		
		byte[] bytes = multipartFile.getBytes();
		
		String multipartFileName=multipartFile.getOriginalFilename();
		
		String subFileName = AppConstant.IMAGE_UPLOAD_URL+complaintId+"_"+complaintStageDetailsModel.getComplaintStageDetailId();
		
		//create sub file for complaint id
		File  file=new File(subFileName);
		if (!file.exists()) {
			file.mkdir();
        }
		
		String fileName = subFileName+"/" + UUID.randomUUID() +"."+multipartFileName.split("\\.")[1];

		File saveImage = new File(fileName);

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(saveImage));

		stream.write(bytes);
		
		imageModel.setImagePath(fileName);
		imageModel.setComplaintStageDetails(complaintStageDetailsModel);
		imageDao.save(imageModel);
		
		stream.close();
		
		return "success";
	}

	@Override
	public List<ComplaintDto> findByComplaintStatus(String complaintStatus) throws Exception {
		
		List<ComplaintModel> complaintModels=complaintDao.findByComplaintStatus(complaintStatus);
		
		List<ComplaintDto> complaintDtos=new ArrayList<>();
		
		CustomerModel customerModel=new CustomerModel();
		CategoryModel categoryModel=new CategoryModel();
		
		for (ComplaintModel complaintModel : complaintModels) {
			
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			LocalDateTime nowdateTime=LocalDateTime.now();
			LocalDateTime dateTime=LocalDateTime.parse(dateFormat.format(complaintModel.getCreateDate()));
			
			long diff=ChronoUnit.DAYS.between(nowdateTime, dateTime);
			
			if(diff <= 7) {
				customerModel=complaintModel.getCustomer();
				CustomerDto customerDto=new CustomerDto();
				
				customerDto.setCustomerId(customerModel.getCustomerId());
				customerDto.setCustomerEmail(customerModel.getCustomerEmail());
				customerDto.setCustomerMobile(customerModel.getCustomerMobile());
				customerDto.setCustomerName(customerModel.getCustomerName());
				customerDto.setCustomerNic(customerModel.getCustomerNic());
				
				categoryModel=complaintModel.getCategory();
				CategoryDto categoryDto=new CategoryDto();
				
				categoryDto.setCategoryId(categoryModel.getCategoryId());
				categoryDto.setCategoryName(categoryModel.getCategoryName());
				categoryDto.setIsActive(categoryModel.getIsActive());
				
				ComplaintDto complaintDto=new ComplaintDto();
				
				complaintDto.setCustomerDto(customerDto);
				complaintDto.setCategoryDto(categoryDto);
				complaintDto.setComplaintAction(complaintModel.getComplaintAction());
				complaintDto.setComplaintId(complaintModel.getComplaintId());
				complaintDto.setComplaintMessage(complaintModel.getComplaintMessage());
				complaintDto.setComplaintReference(complaintModel.getComplaintReference());
				complaintDto.setComplaintRootCause(complaintModel.getComplaintRootCause());
				complaintDto.setComplaintStatus(complaintModel.getComplaintStatus());
				complaintDto.setComplaintType(complaintModel.getComplaintType());
				complaintDto.setComplaintSubject(complaintModel.getComplaintSubject());
				complaintDto.setComplaintCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(complaintModel.getCreateDate()));
				//complaintDto.setAcknowledgementDate(new SimpleDateFormat("yyyy-MM-dd").format(complaintModel.getAcknowledgementDate()));
				complaintDtos.add(complaintDto);
			}
			
			
		}
		
		return complaintDtos;
	}

	@Override
	public String updateComplaintStatus(ArrayList<Integer> idList) throws Exception {
		
		for (Integer integer : idList) {
			ComplaintModel complaintModel=complaintDao.findOne(integer);
			if(complaintModel!=null) {
				complaintModel.setComplaintStatus(AppConstant.COMPLAINT_STATUS_ACKNOWLEDGE);
				complaintModel.setAcknowledgementDate(new Date());
				complaintDao.save(complaintModel);
				ComplaintStageDetailsModel complaintStageDetailsModel=new ComplaintStageDetailsModel();
				complaintStageDetailsModel.setComplaint(complaintModel);
				stageDetailsService.update(complaintStageDetailsModel, AppConstant.COMPLAINT_STAGE_ACKNOWLEDGE);
			}
		}
		
		return "200";
	}

}
