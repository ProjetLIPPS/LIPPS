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
@Table (name = "formation_module", uniqueConstraints = {
	    @UniqueConstraint(columnNames={"fmo_frm_id", "fmo_mod_id"})
	})
public class FormationToModule implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "fmo_frm_id", referencedColumnName = "frm_id")
	@NotNull
	private Formation formation = null;
	
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "fmo_mod_id", referencedColumnName = "mod_id")
	@NotNull
	private Module module = null;


	public FormationToModule() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FormationToModule(Formation formation, Module module) {
		super();
		this.formation = formation;
		this.module = module;
	}


	public Formation getFormation() {
		return formation;
	}


	public void setFormation(Formation formation) {
		this.formation = formation;
	}


	public Module getModule() {
		return module;
	}


	public void setModule(Module module) {
		this.module = module;
	}
	
	
	
	
	
	
}
