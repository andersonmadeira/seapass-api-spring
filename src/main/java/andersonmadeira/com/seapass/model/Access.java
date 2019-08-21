package andersonmadeira.com.seapass.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Access implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pk_access", sequenceName = "access_seq", allocationSize = 1)
	@GeneratedValue(generator = "pk_access", strategy = GenerationType.AUTO)
	private Long id;

	private String host;

	private String port;

	private String user;

	private String pass;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "entry_id")
	private Entry entry;

}
