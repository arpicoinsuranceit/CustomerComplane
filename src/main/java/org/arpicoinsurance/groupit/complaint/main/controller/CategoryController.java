package org.arpicoinsurance.groupit.complaint.main.controller;

import java.util.List;
import org.arpicoinsurance.groupit.complaint.main.dto.CategoryDto;
import org.arpicoinsurance.groupit.complaint.main.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/complaint/category/add_category" , method=RequestMethod.POST)
	public String saveCategory(@RequestBody CategoryDto categoryDto) throws Exception{
		return categoryService.saveCategory(categoryDto);
	}
	
	@RequestMapping(value="/complaint/category/update_category" , method=RequestMethod.POST)
	public String updateCategory(@RequestBody CategoryDto categoryDto) throws Exception{
		return categoryService.updateCategory(categoryDto);
	}
	
	@RequestMapping(value="/view_category" , method=RequestMethod.GET)
	@ResponseBody
	public List<CategoryDto> getAllCategory() throws Exception{
		return categoryService.viewAllCategory();
	}

}
