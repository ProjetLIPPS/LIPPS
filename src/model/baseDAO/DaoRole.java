package model.baseDAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Role;

public class DaoRole extends DaoParent 
{
	
	
	public Role findByName(String type) 
	{
		Session session = BaseSession.getNewSession();
		Role result = null;
		
		try
		{
			Criteria criteria = session.createCriteria(Role.class);
			criteria.add(Restrictions.eq("type", type));


			result = (Role) criteria.uniqueResult();
			
		}
		catch (Exception e)
		{
			
		}
		
		
		
		
		
		return result;
	}

}
