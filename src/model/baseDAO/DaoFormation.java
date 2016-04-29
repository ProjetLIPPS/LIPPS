package model.baseDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.DataParent;
import model.objet.Formation;
import model.objet.Specialisation;
import model.objet.Utilisateur;
import model.objet.UtilisateurToFormation;

public class DaoFormation extends DaoParent {

	public Formation findFormationByIntitule (String intitule) throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Formation.class);
		criteria.add(Restrictions.eq("intitule", intitule));
		criteria.add(Restrictions.eq("isModel", false));

		Formation result = (Formation) criteria.uniqueResult();

		session.close();

		return result;
	}
	
	
	public Collection<Formation> findFormationBySpecialisation (Specialisation spe) throws Exception
	{
		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Formation.class);
		criteria.add(Restrictions.eq("specialisation", spe));
		criteria.add(Restrictions.eq("isModel", false));

		@SuppressWarnings("unchecked")
		List<Formation> list = criteria.list();

		session.close();

		
		
		return list;
	}

	
	
	public String[] getListeNomModeles()
	{
		
		List<Formation> listeModeleFormation = new ArrayList<Formation>();
		
		try
		{
			listeModeleFormation = (List<Formation>) readAllModele();
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		String [] result = new String [listeModeleFormation.size()];
		
		for (int i = 0; i < result.length; i++)
		{
			result[i] = listeModeleFormation.get(i).getIntitule();
		}
		
		Arrays.sort(result);
		
		return result;
	}

	
	
	public Collection<Formation> readAllModele() throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Formation.class);
		criteria.add(Restrictions.eq("isModel", true));

		@SuppressWarnings("unchecked")
		List<Formation> list = criteria.list();

		session.close();

		return list;
	}
	
	
	public List<Formation> readAllFormationFromUser(Utilisateur utilisateur) throws Exception
	{
		List<Formation> listFrm = new ArrayList<Formation>();
		
		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(UtilisateurToFormation.class);
		criteria.add(Restrictions.eq("utilisateur", utilisateur));
		

		@SuppressWarnings("unchecked")
		List list = criteria.list();
		
		 for (Iterator iterator = list.iterator(); iterator.hasNext();)
		 {
			 UtilisateurToFormation userForm = (UtilisateurToFormation) iterator.next();
			 listFrm.add(userForm.getFormation());
		 }
		
	
		return listFrm;
	}
	
}
