package org.arpicoinsurance.groupit.complaint.main.service;

import java.util.List;

import org.arpicoinsurance.groupit.complaint.main.dto.CategoryDto;

public interface CategoryService {
	
	public String saveCategory(CategoryDto categoryDto)throws Exception;
	
	public List<CategoryDto> viewAllCategory()throws Exception;
	
	public String updateCategory(CategoryDto categoryDto)throws Exception;

}
