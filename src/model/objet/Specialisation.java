package model.objet;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "specialisation")

public class Specialisation extends DataParent {

	public static final String NOM_ID = "spe_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "spe_nom")
	@NotNull
	private String nom = null;

	
	@OneToMany(mappedBy = "specialisation", fetch = FetchType.LAZY)
	private List<UtilisateurToSpecialisation> utilisateurToSpecialisation = null;

	
	public Integer getId() {
		return id;
	}

}
