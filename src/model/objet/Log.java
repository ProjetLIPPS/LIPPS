package model.objet;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "log")
public class Log extends DataParent {

	public static final String NOM_ID = "log_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Type(type = "date")
	@Column(name = "log_derniere_connexion")
	@NotNull
	protected Date derniereConnexion= null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uti_id")
	@NotNull
	private Utilisateur utilisateur = null;

	public Integer getId() {
		return id;
	}


}// End Log
