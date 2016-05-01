package model.baseDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Formation;
import model.objet.FormationToModule;

public class DaoFormationToModule extends DaoParent
{
	
	public Collection<FormationToModule> getAllFormationToModuleFromFormation(Formation formation)
	{
		
		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(FormationToModule.class);
		criteria.add(Restrictions.eq("formation", formation));
		

		@SuppressWarnings("unchecked")
		List<FormationToModule> list = criteria.list();
		
		 
		return list;
		
	}
	
	

}
