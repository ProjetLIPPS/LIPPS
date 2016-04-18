package model.objet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mod_id")
	private Module modId = null;

	public Sequence(Integer id, String intitule, Module modId) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.modId = modId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Module getModId() {
		return modId;
	}

	public void setModId(Module modId) {
		this.modId = modId;
	}

	public static String getNomId() {
		return NOM_ID;
	}

}
