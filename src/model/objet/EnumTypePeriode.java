package model.objet;

public enum EnumTypePeriode {

	Centre(1, "Période en centre AFPA"), Entreprise(2, "Période en entreprise"), Evaluation(3,
			"Evaluation en cours de formation"), Evaluationfinale(4, "Evaluation finale");

	private Integer id = null;
	private String libelle = null;

	// Constructeur

	EnumTypePeriode(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
