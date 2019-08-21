package com.andersonmadeira.seapass.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andersonmadeira.seapass.model.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
	List<Credentials> findAll();
}
