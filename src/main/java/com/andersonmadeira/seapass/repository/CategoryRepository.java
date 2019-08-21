package com.andersonmadeira.seapass.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andersonmadeira.seapass.model.Category;
import com.andersonmadeira.seapass.model.Credentials;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
}
