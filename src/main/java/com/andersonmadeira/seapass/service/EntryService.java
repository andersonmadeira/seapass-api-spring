package com.andersonmadeira.seapass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.andersonmadeira.seapass.exception.ObjectNotFoundException;
import com.andersonmadeira.seapass.model.Entry;
import com.andersonmadeira.seapass.repository.EntryRepository;

@Service
public class EntryService {

	@Autowired
	EntryRepository repo;
	
	public Page<Entry> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public Entry findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Entry not found: " + id));
	}
	
}
