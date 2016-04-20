package model.objet;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "specialisation")

public class Specialisation extends DataParent {

	public static final String NOM_ID = "spe_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "spe_nom")
	@NotNull
	private String nom = null;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "frm_id")
	@NotNull
	private List<Formation> listFormation = null;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "j_utilisateur_specialisation", joinColumns = @JoinColumn(name = "spe_id") , inverseJoinColumns = @JoinColumn(name = "uti_id") )
	@NotNull
	private List<Utilisateur> listUtilisateur = null;

	public Specialisation(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Formation> getListFormation() {
		return listFormation;
	}

	public void setListFormation(List<Formation> listFormation) {
		this.listFormation = listFormation;
	}

	public List<Utilisateur> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
