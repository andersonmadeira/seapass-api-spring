package andersonmadeira.com.seapass.model;

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

}
