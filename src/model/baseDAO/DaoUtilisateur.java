package model.baseDAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

public class DaoUtilisateur extends DaoParent {

	
	public Object[][] readAdmin() throws Exception
	{

		Session session = BaseSession.getNewSession(); 
		String stringQuery = "SELECT u.uti_identifiant_afpa ,u.uti_nom, u.uti_prenom , f.frm_intitule , c.con_mail , c.con_telephone  from utilisateur u, role r, utilisateur_role j, contact c , formation f , utilisateur_formation l  where u.uti_id = j.utr_uti_id and r.rol_id = j.utr_rol_id and u.uti_id = c.uti_id and  rol_id = 1 and u.uti_id = utf_uti_id and utf_frm_id = frm_id ";
		SQLQuery  query = session.createSQLQuery(stringQuery.toString());
		ScrollableResults resultat = query.scroll();
		resultat.last();
		int getSize = resultat.getRowNumber();
	    Object [][] resultAdmin = new Object [6][getSize];
	    resultat.beforeFirst();
		while (resultat.next())
			{
				System.out.println(resultat.getText(3));
				/*int i = 0 ;
				resultAdmin [0][i] = resultat.getInteger(0);
				resultAdmin [1][i] = resultat.getString(1);
				resultAdmin [2][i] = resultat.getString(2);
				resultAdmin [3][i] = resultat.getString(3);
				resultAdmin [4][i] = resultat.getString(4);
				resultAdmin [5][i] = resultat.getString(5);
				i++;*/
			
			}
	

		return resultAdmin;
	}
	
	
}
