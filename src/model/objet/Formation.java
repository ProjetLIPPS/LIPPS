package model.objet;

import java.util.ArrayList;
import java.util.Date;
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

import org.hibernate.annotations.Type;



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
	private String ccp = null;

	@Column(name = "frm_nombre_stage")
	private Integer nombreStage = null;
	
	
	@Column(name = "frm_model")
	@NotNull
	private boolean isModel;
	
	@Type(type = "date")
	@Column(name = "frm_date_debut")
	private Date dateDebut = null;
	
	@Type(type = "date")
	@Column(name = "frm_date_fin")
	private Date dateFin = null;

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
	
	


	public Formation(Integer id, Integer grn, Integer offre, String intitule, Integer duree, String debouche,
			String ccp, Integer nombreStage, Date dateDebut, Date dateFin,
			Specialisation specialisation, boolean isModel) 
	{
		super();
		this.id = id;
		this.grn = grn;
		this.offre = offre;
		this.intitule = intitule;
		this.duree = duree;
		this.debouche = debouche;
		this.ccp = ccp;
		this.nombreStage = nombreStage;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.specialisation = specialisation;
		this.isModel = isModel;
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



	public boolean isModel() {
		return isModel;
	}


	public void setModel(boolean isModel) {
		this.isModel = isModel;
	}


	public String getCcp() {
		return ccp;
	}


	public void setCcp(String ccp) {
		this.ccp = ccp;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}




}
