package model.baseDAO;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Formation;
import model.objet.Specialisation;

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
}
