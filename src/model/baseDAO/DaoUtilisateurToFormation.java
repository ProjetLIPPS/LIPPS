package model.baseDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.objet.DataParent;
import model.objet.Formation;
import model.objet.FormationToModule;
import model.objet.Utilisateur;
import model.objet.UtilisateurToFormation;

public class DaoUtilisateurToFormation extends DaoParent
{
	@SuppressWarnings("unchecked")
	public  Collection<UtilisateurToFormation> readUtilisateurToFormationFromUser(Utilisateur user) throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(UtilisateurToFormation.class);
		criteria.add(Restrictions.eq("utilisateur", user));
		

		List<UtilisateurToFormation> list = criteria.list();

		session.close();

		return list;
	}

	
}
