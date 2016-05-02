package model.baseDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
	
	
	public Collection<Formation> readAllFormationFromUser(Utilisateur utilisateur) throws Exception
	{
		List<Formation> listFrm = new ArrayList<Formation>();
		
		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(UtilisateurToFormation.class);
		criteria.add(Restrictions.eq("utilisateur", utilisateur));
		

		@SuppressWarnings("unchecked")
		List<Formation> list = criteria.list();
		
		 for (@SuppressWarnings("rawtypes")	Iterator iterator = list.iterator(); iterator.hasNext();)
		 {
			 UtilisateurToFormation userForm = (UtilisateurToFormation) iterator.next();
			 listFrm.add(userForm.getFormation());
		 }
		
	
		return listFrm;
	}
	
	public Formation findFormationByIntituleAndDate (String intitule, String dateString) throws Exception
	{

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(dateString);
	
		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Formation.class);
		criteria.add(Restrictions.eq("intitule", intitule));
		criteria.add(Restrictions.eq("dateDebut", date));
		
		Formation result = (Formation) criteria.uniqueResult();

		session.close();
		
				
		return result;
	}
	

	
	public Formation findModeleByIntitule (String intitule) throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Formation.class);
		criteria.add(Restrictions.eq("intitule", intitule));
		criteria.add(Restrictions.eq("isModel", true));

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

	
	
	public String[] getListeNomModelesBySpe(Specialisation spe)
	{
		
		List<Formation> listeModeleFormation = new ArrayList<Formation>();
		
		try
		{
			listeModeleFormation = (List<Formation>) readAllModeleBySpe(spe);
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
	
	
	
	public Collection<Formation> readAllModeleBySpe(Specialisation spe) throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Formation.class);
		criteria.add(Restrictions.eq("isModel", true));
		criteria.add(Restrictions.eq("specialisation", spe));
		

		@SuppressWarnings("unchecked")
		List<Formation> list = criteria.list();

		session.close();

		return list;
	}

	
}
