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
import javax.persistence.OneToMany;
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
	@Column(name = "uti_date_naissance")
	private Date dateNaissance = null;

	@Column(name = "uti_identifiant_afpa")
	@NotNull
	private Integer identifiantAFPA = null;

	@Column(name = "uti_password")
	@NotNull
	private String password = null;

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<UtilisateurToFormation> utilisateurToFormation = null;

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<UtilisateurToRole> utilisateurToRole = null;

	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<UtilisateurToSpecialisation> utilisateurToSpecialisation = null;

	public Integer getId() {
		return id;
	}


	

}
