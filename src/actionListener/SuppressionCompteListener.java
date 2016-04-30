package actionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import ihm.fenetre.PanelCCompte;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;

public class SuppressionCompteListener implements MouseListener
{
	private PanelCCompte panelCCompte;
	private Object[][] resultatRecherche;

	public SuppressionCompteListener(PanelCCompte panelCCompte)
	{
		this.panelCCompte = panelCCompte;
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
			supprimeCompte(source);
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	public void supprimeCompte(JButton source) throws Exception
	{
		if (source.equals(panelCCompte.getBtnSupprimer()))
		{
			resultatRecherche = DaoFactory.getDaoUtilisateur().executeLastQuery();
			Integer currentRow = PanelCCompte.getTableau().getSelectedRow();
			Integer idAfpa = (Integer) resultatRecherche [currentRow][0];
			Utilisateur utilisateurASupprimer = DaoFactory.getDaoUtilisateur().findByIdAfpa(idAfpa);
			DaoFactory.getDaoContact().delete(DaoFactory.getDaoContact().getContactFromUser(utilisateurASupprimer));
			DaoFactory.getDaoUtilisateur().delete(utilisateurASupprimer);
			PanelCCompte.getTableau().setModel(new DefaultTableModel(DaoFactory.getDaoUtilisateur().executeLastQuery(), PanelCCompte.getEnteteTableau() ));
		}
	}
	
}
