//package com.matheus.crm.service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.matheus.crm.dto.CategoryDTO;
//import com.matheus.crm.entity.Category;
//import com.matheus.crm.repository.CategoryRepository;
//import com.matheus.crm.service.exception.DatabaseException;
//import com.matheus.crm.service.exception.NotFoundException;
//
//@Service
//public class CategoryService {
//
//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	@Transactional(readOnly = true)
//	public CategoryDTO findCategoryById(Long id){
//		Optional<Category> categoryOptional = categoryRepository.findById(id);
//		Category entity = categoryOptional.orElseThrow(() -> new NotFoundException("ID: " + id + " not found!"));
//
//		return new CategoryDTO(entity);
//	}
//
//	@Transactional(readOnly = true)
//	public List<CategoryDTO> findAllCategories(){
//		List<Category> list = categoryRepository.findAll();
//
//		List<CategoryDTO> listDto = list.stream()
//				.map(x -> new CategoryDTO(x)).collect(Collectors.toList());
//		return listDto;
//	}
//
//	@Transactional
//	public CategoryDTO addCategory(CategoryDTO category) {
//		Category entity = new Category();
//		entity.setName(category.getName());
//		entity.setDescription(category.getDescription());
//		entity = categoryRepository.save(entity);
//		return new CategoryDTO(entity);
//	}
//
//	@Transactional
//	public CategoryDTO updateCategory(Long id, CategoryDTO category) {
//		Category entity = categoryRepository.findById(id)
//	            .orElseThrow(() -> new NotFoundException("Category not found for id: " + id));
//
//	    entity.setName(category.getName());
//	    entity.setDescription(category.getDescription());
//
//	    Category updatedCategory = categoryRepository.save(entity);
//
//	    return new CategoryDTO(updatedCategory);
//	}
//
//	public void deleteCategoryById(Long id) {
//		try {
//			categoryRepository.deleteById(id);
//		} catch (EmptyResultDataAccessException e) {
//			throw new NotFoundException("Id not found!");
//		}
//		catch (DataIntegrityViolationException e) {
//			throw new DatabaseException("Integrity violation");
//		}
//	}
//
//}
