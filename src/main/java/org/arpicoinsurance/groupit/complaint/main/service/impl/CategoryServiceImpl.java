package org.arpicoinsurance.groupit.complaint.main.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.arpicoinsurance.groupit.complaint.main.dao.CategoryDao;
import org.arpicoinsurance.groupit.complaint.main.dto.CategoryDto;
import org.arpicoinsurance.groupit.complaint.main.model.CategoryModel;
import org.arpicoinsurance.groupit.complaint.main.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public String saveCategory(CategoryDto categoryDto) throws Exception {
		
		CategoryModel categoryModel=new CategoryModel();
		categoryModel.setCategoryName(categoryDto.getCategoryName());
		categoryModel.setCreateDate(new Date());
		categoryModel.setIsActive(categoryDto.getIsActive());
		categoryModel.setUpdateDate(new Date());
		
		return categoryDao.save(categoryModel)!=null ?  "200":"204";
	}

	@Override
	public List<CategoryDto> viewAllCategory() throws Exception {
		
		List<CategoryModel> categoryList= (List<CategoryModel>) categoryDao.findAll();
		List<CategoryDto> categoryDtos=new ArrayList<>();
		
		for (CategoryModel categoryModel : categoryList) {
			CategoryDto categoryDto=new CategoryDto();
			categoryDto.setCategoryId(categoryModel.getCategoryId());
			categoryDto.setCategoryName(categoryModel.getCategoryName());
			categoryDto.setCreateDate(categoryModel.getCreateDate());
			categoryDto.setIsActive(categoryModel.getIsActive());
			categoryDto.setUpdateDate(categoryModel.getUpdateDate());
			
			categoryDtos.add(categoryDto);
		}
		
		return categoryDtos;
	}

	@Override
	public String updateCategory(CategoryDto categoryDto) throws Exception {
		
		CategoryModel categoryModel=new CategoryModel();
		categoryModel.setCategoryId(categoryDto.getCategoryId());
		categoryModel.setCategoryName(categoryDto.getCategoryName());
		categoryModel.setCreateDate(new Date());
		categoryModel.setIsActive(categoryDto.getIsActive());
		categoryModel.setUpdateDate(new Date());
		
		return categoryDao.save(categoryModel)!=null ?  "200":"204";
	}

}
