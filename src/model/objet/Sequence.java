package model.objet;

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

@Entity
@Table(name = "sequence")
public class Sequence extends DataParent {
	public static final String NOM_ID = "seq_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "seq_intitule")
	@NotNull
	private String intitule = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mod_id")
	@NotNull
	private Module module = null;

	public Integer getId() {
		return id;
	}


}
