package model.objet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends DataParent {

	public static final String NOM_ID = "uti_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "uti_nom")
	@NotNull
	private String nom = null;

	@Column(name = "uti_prenom")
	@NotNull
	private String prenom = null;

	@Type(type = "date")
	@Column(name = "uti_date_naissance")
	private Date dateNaissance = null;

	@Column(name = "uti_identifiant_afpa")
	@NotNull
	private Integer identifiantAFPA = null;

	@Column(name = "uti_password")
	//@NotNull
	private String password = null;

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UtilisateurToFormation> utilisateurToFormation = new ArrayList<UtilisateurToFormation>();

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UtilisateurToRole> utilisateurToRole = new ArrayList<UtilisateurToRole>() ;

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UtilisateurToSpecialisation> utilisateurToSpecialisation = null;

	public Integer getId() {
		return id;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Integer id, String nom, String prenom, Date dateNaissance, Integer identifiantAFPA,
			String password, List<UtilisateurToFormation> utilisateurToFormation,
			List<UtilisateurToRole> utilisateurToRole, List<UtilisateurToSpecialisation> utilisateurToSpecialisation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.identifiantAFPA = identifiantAFPA;
		this.password = password;
		this.utilisateurToFormation = utilisateurToFormation;
		this.utilisateurToRole = utilisateurToRole;
		this.utilisateurToSpecialisation = utilisateurToSpecialisation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Integer getIdentifiantAFPA() {
		return identifiantAFPA;
	}

	public void setIdentifiantAFPA(Integer identifiantAFPA) {
		this.identifiantAFPA = identifiantAFPA;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UtilisateurToFormation> getUtilisateurToFormation() {
		return utilisateurToFormation;
	}

	public void setUtilisateurToFormation(List<UtilisateurToFormation> utilisateurToFormation) {
		this.utilisateurToFormation = utilisateurToFormation;
	}

	public List<UtilisateurToRole> getUtilisateurToRole() {
		return utilisateurToRole;
	}

	public void setUtilisateurToRole(List<UtilisateurToRole> utilisateurToRole) {
		this.utilisateurToRole = utilisateurToRole;
	}

	public List<UtilisateurToSpecialisation> getUtilisateurToSpecialisation() {
		return utilisateurToSpecialisation;
	}

	public void setUtilisateurToSpecialisation(List<UtilisateurToSpecialisation> utilisateurToSpecialisation) {
		this.utilisateurToSpecialisation = utilisateurToSpecialisation;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

}
