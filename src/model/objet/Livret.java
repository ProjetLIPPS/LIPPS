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

	public Livret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livret(Integer id, boolean cloture, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.cloture = cloture;
		this.utilisateur = utilisateur;
	}

	public boolean isCloture() {
		return cloture;
	}

	public void setCloture(boolean cloture) {
		this.cloture = cloture;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}// END LIVRET
