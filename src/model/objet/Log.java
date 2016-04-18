package model.objet;

import java.time.Instant;
import java.util.Date;

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
	@Column(name = "log_lastconn")
	@NotNull
	protected Date lastconn = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uti_id")
	@NotNull
	private Utilisateur user = null;

	public Log(Integer id, Utilisateur user) {
		super();
		this.id = id;
		lastconn = Date.from(Instant.now());
		this.user = user;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLastconn() {
		return lastconn;
	}

	public void setLastconn(Date lastconn) {
		this.lastconn = lastconn;
	}

	public Utilisateur getListUtilisateur() {
		return user;
	}

	public void setUtilisateur(Utilisateur user) {
		this.user = user;
	}

}// End Log
