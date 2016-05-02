package model.baseDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Utilisateur;
import model.objet.UtilisateurToSpecialisation;

public class DaoUtilisateurToSpecialisation extends DaoParent
{

	public  Collection<UtilisateurToSpecialisation> readUtilisateurToSpecialisationFromUser(Utilisateur user) throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(UtilisateurToSpecialisation.class);
		criteria.add(Restrictions.eq("utilisateur", user));
		

		@SuppressWarnings("unchecked")
		List<UtilisateurToSpecialisation> list = criteria.list();

		session.close();

		return list;
	}
}
