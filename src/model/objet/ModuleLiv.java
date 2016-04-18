package model.objet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "module_liv")

public class ModuleLiv extends DataParent {

	public static final String NOM_ID = "mdl_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	@Column(name = "mdl_intitule")
	@NotNull
	private String intitule = null;

	@Column(name = "mdl_result")
	private boolean result;

	@Column(name = "mdl_obs")
	@NotNull
	private String observation = null;

	@Column(name = "mdl_spe_int")
	private String speInt = null;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "liv_id")
	private Livret livret = null;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "sql_id")
	private List<SequenceLiv> listSequenceLiv = null;

	public ModuleLiv(Integer id, String intitule) {
		super();
		this.id = id;
		this.intitule = intitule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getSpeInt() {
		return speInt;
	}

	public void setSpeInt(String speInt) {
		this.speInt = speInt;
	}

	public Livret getLivret() {
		return livret;
	}

	public void setLivret(Livret livret) {
		this.livret = livret;
	}

	public List<SequenceLiv> getListSequenceLiv() {
		return listSequenceLiv;
	}

	public void setListSequenceLiv(List<SequenceLiv> listSequenceLiv) {
		this.listSequenceLiv = listSequenceLiv;
	}

}
