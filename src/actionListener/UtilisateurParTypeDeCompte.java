package actionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controleur.ControleurFMain;
import ihm.fenetre.PanelCCompte;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;

public class UtilisateurParTypeDeCompte implements MouseListener
{

	private PanelCCompte panelCCompte;
	private Object[][] resultatRecherche;

	public UtilisateurParTypeDeCompte(PanelCCompte panelCCompte)
	{
		this.panelCCompte = panelCCompte;
	}

	public void actionPerformed(ActionEvent e)

	{

	}

	public void setLblColor()
	{
		panelCCompte.getLblAdministrateur().setForeground(Color.WHITE);
		panelCCompte.getLblFormateur().setForeground(Color.WHITE);
		panelCCompte.getLblStagiaire().setForeground(Color.WHITE);
		panelCCompte.getLblTuteur().setForeground(Color.WHITE);
		panelCCompte.getLblTous().setForeground(Color.WHITE);
	}

	public void setBorder()

	{

		panelCCompte.getLblAdministrateur().setBorder(null);
		panelCCompte.getLblFormateur().setBorder(null);
		panelCCompte.getLblStagiaire().setBorder(null);
		panelCCompte.getLblTuteur().setBorder(null);
		panelCCompte.getLblTous().setBorder(null);
	}

	public void afficheTableau(JLabel source) throws Exception

	{
		if (source.equals(panelCCompte.getLblAdministrateur())|| source.equals(panelCCompte.getLblFormateur())||source.equals(panelCCompte.getLblStagiaire())||source.equals(panelCCompte.getLblTuteur()))
		{
			setLblColor();
			panelCCompte.getLblAdministrateur().setForeground(new Color(30, 144, 255));
			panelCCompte.getLblAdministrateur().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			setBorder();
			panelCCompte.setIsSelected(1);
			panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");
			if (panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier"))
			{
				resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateurTypeCompte(panelCCompte.getIsSelected());
			}
			else 
			{
				resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateurTypeCompteFiltre(panelCCompte.getIsSelected(),panelCCompte.getComboSecMetier().getSelectedItem().toString());
			}

		} 
		else if ((source.equals(panelCCompte.getLblTous())&& panelCCompte.getIsSelected() != 5) || (panelCCompte.getIsSelected() == 5)  )
		{
			setLblColor();
			panelCCompte.getLblTous().setForeground(new Color(30, 144, 255));
			panelCCompte.getLblTous().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			setBorder();
			panelCCompte.setIsSelected(5);
			panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");
			if (panelCCompte.getComboSecMetier().getSelectedItem().equals("Secteur de métier"))
			{
				resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateurAll();
			}


		}

		panelCCompte.getTableau().setModel( new DefaultTableModel(resultatRecherche,panelCCompte.getEnteteTableau()));

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		JLabel source = (JLabel) e.getSource();

		if (source.equals(panelCCompte.getLblAdministrateur()) &&  panelCCompte.getIsSelected()!= 1)
		{

			panelCCompte.getLblAdministrateur().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		} else if (source.equals(panelCCompte.getLblFormateur()) && panelCCompte.getIsSelected() != 2)
		{

			panelCCompte.getLblFormateur().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		} else if (source.equals(panelCCompte.getLblStagiaire()) && panelCCompte.getIsSelected() != 3)
		{

			panelCCompte.getLblStagiaire().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		} else if (source.equals(panelCCompte.getLblTuteur()) && panelCCompte.getIsSelected() != 4)
		{

			panelCCompte.getLblTuteur().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		}
		else if (source.equals(panelCCompte.getLblTous()) && panelCCompte.getIsSelected() != 5) 
		{
			panelCCompte.getLblTous().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		}

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

		JLabel source = (JLabel) e.getSource();
		if (source.equals(panelCCompte.getLblAdministrateur()))
		{

			setBorder();
		} else if (source.equals(panelCCompte.getLblFormateur()))
		{

			setBorder();
		} else if (source.equals(panelCCompte.getLblStagiaire()))
		{

			setBorder();
		}else if (source.equals(panelCCompte.getLblTuteur()))
		{

			setBorder();
		}
		else
		{

			setBorder();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		JLabel source = (JLabel) e.getSource();
		try
		{
			afficheTableau(source);
		} catch (Exception e1)
		{

		}

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
