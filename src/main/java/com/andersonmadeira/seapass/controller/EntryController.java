package com.andersonmadeira.seapass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonmadeira.seapass.model.Entry;
import com.andersonmadeira.seapass.service.EntryService;

@RestController
@RequestMapping("/api")
public class EntryController {
	
	@Autowired
	EntryService service;
	
	@GetMapping("/entries")
	ResponseEntity<Page<Entry>> findAll(Pageable pageable) {
		Page<Entry> pagedEntries = service.findAll(pageable);
		return ResponseEntity.ok(pagedEntries);
	}
	
	@GetMapping("/entries/{id}")
	ResponseEntity<Entry> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
