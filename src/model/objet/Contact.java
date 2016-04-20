package model.objet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "con_tel")
	private String telephone = null;

	@Column(name = "con_mail")
	@NotNull
	private String mail = null;

	public Integer getId() {
		return id;
	}


}
