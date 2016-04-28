package ihm.popup;

import java.awt.Color;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import actionListener.PopupListener;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Specialisation;

public class CreationCompte extends JDialog {
	private JTextField textField_Prenom;
	private JTextField textField_Nom;
	private JDateChooser textField_DteNaissance;
	private JTextField textField_Email;
	private JTextField textField_NoAFPA;
	private ButtonGroup groupRadioType;
	private JComboBox<String> comboBoxForm;
	private JComboBox<String> comboBoxSpe;
	private JList<String> jListForma;
	private JButton btnAjouter;
	private String[] listeFormData = new String[0];


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
		lblNom.setBounds(169, 411, 49, 21);
		getContentPane().add(lblNom);
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_Prenom = new JTextField();
		textField_Prenom.setBounds(229, 453, 277, 27);
		getContentPane().add(textField_Prenom);
		textField_Prenom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Prenom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(146, 456, 72, 21);
		getContentPane().add(lblPrenom);
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(229, 408, 277, 27);
		getContentPane().add(textField_Nom);
		textField_Nom.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Nom.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setBounds(49, 546, 169, 21);
		getContentPane().add(lblDateDeNaissance);
		lblDateDeNaissance.setForeground(Color.WHITE);
		lblDateDeNaissance.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblNumroAfpa = new JLabel("Numéro AFPA :");
		lblNumroAfpa.setBounds(94, 366, 124, 21);
		getContentPane().add(lblNumroAfpa);
		lblNumroAfpa.setForeground(Color.WHITE);
		lblNumroAfpa.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(166, 501, 52, 21);
		getContentPane().add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_DteNaissance = new JDateChooser();
		textField_DteNaissance.setBounds(229, 543, 135, 27);
		getContentPane().add(textField_DteNaissance);
		textField_DteNaissance.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		//textField_DteNaissance.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(229, 498, 277, 27);
		getContentPane().add(textField_Email);
		textField_Email.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Email.setColumns(10);
		
		textField_NoAFPA = new JTextField();
		textField_NoAFPA.setBounds(229, 363, 277, 27);
		getContentPane().add(textField_NoAFPA);
		textField_NoAFPA.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_NoAFPA.setColumns(10);
		
		JRadioButton rdbtnAdministrateur = new JRadioButton("Administrateur");
		rdbtnAdministrateur.setName("admin");
		rdbtnAdministrateur.addFocusListener(listener);
		rdbtnAdministrateur.setFocusPainted(false);
		rdbtnAdministrateur.setBounds(94, 113, 153, 31);
		getContentPane().add(rdbtnAdministrateur);
		rdbtnAdministrateur.setForeground(Color.WHITE);
		rdbtnAdministrateur.setBackground(Color.decode("#3787C8"));
		rdbtnAdministrateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		groupRadioType.add(rdbtnAdministrateur);

		JRadioButton rdbtnFormateur = new JRadioButton("Formateur");
		rdbtnFormateur.setName("form");
		rdbtnFormateur.addFocusListener(listener);
		rdbtnFormateur.setFocusPainted(false);
		rdbtnFormateur.setBounds(260, 113, 115, 31);
		getContentPane().add(rdbtnFormateur);
		rdbtnFormateur.setForeground(Color.WHITE);
		rdbtnFormateur.setBackground(Color.decode("#3787C8"));
		rdbtnFormateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		groupRadioType.add(rdbtnFormateur);
		
		JRadioButton rdbtnStagiaire = new JRadioButton("Stagiaire");
		rdbtnStagiaire.setName("sta");
		rdbtnStagiaire.addFocusListener(listener);
		rdbtnStagiaire.setFocusPainted(false);
		rdbtnStagiaire.setBounds(390, 113, 101, 31);
		getContentPane().add(rdbtnStagiaire);
		rdbtnStagiaire.setForeground(Color.WHITE);
		rdbtnStagiaire.setBackground(Color.decode("#3787C8"));
		rdbtnStagiaire.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		groupRadioType.add(rdbtnStagiaire);
		
		JRadioButton rdbtnTuteur = new JRadioButton("Tuteur");
		rdbtnTuteur.setName("tut");
		rdbtnTuteur.addFocusListener(listener);
		rdbtnTuteur.setFocusPainted(false);
		rdbtnTuteur.setBounds(512, 113, 79, 31);
		getContentPane().add(rdbtnTuteur);
		rdbtnTuteur.setForeground(Color.WHITE);
		rdbtnTuteur.setBackground(Color.decode("#3787C8"));
		rdbtnTuteur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		groupRadioType.add(rdbtnTuteur);
		
