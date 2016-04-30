package model.objet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sequence")
public class Sequence extends DataParent {
	
	public static final String NOM_ID = "seq_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "seq_intitule")
	@NotNull
	private String intitule = null;
	
	@Column(name = "seq_position")
	@NotNull
	private Integer position = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mod_id")
	@NotNull
	private Module module = null;



	public Sequence() {
		super();
 	}

	public Sequence(Integer id, String intitule, Module module, Integer position) 
	{
		super();
		this.id = id;
		this.intitule = intitule;
		this.position = position;
		this.module = module;
	}
	

	
	public Integer getId() {
		return id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	
}
