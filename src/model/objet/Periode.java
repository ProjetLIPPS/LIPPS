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
@Table(name = "periode")
public class Periode extends DataParent {
	public static final String NOM_ID = "prd_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "prd_debut")
	@Type(type = "date")
	@NotNull
	private Date dateDebut = null;

	@Column(name = "prd_fin")
	@Type(type = "date")
	private Date dateFin = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "frm_id")
	private Formation formation = null;

	@Column(name = "prd_typ")
	private Integer typePeriode = null;

	public Periode(Integer id, Date dateDebut, Date dateFin, Formation formation, Integer typeId) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.formation = formation;
		this.typePeriode = typeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Formation getFrmId() {
		return formation;
	}

	public void setFrmId(Formation formation) {
		this.formation = formation;
	}

}
