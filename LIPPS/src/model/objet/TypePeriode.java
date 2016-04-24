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
@Table(name = "type_periode")
public class TypePeriode extends DataParent {
	public static final String NOM_ID = "tpe_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "tpe_nom")
	@NotNull
	private Date nom = null;

	
	
	public Integer getId() {
		return id;
	}



	public TypePeriode() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TypePeriode(Integer id, Date nom) {
		super();
		this.id = id;
		this.nom = nom;
	}



	public Date getNom() {
		return nom;
	}



	public void setNom(Date nom) {
		this.nom = nom;
	}



	public void setId(Integer id) {
		this.id = id;
	}
	
	
}