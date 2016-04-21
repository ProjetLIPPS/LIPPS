package model.objet;

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

@Entity
@Table(name = "suivi_livret")
public class SuiviLivret extends DataParent {

	public static final String NOM_ID = "sui_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "sui_ponctualite")
	private String ponctualite = null;

	@Column(name = "sui_assiduite")
	private String assiduite = null;

	@Column(name = "sui_presentation")
	private String presentation = null;

	@Column(name = "sui_adaptation")
	private String adaptation = null;

	@Column(name = "sui_relationnel")
	private String relationnel = null;

	@Column(name = "sui_communication")
	private String communication = null;

	@Column(name = "sui_motivation")
	private String motivation = null;

	@Column(name = "sui_initiative")
	private String initiative = null;

	@Column(name = "sui_autonomie")
	private String autonomie = null;

	@Column(name = "sui_maitrise_de_soi")
	private String maitriseDeSoi = null;

	@Column(name = "sui_organisation")
	private String organisation = null;

	@Column(name = "sui_respect_regle")
	private String respectRegle = null;

	@Column(name = "sui_securite")
	private String securite = null;

	@Column(name = "sui_respect_materiel")
	private String respectMateriel = null;

	@Column(name = "sui_qualite_travail")
	private String qualiteTravail = null;

	@Column(name = "sui_citoyennete")
	private String citoyennete = null;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "liv_id")
	@NotNull
	private Livret livret = null;
	
	
	public Integer getId() {
		return id;
	}


}
