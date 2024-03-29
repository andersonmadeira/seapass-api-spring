package com.andersonmadeira.seapass.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pk_entry", sequenceName = "entry_seq", allocationSize = 1)
	@GeneratedValue(generator = "pk_entry", strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToOne(mappedBy = "entry")
	private Credentials credentials;

	@OneToMany(mappedBy = "entry")
	private List<Extra> extras = new ArrayList<>();

	public Entry() {
	}

	public Entry(Long id, String name, Credentials credentials, List<Extra> extras) {
		super();
		this.id = id;
		this.name = name;
		this.credentials = credentials;
		this.extras = extras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<Extra> getExtras() {
		return extras;
	}

	public void setExtras(List<Extra> extras) {
		this.extras = extras;
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
		Entry other = (Entry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
