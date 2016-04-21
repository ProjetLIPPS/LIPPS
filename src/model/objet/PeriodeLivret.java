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

@Entity
@Table(name = "periode_livret")
public class PeriodeLivret extends DataParent {

	public static final String NOM_ID = "per_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "per_date_debut")
	private Date dateDebut = null;

	@Column(name = "per_date_fin")
	private Date dateFin = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tpl_id")
	@NotNull
	private TypePeriodeLivret typePeriodeLivret = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "liv_id")
	@NotNull
	private Livret livret = null;

	public Integer getId() {
		return id;
	}

	public PeriodeLivret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PeriodeLivret(Integer id, Date dateDebut, Date dateFin, TypePeriodeLivret typePeriodeLivret, Livret livret) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typePeriodeLivret = typePeriodeLivret;
		this.livret = livret;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public TypePeriodeLivret getTypePeriodeLivret() {
		return typePeriodeLivret;
	}

	public void setTypePeriodeLivret(TypePeriodeLivret typePeriodeLivret) {
		this.typePeriodeLivret = typePeriodeLivret;
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
