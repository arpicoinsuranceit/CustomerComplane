package org.arpicoinsurance.groupit.complaint.main.service.impl;

import javax.transaction.Transactional;
import org.arpicoinsurance.groupit.complaint.main.dao.ImageDao;
import org.arpicoinsurance.groupit.complaint.main.dto.ImageDto;
import org.arpicoinsurance.groupit.complaint.main.model.ImageModel;
import org.arpicoinsurance.groupit.complaint.main.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageDao imageDao;

	@Override
	public ImageDto searchImage(Integer id) throws Exception {
		ImageModel imageModel=imageDao.findOne(id);
		
		ImageDto imageDto=new ImageDto();
		imageDto.setImageId(imageModel.getImageId());
		imageDto.setImagePath(imageModel.getImagePath());
		
		return imageDto;
	}
	
	
	
}