		JButton btnNewButton = new JButton("Valider");
		
		btnNewButton.addActionListener(listener);
		btnNewButton.setName("compte");
		
		btnNewButton.setBounds(229, 616, 101, 33);
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
		btnNewButton_1.setBounds(405, 616, 101, 33);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(229, 272, 277, 76);
		getContentPane().add(scrollPane);
		
		jListForma = new JList<String>();
		scrollPane.setViewportView(jListForma);
		jListForma.setFocusable(false);
		jListForma.setBackground(Color.WHITE);
		jListForma.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		btnAjouter = new JButton("↓  Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ajouterFormation();
			}
		});
		btnAjouter.setFocusPainted(false);
		btnAjouter.setBackground(Color.WHITE);
		btnAjouter.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnAjouter.setBounds(229, 238, 124, 23);
		getContentPane().add(btnAjouter);
		
		JLabel lblFormationSelectionne = new JLabel("Formation(s)");
		lblFormationSelectionne.setForeground(Color.WHITE);
		lblFormationSelectionne.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblFormationSelectionne.setBounds(83, 275, 101, 21);
		getContentPane().add(lblFormationSelectionne);
		
		JLabel lblSelectionnes = new JLabel("sélectionnée(s) :");
		lblSelectionnes.setForeground(Color.WHITE);
		lblSelectionnes.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblSelectionnes.setBounds(83, 301, 135, 21);
		getContentPane().add(lblSelectionnes);
		
		JButton btnSupprimer = new JButton("Supprimer  ↑");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				supprimerFormation();
			}
		});
		btnSupprimer.setFocusPainted(false);
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnSupprimer.setBounds(381, 238, 124, 23);
		getContentPane().add(btnSupprimer);
		setLocationRelativeTo(null);
		
		
		setVisible(true);
		
		
		
	}
	
	



	public CreationCompte getThis()
	{
		return this;
	}
	
	
	
	
	private void remplirComboSpe() 
	{
		comboBoxSpe.setModel(new DefaultComboBoxModel<String>(DaoFactory.getDaoSpecialisation().getNomSpecialisation()));	
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
	


	protected void ajouterFormation() 
	{
		boolean contains = false;
		
		for (int i = 0; !contains && i < listeFormData.length; i++)
		{
			if (listeFormData[i] == comboBoxForm.getSelectedItem())
				contains = true;
		}
		
		if(!contains)
		{
			String[] dataTemp = new String [listeFormData.length+1];
			
			for (int i = 0; i < listeFormData.length; i++)
			{
				dataTemp[i] = listeFormData[i];
			}
			
			dataTemp[dataTemp.length-1] = (String) comboBoxForm.getSelectedItem();
			listeFormData = dataTemp;
			
			jListForma.setListData(listeFormData);
		}
		
		
	}
	
	
	
	protected void supprimerFormation()
	{	
		if (listeFormData.length > 0 && jListForma.getSelectedIndex() > -1)
		{
			listeFormData[jListForma.getSelectedIndex()] = null;
			String[] dataTemp = new String [listeFormData.length-1];
			
			int j = 0;
			for (int i = 0; i < listeFormData.length; i++)
			{
				if (listeFormData[i] != null)
				{
					dataTemp[j] = listeFormData[i];
					j++;
				}
			}
			
			listeFormData = dataTemp;
			
			jListForma.setListData(listeFormData);
		}
	}
	
	
	
	public JTextField getTextField_Email() 
	{
		return textField_Email;
	}
	public JDateChooser getTextField_DteNaissance() 
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
	
	public JComboBox<String> getComboBoxForm() 
	{
		return comboBoxForm;
	}

	public JComboBox<String> getComboBoxSpe() 
	{
		return comboBoxSpe;
	}


	public JButton getBtnAjouter() 
	{
		return btnAjouter;
	}

	
	public String[] getFormations()
	{
		String [] tab = new String[jListForma.getModel().getSize()];
		
		for (int i = 0; i < tab.length; i++)
		{
			tab[i] = jListForma.getModel().getElementAt(i);
		}
		
		
		return tab;
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
