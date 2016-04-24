package model.baseDAO;

import org.hibernate.Query;
import org.hibernate.Session;

import model.objet.Specialisation;

public class DaoSpecialisation extends DaoParent {

	
	public Specialisation findSpeById(Integer id) throws Exception
	{

		Session session = BaseSession.getNewSession();
		
		Query q = session.createQuery("from Specialisation where id= :id");
		
		q.setString("id", id.toString());
		
		
		Specialisation result = (Specialisation) q.uniqueResult();

		session.close();

		return result;
	}	
	
}
