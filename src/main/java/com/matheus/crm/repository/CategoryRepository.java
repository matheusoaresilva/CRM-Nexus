package com.matheus.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	Optional<Category> findById(Long id);
}
