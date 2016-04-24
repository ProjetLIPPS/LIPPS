package model.baseDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Contient des méthodes de gestion de persistence de données
 * 
 */
public class BaseSession {
	/**
	 * Nom du fichier de configuration de l'ORM Hibernate
	 */
	private static final String HIBERNATE_CONFIGURATION = "hibernate.cfg.xml";

	private static SessionFactory sessionFactory;

	/**
	 * Effectue la connexion au SGBD Initialise le SGBD Crée une SessionFactory
	 * permettant l'accès à la base de données
	 * 
	 * @return La SessionFactory
	 */
	private static SessionFactory getSessionFactory() {

		if (sessionFactory != null) {
			return sessionFactory;
		}

		try {

			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration().configure(HIBERNATE_CONFIGURATION);
			configuration.configure();
			
			sessionFactory = configuration.buildSessionFactory();

			return sessionFactory;

		} catch (Throwable e) {
			System.err.println("Création de la SessionFactory : \n" + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * Crée une nouvelle session pour l'accès aux données
	 * 
	 * @return Session de connexion
	 */
	public static Session getNewSession() {

		return getSessionFactory().openSession();
	}
}
