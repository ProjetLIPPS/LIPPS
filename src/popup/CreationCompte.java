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
		getContentPane().setLayout(null);
		
		ButtonGroup groupRadio = new ButtonGroup();
		
		JLabel lblEditionDeCompte = new JLabel("Edition de compte");
		lblEditionDeCompte.setBounds(149, 40, 361, 37);
		getContentPane().add(lblEditionDeCompte);
		lblEditionDeCompte.setForeground(Color.WHITE);
		lblEditionDeCompte.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEditionDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(144, 288, 45, 21);
		getContentPane().add(lblNom);
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField = new JTextField();
		textField.setBounds(206, 335, 277, 27);
		getContentPane().add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(126, 339, 67, 21);
		getContentPane().add(lblPrenom);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 286, 277, 27);
		getContentPane().add(textField_1);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setBounds(49, 445, 148, 21);
		getContentPane().add(lblDateDeNaissance);
		lblDateDeNaissance.setForeground(Color.WHITE);
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNumroAfpa = new JLabel("Numéro AFPA :");
		lblNumroAfpa.setBounds(76, 242, 114, 21);
		getContentPane().add(lblNumroAfpa);
		lblNumroAfpa.setForeground(Color.WHITE);
		lblNumroAfpa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(141, 369, 57, 55);
		getContentPane().add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel label = new JLabel("@");
		label.setBounds(342, 386, 15, 31);
		getContentPane().add(label);
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_2 = new JTextField();
		textField_2.setBounds(276, 442, 57, 27);
		getContentPane().add(textField_2);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(208, 441, 57, 27);
		getContentPane().add(textField_3);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(208, 386, 122, 27);
		getContentPane().add(textField_4);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(369, 387, 143, 27);
		getContentPane().add(textField_5);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(349, 443, 114, 27);
		getContentPane().add(textField_6);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(208, 239, 277, 27);
		getContentPane().add(textField_7);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_7.setColumns(10);
		
		JRadioButton rdbtnAdministrateur = new JRadioButton("Administrateur");
		rdbtnAdministrateur.setBounds(68, 157, 139, 31);
		getContentPane().add(rdbtnAdministrateur);
		rdbtnAdministrateur.setForeground(Color.WHITE);
		rdbtnAdministrateur.setBackground(Color.decode("#3787C8"));
		rdbtnAdministrateur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdministrateur.setFocusable(false);
		groupRadio.add(rdbtnAdministrateur);
		
		JRadioButton rdbtnFormateur = new JRadioButton("Formateur");
		rdbtnFormateur.setBounds(216, 156, 105, 31);
		getContentPane().add(rdbtnFormateur);
		rdbtnFormateur.setForeground(Color.WHITE);
		rdbtnFormateur.setBackground(Color.decode("#3787C8"));
		rdbtnFormateur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFormateur.setFocusable(false);
		groupRadio.add(rdbtnFormateur);
		
		JRadioButton rdbtnStagiaire = new JRadioButton("Stagiaire\r\n");
		rdbtnStagiaire.setBounds(331, 157, 93, 31);
		getContentPane().add(rdbtnStagiaire);
		rdbtnStagiaire.setForeground(Color.WHITE);
		rdbtnStagiaire.setBackground(Color.decode("#3787C8"));
		rdbtnStagiaire.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnStagiaire.setFocusable(false);
		groupRadio.add(rdbtnStagiaire);
		
		JRadioButton rdbtnTuteur = new JRadioButton("Tuteur");
		rdbtnTuteur.setBounds(438, 157, 77, 31);
		getContentPane().add(rdbtnTuteur);
		rdbtnTuteur.setForeground(Color.WHITE);
		rdbtnTuteur.setBackground(Color.decode("#3787C8"));
		rdbtnTuteur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnTuteur.setFocusable(false);
		groupRadio.add(rdbtnTuteur);
		
		JButton btnNewButton = new JButton("Valider\r\n");
		btnNewButton.setBounds(214, 597, 83, 33);
		getContentPane().add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 102, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setMargin(new Insets(6, 20, 6, 20));
		
		btnNewButton.setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBounds(370, 599, 87, 33);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 102, 255));
		btnNewButton_1.setMargin(new Insets(6, 18, 6, 18));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
		
		
		
		
		
		
		

		//SwingUtilities.updateComponentTreeUI(/*panelCenterMain*/ this);
		
	}
}
