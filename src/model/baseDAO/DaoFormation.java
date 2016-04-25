package model.baseDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Formation;

public class DaoFormation extends DaoParent {

	public Formation findFormationByIntitule (String intitule) throws Exception
	{

		Session session = BaseSession.getNewSession();
		
		Query q = session.createQuery("from Formation where intitule= :intitule");
		
		q.setString("intitule", intitule);
		
		
		Formation result = (Formation) q.uniqueResult();

		session.close();

		return result;
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
	
}
