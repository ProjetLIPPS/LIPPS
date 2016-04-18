package ihm.popup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ihm.theme.ThemeLIPPS;

public class CreationCompte extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	

	

	/**
	 * Create the frame.
	 */
	public CreationCompte() {
		setModal(true);
		getContentPane().setBackground(ThemeLIPPS.BLUE);
		setResizable(false);
		setMinimumSize(new Dimension(700, 700));
		setTitle("Créer un module");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(null);
		
		ButtonGroup groupRadio = new ButtonGroup();
		
		JLabel lblEditionDeCompte = new JLabel("Edition de compte");
		lblEditionDeCompte.setBounds(164, 39, 361, 37);
		getContentPane().add(lblEditionDeCompte);
		lblEditionDeCompte.setForeground(Color.WHITE);
		lblEditionDeCompte.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		lblEditionDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(167, 340, 49, 21);
		getContentPane().add(lblNom);
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField = new JTextField();
		textField.setBounds(227, 382, 277, 27);
		getContentPane().add(textField);
		textField.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(144, 385, 72, 21);
		getContentPane().add(lblPrenom);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 337, 277, 27);
		getContentPane().add(textField_1);
		textField_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_1.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setBounds(47, 475, 169, 21);
		getContentPane().add(lblDateDeNaissance);
		lblDateDeNaissance.setForeground(Color.WHITE);
		lblDateDeNaissance.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblNumroAfpa = new JLabel("Numéro AFPA :");
		lblNumroAfpa.setBounds(92, 295, 124, 21);
		getContentPane().add(lblNumroAfpa);
		lblNumroAfpa.setForeground(Color.WHITE);
		lblNumroAfpa.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(164, 430, 52, 21);
		getContentPane().add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 472, 101, 27);
		getContentPane().add(textField_3);
		textField_3.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(227, 427, 277, 27);
		getContentPane().add(textField_4);
		textField_4.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_4.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(227, 292, 277, 27);
		getContentPane().add(textField_7);
		textField_7.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_7.setColumns(10);
		
		JRadioButton rdbtnAdministrateur = new JRadioButton("Administrateur");
		rdbtnAdministrateur.setBounds(90, 179, 153, 31);
		getContentPane().add(rdbtnAdministrateur);
		rdbtnAdministrateur.setForeground(Color.WHITE);
		rdbtnAdministrateur.setBackground(Color.decode("#3787C8"));
		rdbtnAdministrateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnAdministrateur.setFocusable(false);
		groupRadio.add(rdbtnAdministrateur);
		
		JRadioButton rdbtnFormateur = new JRadioButton("Formateur");
		rdbtnFormateur.setBounds(256, 179, 115, 31);
		getContentPane().add(rdbtnFormateur);
		rdbtnFormateur.setForeground(Color.WHITE);
		rdbtnFormateur.setBackground(Color.decode("#3787C8"));
		rdbtnFormateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnFormateur.setFocusable(false);
		groupRadio.add(rdbtnFormateur);
		
		JRadioButton rdbtnStagiaire = new JRadioButton("Stagiaire\r\n");
		rdbtnStagiaire.setBounds(386, 179, 101, 31);
		getContentPane().add(rdbtnStagiaire);
		rdbtnStagiaire.setForeground(Color.WHITE);
		rdbtnStagiaire.setBackground(Color.decode("#3787C8"));
		rdbtnStagiaire.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnStagiaire.setFocusable(false);
		groupRadio.add(rdbtnStagiaire);
		
		JRadioButton rdbtnTuteur = new JRadioButton("Tuteur");
		rdbtnTuteur.setBounds(508, 179, 79, 31);
		getContentPane().add(rdbtnTuteur);
		rdbtnTuteur.setForeground(Color.WHITE);
		rdbtnTuteur.setBackground(Color.decode("#3787C8"));
		rdbtnTuteur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnTuteur.setFocusable(false);
		groupRadio.add(rdbtnTuteur);
		
		JButton btnNewButton = new JButton("Valider\r\n");
		btnNewButton.setBounds(227, 598, 101, 33);
		getContentPane().add(btnNewButton);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton.setMargin(new Insets(6, 20, 6, 20));
		
		btnNewButton.setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBounds(403, 598, 101, 33);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setMargin(new Insets(6, 18, 6, 18));
		btnNewButton_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_1.setBackground(Color.WHITE);
		
		
		
		
		
		
		

		//SwingUtilities.updateComponentTreeUI(/*panelCenterMain*/ this);
		
	}
}
