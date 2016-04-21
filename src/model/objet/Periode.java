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
@Table(name = "periode")
public class Periode extends DataParent {
	public static final String NOM_ID = "prd_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "prd_date_debut")
	@Type(type = "date")
	@NotNull
	private Date dateDebut = null;

	@Column(name = "prd_date_fin")
	@Type(type = "date")
	private Date dateFin = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "frm_id")
	@NotNull
	private Formation formation = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tpe_id")
	@NotNull
	private TypePeriode typePeriode = null;

	public Integer getId() {
		return id;
	}

	public Periode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Periode(Integer id, Date dateDebut, Date dateFin, Formation formation, TypePeriode typePeriode) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.formation = formation;
		this.typePeriode = typePeriode;
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public TypePeriode getTypePeriode() {
		return typePeriode;
	}

	public void setTypePeriode(TypePeriode typePeriode) {
		this.typePeriode = typePeriode;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
