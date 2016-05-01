package model.baseDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Module;
import model.objet.Sequence;

public class DaoSequence extends DaoParent {

	
	
	public List<Sequence> findSequenceFromModule (Module module) throws Exception
	{

		
		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Sequence.class);
		criteria.add(Restrictions.eq("module", module));
		
		@SuppressWarnings("unchecked")
		List<Sequence> result = (List<Sequence>) criteria.list();
		
		
		session.close();
		
				
		return result;
	}
	
	
	
}
