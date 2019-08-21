package com.andersonmadeira.seapass.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andersonmadeira.seapass.model.Access;

public interface AccessRepository extends CrudRepository<Access, Long> {
	List<Access> findAll();
}
