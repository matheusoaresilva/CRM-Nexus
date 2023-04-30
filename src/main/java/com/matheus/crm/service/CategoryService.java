package com.matheus.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.Category;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<Category> findCategoryById(Long id){
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		if (!categoryOptional.isPresent()) {
			throw new NotFoundException("ID: " + id + " not found!");
		}
		return categoryOptional;
	}
	
	public List<Category> findAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
}
