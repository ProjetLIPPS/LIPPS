package controleur;

import model.baseDAO.DaoFactory;
import model.objet.Contact;
import model.objet.Utilisateur;

public class TestControleurLogin 
{

	public static void main(String[] args) 
	{
		/*
		ControleurLogin ctrl = new ControleurLogin();
		ctrl.init();
		*/
		
		Contact con = new Contact();
		try
		{
			con = DaoFactory.getDaoContact().findById(con, 1);
			Utilisateur user = con.getUtilisateur();
			System.out.println(user.getNom());
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
