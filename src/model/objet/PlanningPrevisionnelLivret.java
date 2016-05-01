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
@Table(name = "planning_previsionnel")
public class PlanningPrevisionnelLivret extends DataParent
{
	
	public static final String NOM_ID = "ppl_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;
	
	
	@Column(name = "ppl_date_evaluation_finale")
	@Type(type = "date")
	private Date dateEvaluationFinale = null;
	
	@Column(name = "ppl_texte_evaluation_finale")
	private String descriptionEvaluationFinale = null;

	
	@OneToOne (fetch=FetchType.EAGER)
	@JoinColumn (name = "liv_id")
	@NotNull
	private Livret livret = null;
	
	
	
	public PlanningPrevisionnelLivret()
	{
		super();
	}



	public PlanningPrevisionnelLivret(Integer id, Date dateEvaluationFinale, String descriptionEvaluationFinale,
			Livret livret)
	{
		super();
		this.id = id;
		this.dateEvaluationFinale = dateEvaluationFinale;
		this.descriptionEvaluationFinale = descriptionEvaluationFinale;
		this.livret = livret;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getDateEvaluationFinale() {
		return dateEvaluationFinale;
	}



	public void setDateEvaluationFinale(Date dateEvaluationFinale) {
		this.dateEvaluationFinale = dateEvaluationFinale;
	}



	public String getDescriptionEvaluationFinale() {
		return descriptionEvaluationFinale;
	}



	public void setDescriptionEvaluationFinale(String descriptionEvaluationFinale) {
		this.descriptionEvaluationFinale = descriptionEvaluationFinale;
	}



	public Livret getLivret() {
		return livret;
	}



	public void setLivret(Livret livret) {
		this.livret = livret;
	}


	
	
	
	
	
	
	
	
	
}
