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
@Table(name = "periode")
public class Periode extends DataParent {
	public static final String NOM_ID = "prd_id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = NOM_ID)
	private Integer id = null;

	
	
	@Column(name = "prd_date_centre")
	@Type(type = "date")
	private Date dateCentre = null;
	
	@Column(name = "prd_description_centre")
	private String descriptionPeriodeCentre = null;
	
	
	
	@Column(name = "prd_date_entreprise")
	@Type(type = "date")
	private Date dateEntreprise = null;
	
	
	@Column(name = "prd_description_entreprise")
	private String descriptionPeriodeEntreprise = null;
	
	
	
	
	@Column(name = "prd_date_ecf")
	@Type(type = "date")
	private Date dateEcf = null;
	
	
	@Column(name = "prd_texte_ecf")
	private String texteEcf = null;
	

	

	

	public Periode() 
	{
		super();
		
	}

	
	
	
	public Periode(Integer id, Date dateCentre, String descriptionPeriodeCentre, Date dateEntreprise,
			String descriptionPeriodeEntreprise, Date dateEcf, String texteEcf) {
		super();
		this.id = id;
		this.dateCentre = dateCentre;
		this.descriptionPeriodeCentre = descriptionPeriodeCentre;
		this.dateEntreprise = dateEntreprise;
		this.descriptionPeriodeEntreprise = descriptionPeriodeEntreprise;
		this.dateEcf = dateEcf;
		this.texteEcf = texteEcf;
	}







	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}




	public Date getDateCentre() {
		return dateCentre;
	}




	public void setDateCentre(Date dateCentre) {
		this.dateCentre = dateCentre;
	}




	public String getDescriptionPeriodeCentre() {
		return descriptionPeriodeCentre;
	}




	public void setDescriptionPeriodeCentre(String descriptionPeriodeCentre) {
		this.descriptionPeriodeCentre = descriptionPeriodeCentre;
	}




	public Date getDateEntreprise() {
		return dateEntreprise;
	}




	public void setDateEntreprise(Date dateEntreprise) {
		this.dateEntreprise = dateEntreprise;
	}




	public String getDescriptionPeriodeEntreprise() {
		return descriptionPeriodeEntreprise;
	}




	public void setDescriptionPeriodeEntreprise(String descriptionPeriodeEntreprise) {
		this.descriptionPeriodeEntreprise = descriptionPeriodeEntreprise;
	}




	public Date getDateEcf() {
		return dateEcf;
	}




	public void setDateEcf(Date dateEcf) {
		this.dateEcf = dateEcf;
	}




	public String getTexteEcf() {
		return texteEcf;
	}




	public void setTexteEcf(String texteEcf) {
		this.texteEcf = texteEcf;
	}

	
	
	
	
}
