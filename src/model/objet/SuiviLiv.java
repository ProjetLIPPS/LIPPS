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
@Table(name = "suivi_liv")
public class SuiviLiv extends DataParent {

	public static final String NOM_ID = "sui_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "sui_ponctualite")
	private String ponctualite = null;

	@Column(name = "sui_assiduite")
	private String assiduite = null;

	@Column(name = "sui_presentation")
	private String presentation = null;

	@Column(name = "sui_adaptation")
	private String adaptation = null;

	@Column(name = "sui_relationnel")
	private String relationnel = null;

	@Column(name = "sui_communication")
	private String communication = null;

	@Column(name = "sui_motivation")
	private String motivation = null;

	@Column(name = "sui_initiative")
	private String initiative = null;

	@Column(name = "sui_autonomie")
	private String autonomie = null;

	@Column(name = "sui_selfControl")
	private String selfControl = null;

	@Column(name = "sui_organisation")
	private String organisation = null;

	@Column(name = "sui_respectRegle")
	private String respectRegle = null;

	@Column(name = "sui_securite")
	private String securite = null;

	@Column(name = "sui_respectMateriel")
	private String respectMateriel = null;

	@Column(name = "sui_qualiteTravail")
	private String qualiteTravail = null;

	@Column(name = "sui_citoyennete")
	private String citoyennete = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "liv_id")
	@NotNull
	private Livret livret = null;

	// Constructeur

	public SuiviLiv(Livret livret) {
		super();
		this.livret = livret;
	}

	// GetSets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPonctualite() {
		return ponctualite;
	}

	public void setPonctualite(String ponctualite) {
		this.ponctualite = ponctualite;
	}

	public String getAssiduite() {
		return assiduite;
	}

	public void setAssiduite(String assiduite) {
		this.assiduite = assiduite;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getAdaptation() {
		return adaptation;
	}

	public void setAdaptation(String adaptation) {
		this.adaptation = adaptation;
	}

	public String getRelationnel() {
		return relationnel;
	}

	public void setRelationnel(String relationnel) {
		this.relationnel = relationnel;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getInitiative() {
		return initiative;
	}

	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}

	public String getAutonomie() {
		return autonomie;
	}

	public void setAutonomie(String autonomie) {
		this.autonomie = autonomie;
	}

	public String getSelfControl() {
		return selfControl;
	}

	public void setSelfControl(String selfControl) {
		this.selfControl = selfControl;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getRespectRegle() {
		return respectRegle;
	}

	public void setRespectRegle(String respectRegle) {
		this.respectRegle = respectRegle;
	}

	public String getSecurite() {
		return securite;
	}

	public void setSecurite(String securite) {
		this.securite = securite;
	}

	public String getRespectMateriel() {
		return respectMateriel;
	}

	public void setRespectMateriel(String respectMateriel) {
		this.respectMateriel = respectMateriel;
	}

	public String getQualiteTravail() {
		return qualiteTravail;
	}

	public void setQualiteTravail(String qualiteTravail) {
		this.qualiteTravail = qualiteTravail;
	}

	public String getCitoyennete() {
		return citoyennete;
	}

	public void setCitoyennete(String citoyennete) {
		this.citoyennete = citoyennete;
	}

	public Livret getLivret() {
		return livret;
	}

	public void setLivret(Livret livret) {
		this.livret = livret;
	}

}
