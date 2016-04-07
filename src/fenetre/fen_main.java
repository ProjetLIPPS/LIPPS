package fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import utilisateur.Module;
import utilisateur.Sequence;

public class fen_main extends JFrame {
	
	private JPanel contentPane;
	private JPanel panelCenterFormation;
	private JPanel panelCenterCompte = new PanelCCompte();
	private JPanel panelCenterMain = new JPanel();
	private JPanel contentPaneCenter;
	private JPanel panelFormation;
	private JPanel panelCompte;
	private JLabel lblFormation;
	private JLabel lblGererLesComptes;
	private ArrayList<Module> module = new ArrayList<Module>();
	
	public ArrayList<Module> getModule()
	{
		return module;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		fen_main frame = new fen_main();
		frame.setVisible(true);
		frame.refresh();
		
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fen_main frame = new fen_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}

	/**
	 * Create the frame.
	 */
	public fen_main() {
		
		/*
		Module module1 = new Module("mod1");
		module1.ajouterSeq(new Sequence("sq1"));
		module1.ajouterSeq(new Sequence("sq2"));
		
		Module module2 = new Module("mod2");
		module2.ajouterSeq(new Sequence("sq1"));
		module2.ajouterSeq(new Sequence("sq2"));
		module2.ajouterSeq(new Sequence("sq3"));
		module2.ajouterSeq(new Sequence("sq4"));
		module.add(module1);
		module.add(module2);
		*/
		panelCenterFormation = new PanelCFormation(this);
		contentPaneCenter = panelCenterFormation;
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/60x60.gif"));
		setTitle("LIPPS");
		this.setExtendedState(this.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000,800));
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
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
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
				panelFormation.setBackground(Color.decode("#3887c9"));
				panelCompte.setBackground(Color.decode("#f2f2f2"));
				lblFormation.setForeground(Color.WHITE);
				lblGererLesComptes.setForeground(Color.DARK_GRAY);
				panelCenterMain.remove(contentPaneCenter);
				contentPaneCenter = panelCenterFormation;
				panelCenterMain.add(contentPaneCenter);
				refresh();
			}
		});
		panelFormation.setBackground(Color.decode("#3887c9"));
		panelFormation.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTab.add(panelFormation);
		
		lblFormation = new JLabel("G\u00E9rer les formations");
		lblFormation.setForeground(Color.WHITE);
		lblFormation.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblFormation.setFont(new Font("Arial", Font.PLAIN, 16));
		panelFormation.add(lblFormation);
		
		panelCompte = new JPanel();
		panelCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				panelFormation.setBackground(Color.decode("#f2f2f2"));
				panelCompte.setBackground(Color.decode("#3887c9"));
				lblFormation.setForeground(Color.DARK_GRAY);
				lblGererLesComptes.setForeground(Color.WHITE);
				panelCenterMain.remove(contentPaneCenter);
				contentPaneCenter = panelCenterCompte;
				panelCenterMain.add(contentPaneCenter);
				refresh();
			}
		});
		panelCompte.setBackground(Color.decode("#f2f2f2"));
		//panelCompte.setOpaque(false);
		panelTab.add(panelCompte);
		
		lblGererLesComptes = new JLabel("G\u00E9rer les comptes");
		lblGererLesComptes.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblGererLesComptes.setForeground(Color.DARK_GRAY);
		lblGererLesComptes.setFont(new Font("Arial", Font.PLAIN, 16));
		panelCompte.add(lblGererLesComptes);
		
		
		panelCenterMain.setBackground(Color.decode("#3887c9"));
		panelCenterMain.setBorder(new EmptyBorder(80, 80, 80, 80));
		panelCenter.add(panelCenterMain, BorderLayout.CENTER);
		panelCenterMain.setLayout(new BorderLayout(0, 0));
		
		
		panelCenterMain.add(contentPaneCenter);
		
		
	}
	
	public void refresh()
	{
		SwingUtilities.updateComponentTreeUI(/*panelCenterMain*/ this);
	}
	
	public void creerModule()
	{
		
		
		Module module1 = new Module("mod1");
		module1.ajouterSeq(new Sequence("sq1"));
		module1.ajouterSeq(new Sequence("sq2"));
		
		Module module2 = new Module("mod2");
		module2.ajouterSeq(new Sequence("sq1"));
		module2.ajouterSeq(new Sequence("sq2"));
		module2.ajouterSeq(new Sequence("sq3"));
		module2.ajouterSeq(new Sequence("sq4"));
		module.add(module1);
		module.add(module2);
		
		
		panelCenterMain.remove(contentPaneCenter);
		panelCenterFormation = new PanelCFormation(this);
		contentPaneCenter = panelCenterFormation;
		panelCenterMain.add(contentPaneCenter);
		refresh();
		
	}
}
