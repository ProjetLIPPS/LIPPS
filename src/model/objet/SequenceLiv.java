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
@Table(name = "sequence_liv")

public class SequenceLiv extends DataParent {

	public static final String NOM_ID = "sql_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "sql_intitule")
	@NotNull
	private String intitule = null;

	@Type(type = "date")
	@Column(name = "sql_date_mes")
	@NotNull
	private Date dateMes = null;

	@Type(type = "date")
	@Column(name = "sql_date_acq")
	@NotNull
	private Date dateAcq = null;

	@Column(name = "sql_niveau")
	@NotNull
	private String niveau = null;

	@Column(name = "sql_s_obs")
	@NotNull
	private String obsStagiaire = null;

	@Column(name = "sql_f_obs")
	@NotNull
	private String obsFormateur = null;

	@Column(name = "sql_t_obs")
	@NotNull
	private String obsTuteur = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mdl_id")
	private ModuleLiv mdlId = null;

	public SequenceLiv(Integer id, String intitule, ModuleLiv mdlId) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.mdlId = mdlId;
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

	public ModuleLiv getModId() {
		return mdlId;
	}

	public void setMdlId(ModuleLiv mdlId) {
		this.mdlId = mdlId;
	}

	public static String getNomId() {
		return NOM_ID;
	}

	public Date getDateMes() {
		return dateMes;
	}

	public void setDateMes(Date dateMes) {
		this.dateMes = dateMes;
	}

	public Date getDateAcq() {
		return dateAcq;
	}

	public void setDateAcq(Date dateAcq) {
		this.dateAcq = dateAcq;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getObsStagiaire() {
		return obsStagiaire;
	}

	public void setObsStagiaire(String obsStagiaire) {
		this.obsStagiaire = obsStagiaire;
	}

	public String getObsFormateur() {
		return obsFormateur;
	}

	public void setObsFormateur(String obsFormateur) {
		this.obsFormateur = obsFormateur;
	}

	public String getObsTuteur() {
		return obsTuteur;
	}

	public void setObsTuteur(String obsTuteur) {
		this.obsTuteur = obsTuteur;
	}

}
