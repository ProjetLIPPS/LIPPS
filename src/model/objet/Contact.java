package model.objet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "contact")
public class Contact extends DataParent {

	public static final String NOM_ID = "con_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "con_raison_sociale")
	private String raisonSociale = null;

	@Column(name = "con_rue")
	private String rue = null;

	@Column(name = "con_cp")
	private Integer cp = null;

	@Column(name = "con_ville")
	private String ville = null;

	@Column(name = "con_telephone")
	private String telephone = null;

	@Column(name = "con_mail")
	@NotNull
	private String mail = null;

	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name = "uti_id")
	@NotNull
	private Utilisateur utilisateur = null;
	
	public Integer getId() {
		return id;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Integer id, String raisonSociale, String rue, Integer cp, String ville, String telephone,
			String mail, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.raisonSociale = raisonSociale;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
		this.mail = mail;
		this.utilisateur = utilisateur;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
