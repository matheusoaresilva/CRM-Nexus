package com.matheus.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.Category;
import com.matheus.crm.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<Category> findCategoryById(Long id){
		Optional<Category> category = categoryRepository.findById(id);
		return category;
	}
}
