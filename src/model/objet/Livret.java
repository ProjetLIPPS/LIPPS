package model.objet;

import java.util.List;

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
@Table(name = "livret")
public class Livret extends DataParent {

	public static final String NOM_ID = "liv_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "liv_cloture")
	@NotNull
	private boolean cloture;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "mdl_id")
	private List<ModuleLiv> listModuleLiv = null;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "j_liv_periode", joinColumns = @JoinColumn(name = "liv_id") , inverseJoinColumns = @JoinColumn(name = "per_id") )
	private List<PeriodeLiv> listperiodeLiv = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "anx_id")
	private AnnexeLiv annexe = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private ProjetProLiv projetPro = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "res_id")
	private ResultParcoursLiv resultatParcours = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sui_id")
	private SuiviLiv suivi = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uti_id")
	private Utilisateur user = null;

	public Livret(Integer id, Utilisateur user) {
		super();
		this.cloture = false;
		this.user = user;

	}

	// Getters Setters

	public Integer getId() {
		return id;
	}

	public AnnexeLiv getAnnexe() {
		return annexe;
	}

	public void setAnnexe(AnnexeLiv annexe) {
		this.annexe = annexe;
	}

	public ProjetProLiv getProjetPro() {
		return projetPro;
	}

	public void setProjetPro(ProjetProLiv projetPro) {
		this.projetPro = projetPro;
	}

	public ResultParcoursLiv getResultatParcours() {
		return resultatParcours;
	}

	public void setResultatParcours(ResultParcoursLiv resultatParcours) {
		this.resultatParcours = resultatParcours;
	}

	public SuiviLiv getSuivi() {
		return suivi;
	}

	public void setSuivi(SuiviLiv suivi) {
		this.suivi = suivi;
	}

	public List<ModuleLiv> getListModuleLiv() {
		return listModuleLiv;
	}

	public void setListModuleLiv(List<ModuleLiv> listModuleLiv) {
		this.listModuleLiv = listModuleLiv;
	}

	public List<PeriodeLiv> getListperiodeLiv() {
		return listperiodeLiv;
	}

	public void setListperiodeLiv(List<PeriodeLiv> listperiodeLiv) {
		this.listperiodeLiv = listperiodeLiv;
	}

	public void setId(Integer liv_id) {
		this.id = liv_id;
	}

	public boolean getCloture() {
		return cloture;
	}

	public void setCloture(boolean liv_cloture) {
		this.cloture = liv_cloture;
	}

	public Utilisateur getUtilisateur() {
		return user;
	}

	public void setUtilisateur(Utilisateur user) {
		this.user = user;
	}

}// END LIVRET
