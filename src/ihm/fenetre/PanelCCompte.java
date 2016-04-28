package ihm.fenetre;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import actionListener.BoutonCreerCompte;
import actionListener.FocusListeners;
import actionListener.RechercherListener;
import actionListener.UtilisateurParTypeDeCompte;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class PanelCCompte extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField barreRecherche;
	private static JTable tableau;
	private JLabel lblAdministrateur = new JLabel(" Administrateur");
	private JLabel lblFormateur = new JLabel(" Formateur");
	private JLabel lblStagiaire = new JLabel(" Stagiaire");
	private JLabel lblTuteur = new JLabel(" Tuteur");
	private JLabel lblTous = new JLabel("Tous");
	private static String[] enteteTableau = new String[]
	{ "Identifiant AFPA", "Nom", "Prenom","Rôle", "Formation", "Email", "Numéro Téléphone" };
	private DefaultTableModel modeleTableau = new DefaultTableModel(new Object[][]
	{}, enteteTableau);
	private Integer isSelected = 5;
	private JButton btnRecherche = new JButton();
	private JComboBox<String> comboSecMetier = new JComboBox<String>();
	private JButton btnCreer = new JButton("Créer");

	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	public PanelCCompte()
	{

		UtilisateurParTypeDeCompte utilisateurParType = new UtilisateurParTypeDeCompte(this);
		FocusListeners rechercheListener = new FocusListeners(this);
		RechercherListener listenerBtnRecherche = new RechercherListener(this);
		BoutonCreerCompte creerCompteListener = new  BoutonCreerCompte(this);

		this.setBorder(null);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(0, 0));

		JPanel panelWest = new JPanel();
		panelWest.setPreferredSize(new Dimension(250, 10));
		panelWest.setBackground(ThemeLIPPS.BLUE_DARK);
		this.add(panelWest, BorderLayout.WEST);
		panelWest.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelWest.setLayout(new BorderLayout(0, 0));

		JPanel panelTypeCompte = new JPanel();
		panelTypeCompte.setOpaque(false);
		panelWest.add(panelTypeCompte, BorderLayout.CENTER);
		panelTypeCompte.setLayout(new GridLayout(11, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panelTypeCompte.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panelTypeCompte.add(panel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panelTypeCompte.add(panel_5);

		JPanel panel_Administrateur = new JPanel();
		panel_Administrateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, 20));
		FlowLayout fl_panel_Administrateur = (FlowLayout) panel_Administrateur.getLayout();
		fl_panel_Administrateur.setVgap(0);
		fl_panel_Administrateur.setHgap(25);
		fl_panel_Administrateur.setAlignment(FlowLayout.LEFT);
		panel_Administrateur.setOpaque(false);
		panelTypeCompte.add(panel_Administrateur);
		lblAdministrateur.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdministrateur.setHorizontalAlignment(SwingConstants.CENTER);

		lblAdministrateur.addMouseListener(utilisateurParType);
		lblAdministrateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdministrateur.setMaximumSize(new Dimension(70, 20));
		lblAdministrateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, 25));
		lblAdministrateur.setForeground(new Color(255, 255, 255));
		panel_Administrateur.add(lblAdministrateur);

		JPanel panelFormateur = new JPanel();
		FlowLayout fl_panelFormateur = (FlowLayout) panelFormateur.getLayout();
		fl_panelFormateur.setVgap(0);
		fl_panelFormateur.setHgap(25);
		fl_panelFormateur.setAlignment(FlowLayout.LEFT);
		panelFormateur.setOpaque(false);
		panelTypeCompte.add(panelFormateur);

		lblFormateur.addMouseListener(utilisateurParType);
		lblFormateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFormateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, 25));
		lblFormateur.setForeground(Color.WHITE);
		panelFormateur.add(lblFormateur);
		
				JPanel panelStagiaire = new JPanel();
				FlowLayout fl_panelStagiaire = (FlowLayout) panelStagiaire.getLayout();
				fl_panelStagiaire.setVgap(0);
				fl_panelStagiaire.setAlignment(FlowLayout.LEFT);
				fl_panelStagiaire.setHgap(25);
				panelStagiaire.setOpaque(false);
				panelTypeCompte.add(panelStagiaire);
				
						lblStagiaire.addMouseListener(utilisateurParType);
						lblStagiaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						lblStagiaire.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, 25));
						lblStagiaire.setForeground(Color.WHITE);
						panelStagiaire.add(lblStagiaire);
		
				JPanel panelTuteur = new JPanel();
				FlowLayout fl_panelTuteur = (FlowLayout) panelTuteur.getLayout();
				fl_panelTuteur.setVgap(0);
				fl_panelTuteur.setHgap(25);
				fl_panelTuteur.setAlignment(FlowLayout.LEFT);
				panelTuteur.setOpaque(false);
				panelTypeCompte.add(panelTuteur);
				
						lblTuteur.addMouseListener(utilisateurParType);
						lblTuteur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						lblTuteur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, 25));
						lblTuteur.setForeground(Color.WHITE);
						panelTuteur.add(lblTuteur);
		
				JPanel panelTous = new JPanel();
				FlowLayout fl_panelTous = (FlowLayout) panelTous.getLayout();
				fl_panelTous.setVgap(0);
				fl_panelTous.setHgap(33);
				fl_panelTous.setAlignment(FlowLayout.LEFT);
				panelTous.setOpaque(false);
				panelTypeCompte.add(panelTous);
				
				
				lblTous.setHorizontalAlignment(SwingConstants.CENTER);
				lblTous.setHorizontalTextPosition(SwingConstants.CENTER);
				lblTous.setForeground(Color.WHITE);
				lblTous.setFont(new Font("Century Gothic", Font.BOLD, 25));
				lblTous.addMouseListener(utilisateurParType);
				
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panelTypeCompte.add(panel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panelTypeCompte.add(panel_3);

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(Color.WHITE);
		this.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));

		JPanel panelSupTri = new JPanel();
		panelSupTri.setPreferredSize(new Dimension(10, 90));
		panelSupTri.setMinimumSize(new Dimension(1500, 1500));
		panelSupTri.setBorder(new EmptyBorder(20, 0, 5, 0));
		panelSupTri.setBackground(ThemeLIPPS.BLUE_DARK);
		panelCentre.add(panelSupTri, BorderLayout.NORTH);
		panelSupTri.setLayout(new BorderLayout(0, 0));

		JPanel panelBouttons = new JPanel();
		panelBouttons.setOpaque(false);
		panelBouttons.setBorder(UIManager.getBorder("Menu.border"));
		panelBouttons.setBackground(Color.WHITE);
		panelSupTri.add(panelBouttons);
		panelBouttons.setLayout(new BorderLayout(0, 0));

		JPanel panelSecMetier = new JPanel();
		panelSecMetier.setBorder(new EmptyBorder(15, 0, 20, 0));
		panelBouttons.add(panelSecMetier, BorderLayout.CENTER);
		panelSecMetier.setOpaque(false);
		panelSecMetier.setBackground(new Color(211, 211, 211));

		
		((JLabel) comboSecMetier.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panelSecMetier.setLayout(new BorderLayout(0, 0));
		comboSecMetier.setAlignmentX(Component.RIGHT_ALIGNMENT);
		comboSecMetier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSecMetier.add(comboSecMetier, BorderLayout.WEST);
		comboSecMetier.setMinimumSize(new Dimension(28, 25));
		comboSecMetier.setPreferredSize(new Dimension(250, 30));
		comboSecMetier.setBackground(SystemColor.window);
		comboSecMetier.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 15));
		/*comboSecMetier.setModel(new DefaultComboBoxModel(new String[]
		{ "Secteur de métier", "Audiovisuel", "Automobile", "Autre", "Assurance", "Bâtiment", "Commerce",
				"Communication", "Droit", "Enseignement", "Environnement", "Hôtellerie", "Immobilier", "Informatique",
				"Langues", "Marketing", "Propreté", "Ressources Humaines", "Restauration", "Sciences Humaines",
				"Secrétariat", "Social", "Tourisme", "Transport , Logistique" }));*/
		comboSecMetier.setModel(new DefaultComboBoxModel(DaoFactory.getDaoSpecialisation().getNomSpecialisation()));
		comboSecMetier.insertItemAt("Secteur de métier",0);
		comboSecMetier.setSelectedIndex(0);
		comboSecMetier.addActionListener(utilisateurParType);
		
				JPanel panelRecherche = new JPanel();
				panelBouttons.add(panelRecherche, BorderLayout.EAST);
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
						barreRecherche.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 15));
						barreRecherche.setToolTipText("");
						barreRecherche.setText("Nom ou n°AFPA");
						barreRecherche.setColumns(15);
						barreRecherche.addFocusListener(rechercheListener);
						barreRecherche.addKeyListener(listenerBtnRecherche);
						

						
						btnRecherche.setFocusable(false);
						btnRecherche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btnRecherche.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						btnRecherche.setIconTextGap(0);
						btnRecherche.setHorizontalTextPosition(SwingConstants.CENTER);
						btnRecherche.setFont(new Font("Tahoma", Font.PLAIN, 13));
						btnRecherche.setPreferredSize(new Dimension(40, 30));
						btnRecherche.setMargin(new Insets(3, 14, 4, 14));
						panelRecherche.add(btnRecherche);
						btnRecherche.setIcon(new ImageIcon("./img/search 16.png"));
						btnRecherche.addMouseListener(listenerBtnRecherche);

		JPanel panelResultatRecherche = new JPanel();
		panelResultatRecherche.setBackground(Color.WHITE);
		panelCentre.add(panelResultatRecherche, BorderLayout.CENTER);
		panelResultatRecherche.setLayout(new BorderLayout(0, 0));

		JPanel panelTableau = new JPanel();
		panelTableau.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(191, 205, 219), new Color(191, 205, 219),
				new Color(191, 205, 219), new Color(191, 205, 219)));
		panelTableau.setBackground(Color.WHITE);
		panelResultatRecherche.add(panelTableau, BorderLayout.CENTER);
		panelTableau.setLayout(new BorderLayout(0, 0));

		tableau = new JTable();
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableau.setForeground(Color.DARK_GRAY);
		tableau.setShowHorizontalLines(false);
		tableau.setShowGrid(false);
		tableau.setRowHeight(23);
		tableau.setIntercellSpacing(new Dimension(3, 20));
		tableau.setRowMargin(6);
		tableau.setShowVerticalLines(false);
		tableau.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192),
				new Color(192, 192, 192), new Color(192, 192, 192)));
		tableau.setBackground(SystemColor.textHighlightText);
		tableau.setFocusable(false);
		tableau.setFont(new Font("Tahoma", Font.PLAIN, 14));

		tableau.setModel(modeleTableau);

		tableau.getTableHeader().setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		tableau.setDefaultEditor(Object.class, null);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < 7; i++)
		{
			tableau.getColumnModel().getColumn(i).setResizable(false);
			tableau.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		}

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.LEFT);

		for (int i = 0; i < 7; i++)
		{
			tableau.getColumnModel().getColumn(i).setResizable(false);
			tableau.getColumnModel().getColumn(i).setCellRenderer(renderer);

		}

		panelTableau.add(tableau, BorderLayout.CENTER);
		panelTableau.add(tableau.getTableHeader(), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(panelTableau);
		panelResultatRecherche.add(scrollPane, BorderLayout.CENTER);
		

		JPanel panelSudBoutons = new JPanel();
		FlowLayout fl_panelSudBoutons = (FlowLayout) panelSudBoutons.getLayout();
		fl_panelSudBoutons.setVgap(18);
		panelSudBoutons.setPreferredSize(new Dimension(10, 90));
		panelSudBoutons.setBackground(ThemeLIPPS.BLUE_DARK);
		panelCentre.add(panelSudBoutons, BorderLayout.SOUTH);

		JPanel panelBouttons_1 = new JPanel();
		FlowLayout fl_panelBouttons_1 = (FlowLayout) panelBouttons_1.getLayout();
		fl_panelBouttons_1.setHgap(15);
		panelBouttons_1.setBackground(ThemeLIPPS.BLUE_DARK);
		panelSudBoutons.add(panelBouttons_1);

		JPanel panelButtonSub = new JPanel();
		panelButtonSub.setBackground(ThemeLIPPS.BLUE_DARK);
		panelBouttons_1.add(panelButtonSub);
		panelButtonSub.setOpaque(false);
		panelButtonSub.setBorder(new EmptyBorder(0, 20, 0, 20));
		panelButtonSub.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

		
		btnCreer.setFocusable(false);
		btnCreer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreer.setPressedIcon(null);
		btnCreer.setSelectedIcon(null);
		btnCreer.setPreferredSize(new Dimension(100, 36));
		btnCreer.addMouseListener(creerCompteListener);
		
		btnCreer.setBackground(new Color(245, 245, 245));
		btnCreer.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 15));
		btnCreer.setActionCommand("Créer");
		panelButtonSub.add(btnCreer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFocusable(false);
		btnModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifier.setPreferredSize(new Dimension(100, 36));
		btnModifier.setBackground(new Color(245, 245, 245));
		btnModifier.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 15));
		btnModifier.setActionCommand("Modifier");
		panelButtonSub.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFocusable(false);
		btnSupprimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSupprimer.setPreferredSize(new Dimension(115, 36));
		btnSupprimer.setBackground(new Color(245, 245, 245));
		btnSupprimer.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 15));
		btnSupprimer.setActionCommand("Supprimer");
		panelButtonSub.add(btnSupprimer);

		JPanel panelEast = new JPanel();
		panelEast.setPreferredSize(new Dimension(90, 10));
		panelEast.setBackground(ThemeLIPPS.BLUE_DARK);
		add(panelEast, BorderLayout.EAST);
		
		try
		{
			utilisateurParType.afficheTableau(lblTous);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelTous.add(lblTous);


	}
	
	

	public JLabel getLblTous()
	{
		return lblTous;
	}



	public void setLblTous(JLabel lblTous)
	{
		this.lblTous = lblTous;
	}



	public JButton getBtnRecherche()
	{
		return btnRecherche;
	}

	public void setBtnRecherche(JButton btnRecherche)
	{
		this.btnRecherche = btnRecherche;
	}

	public static JTable getTableau()
	{
		return tableau;
	}

	public void setTableau(JTable tableau)
	{
		this.tableau = tableau;
	}

	public JLabel getLblAdministrateur()
	{
		return lblAdministrateur;
	}

	public void setLblAdministrateur(JLabel lblAdministrateur)
	{
		this.lblAdministrateur = lblAdministrateur;
	}

	public JLabel getLblFormateur()
	{
		return lblFormateur;
	}

	public void setLblFormateur(JLabel lblFormateur)
	{
		this.lblFormateur = lblFormateur;
	}

	public JLabel getLblStagiaire()
	{
		return lblStagiaire;
	}

	public void setLblStagiaire(JLabel lblStagiaire)
	{
		this.lblStagiaire = lblStagiaire;
	}

	public JLabel getLblTuteur()
	{
		return lblTuteur;
	}

	public void setLblTuteur(JLabel lblTuteur)
	{
		this.lblTuteur = lblTuteur;
	}

	public static String[] getEnteteTableau()
	{
		return enteteTableau;
	}

	public void setEnteteTableau(String[] enteteTableau)
	{
		this.enteteTableau = enteteTableau;
	}

	public DefaultTableModel getModeleTableau()
	{
		return modeleTableau;
	}

	public void setModeleTableau(DefaultTableModel modeleTableau)
	{
		this.modeleTableau = modeleTableau;
	}

	public void setBarreRecherche(JTextField barreRecherche)
	{
		this.barreRecherche = barreRecherche;
	}

	public JTextField getBarreRecherche()
	{
		return this.barreRecherche;
	}


	public Integer getIsSelected()
	{
		return isSelected;
	}

	public void setIsSelected(Integer isSelected)
	{
		this.isSelected = isSelected;
	}
	public JButton getBtnCreer()
	{
		return btnCreer;
	}



	public void setBtnCreer(JButton btnCreer)
	{
		this.btnCreer = btnCreer;
	}



	public JComboBox<String> getComboSecMetier()
	{
		return comboSecMetier;
	}



	public void setComboSecMetier(JComboBox<String> comboSecMetier)
	{
		this.comboSecMetier = comboSecMetier;
	}



	


	


}
