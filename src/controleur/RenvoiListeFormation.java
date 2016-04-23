package controleur;

public class RenvoiListeFormation {

	
	public static String[] renvoiListeFormation() {
		
		String[] listFormation = null;
		
		// methode recup formations depuis dao
		// TODO condition if selon admin ou formateur 
		
		// >> test en dur:
		
		listFormation = new String[ ]{"formation 1", "formation 2", "formation 3"};
		
		return listFormation;
		
	}
	
	
}
