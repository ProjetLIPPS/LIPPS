package model.objet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "module")
public class Module extends DataParent {

	public static final String NOM_ID = "mod_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "mod_intitule")
	@NotNull
	private String intitule = null;

	@OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
	private List<FormationToModule> formationToModule = null;

	public Integer getId() {
		return id;
	}

	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Module(Integer id, String intitule, List<FormationToModule> formationToModule) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.formationToModule = formationToModule;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<FormationToModule> getFormationToModule() {
		return formationToModule;
	}

	public void setFormationToModule(List<FormationToModule> formationToModule) {
		this.formationToModule = formationToModule;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
