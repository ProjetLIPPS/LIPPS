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
@Table(name = "sequence_liv")

public class SequenceLivret extends DataParent {

	public static final String NOM_ID = "sel_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "sel_intitule")
	@NotNull
	private String intitule = null;

	@Type(type = "date")
	@Column(name = "sel_date_mes")
	@NotNull
	private Date dateMessage = null;

	@Type(type = "date")
	@Column(name = "sel_date_acq")
	@NotNull
	private Date dateAcquisition = null;

	@Column(name = "sel_niveau")
	@NotNull
	private String niveau = null;

	@Column(name = "sel_s_obs")
	@NotNull
	private String observationStagiaire = null;

	@Column(name = "sel_f_obs")
	@NotNull
	private String observationFormateur = null;

	@Column(name = "sel_t_obs")
	@NotNull
	private String observationTuteur = null;

	public Integer getId() {
		return id;
	}


}
