package controleur;



import ihm.LippsIhm;


public class Appli {

	public static void main(String[] args) {
		
		Boolean result = null;

		try
		{
			// configure hibernate
			// new Configuration().configure().buildSessionFactory();
			//Utilisateur user1 = new Utilisateur(null, "Connu", "Alain", "2012/02/10" , 26262, "5545654610");
			
			
//			Contact contact1 = new Contact(null, "test@dechavanne.fr");
//			DaoFactory.getDaoContact().save(contact1);
//			
//		    user1.setContact(contact1);
//			DaoFactory.getDaoUtilisateur().save(user1);
//			
//			Log log1 = new Log(null ,user1);
//			DaoFactory.getDaoLog().save(log1);
//		Specialisation spe1 = new Specialisation("Informatique");
//		DaoFactory.getDaoSpecialisation().save(spe1);
//		
//		//DaoFactory.getDaoSpecialisation().save(spe1);
//			
//		Formation frm1 = new Formation(123, 456, "Dev logiciel", 1295, "emplois blabla", 2, 3, spe1);
//		DaoFactory.getDaoFormation().save(frm1);
			
			result = true;
		}
		catch (Exception e)
		{
			result = false;

			e.printStackTrace();
		}
		finally
		{
			System.out.println(String.valueOf(result));
		}
	
		

		LippsIhm frame = new LippsIhm();
		frame.setVisible(true);
		frame.refresh();
				

	}

}
