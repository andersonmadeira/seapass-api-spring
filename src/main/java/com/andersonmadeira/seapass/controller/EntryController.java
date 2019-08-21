package com.andersonmadeira.seapass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonmadeira.seapass.dto.CredentialsDTO;
import com.andersonmadeira.seapass.dto.EntryDTO;
import com.andersonmadeira.seapass.model.Credentials;
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
	
	@PostMapping("/entries")
	ResponseEntity<Void> addNewEntry(@RequestBody EntryDTO dto) {
		service.save(dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/entries/{id}")
	ResponseEntity<Void> removeEntry(@PathVariable Long id) {
		service.remove(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/entries/{id}/credentials")
	ResponseEntity<Credentials> getEntryAccess(@PathVariable Long id) {
		Entry entry = service.findById(id);
		return ResponseEntity.ok(entry.getCredentials());
	}
	
	@PutMapping("/entries/{id}/credentials")
	ResponseEntity<Credentials> updateEntryAccess(@PathVariable Long id, @RequestBody CredentialsDTO dto) {
		service.setEntryAccess(id, dto);
		return ResponseEntity.ok().build();
	}
}
