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

}
