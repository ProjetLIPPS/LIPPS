package model.baseDAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Contact;
import model.objet.Utilisateur;

public class DaoContact extends DaoParent 
{
	public Boolean isPasswordCorrect(String email, String password)
	{
		Boolean reponse = false;
		
		Session session = BaseSession.getNewSession();

		try
		{
			Criteria criteria = session.createCriteria(Contact.class);
			criteria.add(Restrictions.eq("mail", email));

			@SuppressWarnings("unchecked")
			Contact result = (Contact) criteria.uniqueResult();
			
			String userpass = result.getUtilisateur().getPassword();
			
			if(password.equals(userpass))
			{
				reponse = true;
			}
		} 
		catch (Exception e)
		{
			
		}

		session.close();

		
		
		return reponse;
	}
	
	
	
	
	public Contact getContactFromUser(Utilisateur user)
	{
		Contact result = new Contact();
		
		Session session = BaseSession.getNewSession();

		try
		{
			Criteria criteria = session.createCriteria(Contact.class);
			criteria.add(Restrictions.eq("utilisateur", user));


			result = (Contact) criteria.uniqueResult();
		}
		catch (Exception e)
		{
			
		}
		
		
		return result;
	}
	
	
}
