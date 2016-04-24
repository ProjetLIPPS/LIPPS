package model.baseDAO;


import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.objet.DataParent;

/**
 * Data Access Object pour les objets du modele de type IDao<br />
 * 
 * Contient notamment des functions communes pour la persistence des donnees
 * dont les fonctions CRUD : Create, Read, Update, Delete
 * 
 */
public  abstract class DaoParent
{

	public <E extends DataParent> E save(E objetBase) throws Exception
	{

		Session session = BaseSession.getNewSession();
		Transaction tx = session.beginTransaction();

		try
		{
			session.save(objetBase);

			tx.commit();
			
			session.close();
			return objetBase;
		}
		catch (Exception e)
		{
			tx.rollback();
			session.close();

			throw e;
		}

	}

	

	public <E extends DataParent> E findById(Class<E> objetBaseClass, Integer id)
			throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(objetBaseClass);
		criteria.add(Restrictions.eq("id", id));

		@SuppressWarnings("unchecked")
		E result = (E) criteria.uniqueResult();

		session.close();

		return result;
	}

	@SuppressWarnings("unchecked")
	public <E extends DataParent> Collection<E> readAll(Class<E> objetBaseClass) throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(objetBaseClass);

		List<E> list = criteria.list();

		session.close();

		return list;
	}

	public <E extends DataParent> void update(E objetBase) throws Exception
	{

		Session session = BaseSession.getNewSession();
		Transaction tx = session.beginTransaction();

		try
		{
			session.update(objetBase);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			tx.rollback();
			session.close();

			throw e;
		}
	}

	public <E extends DataParent> void saveOrUpdate(E objetBase) throws Exception
	{

		Session session = BaseSession.getNewSession();
		Transaction tx = session.beginTransaction();

		try
		{
			session.saveOrUpdate(objetBase);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			tx.rollback();
			session.close();

			throw e;
		}
	}

	public <E extends DataParent> void delete(E objetBase) throws Exception
	{

		Session session = BaseSession.getNewSession();
		Transaction tx = session.beginTransaction();

		try
		{
			session.delete(objetBase);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			tx.rollback();
			session.close();

			throw e;
		}

	}

	

}
