package model.baseDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.DataParent;
import model.objet.Specialisation;

public class DaoSpecialisation extends DaoParent {


	
	public Specialisation findByName(String name)
			throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Specialisation.class);
		criteria.add(Restrictions.eq("nom", name));


		Specialisation result = (Specialisation) criteria.uniqueResult();

		session.close();

		return result;
	}
	
	
	
	public String[] getNomSpecialisation()
	{
		List<Specialisation> listespe = new ArrayList<Specialisation>();
		
		try
		{
			listespe = (List<Specialisation>) readAll(Specialisation.class);
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		String [] result = new String [listespe.size()];
		
		for (int i = 0; i < result.length; i++)
		{
			result[i] = listespe.get(i).getNom();
		}
		
		Arrays.sort(result);
		
		return result;
	}
	
}
