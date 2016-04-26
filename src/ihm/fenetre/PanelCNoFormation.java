package ihm.fenetre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ihm.popup.CreaForm;
import ihm.theme.ThemeLIPPS;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;


public class PanelCNoFormation extends JPanel
{

	
	/**
	 * Create the panel.
	 */
	public PanelCNoFormation()
	{
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		this.setBackground(ThemeLIPPS.BLUE_DARK);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setOpaque(false);
		panelLeft.setBackground(ThemeLIPPS.BLUE_DARK);
		panelLeft.setPreferredSize(new Dimension(300, 10));
		add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLabel = new JPanel();
		panelLabel.setOpaque(false);
		panelLeft.add(panelLabel, BorderLayout.NORTH);
		panelLabel.setBackground(ThemeLIPPS.BLUE);
		panelLabel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations = new JLabel("Mes Formations");
		lblMesFormations.setVerticalAlignment(SwingConstants.TOP);
		lblMesFormations.setForeground(Color.WHITE);
		panelLabel.add(lblMesFormations, BorderLayout.NORTH);
		lblMesFormations.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 150));
		
		JPanel panelCenterLbl = new JPanel();
		panelCenterLbl.setOpaque(false);
		panelCenterLbl.setMinimumSize(new Dimension(0, 10));
		panelCenterLbl.setBackground(ThemeLIPPS.BLUE);
		panelLeft.add(panelCenterLbl, BorderLayout.CENTER);
		panelCenterLbl.setPreferredSize(new Dimension(50, 900));
		panelCenterLbl.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVousNavezAucune = new JLabel("Aucune formation existante");
		lblVousNavezAucune.setVerticalAlignment(SwingConstants.TOP);
		lblVousNavezAucune.setVerticalTextPosition(SwingConstants.TOP);
		lblVousNavezAucune.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblVousNavezAucune.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblVousNavezAucune.setForeground(Color.WHITE);
		lblVousNavezAucune.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVousNavezAucune.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenterLbl.add(lblVousNavezAucune, BorderLayout.NORTH);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setOpaque(false);
		panelBtn.setBorder(new EmptyBorder(0, 0, 15, 0));
		panelLeft.add(panelBtn, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		panel.setPreferredSize(new Dimension(250, 40));
		panelBtn.add(panel);
		
		JButton btnCrrNouvelleFormation = new JButton("Créér nouvelle formation");
		btnCrrNouvelleFormation.setPreferredSize(new Dimension(250, 40));
		btnCrrNouvelleFormation.setMnemonic('n');
		btnCrrNouvelleFormation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnCrrNouvelleFormation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CreaForm newFormation = new CreaForm();
		}
	});
		panel.add(btnCrrNouvelleFormation);
		
//		JButton btnCrerNouvelleFormation = new JButton("Créer nouvelle formation");
//		btnCrerNouvelleFormation.setHorizontalTextPosition(SwingConstants.CENTER);
//		panel.add(btnCrerNouvelleFormation);
//		btnCrerNouvelleFormation.setBorderPainted(false);
//		btnCrerNouvelleFormation.setBorder(null);
//		btnCrerNouvelleFormation.setPreferredSize(new Dimension(200, 40));

		
		JPanel panelRight = new JPanel();
		panelRight.setPreferredSize(new Dimension(40, 30));
		panelRight.setBorder(null);
		panelRight.setBackground(Color.WHITE);
		add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLogo = new JLabel(new ImageIcon("./img/afpa.jpg"));
		
		panelRight.add(lblLogo, BorderLayout.CENTER);
	}

	
}
