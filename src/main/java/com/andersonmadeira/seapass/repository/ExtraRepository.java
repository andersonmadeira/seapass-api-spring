package com.andersonmadeira.seapass.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andersonmadeira.seapass.model.Extra;

public interface ExtraRepository extends CrudRepository<Extra, Long> {
	List<Extra> findAll();
}
