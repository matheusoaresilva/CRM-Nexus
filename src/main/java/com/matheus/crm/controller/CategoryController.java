package com.matheus.crm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.entity.Category;
import com.matheus.crm.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(
			value = "/category/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Category>> findCategoryById(@PathVariable(name = "id") Long id) {
		Optional<Category> category = categoryService.findCategoryById(id);
		if (category == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(category);
	}
}
