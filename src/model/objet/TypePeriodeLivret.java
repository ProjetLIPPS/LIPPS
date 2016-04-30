package model.objet;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "type_periode_livret")
public class TypePeriodeLivret extends DataParent {
	public static final String NOM_ID = "tpl_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "tpl_nom")
	@NotNull
	private String nom = null;

	
	
	public Integer getId() {
		return id;
	}



	public TypePeriodeLivret() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TypePeriodeLivret(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	
}
