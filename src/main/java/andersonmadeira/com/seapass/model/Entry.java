package andersonmadeira.com.seapass.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@OneToOne(mappedBy = "entry")
	private Access access;

	@OneToMany(mappedBy = "entry")
	private List<Extra> extras = new ArrayList<>();

}
