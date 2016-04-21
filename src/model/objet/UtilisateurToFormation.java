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
	
	
	
	
	
	
}
