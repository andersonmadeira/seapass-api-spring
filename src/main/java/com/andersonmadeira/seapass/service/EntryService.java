package com.andersonmadeira.seapass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.andersonmadeira.seapass.dto.CredentialsDTO;
import com.andersonmadeira.seapass.dto.EntryDTO;
import com.andersonmadeira.seapass.exception.ObjectNotFoundException;
import com.andersonmadeira.seapass.model.Credentials;
import com.andersonmadeira.seapass.model.Entry;
import com.andersonmadeira.seapass.repository.CredentialsRepository;
import com.andersonmadeira.seapass.repository.EntryRepository;

@Service
public class EntryService {

	@Autowired
	EntryRepository repo;

	@Autowired
	CredentialsRepository accessRepo;

	public Page<Entry> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Entry findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Entry not found: " + id));
	}

	public void save(EntryDTO dto) {
		Entry e = new Entry();

		e.setId(dto.getId());
		e.setName(dto.getName());

		repo.save(e);
	}

	public void setEntryAccess(Long entryId, CredentialsDTO dto) {
		Entry entry = findById(entryId);
		Credentials credentials = new Credentials();

		credentials.setId(dto.getId());
		credentials.setHostname(dto.getHostname());
		credentials.setPort(dto.getPort());
		credentials.setUsername(dto.getUsername());
		credentials.setPassword(dto.getPassword());

		credentials.setEntry(entry);

		accessRepo.save(credentials);

		entry.setCredentials(credentials);

		repo.save(entry);
	}

	public void remove(Long entryId) {
		Entry entry = findById(entryId);
		repo.delete(entry);
	}

}
