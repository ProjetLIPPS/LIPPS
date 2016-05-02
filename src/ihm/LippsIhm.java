package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controleur.ControleurFMain;
import controleur.ControleurLogin;
import ihm.fenetre.PanelCCompte;
import ihm.fenetre.PanelCFormation;
import ihm.fenetre.PanelMngModele;
import ihm.fenetre.PanelMngModule;
import ihm.theme.ThemeLIPPS;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Cursor;


public class LippsIhm extends JFrame {
	
	private JPanel contentPane;
	private JPanel panelCenterFormation = panelLoad();
	private JPanel panelCenterCompte = new PanelCCompte();
	private JPanel panelCenterMain = new JPanel();
	private JPanel contentPaneCenter;
	private JPanel panelFormation;
	private JPanel panelCompte;
	private JLabel lblFormation;
	private JLabel lblGererLesComptes;
	
	
	
	

	/**
	 * Create the frame.
	 */
	public LippsIhm() {
		
		
		contentPaneCenter = panelCenterFormation;
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/60x60.gif"));
		setTitle("LIPPS");
		this.setExtendedState(this.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1280,800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBorder(new EmptyBorder(40, 40, 40, 40));
		panelNorth.setOpaque(false);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel SubPanelWest = new JPanel();
		SubPanelWest.setOpaque(false);
		panelNorth.add(SubPanelWest, BorderLayout.WEST);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./img/Logo_couleur_200x76.png"));
		SubPanelWest.add(label);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panelNorth.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel(ControleurFMain.getUtilisateur().getPrenom() + " " + ControleurFMain.getUtilisateur().getNom());
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon("./img/icon_profil.png"));
		
		JLabel lblSeDconnecter = new JLabel("Déconnexion");
		lblSeDconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				int confirmation = JOptionPane.showConfirmDialog(getThis(), "Voulez-vous vraiment vous déconnecter ?", "Confirmation", JOptionPane.YES_NO_OPTION);

				if (confirmation == JOptionPane.YES_OPTION)
				{
					getThis().dispose();
					new ControleurLogin();
				}
			}
		});
		lblSeDconnecter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSeDconnecter.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSeDconnecter.setForeground(ThemeLIPPS.BLUE_DARK);
		lblSeDconnecter.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeDconnecter.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(lblSeDconnecter);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTab = new JPanel();
		panelTab.setOpaque(false);
		panelCenter.add(panelTab, BorderLayout.NORTH);
		panelTab.setLayout(new GridLayout(1, 2, 0, 0));
		
		panelFormation = new JPanel();
		panelFormation.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				panelFormation.setBackground(ThemeLIPPS.BLUE);
				panelCompte.setBackground(ThemeLIPPS.GREY_LIGHT);
				lblFormation.setForeground(Color.WHITE);
				lblGererLesComptes.setForeground(Color.DARK_GRAY);
				panelCenterMain.remove(contentPaneCenter);
				contentPaneCenter = panelCenterFormation;
				panelCenterMain.add(contentPaneCenter);
				refresh();
			}
		});
		panelFormation.setBackground(ThemeLIPPS.BLUE);
		panelFormation.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTab.add(panelFormation);
		
		lblFormation = new JLabel("G\u00E9rer les formations");
		lblFormation.setForeground(Color.WHITE);
		lblFormation.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblFormation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 16));
		panelFormation.add(lblFormation);
		
		panelCompte = new JPanel();
		panelCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				panelFormation.setBackground(ThemeLIPPS.GREY_LIGHT);
				panelCompte.setBackground(ThemeLIPPS.BLUE);
				lblFormation.setForeground(Color.DARK_GRAY);
				lblGererLesComptes.setForeground(Color.WHITE);
				panelCenterMain.remove(contentPaneCenter);
				contentPaneCenter = panelCenterCompte;
				panelCenterMain.add(contentPaneCenter);
				refresh();
			}
		});
		panelCompte.setBackground(ThemeLIPPS.GREY_LIGHT);
		panelTab.add(panelCompte);
		
		lblGererLesComptes = new JLabel("G\u00E9rer les comptes");
		lblGererLesComptes.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblGererLesComptes.setForeground(Color.DARK_GRAY);
		lblGererLesComptes.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 16));
		panelCompte.add(lblGererLesComptes);
		
		
		panelCenterMain.setBackground(ThemeLIPPS.BLUE);
		panelCenterMain.setBorder(new EmptyBorder(80, 80, 80, 80));
		panelCenter.add(panelCenterMain, BorderLayout.CENTER);
		panelCenterMain.setLayout(new BorderLayout(0, 0));
		
		
		panelCenterMain.add(contentPaneCenter);
		
		setVisible(true);
		
	}
	
	private JPanel panelLoad()
	{
		if (ControleurFMain.getUtilisateur().getUtilisateurToRole().size() > 1)
		{
			int confirmation = JOptionPane.showConfirmDialog(this, "Voulez-vous vous connecter en tant qu'Administrateur (oui) ou Formateur (non) ?", "Confirmation", JOptionPane.YES_NO_OPTION);

			if (confirmation == JOptionPane.YES_OPTION)
			{
				return new PanelMngModele();
			}
			else
			{
				return new PanelCFormation();
			}
			
		}
		else if (ControleurFMain.getUtilisateur().getUtilisateurToRole().get(0).getRole().getType().equals("Administrateur") )
		{
			return new PanelMngModele();
		}
		else
		{
			return new PanelCFormation();
		}
		
		
		
		
	}

	public JPanel getPanelCenterFormation() {
		return panelCenterFormation;
	}
	
	public void refresh()
	{
		SwingUtilities.updateComponentTreeUI(panelCenterMain);
	}
	
	public void reloadPanelCenterFormation()
	{
		
		panelCenterMain.remove(contentPaneCenter);
		panelCenterFormation = new PanelCFormation();
		contentPaneCenter = panelCenterFormation;
		panelCenterMain.add(contentPaneCenter);
		refresh();
		
	}
	
	public void reloadPanelMngModule()
	{
		panelCenterMain.remove(contentPaneCenter);
		panelCenterFormation = new PanelMngModule();
		contentPaneCenter = panelCenterFormation;
		panelCenterMain.add(contentPaneCenter);
		refresh();
				
	}
	
	private LippsIhm getThis()
	{
		return this;
	}

	
}
