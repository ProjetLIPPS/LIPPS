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

	@Column(name = "prd_typ")
	private Integer typePeriode = null;

	public Integer getId() {
		return id;
	}

}
