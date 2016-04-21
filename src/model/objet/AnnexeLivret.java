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
@Table(name = "annexe_livret")
public class AnnexeLivret extends DataParent {

	public static final String NOM_ID = "anx_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "anx_objet")
	private String objet = null;

	@Type(type = "date")
	@Column(name = "anx_date")
	private Date date = null;

	@Column(name = "anx_duree")
	private Integer duree = null;

	@Column(name = "anx_duree_totale")
	private Integer dureeTotale = null;

	@Column(name = "anx_modalite")
	private String modalite = null;

	@Column(name = "anx_acteur")
	private String acteur = null;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "liv_id")
	@NotNull
	private Livret livret = null;
	
	
	public Integer getId() {
		return id;
	}


	public AnnexeLivret() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AnnexeLivret(Integer id, String objet, Date date, Integer duree, Integer dureeTotale, String modalite,
			String acteur, Livret livret) {
		super();
		this.id = id;
		this.objet = objet;
		this.date = date;
		this.duree = duree;
		this.dureeTotale = dureeTotale;
		this.modalite = modalite;
		this.acteur = acteur;
		this.livret = livret;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getDuree() {
		return duree;
	}


	public void setDuree(Integer duree) {
		this.duree = duree;
	}


	public Integer getDureeTotale() {
		return dureeTotale;
	}


	public void setDureeTotale(Integer dureeTotale) {
		this.dureeTotale = dureeTotale;
	}


	public String getModalite() {
		return modalite;
	}


	public void setModalite(String modalite) {
		this.modalite = modalite;
	}


	public String getActeur() {
		return acteur;
	}


	public void setActeur(String acteur) {
		this.acteur = acteur;
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
