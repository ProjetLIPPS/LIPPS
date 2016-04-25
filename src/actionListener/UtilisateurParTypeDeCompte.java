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
		panelCCompte.getLblAdmin().setForeground(Color.WHITE);
		panelCCompte.getLblForm().setForeground(Color.WHITE);
		panelCCompte.getLblSta().setForeground(Color.WHITE);
		panelCCompte.getLblTut().setForeground(Color.WHITE);

	}

	public void setBorder()

	{

		panelCCompte.getLblAdmin().setBorder(null);
		panelCCompte.getLblForm().setBorder(null);
		panelCCompte.getLblSta().setBorder(null);
		panelCCompte.getLblTut().setBorder(null);

	}

	public void afficheTableau(JLabel source) throws Exception

	{
		if (source.equals(panelCCompte.getLblAdmin())&& panelCCompte.getIsSelected() != 1 )
		{
			setLblColor();
			panelCCompte.getLblAdmin().setForeground(new Color(30, 144, 255));
			panelCCompte.getLblAdmin().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			setBorder();
			panelCCompte.setIsSelected(1);
			resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateur(panelCCompte.getIsSelected());
			panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");

		} else if (source.equals(panelCCompte.getLblForm())&& panelCCompte.getIsSelected() != 2)
		{
			setLblColor();
			panelCCompte.getLblForm().setForeground(new Color(30, 144, 255));
			panelCCompte.getLblForm().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			setBorder();
			panelCCompte.setIsSelected(2);
			resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateur(panelCCompte.getIsSelected());
			panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");


		} else if (source.equals(panelCCompte.getLblSta())&& panelCCompte.getIsSelected() != 3)
		{
			setLblColor();
			panelCCompte.getLblSta().setForeground(new Color(30, 144, 255));
			panelCCompte.getLblSta().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			setBorder();
			panelCCompte.setIsSelected(3);
			resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateur(panelCCompte.getIsSelected());
			panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");


		} else if (source.equals(panelCCompte.getLblTuteur())&& panelCCompte.getIsSelected() != 4)
		{
			setLblColor();
			panelCCompte.getLblTut().setForeground(new Color(30, 144, 255));
			panelCCompte.getLblTut().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			setBorder();
			panelCCompte.setIsSelected(4);
			resultatRecherche = DaoFactory.getDaoUtilisateur().readUtilisateur(panelCCompte.getIsSelected());
			panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");
			


		}

		panelCCompte.getTableau().setModel( new DefaultTableModel(resultatRecherche,panelCCompte.getEnteteTableau()));

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		JLabel source = (JLabel) e.getSource();

		if (source.equals(panelCCompte.getLblAdmin()) &&  panelCCompte.getIsSelected()!= 1)
		{

			panelCCompte.getLblAdmin().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		} else if (source.equals(panelCCompte.getLblForm()) && panelCCompte.getIsSelected() != 2)
		{

			panelCCompte.getLblForm().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		} else if (source.equals(panelCCompte.getLblSta()) && panelCCompte.getIsSelected() != 3)
		{

			panelCCompte.getLblSta().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		} else if (source.equals(panelCCompte.getLblTut()) && panelCCompte.getIsSelected() != 4)
		{

			panelCCompte.getLblTut().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		}

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

		JLabel source = (JLabel) e.getSource();
		if (source.equals(panelCCompte.getLblAdmin()))
		{

			setBorder();
		} else if (source.equals(panelCCompte.getLblForm()))
		{

			setBorder();
		} else if (source.equals(panelCCompte.getLblSta()))
		{

			setBorder();
		} else
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
