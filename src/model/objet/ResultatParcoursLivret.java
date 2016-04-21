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
@Table(name = "result_parcours_livret")
public class ResultatParcoursLivret extends DataParent {

	public static final String NOM_ID = "res_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "res_attestation")
	private String attestation = null;

	@Column(name = "res_observation")
	private String observation = null;

	@Column(name = "res_niveau")
	private String niveau = null;

	@Column(name = "res_emploi")
	private String emploi = null;

	@Type(type = "date")
	@Column(name = "res_date_debut")
	private Date dateDebut = null;

	@Column(name = "res_duree")
	private Integer duree = null;

	@Column(name = "res_certification")
	private String certification = null;

	@Column(name = "res_intitule_certification")
	private String intituleCertification = null;

	@Column(name = "res_type_certification")
	private String typeCertification = null;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "liv_id")
	@NotNull
	private Livret livret = null;
	
	
	public Integer getId() {
		return id;
	}

	
}
