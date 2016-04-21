package model.objet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends DataParent {

	public static final String NOM_ID = "rol_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "role_type")
	private String type = null;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<UtilisateurToRole> utilisateurToRole = null;

	
	public Integer getId() {
		return id;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Role(Integer id, String type, List<UtilisateurToRole> utilisateurToRole) {
		super();
		this.id = id;
		this.type = type;
		this.utilisateurToRole = utilisateurToRole;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<UtilisateurToRole> getUtilisateurToRole() {
		return utilisateurToRole;
	}


	public void setUtilisateurToRole(List<UtilisateurToRole> utilisateurToRole) {
		this.utilisateurToRole = utilisateurToRole;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
}
