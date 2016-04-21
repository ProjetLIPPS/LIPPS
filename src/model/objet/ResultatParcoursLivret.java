package model.objet;

import java.util.Date;

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

import org.hibernate.annotations.Type;

@Entity
@Table(name = "resultat_parcours_livret")
public class ResultatParcoursLivret extends DataParent {

	public static final String NOM_ID = "res_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "res_attestation")
	private String attestation = null;

	@Column(name = "res_observation")
	private String observation = null;

	@Column(name = "res_niveau")
	private String niveau = null;

	@Column(name = "res_emploi")
	private String emploi = null;

	@Type(type = "date")
	@Column(name = "res_date_debut")
	private Date dateDebut = null;

	@Column(name = "res_duree")
	private Integer duree = null;

	@Column(name = "res_certification")
	private String certification = null;

	@Column(name = "res_intitule_certification")
	private String intituleCertification = null;

	@Column(name = "res_type_certification")
	private String typeCertification = null;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "liv_id")
	@NotNull
	private Livret livret = null;
	
	
	public Integer getId() {
		return id;
	}


	public ResultatParcoursLivret() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ResultatParcoursLivret(Integer id, String attestation, String observation, String niveau, String emploi,
			Date dateDebut, Integer duree, String certification, String intituleCertification, String typeCertification,
			Livret livret) {
		super();
		this.id = id;
		this.attestation = attestation;
		this.observation = observation;
		this.niveau = niveau;
		this.emploi = emploi;
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.certification = certification;
		this.intituleCertification = intituleCertification;
		this.typeCertification = typeCertification;
		this.livret = livret;
	}


	public String getAttestation() {
		return attestation;
	}


	public void setAttestation(String attestation) {
		this.attestation = attestation;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getEmploi() {
		return emploi;
	}


	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Integer getDuree() {
		return duree;
	}


	public void setDuree(Integer duree) {
		this.duree = duree;
	}


	public String getCertification() {
		return certification;
	}


	public void setCertification(String certification) {
		this.certification = certification;
	}


	public String getIntituleCertification() {
		return intituleCertification;
	}


	public void setIntituleCertification(String intituleCertification) {
		this.intituleCertification = intituleCertification;
	}


	public String getTypeCertification() {
		return typeCertification;
	}


	public void setTypeCertification(String typeCertification) {
		this.typeCertification = typeCertification;
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
