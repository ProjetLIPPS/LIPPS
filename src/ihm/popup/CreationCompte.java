package ihm.popup;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import actionListener.PopupListener;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Specialisation;

public class CreationCompte extends JDialog {
	private JTextField textField_Prenom;
	private JTextField textField_Nom;
	private JTextField textField_DteNaissance;
	private JTextField textField_Email;
	private JTextField textField_NoAFPA;
	private ButtonGroup groupRadioType;
	private JComboBox<String> comboBoxForm;
	private JComboBox<String> comboBoxSpe;
	private JTextArea textAreaForma;
	

	//TODO : creer 2 combobox (specialisation + formation)
	//TODO : no telephonne

	/**
	 * Create the frame.
	 */
	public CreationCompte()
	{
		PopupListener listener = new PopupListener();
		
		setModal(true);
		getContentPane().setBackground(ThemeLIPPS.BLUE);
		setResizable(false);
		setMinimumSize(new Dimension(700, 700));
		setTitle("Créer un module");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(null);
		
		groupRadioType = new ButtonGroup();
		
		JLabel lblEditionDeCompte = new JLabel("Edition de compte");
		lblEditionDeCompte.setBounds(163, 28, 361, 37);
		getContentPane().add(lblEditionDeCompte);
		lblEditionDeCompte.setForeground(Color.WHITE);
		lblEditionDeCompte.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		lblEditionDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(169, 401, 49, 21);
		getContentPane().add(lblNom);
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_Prenom = new JTextField();
		textField_Prenom.setBounds(229, 443, 277, 27);
		getContentPane().add(textField_Prenom);
		textField_Prenom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Prenom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(146, 446, 72, 21);
		getContentPane().add(lblPrenom);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(229, 398, 277, 27);
		getContentPane().add(textField_Nom);
		textField_Nom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Nom.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setBounds(49, 536, 169, 21);
		getContentPane().add(lblDateDeNaissance);
		lblDateDeNaissance.setForeground(Color.WHITE);
		lblDateDeNaissance.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblNumroAfpa = new JLabel("Numéro AFPA :");
		lblNumroAfpa.setBounds(94, 356, 124, 21);
		getContentPane().add(lblNumroAfpa);
		lblNumroAfpa.setForeground(Color.WHITE);
		lblNumroAfpa.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(166, 491, 52, 21);
		getContentPane().add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_DteNaissance = new JTextField();
		textField_DteNaissance.setBounds(229, 533, 101, 27);
		getContentPane().add(textField_DteNaissance);
		textField_DteNaissance.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_DteNaissance.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(229, 488, 277, 27);
		getContentPane().add(textField_Email);
		textField_Email.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Email.setColumns(10);
		
		textField_NoAFPA = new JTextField();
		textField_NoAFPA.setBounds(229, 353, 277, 27);
		getContentPane().add(textField_NoAFPA);
		textField_NoAFPA.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_NoAFPA.setColumns(10);
		
		JRadioButton rdbtnAdministrateur = new JRadioButton("Administrateur");
		rdbtnAdministrateur.setBounds(94, 113, 153, 31);
		getContentPane().add(rdbtnAdministrateur);
		rdbtnAdministrateur.setForeground(Color.WHITE);
		rdbtnAdministrateur.setBackground(Color.decode("#3787C8"));
		rdbtnAdministrateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnAdministrateur.setFocusable(false);
		groupRadioType.add(rdbtnAdministrateur);

		JRadioButton rdbtnFormateur = new JRadioButton("Formateur");
		rdbtnFormateur.setBounds(260, 113, 115, 31);
		getContentPane().add(rdbtnFormateur);
		rdbtnFormateur.setForeground(Color.WHITE);
		rdbtnFormateur.setBackground(Color.decode("#3787C8"));
		rdbtnFormateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnFormateur.setFocusable(false);
		groupRadioType.add(rdbtnFormateur);
		
		JRadioButton rdbtnStagiaire = new JRadioButton("Stagiaire");
		rdbtnStagiaire.setBounds(390, 113, 101, 31);
		getContentPane().add(rdbtnStagiaire);
		rdbtnStagiaire.setForeground(Color.WHITE);
		rdbtnStagiaire.setBackground(Color.decode("#3787C8"));
		rdbtnStagiaire.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnStagiaire.setFocusable(false);
		groupRadioType.add(rdbtnStagiaire);
		
		JRadioButton rdbtnTuteur = new JRadioButton("Tuteur");
		rdbtnTuteur.setBounds(512, 113, 79, 31);
		getContentPane().add(rdbtnTuteur);
		rdbtnTuteur.setForeground(Color.WHITE);
		rdbtnTuteur.setBackground(Color.decode("#3787C8"));
		rdbtnTuteur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		rdbtnTuteur.setFocusable(false);
		groupRadioType.add(rdbtnTuteur);
		
		JButton btnNewButton = new JButton("Valider");
		
		btnNewButton.addActionListener(listener);
		btnNewButton.setName("compte");
		
		btnNewButton.setBounds(227, 606, 101, 33);
		getContentPane().add(btnNewButton);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton.setMargin(new Insets(6, 20, 6, 20));
		
		btnNewButton.setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getThis().dispose();
			}
		});
		btnNewButton_1.setBounds(403, 606, 101, 33);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setMargin(new Insets(6, 18, 6, 18));
		btnNewButton_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_1.setBackground(Color.WHITE);
		
		
		comboBoxForm = new JComboBox<String>();
		comboBoxForm.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		comboBoxForm.setBackground(Color.WHITE);
		comboBoxForm.setBounds(229, 201, 277, 27);
		
		comboBoxSpe = new JComboBox<String>();
		comboBoxSpe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				remplirComboForm();
			}
		});
		comboBoxSpe.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		comboBoxSpe.setBackground(Color.WHITE);
		comboBoxSpe.setBounds(229, 163, 277, 27);
		remplirComboSpe();
		getContentPane().add(comboBoxSpe);
		
		
		remplirComboForm();
		getContentPane().add(comboBoxForm);
		
		JLabel lblSpcialisation = new JLabel("Spécialisation :");
		lblSpcialisation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblSpcialisation.setForeground(Color.WHITE);
		lblSpcialisation.setBounds(94, 163, 124, 27);
		getContentPane().add(lblSpcialisation);
		
		JLabel lblFormation = new JLabel("Formation :");
		lblFormation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblFormation.setForeground(Color.WHITE);
		lblFormation.setBounds(126, 204, 92, 21);
		getContentPane().add(lblFormation);
		
		textAreaForma = new JTextArea();
		textAreaForma.setBackground(Color.WHITE);
		textAreaForma.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textAreaForma.setBounds(229, 272, 277, 66);
		getContentPane().add(textAreaForma);
		
		JButton btnNewButton_2 = new JButton("↓  Ajouter  ↓");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_2.setBounds(281, 238, 158, 23);
		getContentPane().add(btnNewButton_2);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		
		
	}
	
	

	public CreationCompte getThis()
	{
		return this;
	}
	
	
	
	
	private void remplirComboSpe() 
	{
		String [] nomSpe = DaoFactory.getDaoSpecialisation().getNomSpecialisation();
		
		for (int i = 0; i < nomSpe.length; i++)
		{
			comboBoxSpe.addItem(nomSpe[i]);
		}
		
		
	}
	
	
	private void remplirComboForm() 
	{
		String titreSpe = (String) comboBoxSpe.getSelectedItem();
		List<Formation> listeForm = new ArrayList<Formation>();
		
		try
		{
			Specialisation spe = DaoFactory.getDaoSpecialisation().findByName(titreSpe);
			listeForm = (List<Formation>) DaoFactory.getDaoFormation().findFormationBySpecialisation(spe);
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		comboBoxForm.removeAllItems();
		
		for (int i = 0; i < listeForm.size(); i++)
		{
			comboBoxForm.addItem(listeForm.get(i).getIntitule());
		}
		
		
		
	}
	
	
	
	public JTextField getTextField_Email() 
	{
		return textField_Email;
	}
	public JTextField getTextField_DteNaissance() 
	{
		return textField_DteNaissance;
	}
	public JTextField getTextField_NoAFPA()
	{
		return textField_NoAFPA;
	}
	public JTextField getTextField_Nom()
	{
		return textField_Nom;
	}
	public JTextField getTextField_Prenom()
	{
		return textField_Prenom;
	}

	public String getSelectionType() 
	{
		//groupRadioType
		String type = null;
		
		for (Enumeration<AbstractButton> buttons = groupRadioType.getElements(); buttons.hasMoreElements();)
		{
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) 
            {
            	type = button.getText();
            }
        }

       
		
		
		
		return type;
	}
	
	
}
