package model.objet;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "periode_liv")
public class PeriodeLiv extends DataParent {

	public static final String NOM_ID = "per_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "per_date_deb")
	private Date dateDeb = null;

	@Column(name = "per_date_fin")
	private Date dateFin = null;

	@Column(name = "per_typ")
	private Integer typePeriode = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "liv_id")
	@NotNull
	private Livret livret = null;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "j_liv_periode", joinColumns = @JoinColumn(name = "per_id") , inverseJoinColumns = @JoinColumn(name = "liv_id") )
	private List<Livret> listLivret = null;

	// Constructeur

	public PeriodeLiv(Integer id, Date dateDebut, Date dateFin, Integer typeId) {
		super();
		this.id = id;
		this.dateDeb = dateDebut;
		this.dateFin = dateFin;
		this.typePeriode = typeId;
	}

	// GetSets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Livret getLivret() {
		return livret;
	}

	public void setLivret(Livret livret) {
		this.livret = livret;
	}

}
