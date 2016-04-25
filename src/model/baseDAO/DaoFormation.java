package model.baseDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.DataParent;
import model.objet.Formation;
import model.objet.Specialisation;
import model.objet.Utilisateur;

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
	
	public List<Formation> readAllFromUser(Utilisateur user) throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Formation.class);
		criteria.add(Restrictions.in("uti_id", user.getId()));
		
		@SuppressWarnings("unchecked")
		List<Formation> list = (List<Formation>) criteria.list();

		session.close();

		return list;
	}
}
