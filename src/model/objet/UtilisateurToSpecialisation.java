package model.objet;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="utilisateur_specialisation", uniqueConstraints = {
	    @UniqueConstraint(columnNames={"uts_uti_id", "uts_spe_id"})
	})
public class UtilisateurToSpecialisation implements Serializable {
	
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
	
	
	
	
	
	
}
