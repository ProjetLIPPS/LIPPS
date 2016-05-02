package controleur;



import javax.swing.JOptionPane;

import org.hibernate.cfg.Configuration;

import ihm.LippsIhm;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Specialisation;
import model.objet.Utilisateur;


public class Appli {

	public static void main(String[] args) {
		
		Boolean result = null;

		
		try
		{
			// configure hibernate
			new Configuration().configure().buildSessionFactory();
			
			
			//Lance le controleur de la fenetre le Login
			new ControleurLogin();
			
			
			result = true;
		}
		catch (Exception e)
		{
			result = false;
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connexion à la base de donnée impossible, veuillez verifier vos paramètres ou réessayer plus tard.", "Erreur", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		finally
		{
			System.out.println(String.valueOf(result));
		}
		
		

		
				

	}

}