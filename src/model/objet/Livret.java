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
@Table(name = "livret")
public class Livret extends DataParent {

	public static final String NOM_ID = "liv_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "liv_cloture")
	@NotNull
	private boolean cloture;

	public Integer getId() {
		return id;
	}

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "uti_id")
	@NotNull
	private Utilisateur utilisateur = null;
	

}// END LIVRET
