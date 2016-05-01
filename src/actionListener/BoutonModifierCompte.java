package actionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import controleur.ControleurFMain;
import ihm.fenetre.PanelCCompte;
import ihm.popup.CreationCompte;
import ihm.popup.ModificationCompte;
import model.baseDAO.DaoFactory;
import model.objet.ResultatParcoursLivret;
import model.objet.Utilisateur;

public class BoutonModifierCompte implements MouseListener
{

private PanelCCompte panelCcompte;
private Object [][] resultatRecherche;
private ModificationCompte popupModifCompte;
	
	public  BoutonModifierCompte (PanelCCompte panelCCompte)
	{
		this.panelCcompte = panelCCompte;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		JButton source = (JButton) e.getSource();
		try
		{
			modifCompte(source);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void modifCompte(JButton source) throws Exception
	
	{
		
			
			
			resultatRecherche = DaoFactory.getDaoUtilisateur().executeLastQuery();
			Integer currentRow = PanelCCompte.getTableau().getSelectedRow();
			Integer idAfpa = (Integer) resultatRecherche[currentRow][0];
			String role = (String) resultatRecherche[currentRow][3];
			Utilisateur utilisateurAModifier = DaoFactory.getDaoUtilisateur().findByIdAfpa(idAfpa);
			ModificationCompte popupModifierCompte = new ModificationCompte(utilisateurAModifier);
			
		
	}

}
