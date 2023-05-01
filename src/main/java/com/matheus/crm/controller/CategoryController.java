package com.matheus.crm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.crm.dto.CategoryDTO;
import com.matheus.crm.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(
			value = "/category/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable(name = "id") Long id) {
		CategoryDTO category = categoryService.findCategoryById(id);
		return ResponseEntity.ok(category);
	}
	
	@RequestMapping(
			value = "/getcategories", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CategoryDTO>> getCategories(){
		List<CategoryDTO> category = categoryService.findAllCategories();
		if (category.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(category);
	}
	
	@RequestMapping(
			value = "/createcategory",consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDto) {
		categoryDto = categoryService.addCategory(categoryDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoryDto.getId()).toUri();
		return ResponseEntity.created(uri).body(categoryDto);
	}
	
}
