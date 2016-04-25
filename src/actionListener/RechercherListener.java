package actionListener;

import java.awt.Toolkit;
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
				afficheResultatRecherche(btnPressed, enterKeyFalse);
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
			Toolkit.getDefaultToolkit().beep();
			Character testIsNumeroOuString = panelCCompte.getBarreRecherche().getText().charAt(0);
			String texteBarreRecherche = panelCCompte.getBarreRecherche().getText();
			panelCCompte.getBtnRecherche().doClick();

			if (Character.isDigit(testIsNumeroOuString) && panelCCompte.getIsSelected().intValue() == 0)
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier")
						|| !panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("Filtre par ordre alphabétique"))
				{
					String specialite = filtreSpecialisation();
					String ordreAlpha = ordreAlpha();
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheToutCompteFiltre(null,
							Integer.parseInt(texteBarreRecherche), specialite, ordreAlpha);
				} else
				{
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheToutCompte(null,
							Integer.parseInt(texteBarreRecherche));
				}

			} else if (panelCCompte.getIsSelected().intValue() == 0)
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier")
						|| !panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("Filtre par ordre alphabétique"))
				{
					String specialite = filtreSpecialisation();
					String ordreAlpha = ordreAlpha();
					resultatRecherche = DaoFactory.getDaoUtilisateur()
							.readRechercheToutCompteFiltre(texteBarreRecherche, null, specialite, ordreAlpha);
				} else
				{
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheToutCompte(texteBarreRecherche,
							null);
				}

			} else if (Character.isDigit(testIsNumeroOuString))
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier")
						|| !panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("Filtre par ordre alphabétique"))
				{
					String specialite = filtreSpecialisation();
					String ordreAlpha = ordreAlpha();
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheFiltre(null,
							Integer.parseInt(texteBarreRecherche), panelCCompte.getIsSelected(), specialite,
							ordreAlpha);
				} else
				{
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRecherche(null,
							Integer.parseInt(texteBarreRecherche), panelCCompte.getIsSelected());
				}
			}

			else
			{
				if (!panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier")
						|| !panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("Filtre par ordre alphabétique"))
				{
					String specialite = filtreSpecialisation();
					String ordreAlpha = ordreAlpha();
					resultatRecherche = DaoFactory.getDaoUtilisateur().readRechercheFiltre(texteBarreRecherche, null,
							panelCCompte.getIsSelected(), specialite, ordreAlpha);
				} else
				{

					resultatRecherche = DaoFactory.getDaoUtilisateur().readRecherche(texteBarreRecherche, null,
							panelCCompte.getIsSelected());
				}
			}
			panelCCompte.getTableau()
					.setModel(new DefaultTableModel(resultatRecherche, panelCCompte.getEnteteTableau()));
		} else if (panelCCompte.getBarreRecherche().getText().equals(""))
		{
			Toolkit.getDefaultToolkit().beep();
			resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateur(panelCCompte.getIsSelected());
			panelCCompte.getTableau()
					.setModel(new DefaultTableModel(resultatRecherche, panelCCompte.getEnteteTableau()));
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

				afficheResultatRecherche(btnRechercheFalse, enterKey);
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

	public String ordreAlpha()
	{
		String ordreAlpha = "";
		if (!panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("Filtre par ordre alphabétique"))
		{
			if (panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("A,B,C,D"))
			{
				ordreAlpha = " and u.uti_nom between 'a' and 'd' ";
			} else if (panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("E,F,G,H,I"))
			{
				ordreAlpha = " and u.uti_nom between 'e' and 'i' ";
			} else if (panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("J,K,L,M"))
			{
				ordreAlpha = " and u.uti_nom between 'j' and 'm' ";
			} else if (panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("N,O,P,Q"))
			{
				ordreAlpha = " and u.uti_nom between 'n' and 'q' ";
			} else if (panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("R,S,T,U"))
			{
				ordreAlpha = " and u.uti_nom between 'r' and 'u' ";
			} else if (panelCCompte.getComboOrdreAlpha().getSelectedItem().equals("V,W,X,Y,Z"))
			{
				ordreAlpha = " and u.uti_nom between 'v' and 'z' ";
			}
		}

		return ordreAlpha;
	}
}
