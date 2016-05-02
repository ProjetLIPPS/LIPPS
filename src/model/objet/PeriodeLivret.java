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
@Table(name = "periode_livret")
public class PeriodeLivret extends DataParent {

	public static final String NOM_ID = "prl_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	
	@Column(name = "prl_date_centre")
	@Type(type = "date")
	private Date dateCentre = null;
	
	@Column(name = "prl_description_centre")
	private String descriptionPeriodeCentre = null;
	
	
	
	@Column(name = "prl_date_entreprise")
	@Type(type = "date")
	private Date dateEntreprise = null;
	
	
	@Column(name = "prl_description_entreprise")
	private String descriptionPeriodeEntreprise = null;
	
	
	
	
	@Column(name = "prl_date_ecf")
	@Type(type = "date")
	private Date dateEcf = null;
	
	
	@Column(name = "prl_texte_ecf")
	private String texteEcf = null;

	
	@Column(name = "prl_position")
	private Integer position = null;
	
	
	
	@OneToOne (fetch=FetchType.EAGER)
	@JoinColumn (name = "ppl_id")
	@NotNull
	private PlanningPrevisionnelLivret planningPrevisionnelLivret = null;

	
	
	
	
	
	
	
	

	public PeriodeLivret(Integer id, Date dateCentre, String descriptionPeriodeCentre, Date dateEntreprise,
			String descriptionPeriodeEntreprise, Date dateEcf, String texteEcf, Integer position,
			PlanningPrevisionnelLivret planningPrevisionnelLivret) {
		super();
		this.id = id;
		this.dateCentre = dateCentre;
		this.descriptionPeriodeCentre = descriptionPeriodeCentre;
		this.dateEntreprise = dateEntreprise;
		this.descriptionPeriodeEntreprise = descriptionPeriodeEntreprise;
		this.dateEcf = dateEcf;
		this.texteEcf = texteEcf;
		this.position = position;
		this.planningPrevisionnelLivret = planningPrevisionnelLivret;
	}

	public PeriodeLivret() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCentre() {
		return dateCentre;
	}

	public void setDateCentre(Date dateCentre) {
		this.dateCentre = dateCentre;
	}

	public String getDescriptionPeriodeCentre() {
		return descriptionPeriodeCentre;
	}

	public void setDescriptionPeriodeCentre(String descriptionPeriodeCentre) {
		this.descriptionPeriodeCentre = descriptionPeriodeCentre;
	}

	public Date getDateEntreprise() {
		return dateEntreprise;
	}

	public void setDateEntreprise(Date dateEntreprise) {
		this.dateEntreprise = dateEntreprise;
	}

	public String getDescriptionPeriodeEntreprise() {
		return descriptionPeriodeEntreprise;
	}

	public void setDescriptionPeriodeEntreprise(String descriptionPeriodeEntreprise) {
		this.descriptionPeriodeEntreprise = descriptionPeriodeEntreprise;
	}

	public Date getDateEcf() {
		return dateEcf;
	}

	public void setDateEcf(Date dateEcf) {
		this.dateEcf = dateEcf;
	}

	public String getTexteEcf() {
		return texteEcf;
	}

	public void setTexteEcf(String texteEcf) {
		this.texteEcf = texteEcf;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public PlanningPrevisionnelLivret getPlanningPrevisionnelLivret() {
		return planningPrevisionnelLivret;
	}

	public void setPlanningPrevisionnelLivret(PlanningPrevisionnelLivret planningPrevisionnelLivret) {
		this.planningPrevisionnelLivret = planningPrevisionnelLivret;
	}

	
	

	
	
}
