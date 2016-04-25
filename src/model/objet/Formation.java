package model.objet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "formation")
public class Formation extends DataParent {

	public static final String NOM_ID = "frm_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "frm_grn")
	@NotNull
	private Integer grn = null;

	@Column(name = "frm_offre")
	@NotNull
	private Integer offre = null;

	@Column(name = "frm_intitule")
	@NotNull
	private String intitule = null;

	@Column(name = "frm_duree")
	@NotNull
	private Integer duree = null;

	@Column(name = "frm_debouche")
	@NotNull
	private String debouche = null;

	@Column(name = "frm_nombre_ccp")
	@NotNull
	private Integer nombreCCP = null;

	@Column(name = "frm_nombre_stage")
	@NotNull
	private Integer nombreStage = null;
	
	
	@Column(name = "frm_model")
	@NotNull
	private boolean isModel;

	@OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	private List<UtilisateurToFormation> utilisateurToFormation = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "spe_id")
	@NotNull
	private Specialisation specialisation = null;

	@OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	private List<FormationToModule> formationToModule = null;

	
	
	
	public Formation() {
		super();
	}
	
	public Formation(Integer grn, Integer offre, String intitule, Integer duree, String debouche, Integer nbccp,
			Integer nbstage, Specialisation spe_id) {

		super();
	}


	public Formation(Integer id, Integer grn, Integer offre, String intitule, Integer duree, String debouche,
			Integer nombreCCP, Integer nombreStage, List<UtilisateurToFormation> utilisateurToFormation,
			Specialisation specialisation, List<FormationToModule> formationToModule) {
		super();
		this.id = id;
		this.grn = grn;
		this.offre = offre;
		this.intitule = intitule;
		this.duree = duree;
		this.debouche = debouche;
		this.nombreCCP = nombreCCP;
		this.nombreStage = nombreStage;
		this.utilisateurToFormation = utilisateurToFormation;
		this.specialisation = specialisation;
		this.formationToModule = formationToModule;
	}


	public Integer getId() {
		return id;
	}

	public Integer getGrn() {
		return grn;
	}


	public void setGrn(Integer grn) {
		this.grn = grn;
	}


	public Integer getOffre() {
		return offre;
	}


	public void setOffre(Integer offre) {
		this.offre = offre;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public Integer getDuree() {
		return duree;
	}


	public void setDuree(Integer duree) {
		this.duree = duree;
	}


	public String getDebouche() {
		return debouche;
	}


	public void setDebouche(String debouche) {
		this.debouche = debouche;
	}


	public Integer getNombreCCP() {
		return nombreCCP;
	}


	public void setNombreCCP(Integer nombreCCP) {
		this.nombreCCP = nombreCCP;
	}


	public Integer getNombreStage() {
		return nombreStage;
	}


	public void setNombreStage(Integer nombreStage) {
		this.nombreStage = nombreStage;
	}


	public List<UtilisateurToFormation> getUtilisateurToFormation() {
		return utilisateurToFormation;
	}


	public void setUtilisateurToFormation(List<UtilisateurToFormation> utilisateurToFormation) {
		this.utilisateurToFormation = utilisateurToFormation;
	}


	public Specialisation getSpecialisation() {
		return specialisation;
	}


	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
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
