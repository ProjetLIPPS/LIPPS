package fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import actionListener.RechercheListener;
import actionListener.TypeCompteListener;
import theme.ThemeLIPPS;
import javax.swing.border.MatteBorder;

public class PanelCCompte extends JPanel {
	private JTextField barreRecherche;
	private JTable table;
	private JLabel lblAdministrateur = new JLabel(" Administrateur");
	private JLabel lblFormateur = new JLabel(" Formateur");
	private JLabel lblStagiaire = new JLabel(" Stagiaire");
	private JLabel lblTuteur = new JLabel(" Tuteur");
	/**
	 * Create the panel.
	 */
	public PanelCCompte() {
		
		TypeCompteListener typeCListener =  new TypeCompteListener(this);
		RechercheListener rechercheListener = new RechercheListener(this);

		this.setBorder(null);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(0, 0));

		JPanel panelArianeWest = new JPanel();
		panelArianeWest.setPreferredSize(new Dimension(250, 10));
		panelArianeWest.setBackground(ThemeLIPPS.BLUE_DARK);
		this.add(panelArianeWest, BorderLayout.WEST);
		panelArianeWest.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelArianeWest.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panelArianeWest.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(8, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_4.add(panel_1);

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_4.add(panel_9);

		JPanel panel_5 = new JPanel();
		panel_5.setFont(new Font("Century Gothic", Font.BOLD, 20));
		FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
		flowLayout_4.setHgap(25);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_5.setOpaque(false);
		panel_4.add(panel_5);
		lblAdministrateur.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);
		

		lblAdministrateur.addMouseListener(typeCListener);
		lblAdministrateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdministrateur.setMaximumSize(new Dimension(70, 20));
		lblAdministrateur.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblAdministrateur.setForeground(new Color(255, 255, 255));
		panel_5.add(lblAdministrateur);

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_6.getLayout();
		flowLayout_5.setHgap(25);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_6.setOpaque(false);
		panel_4.add(panel_6);
		

		lblFormateur.addMouseListener(typeCListener);
		lblFormateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFormateur.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblFormateur.setForeground(Color.WHITE);
		panel_6.add(lblFormateur);

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_7.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		flowLayout_6.setHgap(25);
		panel_7.setOpaque(false);
		panel_4.add(panel_7);
		

		lblStagiaire.addMouseListener(typeCListener);
		lblStagiaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblStagiaire.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblStagiaire.setForeground(Color.WHITE);
		panel_7.add(lblStagiaire);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setHgap(25);
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_8.setOpaque(false);
		panel_4.add(panel_8);
		
		lblTuteur.addMouseListener(typeCListener);
		lblTuteur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTuteur.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTuteur.setForeground(Color.WHITE);
		panel_8.add(lblTuteur);

		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_4.add(panel_10);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel_4.add(panel);

		JPanel panelConteneurCentre = new JPanel();
		panelConteneurCentre.setBackground(Color.WHITE);
		this.add(panelConteneurCentre, BorderLayout.CENTER);
		panelConteneurCentre.setLayout(new BorderLayout(0, 0));

		JPanel panelSup = new JPanel();
		panelSup.setPreferredSize(new Dimension(10, 90));
		panelSup.setMinimumSize(new Dimension(1500, 1500));
		panelSup.setBorder(new EmptyBorder(20, 0, 5, 0));
		panelSup.setBackground(ThemeLIPPS.BLUE_DARK);
		panelConteneurCentre.add(panelSup, BorderLayout.NORTH);
		panelSup.setLayout(new BorderLayout(0, 0));

		JPanel panelBouttons = new JPanel();
		panelBouttons.setOpaque(false);
		panelBouttons.setBorder(UIManager.getBorder("Menu.border"));
		panelBouttons.setBackground(Color.WHITE);
		panelSup.add(panelBouttons);

		JPanel panelRecherche = new JPanel();
		panelRecherche.setOpaque(false);
		panelRecherche.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelRecherche.setBackground(ThemeLIPPS.BLUE_DARK);
		FlowLayout flowLayout_1 = (FlowLayout) panelRecherche.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(15);
		flowLayout_1.setAlignment(FlowLayout.LEFT);

		barreRecherche = new JTextField();
		barreRecherche.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		barreRecherche.setPreferredSize(new Dimension(150, 30));
		barreRecherche.setMargin(new Insets(4, 4, 5, 6));
		barreRecherche.setBackground(Color.WHITE);
		barreRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		panelRecherche.add(barreRecherche);
		barreRecherche.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		barreRecherche.setToolTipText("");
		barreRecherche.setText("Nom ou n\u00B0AFPA");
		barreRecherche.setColumns(15);
		barreRecherche.addFocusListener(rechercheListener);

