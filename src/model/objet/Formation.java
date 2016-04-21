package model.objet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "formation")
public class Formation extends DataParent {

	public static final String NOM_ID = "frm_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "frm_grn")
	@NotNull
	private Integer grn = null;

	@Column(name = "frm_offre")
	@NotNull
	private Integer offre = null;

	@Column(name = "frm_intitule")
	@NotNull
	private String intitule = null;

	@Column(name = "frm_duree")
	@NotNull
	private Integer duree = null;

	@Column(name = "frm_debouche")
	@NotNull
	private String debouche = null;

	@Column(name = "frm_nombre_ccp")
	@NotNull
	private Integer nombreCCP = null;

	@Column(name = "frm_nombre_stage")
	@NotNull
	private Integer nombreStage = null;

	@OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	private List<UtilisateurToFormation> utilisateurToFormation = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "spe_id")
	@NotNull
	private Specialisation specialisation = null;

	@OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	private List<FormationToModule> formationToModule = null;

	
	public Integer getId() {
		return id;
	}


}
