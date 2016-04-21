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
@Table(name = "module_livret")

public class ModuleLivret extends DataParent {

	public static final String NOM_ID = "mdl_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "mdl_intitule")
	@NotNull
	private String intitule = null;

	@Column(name = "mdl_resultat")
	private boolean resultat;

	@Column(name = "mdl_observation")
	@NotNull
	private String observation = null;

	@Column(name = "mdl_intitule_specialisation")
	private String intituleSpecialisation = null;
	
	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "liv_id")
	@NotNull
	private Livret livret = null;
	

	public Integer getId() {
		return id;
	}


	public ModuleLivret() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ModuleLivret(Integer id, String intitule, boolean resultat, String observation,
			String intituleSpecialisation, Livret livret) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.resultat = resultat;
		this.observation = observation;
		this.intituleSpecialisation = intituleSpecialisation;
		this.livret = livret;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public boolean isResultat() {
		return resultat;
	}


	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getIntituleSpecialisation() {
		return intituleSpecialisation;
	}


	public void setIntituleSpecialisation(String intituleSpecialisation) {
		this.intituleSpecialisation = intituleSpecialisation;
	}


	public Livret getLivret() {
		return livret;
	}


	public void setLivret(Livret livret) {
		this.livret = livret;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	

}
