package com.andersonmadeira.seapass.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.andersonmadeira.seapass.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, Long> {
	List<Entry> findAll();
	Page<Entry> findAll(Pageable pageable);
}
