package actionListener;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import ihm.fenetre.PanelCCompte;
import model.baseDAO.DaoFactory;

public class RechercherListener implements MouseListener, KeyListener
{

	private PanelCCompte panelCCompte;
	private Object[][] resultatRecherche;

	public RechercherListener(PanelCCompte panelCcompte)
	{

		this.panelCCompte = panelCcompte;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		JButton src = (JButton) e.getSource();
		if (src.equals(panelCCompte.getBtnRecherche()))
		{

			Boolean btnPressed = true;
			Boolean enterKeyFalse = false;
			try
			{
				panelCCompte.getBarreRecherche().setFocusable(false);
				afficheResultatRecherche(btnPressed, enterKeyFalse);
				panelCCompte.getBarreRecherche().setFocusable(true);
				
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

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

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	public void afficheResultatRecherche(Boolean isButtonPressed, Boolean isEnterKey) throws Exception
	{

		if ((isButtonPressed || isEnterKey) && (!panelCCompte.getBarreRecherche().getText().equals("")
				&& !panelCCompte.getBarreRecherche().getText().equals("Nom ou n°AFPA")))
		{
			
			Character testIsNumeroOuString = panelCCompte.getBarreRecherche().getText().charAt(0);
			String texteBarreRecherche = panelCCompte.getBarreRecherche().getText();
			panelCCompte.getBtnRecherche().doClick();

			if (Character.isDigit(testIsNumeroOuString) && panelCCompte.getIsSelected().intValue() == 5)
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier"))
				{
					String specialite = filtreSpecialisation();
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheToutCompteFiltre(null,
							Integer.parseInt(texteBarreRecherche), specialite);
				} else
				{
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheToutCompte(null,
							Integer.parseInt(texteBarreRecherche));
				}

			} else if (panelCCompte.getIsSelected().intValue() == 5)
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier"))
				{
					String specialite = filtreSpecialisation();
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheToutCompteFiltre(texteBarreRecherche, null, specialite);
				} else
				{
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheToutCompte(texteBarreRecherche,
							null);
				}

			} else if (Character.isDigit(testIsNumeroOuString))
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier"))
				{
					String specialite = filtreSpecialisation();
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheFiltre(null,Integer.parseInt(texteBarreRecherche), panelCCompte.getIsSelected(), specialite);
				} else
				{
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRecherche(null,Integer.parseInt(texteBarreRecherche), panelCCompte.getIsSelected());
				}
			}

			else
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier"))
				{
					String specialite = filtreSpecialisation();
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheFiltre(texteBarreRecherche, null,panelCCompte.getIsSelected(), specialite);
				} else
				{

					resultatRecherche = DaoFactory.getDaoUtilisateur().readRecherche(texteBarreRecherche, null,panelCCompte.getIsSelected());
				}
			}
			panelCCompte.getTableau().setModel(new DefaultTableModel(resultatRecherche, panelCCompte.getEnteteTableau()));
		}
		panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			Boolean enterKey = true;
			Boolean btnRechercheFalse = false;
			try
			{
				panelCCompte.getBarreRecherche().setFocusable(false);
				
				afficheResultatRecherche(btnRechercheFalse, enterKey);
				panelCCompte.getBarreRecherche().setFocusable(true);
				
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	public String filtreSpecialisation()
	{
		String specialisation = "";
		if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier"))
		{
			specialisation = "u.uti_id = m.uts_uti_id and s.spe_id = m.uts_spe_id and s.spe_nom = '"
					+ panelCCompte.getComboSecMetier().getSelectedItem() + "' and ";
		}

		return specialisation;
	}

	

		
}
