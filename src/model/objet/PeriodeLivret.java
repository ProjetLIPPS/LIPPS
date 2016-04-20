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
public class PeriodeLivret extends DataParent {

	public static final String NOM_ID = "per_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "per_date_deb")
	private Date dateDebut = null;

	@Column(name = "per_date_fin")
	private Date dateFin = null;

	@Column(name = "per_typ")
	private Integer typePeriode = null;

	public Integer getId() {
		return id;
	}

}
