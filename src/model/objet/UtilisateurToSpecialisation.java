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
@Table(name="utilisateur_specialisation", uniqueConstraints = {
	    @UniqueConstraint(columnNames={"uts_uti_id", "uts_spe_id"})
	})
public class UtilisateurToSpecialisation extends DataParent implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "uts_uti_id", referencedColumnName = "uti_id")
	@NotNull
	private Utilisateur utilisateur = null;
	
	
	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "uts_spe_id", referencedColumnName = "spe_id")
	@NotNull
	private Specialisation specialisation = null;


	public UtilisateurToSpecialisation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UtilisateurToSpecialisation(Utilisateur utilisateur, Specialisation specialisation) {
		super();
		this.utilisateur = utilisateur;
		this.specialisation = specialisation;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Specialisation getSpecialisation() {
		return specialisation;
	}


	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}
	
	
	
	
	
	
}
