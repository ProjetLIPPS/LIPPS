package model.objet;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


@Entity
@Table (name = "utilisateur_role", uniqueConstraints = {
	    @UniqueConstraint(columnNames={"utr_uti_id", "utr_rol_id"})
	})
public class UtilisateurToRole implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "utr_uti_id", referencedColumnName = "uti_id")
	@NotNull
	private Utilisateur utilisateur = null;
	
	
	
	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "utr_rol_id", referencedColumnName = "rol_id")
	@NotNull
	private Role role = null;



	public UtilisateurToRole() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UtilisateurToRole(Utilisateur utilisateur, Role role) {
		super();
		this.utilisateur = utilisateur;
		this.role = role;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	
	
}
