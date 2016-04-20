package model.objet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "module_liv")

public class ModuleLivret extends DataParent {

	public static final String NOM_ID = "mdl_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "mdl_intitule")
	@NotNull
	private String intitule = null;

	@Column(name = "mdl_result")
	private boolean resultat;

	@Column(name = "mdl_obs")
	@NotNull
	private String observation = null;

	@Column(name = "mdl_spe_int")
	private String intituleSpecialisation = null;

	public Integer getId() {
		return id;
	}


	

}
