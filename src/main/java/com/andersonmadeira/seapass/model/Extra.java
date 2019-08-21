package com.andersonmadeira.seapass.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Extra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pk_extra", sequenceName = "extra_seq", allocationSize = 1)
	@GeneratedValue(generator = "pk_extra", strategy = GenerationType.AUTO)
	private Long id;

	private String key;

	private Access value;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "entry_id")
	private Entry entry;
	
	public Extra() {
	}

	public Extra(Long id, String key, Access value, Entry entry) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.entry = entry;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Access getValue() {
		return value;
	}

	public void setValue(Access value) {
		this.value = value;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extra other = (Extra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
