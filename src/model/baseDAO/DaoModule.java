package model.baseDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Formation;
import model.objet.FormationToModule;
import model.objet.Module;
import model.objet.UtilisateurToFormation;

public class DaoModule extends DaoParent {

	
	public List<Module> findModuleByFormation (Formation formation) throws Exception
	{

		
		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(FormationToModule.class);
		criteria.add(Restrictions.eq("formation", formation));
		
		@SuppressWarnings("unchecked")
		List<FormationToModule> result = (List<FormationToModule>) criteria.list();
		
		List<Module> listModule = new ArrayList<Module>();
		
		 for (@SuppressWarnings("rawtypes")	Iterator iterator = result.iterator(); iterator.hasNext();)
		 {
			 FormationToModule userForm = (FormationToModule) iterator.next();
			 listModule.add(userForm.getModule());
		 }

		session.close();
		
				
		return listModule;
	}
	
	
	
}
