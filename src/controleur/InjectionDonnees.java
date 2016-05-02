package controleur;

import model.baseDAO.DaoFactory;
import model.objet.Role;
import model.objet.Specialisation;

public class InjectionDonnees
{

	public static void main(String[] args)
	{
		boolean done = false;
		
		String [] listeSpe = new String[]
				{ "Audiovisuel", "Automobile", "Autre", "Assurance", "Bâtiment", "Commerce",
						"Communication", "Droit", "Enseignement", "Environnement", "Hôtellerie", "Immobilier", "Informatique",
						"Langues", "Marketing", "Propreté", "Ressources Humaines", "Restauration", "Sciences Humaines",
						"Secrétariat", "Social", "Tourisme", "Transport , Logistique" };
		
		try
		{
			DaoFactory.getDaoRole().save(new Role(null, "Administrateur", null));
			DaoFactory.getDaoRole().save(new Role(null, "Formateur", null));
			DaoFactory.getDaoRole().save(new Role(null, "Stagiaire", null));
			DaoFactory.getDaoRole().save(new Role(null, "Tuteur", null));
			
			for (String spe : listeSpe)
			{
				DaoFactory.getDaoSpecialisation().saveOrUpdate(new Specialisation(null, spe, null));
			}
			
			
			done = true;
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (done)
			{
				System.out.println("Done");
			}
			else
			{
				System.out.println("Pas Done du tout");
			}
			System.exit(0);
		}

	}

}
