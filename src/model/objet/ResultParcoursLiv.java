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
@Table(name = "result_parcours_liv")
public class ResultParcoursLiv extends DataParent {

	public static final String NOM_ID = "res_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "res_attest")
	private String attest = null;

	@Column(name = "res_obs")
	private String obs = null;

	@Column(name = "res_niveau")
	private String niveau = null;

	@Column(name = "res_emploi")
	private String emploi = null;

	@Type(type = "date")
	@Column(name = "res_date_deb")
	private Date dateDeb = null;

	@Column(name = "res_duree")
	private Integer duree = null;

	@Column(name = "res_certif")
	private String certif = null;

	@Column(name = "res_int_certif")
	private String intitCertif = null;

	@Column(name = "res_type_certif")
	private String typeCertif = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "liv_id")
	@NotNull
	private Livret livret = null;

	// Constructeur

	public ResultParcoursLiv(Livret livret) {
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

	public String getAttest() {
		return attest;
	}

	public void setAttest(String attest) {
		this.attest = attest;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
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

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getCertif() {
		return certif;
	}

	public void setCertif(String certif) {
		this.certif = certif;
	}

	public String getIntitCertif() {
		return intitCertif;
	}

	public void setIntitCertif(String intitCertif) {
		this.intitCertif = intitCertif;
	}

	public String getTypeCertif() {
		return typeCertif;
	}

	public void setTypeCertif(String typeCertif) {
		this.typeCertif = typeCertif;
	}

	public Livret getLivret() {
		return livret;
	}

	public void setLivret(Livret livret) {
		this.livret = livret;
	}

}