		JButton btnNewButton = new JButton();
		btnNewButton.setFocusable(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setIconTextGap(0);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setPreferredSize(new Dimension(40, 30));
		btnNewButton.setMargin(new Insets(3, 14, 4, 14));
		panelRecherche.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelBouttons.setLayout(new BorderLayout(0, 0));
		btnNewButton.setIcon(new ImageIcon("./img/search 16.png"));
		panelBouttons.add(panelRecherche, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		panelBouttons.add(panel_2, BorderLayout.CENTER);
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(15);

		JComboBox comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.add(comboBox);
		comboBox.setMinimumSize(new Dimension(28, 25));
		comboBox.setPreferredSize(new Dimension(180, 30));
		comboBox.setBackground(SystemColor.window);
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Secteur de métier", "Audiovisuel", "Automobile",
				"Autre", "Assurance", "Bâtiment", "Commerce", "Communication", "Droit", "Enseignement", "Environnement",
				"Hôtellerie", "Immobilier", "Informatique", "Langues", "Marketing", "Propreté", "Ressources Humaines",
				"Restauration", "Sciences Humaines", "Secrétariat", "Social", "Tourisme", "Transport , Logistique" }));

		JPanel panel_3 = new JPanel();
		panelBouttons.add(panel_3, BorderLayout.EAST);
		panel_3.setOpaque(false);
		panel_3.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setHgap(0);
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		flowLayout_2.setVgap(15);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_1.setPreferredSize(new Dimension(235, 30));
		panel_3.add(comboBox_1);
		comboBox_1.setMinimumSize(new Dimension(28, 25));
		comboBox_1.setBackground(SystemColor.window);
		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Filtre par ordre alphabétique", "A...D", "E...I",
				"J...M", "N...Q", "R...U ", "V...Z" }));
		comboBox_1.setName("Tri par ordre alphabétique");

		JPanel panelEdition = new JPanel();
		panelEdition.setBackground(Color.WHITE);
		panelConteneurCentre.add(panelEdition, BorderLayout.CENTER);
		panelEdition.setLayout(new BorderLayout(0, 0));

		JPanel panelTableau = new JPanel();
		panelTableau.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(191, 205, 219), new Color(191, 205, 219),
				new Color(191, 205, 219), new Color(191, 205, 219)));
		panelTableau.setBackground(Color.WHITE);
		panelEdition.add(panelTableau, BorderLayout.CENTER);
		panelTableau.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192),
				new Color(192, 192, 192), new Color(192, 192, 192)));
		table.setBackground(SystemColor.textHighlightText);
		table.setFocusable(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "N\u00B0 AFPA", "Nom", "Prenom", "Formation", "Email", "N\u00B0 T\u00E9l\u00E9phone" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);

		panelTableau.add(table, BorderLayout.CENTER);
		panelTableau.add(table.getTableHeader(), BorderLayout.NORTH);

		JPanel panelSud = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panelSud.getLayout();
		flowLayout_8.setVgap(18);
		panelSud.setPreferredSize(new Dimension(10, 90));
		panelSud.setBackground(ThemeLIPPS.BLUE_DARK);
		panelConteneurCentre.add(panelSud, BorderLayout.SOUTH);

		JPanel panelBouttonsSud = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelBouttonsSud.getLayout();
		flowLayout_3.setHgap(15);
		panelBouttonsSud.setBackground(ThemeLIPPS.BLUE_DARK);
		panelSud.add(panelBouttonsSud);

		JPanel panelButton = new JPanel();
		panelButton.setBackground(ThemeLIPPS.BLUE_DARK);
		panelBouttonsSud.add(panelButton);
		panelButton.setOpaque(false);
		panelButton.setBorder(new EmptyBorder(0, 20, 0, 20));
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

		JButton btnSuivant = new JButton("Créer\r\n");
		btnSuivant.setFocusable(false);
		btnSuivant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSuivant.setPressedIcon(null);
		btnSuivant.setSelectedIcon(null);
		btnSuivant.setPreferredSize(new Dimension(100, 36));
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSuivant.setBackground(new Color(245, 245, 245));
		btnSuivant.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnSuivant.setActionCommand("Créer");
		panelButton.add(btnSuivant);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFocusable(false);
		btnModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifier.setPreferredSize(new Dimension(100, 36));
		btnModifier.setBackground(new Color(245, 245, 245));
		btnModifier.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnModifier.setActionCommand("Modifier");
		panelButton.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFocusable(false);
		btnSupprimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSupprimer.setPreferredSize(new Dimension(100, 36));
		btnSupprimer.setBackground(new Color(245, 245, 245));
		btnSupprimer.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnSupprimer.setActionCommand("Supprimer");
		panelButton.add(btnSupprimer);

		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(90, 10));
		panel_11.setBackground(ThemeLIPPS.BLUE_DARK);
		add(panel_11, BorderLayout.EAST);

		
	}
	
	public JTextField getBarreRecherche()
	{
		return this.barreRecherche ;
	}

	public JLabel getLblAdmin() 
	{
		
		return this.lblAdministrateur;  
	}
	
	public JLabel getLblForm() 
	{
		
		return this.lblFormateur;  
	}
	
	public JLabel getLblSta() 
	{
		
		return this.lblStagiaire;  
	}
	
	public JLabel getLblTut() 
	{
		
		return this.lblTuteur;  
	}
}
