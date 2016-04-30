package model.baseDAO;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.objet.Contact;
import model.objet.Utilisateur;

public class DaoUtilisateur extends DaoParent
{
	
	private String lastQuery ;
	
	
	public Object[][] readUtilisateurAll() throws Exception
	{

		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom, r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id , role r , utilisateur_role j where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id order by u.uti_nom ";
        this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
		ScrollableResults resultat = query.scroll();
		resultat.last();
		Object[][] resultAdmin = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultAdmin[i][0] = resultat.get()[0];
			resultAdmin[i][1] = resultat.get()[1];
			resultAdmin[i][2] = resultat.get()[2];
			resultAdmin[i][3] = resultat.get()[3];
			resultAdmin[i][4] = resultat.get()[4];
			resultAdmin[i][5] = resultat.get()[5];
			resultAdmin[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultAdmin;
	}
	
	public Object[][] readUtilisateurAllFiltre(String secMetier) throws Exception
	{

		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type, frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id left join utilisateur_specialisation k on u.uti_id = k.uts_uti_id left join specialisation s on s.spe_id = k.uts_spe_id ,role r , utilisateur_role j where s.spe_nom = '"+secMetier+"' and u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id order by u.uti_nom ";
        this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
		ScrollableResults resultat = query.scroll();
		resultat.last();
		Object[][] resultAdmin = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultAdmin[i][0] = resultat.get()[0];
			resultAdmin[i][1] = resultat.get()[1];
			resultAdmin[i][2] = resultat.get()[2];
			resultAdmin[i][3] = resultat.get()[3];
			resultAdmin[i][4] = resultat.get()[4];
			resultAdmin[i][5] = resultat.get()[5];
			resultAdmin[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultAdmin;
	}

	public Object[][] readUtilisateurTypeCompte(Integer isSelected) throws Exception
	{

		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id   , role r, utilisateur_role j where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and rol_id = " +isSelected+ " order by u.uti_nom ";
		this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
		ScrollableResults resultat = query.scroll();
		resultat.last();
		Object[][] resultAdmin = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultAdmin[i][0] = resultat.get()[0];
			resultAdmin[i][1] = resultat.get()[1];
			resultAdmin[i][2] = resultat.get()[2];
			resultAdmin[i][3] = resultat.get()[3];
			resultAdmin[i][4] = resultat.get()[4];
			resultAdmin[i][5] = resultat.get()[5];
			resultAdmin[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultAdmin;
	}
	public Object[][] readUtilisateurTypeCompteFiltre(Integer isSelected,String secMetier) throws Exception
	{

		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id left join utilisateur_specialisation k on u.uti_id = k.uts_uti_id left join specialisation s on s.spe_id = k.uts_spe_id , role r, utilisateur_role j where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and rol_id = " +isSelected+ " and s.spe_nom = '"+secMetier+"' order by u.uti_nom ";
		this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
		ScrollableResults resultat = query.scroll();
		resultat.last();
		Object[][] resultAdmin = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultAdmin[i][0] = resultat.get()[0];
			resultAdmin[i][1] = resultat.get()[1];
			resultAdmin[i][2] = resultat.get()[2];
			resultAdmin[i][3] = resultat.get()[3];
			resultAdmin[i][4] = resultat.get()[4];
			resultAdmin[i][5] = resultat.get()[5];
			resultAdmin[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultAdmin;
	}

	
	
	public Object [][] readRecherche(String nom , Integer idAFPA, Integer isSelected)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id , role r, utilisateur_role j where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and rol_id = "+ isSelected +" and (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') order by u.uti_nom ";
		this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultRecherche[i][0] = resultat.get()[0];
			resultRecherche[i][1] = resultat.get()[1];
			resultRecherche[i][2] = resultat.get()[2];
			resultRecherche[i][3] = resultat.get()[3];
			resultRecherche[i][4] = resultat.get()[4];
			resultRecherche[i][5] = resultat.get()[5];
			resultRecherche[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultRecherche;
        
	}
	
	public Object [][] readRechercheToutCompte(String nom , Integer idAFPA)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id   , role r, utilisateur_role j where (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') and u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id order by u.uti_nom ";
		this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultRecherche[i][0] = resultat.get()[0];
			resultRecherche[i][1] = resultat.get()[1];
			resultRecherche[i][2] = resultat.get()[2];
			resultRecherche[i][3] = resultat.get()[3];
			resultRecherche[i][4] = resultat.get()[4];
			resultRecherche[i][5] = resultat.get()[5];
			resultRecherche[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultRecherche;
        
	}
	
	public Object [][] readRechercheToutCompteFiltre(String nom , Integer idAFPA, String specialite)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id   , role r, utilisateur_role j,specialisation s, utilisateur_specialisation m where "+ specialite +"  (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') and u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id  order by u.uti_nom ";
		this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultRecherche[i][0] = resultat.get()[0];
			resultRecherche[i][1] = resultat.get()[1];
			resultRecherche[i][2] = resultat.get()[2];
			resultRecherche[i][3] = resultat.get()[3];
			resultRecherche[i][4] = resultat.get()[4];
			resultRecherche[i][5] = resultat.get()[5];
			resultRecherche[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultRecherche;
        
	}
	public Object[][] readUtilisateurFiltre(Integer isSelected , String specialite) throws Exception
	{

		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id   , role r, utilisateur_role j,specialisation s, utilisateur_specialisation m   where "+specialite+" u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and rol_id = " +isSelected+ "  order by u.uti_nom ";
		this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
		ScrollableResults resultat = query.scroll();
		resultat.last();
		Object[][] resultAdmin = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultAdmin[i][0] = resultat.get()[0];
			resultAdmin[i][1] = resultat.get()[1];
			resultAdmin[i][2] = resultat.get()[2];
			resultAdmin[i][3] = resultat.get()[3];
			resultAdmin[i][4] = resultat.get()[4];
			resultAdmin[i][5] = resultat.get()[5];
			resultAdmin[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultAdmin;
	}
	
	public Object [][] readRechercheFiltre(String nom , Integer idAFPA, Integer isSelected, String specialite)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id  , role r, utilisateur_role j,specialisation s, utilisateur_specialisation m  where "+specialite+" u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and rol_id = "+ isSelected +" and (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') order by u.uti_nom ";
		this.lastQuery = stringQuery;
		SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultRecherche[i][0] = resultat.get()[0];
			resultRecherche[i][1] = resultat.get()[1];
			resultRecherche[i][2] = resultat.get()[2];
			resultRecherche[i][3] = resultat.get()[3];
			resultRecherche[i][4] = resultat.get()[4];
			resultRecherche[i][5] = resultat.get()[5];
			resultRecherche[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultRecherche;
        
	}
	
	public Object[][] executeLastQuery()
	
	{
		Session session = BaseSession.getNewSession();
		String stringQuery;
		if (this.lastQuery.isEmpty())
		{
			stringQuery = "SELECT distinct u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom ,r.rol_type , frm_intitule , c.con_mail , c.con_telephone from utilisateur u left join  contact c on u.uti_id = c.uti_id left join utilisateur_formation l on u.uti_id = l.utf_uti_id left join formation on l.utf_frm_id = formation.frm_id ,role r , utilisateur_role j where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id order by u.uti_nom ";
		}
		else
		{
			stringQuery = lastQuery;
		}
		SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][7];
		resultat.beforeFirst();
		int i = 0;
		while (resultat.next())
		{

			resultRecherche[i][0] = resultat.get()[0];
			resultRecherche[i][1] = resultat.get()[1];
			resultRecherche[i][2] = resultat.get()[2];
			resultRecherche[i][3] = resultat.get()[3];
			resultRecherche[i][4] = resultat.get()[4];
			resultRecherche[i][5] = resultat.get()[5];
			resultRecherche[i][6] = resultat.get()[6];
			i++;

		}
		session.close();

		return resultRecherche;
	}
	
	public Utilisateur  findByIdAfpa( Integer idAfpa)
			throws Exception
	{

		Session session = BaseSession.getNewSession();

		Criteria criteria = session.createCriteria(Utilisateur.class);
		criteria.add(Restrictions.eq("identifiantAFPA", idAfpa));
		@SuppressWarnings("unchecked")
		Utilisateur result = (Utilisateur) criteria.uniqueResult();

		session.close();
		return result;
	}

	
	public Utilisateur getUserFromMail(String mail)
	{
		Utilisateur user = null;
		
		Session session = BaseSession.getNewSession();

		try
		{
			Criteria criteria = session.createCriteria(Contact.class);
			criteria.add(Restrictions.eq("mail", mail));

			Contact result = (Contact) criteria.uniqueResult();
			
			user = result.getUtilisateur();
		}
		catch (Exception e)
		{
			
		}
		
		
		
		return user;
		
	}

}
