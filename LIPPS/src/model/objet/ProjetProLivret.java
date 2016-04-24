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
@Table(name = "projet_pro_livret")
public class ProjetProLivret extends DataParent {

	public static final String NOM_ID = "pro_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "pro_experience")
	private String experience = null;

	@Column(name = "pro_motivation")
	private String motivation = null;

	@Column(name = "pro_attente")
	private String attente = null;

	@Column(name = "pro_action")
	private String action = null;

	@Type(type = "date")
	@Column(name = "pro_date")
	private Date date = null;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "liv_id")
	@NotNull
	private Livret livret = null;
	
	public Integer getId() {
		return id;
	}

	public ProjetProLivret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjetProLivret(Integer id, String experience, String motivation, String attente, String action, Date date,
			Livret livret) {
		super();
		this.id = id;
		this.experience = experience;
		this.motivation = motivation;
		this.attente = attente;
		this.action = action;
		this.date = date;
		this.livret = livret;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getAttente() {
		return attente;
	}

	public void setAttente(String attente) {
		this.attente = attente;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
