package controleur;



import javax.swing.JOptionPane;

import org.hibernate.cfg.Configuration;

import ihm.LippsIhm;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;


public class TestMain {

	public static void main(String[] args) {
		
		Boolean result = null;

		
		try
		{
			// configure hibernate
			//new Configuration().configure().buildSessionFactory();
			
//			Utilisateur user = new Utilisateur(null, "Bennourine", "Christophe", null, 1326545, "123", null, null, null);
//			Utilisateur user2 = new Utilisateur(null, "Bauer", "Yannick", null, 1326545, "123", null, null, null);
//			Utilisateur user3 = new Utilisateur(null, "Planchon", "Philippe", null, 1326545, "123", null, null, null);
//			DaoFactory.getDaoUtilisateur().save(user);
//			DaoFactory.getDaoUtilisateur().save(user2);
//			DaoFactory.getDaoUtilisateur().save(user3);
			
			
			new LippsIhm();
			
			
			result = true;
		}
		catch (Exception e)
		{
			result = false;

			JOptionPane.showMessageDialog(null, "Connexion à la base de donnée impossible, veuillez verifier vos paramètres ou réessayer plus tard.", "Erreur", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		finally
		{
			System.out.println(String.valueOf(result));
		}
		
		

		
				

	}

}
