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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@Column(name = "frm_grnl")
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

	@Column(name = "frm_nb_ccp")
	@NotNull
	private Integer nbccp = null;

	@Column(name = "frm_nb_stage")
	@NotNull
	private Integer nbstage = null;
	
	@Column(name = "frm_model")
	@NotNull
	private boolean isModel;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "prd_id")
	private List<Periode> listPeriod = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spe_id")
	private Specialisation spe_id = null;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "j_formation_module", joinColumns = @JoinColumn(name = "frm_id") , inverseJoinColumns = @JoinColumn(name = "mod_id") )
	private List<Module> listModule = new ArrayList<Module>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "j_utilisateur_formation", joinColumns = @JoinColumn(name = "frm_id") , inverseJoinColumns = @JoinColumn(name = "uti_id") )
	private List<Utilisateur> listUtilisateur = null;

	
	public Formation() {
		super();
	}
	
	public Formation(Integer grn, Integer offre, String intitule, Integer duree, String debouche, Integer nbccp,
			Integer nbstage, Specialisation spe_id) {
		super();
		this.grn = grn;
		this.offre = offre;
		this.intitule = intitule;
		this.duree = duree;
		this.debouche = debouche;
		this.nbccp = nbccp;
		this.nbstage = nbstage;
		this.spe_id = spe_id;
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

	public Integer getNbccp() {
		return nbccp;
	}

	public void setNbccp(Integer nbccp) {
		this.nbccp = nbccp;
	}

	public Integer getNbstage() {
		return nbstage;
	}

	public void setNbstage(Integer nbstage) {
		this.nbstage = nbstage;
	}

	public Specialisation getSpe_id() {
		return spe_id;
	}

	public void setSpe_id(Specialisation spe_id) {
		this.spe_id = spe_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Module> getListModule() {
		return listModule;
	}

	public void setListModule(List<Module> listModule) {
		this.listModule = listModule;
	}
	
	public void addModule(Module module) {
		this.listModule.add(module);
	}

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

}
