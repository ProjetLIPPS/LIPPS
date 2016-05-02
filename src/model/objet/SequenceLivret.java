package model.objet;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "sequence_livret")

public class SequenceLivret extends DataParent {

	public static final String NOM_ID = "sel_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "sel_intitule")
	@NotNull
	private String intitule = null;

	@Type(type = "date")
	@Column(name = "sel_date_message")
	@NotNull
	private Date dateMessage = null;

	@Type(type = "date")
	@Column(name = "sel_date_acquisition")
	@NotNull
	private Date dateAcquisition = null;

	@Column(name = "sel_niveau")
	@NotNull
	private String niveau = null;

	@Column(name = "sel_s_observation_stagiaire")
	@NotNull
	private String observationStagiaire = null;

	@Column(name = "sel_f_observation_formateur")
	@NotNull
	private String observationFormateur = null;

	@Column(name = "sel_t_observation_tuteur")
	@NotNull
	private String observationTuteur = null;
	
	@Column(name = "sel_position")
	@NotNull
	private Integer position = null;
	
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mdl_id")
	@NotNull
	private ModuleLivret moduleLivret = null;

	
	


	public SequenceLivret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SequenceLivret(Integer id, String intitule, Date dateMessage, Date dateAcquisition, String niveau,
			String observationStagiaire, String observationFormateur, String observationTuteur, Integer position,
			ModuleLivret moduleLivret) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.dateMessage = dateMessage;
		this.dateAcquisition = dateAcquisition;
		this.niveau = niveau;
		this.observationStagiaire = observationStagiaire;
		this.observationFormateur = observationFormateur;
		this.observationTuteur = observationTuteur;
		this.position = position;
		this.moduleLivret = moduleLivret;
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

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public Date getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(Date dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getObservationStagiaire() {
		return observationStagiaire;
	}

	public void setObservationStagiaire(String observationStagiaire) {
		this.observationStagiaire = observationStagiaire;
	}

	public String getObservationFormateur() {
		return observationFormateur;
	}

	public void setObservationFormateur(String observationFormateur) {
		this.observationFormateur = observationFormateur;
	}

	public String getObservationTuteur() {
		return observationTuteur;
	}

	public void setObservationTuteur(String observationTuteur) {
		this.observationTuteur = observationTuteur;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public ModuleLivret getModuleLivret() {
		return moduleLivret;
	}

	public void setModuleLivret(ModuleLivret moduleLivret) {
		this.moduleLivret = moduleLivret;
	}





	
	

}
