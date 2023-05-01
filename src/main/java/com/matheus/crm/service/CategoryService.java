package com.matheus.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.dto.CategoryDTO;
import com.matheus.crm.entity.Category;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryDTO findCategoryById(Long id){
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		if (!categoryOptional.isPresent()) {
			throw new NotFoundException("ID: " + id + " not found!");
		}
		Category entity = categoryOptional.get();
		
		return new CategoryDTO(entity);
	}
	
	public List<CategoryDTO> findAllCategories(){
		List<Category> list = categoryRepository.findAll();
		
		List<CategoryDTO> listDto = list.stream()
				.map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		return listDto;
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
}
