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

public class MouseListeners implements MouseListener
	{

		private ControleurFMain controleur;
		private PanelCCompte panelCCompte;
		private Integer isSelected = 0;
		private String[] enteteTableau = new String[]
			{ "Identifiant AFPA", "Nom", "Prenom", "Formation", "Email", "Numéro Téléphone" };
		private Class[] columnTypes = new Class[]
			{ String.class, String.class, String.class, Integer.class, String.class, String.class };
		private Object[][] resultatRecherche = new Object[3][2];

		public MouseListeners(PanelCCompte panelCCompte)
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

		public void afficheTableau(JLabel source)

			{
				if (source.equals(panelCCompte.getLblAdmin()))
					{
						setLblColor();
						panelCCompte.getLblAdmin().setForeground(new Color(30, 144, 255));
						setBorder();

					}
				else if (source.equals(panelCCompte.getLblForm()))
					{
						setLblColor();
						panelCCompte.getLblForm().setForeground(new Color(30, 144, 255));
						panelCCompte.getLblForm().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
						isSelected = 2;
						setBorder();

					}
				else if (source.equals(panelCCompte.getLblSta()))
					{
						setLblColor();
						panelCCompte.getLblSta().setForeground(new Color(30, 144, 255));
						panelCCompte.getLblSta().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
						isSelected = 3;
						setBorder();

					}
				else
					{
						setLblColor();
						panelCCompte.getLblTut().setForeground(new Color(30, 144, 255));
						panelCCompte.getLblTut().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
						isSelected = 4;
						setBorder();

					}

				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);

				for (int i = 0; i < 6; i++)
					{
						panelCCompte.getTable().getColumnModel().getColumn(i).setResizable(false);
						panelCCompte.getTable().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

					}

				panelCCompte.getTable().setModel(new DefaultTableModel(resultatRecherche, enteteTableau));
			}

		
		@Override
		public void mouseEntered(MouseEvent e)
			{
				JLabel source = (JLabel) e.getSource();

				if (source.equals(panelCCompte.getLblAdmin()) && isSelected != 1)
					{

						panelCCompte.getLblAdmin().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
					}
				else if (source.equals(panelCCompte.getLblForm()) && isSelected != 2)
					{

						panelCCompte.getLblForm().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
					}
				else if (source.equals(panelCCompte.getLblSta()) && isSelected != 3)
					{

						panelCCompte.getLblSta().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
					}
				else if (source.equals(panelCCompte.getLblTut()) && isSelected != 4)
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
					}
				else if (source.equals(panelCCompte.getLblForm()))
					{

						setBorder();
					}
				else if (source.equals(panelCCompte.getLblSta()))
					{

						setBorder();
					}
				else
					{

						setBorder();
					}

			}

	}
