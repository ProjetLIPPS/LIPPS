package model.objet;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.OneToOne;
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
	@Column(name = "uti_birthday")
	private Date birthday = null;

	@Column(name = "uti_num_afpa")
	@NotNull
	private Integer numAfpa = null;

	@Column(name = "uti_password")
	@NotNull
	private String password = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "con_id")
	@NotNull
	private Contact contact = null;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "j_utilisateur_role", joinColumns = @JoinColumn(name = "uti_id") , inverseJoinColumns = @JoinColumn(name = "typ_id") )
	private List<TypeUtilisateur> listTypeUtilisateur = null;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "j_utilisateur_specialisation", joinColumns = @JoinColumn(name = "uti_id") , inverseJoinColumns = @JoinColumn(name = "spe_id") )
	private List<Specialisation> listSpecialisation = null;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "j_utilisateur_formation", joinColumns = @JoinColumn(name = "uti_id") , inverseJoinColumns = @JoinColumn(name = "frm_id") )
	private List<Formation> listFormation = null;

	public Utilisateur(Integer id, String nom, String prenom, String myDate, Integer numAfpa, String password)
			throws Exception {
		super();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = sdf.parse(myDate);

		this.birthday = date;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numAfpa = numAfpa;
		this.password = password;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getNumAfpa() {
		return numAfpa;
	}

	public void setNumAfpa(Integer numAfpa) {
		this.numAfpa = numAfpa;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<TypeUtilisateur> getListTypeUtilisateur() {
		return listTypeUtilisateur;
	}

	public void setListTypeUtilisateur(List<TypeUtilisateur> listAdresse) {
		this.listTypeUtilisateur = listAdresse;
	}

	public List<Specialisation> getListSpecialisation() {
		return listSpecialisation;
	}

	public void setListSpecialisation(List<Specialisation> listSpecialisation) {
		this.listSpecialisation = listSpecialisation;
	}

	public List<Formation> getListFormation() {
		return listFormation;
	}

	public void setListFormation(List<Formation> listFormation) {
		this.listFormation = listFormation;
	}

}
