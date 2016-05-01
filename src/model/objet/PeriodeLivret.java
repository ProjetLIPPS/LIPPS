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

	
	public Integer getId() {
		return id;
	}

	public PeriodeLivret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PeriodeLivret(Integer id)
	{
		super();
		this.id = id;
	}

	
	
}
