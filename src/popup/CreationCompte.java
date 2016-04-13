package popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CreationCompte extends JFrame {

	private JPanel panelTitre;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationCompte frame = new CreationCompte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreationCompte() {
		getContentPane().setBackground(Color.decode("#3787C8"));
		setResizable(false);
		setMinimumSize(new Dimension(700, 700));
		setTitle("Cr\u00E9er un module");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelTitre = new JPanel();
		getContentPane().add(panelTitre, BorderLayout.NORTH);
		panelTitre.setAutoscrolls(true);
		panelTitre.setBackground(Color.decode("#3787C8"));
		panelTitre.setBorder(new EmptyBorder(55, 20, 20, 20));
		
		panelTitre.setLayout(new BorderLayout(0, 25));
		
		JLabel lblEditionDeCompte = new JLabel("Edition de compte");
		lblEditionDeCompte.setForeground(Color.WHITE);
		lblEditionDeCompte.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEditionDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitre.add(lblEditionDeCompte, BorderLayout.NORTH);
		
		JPanel panelBoutton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBoutton.getLayout();
		getContentPane().add(panelBoutton, BorderLayout.SOUTH);
		panelBoutton.setOpaque(false);
		panelBoutton.setBackground(Color.decode("#3787C8"));
		
		JButton btnNewButton = new JButton("Valider\r\n");
		btnNewButton.setForeground(new Color(0, 102, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setMargin(new Insets(6, 20, 6, 20));
		
		btnNewButton.setBackground(Color.WHITE);
		panelBoutton.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setForeground(new Color(0, 102, 255));
		btnNewButton_1.setMargin(new Insets(6, 18, 6, 18));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		panelBoutton.add(btnNewButton_1);
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBorder(new EmptyBorder(40, 0, 0, 0));
		panelCentre.setBackground(Color.decode("#3787C8"));
		getContentPane().add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#3787C8"));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelCentre.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnAdministrateur = new JRadioButton("Administrateur");
		rdbtnAdministrateur.setForeground(Color.WHITE);
		rdbtnAdministrateur.setBackground(Color.decode("#3787C8"));
		rdbtnAdministrateur.setBounds(86, 5, 139, 31);
		rdbtnAdministrateur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdministrateur.setFocusable(false);
		panel.add(rdbtnAdministrateur);
		
		JRadioButton rdbtnFormateur = new JRadioButton("Formateur");
		rdbtnFormateur.setForeground(Color.WHITE);
		rdbtnFormateur.setBackground(Color.decode("#3787C8"));
		rdbtnFormateur.setBounds(270, 5, 105, 31);
		rdbtnFormateur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFormateur.setFocusable(false);
		panel.add(rdbtnFormateur);
		
		JRadioButton rdbtnStagiaire = new JRadioButton("Stagiaire\r\n");
		rdbtnStagiaire.setForeground(Color.WHITE);
		rdbtnStagiaire.setBackground(Color.decode("#3787C8"));
		rdbtnStagiaire.setBounds(416, 5, 93, 31);
		rdbtnStagiaire.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnStagiaire.setFocusable(false);
		panel.add(rdbtnStagiaire);
		
		JRadioButton rdbtnTuteur = new JRadioButton("Tuteur");
		rdbtnTuteur.setForeground(Color.WHITE);
		rdbtnTuteur.setBackground(Color.decode("#3787C8"));
		rdbtnTuteur.setBounds(552, 5, 77, 31);
		rdbtnTuteur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnTuteur.setFocusable(false);
		panel.add(rdbtnTuteur);
		
		ButtonGroup groupRadio = new ButtonGroup();
		groupRadio.add(rdbtnTuteur);
		groupRadio.add(rdbtnStagiaire);
		groupRadio.add(rdbtnFormateur);
		groupRadio.add(rdbtnAdministrateur);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(Color.WHITE);
		lblNom.setBounds(170, 96, 45, 21);
		panel.add(lblNom);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField = new JTextField();
		textField.setBounds(232, 93, 277, 27);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setBounds(148, 158, 67, 21);
		panel.add(lblPrenom);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 155, 277, 27);
		panel.add(textField_1);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setForeground(Color.WHITE);
		lblDateDeNaissance.setBounds(67, 219, 148, 21);
		panel.add(lblDateDeNaissance);
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNumroAfpa = new JLabel("Numéro AFPA :");
		lblNumroAfpa.setForeground(Color.WHITE);
		lblNumroAfpa.setBounds(101, 285, 114, 21);
		panel.add(lblNumroAfpa);
		lblNumroAfpa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(168, 331, 57, 55);
		panel.add(lblEmail);
		
		JLabel label = new JLabel("@");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(377, 343, 15, 31);
		panel.add(label);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(232, 216, 57, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(310, 216, 57, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBounds(387, 216, 122, 27);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBounds(232, 345, 143, 27);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_6.setColumns(10);
		textField_6.setBounds(395, 345, 114, 27);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_7.setColumns(10);
		textField_7.setBounds(232, 279, 277, 27);
		panel.add(textField_7);
		
		
		
		
		
		
		

		//SwingUtilities.updateComponentTreeUI(/*panelCenterMain*/ this);
		
	}
}
