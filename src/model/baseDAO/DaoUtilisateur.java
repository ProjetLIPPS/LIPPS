package model.baseDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import model.objet.DataParent;
import model.objet.Utilisateur;

public class DaoUtilisateur extends DaoParent {

	
	public ScrollableResults readAdmin() throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Utilisateur.class);
		
		
		
		
		
		ScrollableResults listAdmin = criteria.scroll();
		session.close();

		return listAdmin;
	}
	
	
}
