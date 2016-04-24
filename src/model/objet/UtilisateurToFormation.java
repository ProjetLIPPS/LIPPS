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
@Table (name = "utilisateur_formation", uniqueConstraints = {
	    @UniqueConstraint(columnNames={"utf_uti_id", "utf_frm_id"})
	})
public class UtilisateurToFormation implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "utf_uti_id", referencedColumnName = "uti_id")
	@NotNull
	private Utilisateur utilisateur = null;
	
	
	
	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "utf_frm_id", referencedColumnName = "frm_id")
	@NotNull
	private Formation formation = null;



	public UtilisateurToFormation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UtilisateurToFormation(Utilisateur utilisateur, Formation formation) {
		super();
		this.utilisateur = utilisateur;
		this.formation = formation;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Formation getFormation() {
		return formation;
	}



	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	
	
	
	
	
}
