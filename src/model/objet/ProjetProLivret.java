package model.objet;

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
@Table(name = "projet_pro_liv")
public class ProjetProLivret extends DataParent {

	public static final String NOM_ID = "pro_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "pro_xp")
	private String experience = null;

	@Column(name = "pro_motiv")
	private String motivation = null;

	@Column(name = "pro_attente")
	private String attente = null;

	@Column(name = "pro_action")
	private String action = null;

	@Type(type = "date")
	@Column(name = "pro_date")
	private Date date = null;

	public Integer getId() {
		return id;
	}

}
