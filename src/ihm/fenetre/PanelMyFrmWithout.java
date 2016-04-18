package ihm.fenetre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;


public class PanelMyFrmWithout extends JPanel
{

	
	/**
	 * Create the panel.
	 */
	public PanelMyFrmWithout()
	{
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		this.setBackground(Color.decode("#3787C8"));
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.decode("#003C6E"));
		panelLeft.setPreferredSize(new Dimension(300, 10));
		add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLabel = new JPanel();
		panelLeft.add(panelLabel, BorderLayout.NORTH);
		panelLabel.setBackground(Color.decode("#003C6E"));
		panelLabel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations = new JLabel("Mes Formations");
		lblMesFormations.setForeground(Color.WHITE);
		panelLabel.add(lblMesFormations, BorderLayout.NORTH);
		lblMesFormations.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 150));
		
		JPanel panelCenterLbl = new JPanel();
		panelCenterLbl.setMinimumSize(new Dimension(0, 10));
		panelCenterLbl.setBackground(Color.decode("#003C6E"));
		panelLeft.add(panelCenterLbl, BorderLayout.CENTER);
		panelCenterLbl.setPreferredSize(new Dimension(50, 10));
		
		JLabel lblVousNavezAucune = new JLabel("Vous n'avez aucune formation existante");
		lblVousNavezAucune.setBorder(new EmptyBorder(100, 0, 0, 0));
		lblVousNavezAucune.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblVousNavezAucune.setForeground(Color.WHITE);
		lblVousNavezAucune.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVousNavezAucune.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenterLbl.add(lblVousNavezAucune);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAucunContenu = new JLabel("Aucun contenu à afficher");
		lblAucunContenu.setBorder(new EmptyBorder(0, 0, 50, 0));
		lblAucunContenu.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAucunContenu.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblAucunContenu.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAucunContenu.setHorizontalAlignment(SwingConstants.CENTER);
		panelRight.add(lblAucunContenu);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 250, 0));
		panelRight.add(panel, BorderLayout.SOUTH);
		
		JButton btnCrerNouvelleFormation = new JButton("Créer nouvelle formation");
		btnCrerNouvelleFormation.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel.add(btnCrerNouvelleFormation);
	}

	
}
