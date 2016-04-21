package controleur;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;

import model.baseDAO.DaoFactory;
import model.objet.TypeUtilisateur;

public class TestControleurLogin 
{

	public static void main(String[] args) 
	{
		//ControleurLogin ctrl = new ControleurLogin();
		//ctrl.init();
		new Configuration().configure().buildSessionFactory();
		List <TypeUtilisateur> listeTypeUtilisateur = new ArrayList<TypeUtilisateur>();
		
		try 
		{
			listeTypeUtilisateur = (List<TypeUtilisateur>) DaoFactory.getDaoUtilisateur().readAll(TypeUtilisateur.class);
			
			for (int i = 0; i<listeTypeUtilisateur.size(); i++)
			{
				System.out.println(listeTypeUtilisateur.get(i).getRole());
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
