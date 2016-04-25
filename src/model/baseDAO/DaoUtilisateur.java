package model.baseDAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import model.objet.Utilisateur;

public class DaoUtilisateur extends DaoParent
{

	public Object[][] readUtilisateur(Integer isSelected) throws Exception
	{

		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom , f.frm_intitule , c.con_mail , c.con_telephone  from utilisateur u, role r, utilisateur_role j, contact c , formation f , utilisateur_formation l  where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and u.uti_id = c.uti_id and   u.uti_id = utf_uti_id and utf_frm_id = frm_id and rol_id = " +isSelected+ " order by u.uti_nom ";

		SQLQuery query = session.createSQLQuery(stringQuery);
		ScrollableResults resultat = query.scroll();
		resultat.last();
		Object[][] resultAdmin = new Object[resultat.getRowNumber() + 1][6];
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
			i++;

		}
		session.close();

		return resultAdmin;
	}

	
	
	public Object [][] readRecherche(String nom , Integer idAFPA, Integer isSelected)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom , f.frm_intitule , c.con_mail , c.con_telephone  from utilisateur u, role r, utilisateur_role j, contact c , formation f , utilisateur_formation l  where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and u.uti_id = c.uti_id  and u.uti_id = utf_uti_id and utf_frm_id = frm_id and  rol_id = "+ isSelected +" and (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') order by u.uti_nom ";
        SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][6];
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
			i++;

		}
		session.close();

		return resultRecherche;
        
	}
	
	public Object [][] readRechercheToutCompte(String nom , Integer idAFPA)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT  u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom , f.frm_intitule , c.con_mail , c.con_telephone  from utilisateur u, contact c , formation f , utilisateur_formation l  where u.uti_id = c.uti_id and u.uti_id = utf_uti_id and utf_frm_id = frm_id and (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') order by u.uti_nom ";
        SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][6];
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
			i++;

		}
		session.close();

		return resultRecherche;
        
	}
	
	public Object [][] readRechercheToutCompteFiltre(String nom , Integer idAFPA, String specialite, String ordreAlpha)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT  u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom , f.frm_intitule , c.con_mail , c.con_telephone  from utilisateur u, contact c , formation f , utilisateur_formation l,specialisation s, utilisateur_specialisation m where "+ specialite +" u.uti_id = c.uti_id and u.uti_id = utf_uti_id and utf_frm_id = frm_id and (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') "+ ordreAlpha+" order by u.uti_nom ";
        SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][6];
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
			i++;

		}
		session.close();

		return resultRecherche;
        
	}
	public Object[][] readUtilisateurFiltre(Integer isSelected , String specialite, String ordreAlpha ) throws Exception
	{

		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom , f.frm_intitule , c.con_mail , c.con_telephone  from utilisateur u, role r, utilisateur_role j, contact c , formation f , utilisateur_formation l,specialisation s, utilisateur_specialisation m   where "+specialite+" u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and u.uti_id = c.uti_id and " +ordreAlpha+"  u.uti_id = utf_uti_id and utf_frm_id = frm_id and rol_id = " +isSelected+ "  order by u.uti_nom ";

		SQLQuery query = session.createSQLQuery(stringQuery);
		ScrollableResults resultat = query.scroll();
		resultat.last();
		Object[][] resultAdmin = new Object[resultat.getRowNumber() + 1][6];
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
			i++;

		}
		session.close();

		return resultAdmin;
	}
	
	public Object [][] readRechercheFiltre(String nom , Integer idAFPA, Integer isSelected, String specialite, String ordreAlpha)
	{
		Session session = BaseSession.getNewSession();
		String stringQuery = "SELECT u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom , f.frm_intitule , c.con_mail , c.con_telephone  from utilisateur u, role r, utilisateur_role j, contact c , formation f , utilisateur_formation l ,specialisation s, utilisateur_specialisation m  where "+specialite+" u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and u.uti_id = c.uti_id  and u.uti_id = utf_uti_id and utf_frm_id = frm_id and  rol_id = "+ isSelected +" and (u.uti_nom like '"+nom+"%' or u.uti_identifiant_afpa like'"+ idAFPA +"%') "+ordreAlpha+" order by u.uti_nom ";
        SQLQuery query = session.createSQLQuery(stringQuery);
        ScrollableResults resultat = query.scroll();
        resultat.last();
        Object[][] resultRecherche = new Object[resultat.getRowNumber() + 1][6];
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
			i++;

		}
		session.close();

		return resultRecherche;
        
	}


}
