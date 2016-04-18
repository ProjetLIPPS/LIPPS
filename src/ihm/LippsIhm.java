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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import ihm.fenetre.PanelCCompte;
import ihm.fenetre.PanelCFormation;
import ihm.theme.ThemeLIPPS;


public class LippsIhm extends JFrame {
	
	private JPanel contentPane;
	private JPanel panelCenterFormation = new PanelCFormation();
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
		
		JLabel lblNewLabel = new JLabel("Utilisateur");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 18));
		panelNorth.add(lblNewLabel, BorderLayout.EAST);
		lblNewLabel.setIcon(new ImageIcon("./img/icon_profil.png"));
		
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
		
		
	}
	
	public void refresh()
	{
		SwingUtilities.updateComponentTreeUI(/*panelCenterMain*/ this);
	}
	
	
}
