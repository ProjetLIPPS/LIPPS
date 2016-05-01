package ihm.popup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
import javafx.scene.control.RadioButton;
import model.baseDAO.DaoFactory;
import model.objet.Contact;
import model.objet.Formation;
import model.objet.Specialisation;
import model.objet.Utilisateur;
import model.objet.UtilisateurToFormation;
import model.objet.UtilisateurToRole;

public class ModificationCompte extends JDialog
{

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
	private JRadioButton rdbtnAdministrateur = new JRadioButton("Administrateur");
	private JRadioButton rdbtnFormateur = new JRadioButton("Formateur");
	private JRadioButton rdbtnStagiaire = new JRadioButton("Stagiaire");
	private JRadioButton rdbtnTuteur = new JRadioButton("Tuteur");
	private Utilisateur utilisateurAModifier;
	private Contact contactUtilisateurModifier ;


	



	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ModificationCompte(Utilisateur utilisateur) throws Exception
	{
		PopupListener listener = new PopupListener();
		this.utilisateurAModifier = utilisateur;
		setContactUtilisateurModifier();
		setModal(true);
		getContentPane().setBackground(ThemeLIPPS.BLUE);
		setResizable(false);
		setMinimumSize(new Dimension(700, 700));
		setTitle("Modification de compte");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(null);
		
		groupRadioType = new ButtonGroup();
		
		JLabel lblEditionDeCompte = new JLabel("Modifier un compte");
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
		
		
		rdbtnAdministrateur.setName("adminModif");
		rdbtnAdministrateur.addFocusListener(listener);
		rdbtnAdministrateur.setFocusPainted(false);
		rdbtnAdministrateur.setBounds(94, 113, 153, 31);
		getContentPane().add(rdbtnAdministrateur);
		rdbtnAdministrateur.setForeground(Color.WHITE);
		rdbtnAdministrateur.setBackground(Color.decode("#3787C8"));
		rdbtnAdministrateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		groupRadioType.add(rdbtnAdministrateur);

		
		rdbtnFormateur.setName("formModif");
		rdbtnFormateur.addFocusListener(listener);
		rdbtnFormateur.setFocusPainted(false);
		rdbtnFormateur.setBounds(260, 113, 115, 31);
		getContentPane().add(rdbtnFormateur);
		rdbtnFormateur.setForeground(Color.WHITE);
		rdbtnFormateur.setBackground(Color.decode("#3787C8"));
		rdbtnFormateur.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		groupRadioType.add(rdbtnFormateur);
		
		
		rdbtnStagiaire.setName("staModif");
		rdbtnStagiaire.addFocusListener(listener);
		rdbtnStagiaire.setFocusPainted(false);
		rdbtnStagiaire.setBounds(390, 113, 101, 31);
		getContentPane().add(rdbtnStagiaire);
		rdbtnStagiaire.setForeground(Color.WHITE);
		rdbtnStagiaire.setBackground(Color.decode("#3787C8"));
		rdbtnStagiaire.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		groupRadioType.add(rdbtnStagiaire);
		
		
		rdbtnTuteur.setName("tutModif");
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
		btnNewButton.setName("compteModif");
		
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
		remplirComboSpe();
		recupInfoUtilisateur();
		
		
		setVisible(true);
		
		
		
	}
	
	



	public ModificationCompte getThis()
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
	public ButtonGroup getGroupRadioType()
	{
		return groupRadioType;
	}





	public void setGroupRadioType(ButtonGroup groupRadioType)
	{
		this.groupRadioType = groupRadioType;
	}





	public JList<String> getjListForma()
	{
		return jListForma;
	}





	public void setjListForma(JList<String> jListForma)
	{
		this.jListForma = jListForma;
	}





	public String[] getListeFormData()
	{
		return listeFormData;
	}





	public void setListeFormData(String[] listeFormData)
	{
		this.listeFormData = listeFormData;
	}





	public JRadioButton getRdbtnAdministrateur()
	{
		return rdbtnAdministrateur;
	}





	public void setRdbtnAdministrateur(JRadioButton rdbtnAdministrateur)
	{
		this.rdbtnAdministrateur = rdbtnAdministrateur;
	}





	public JRadioButton getRdbtnFormateur()
	{
		return rdbtnFormateur;
	}





	public void setRdbtnFormateur(JRadioButton rdbtnFormateur)
	{
		this.rdbtnFormateur = rdbtnFormateur;
	}





	public JRadioButton getRdbtnStagiaire()
	{
		return rdbtnStagiaire;
	}





	public void setRdbtnStagiaire(JRadioButton rdbtnStagiaire)
	{
		this.rdbtnStagiaire = rdbtnStagiaire;
	}





	public JRadioButton getRdbtnTuteur()
	{
		return rdbtnTuteur;
	}





	public void setRdbtnTuteur(JRadioButton rdbtnTuteur)
	{
		this.rdbtnTuteur = rdbtnTuteur;
	}





	public void setTextField_Prenom(JTextField textField_Prenom)
	{
		this.textField_Prenom = textField_Prenom;
	}





	public void setTextField_Nom(JTextField textField_Nom)
	{
		this.textField_Nom = textField_Nom;
	}





	public void setTextField_DteNaissance(JDateChooser textField_DteNaissance)
	{
		this.textField_DteNaissance = textField_DteNaissance;
	}





	public void setTextField_Email(JTextField textField_Email)
	{
		this.textField_Email = textField_Email;
	}





	public void setTextField_NoAFPA(JTextField textField_NoAFPA)
	{
		this.textField_NoAFPA = textField_NoAFPA;
	}





	public void setComboBoxForm(JComboBox<String> comboBoxForm)
	{
		this.comboBoxForm = comboBoxForm;
	}





	public void setComboBoxSpe(JComboBox<String> comboBoxSpe)
	{
		this.comboBoxSpe = comboBoxSpe;
	}





	public void setBtnAjouter(JButton btnAjouter)
	{
		this.btnAjouter = btnAjouter;
	}





	public Utilisateur getUtilisateurModifier()
	{
		return utilisateurAModifier;
	}





	public void setUtilisateurModifier(Utilisateur utilisateurModifier)
	{
		this.utilisateurAModifier = utilisateurModifier;
	}





	public Contact getContactUtilisateurModifier()
	{
		return contactUtilisateurModifier;
	}





	public void setContactUtilisateurModifier()
	{
		this.contactUtilisateurModifier = DaoFactory.getDaoContact().getContactFromUser(utilisateurAModifier);
	}


	public void recupInfoUtilisateur() throws Exception
	{
		for (UtilisateurToRole roleUti : utilisateurAModifier.getUtilisateurToRole())
		{
			if (roleUti.getRole().getType().equals("Administrateur"))
			{
				rdbtnAdministrateur.doClick();
				rdbtnAdministrateur.setSelected(true);
				rdbtnStagiaire.setEnabled(false);
				rdbtnTuteur.setEnabled(false);
				
			}
			else if (roleUti.getRole().getType().equals("Formateur"))
			{
				rdbtnFormateur.doClick();
				rdbtnFormateur.setSelected(true);
				rdbtnStagiaire.setEnabled(false);
				rdbtnTuteur.setEnabled(false);
				
			}
			else if (roleUti.getRole().getType().equals("Stagiaire"))
			{
				rdbtnStagiaire.doClick();
				rdbtnStagiaire.setSelected(true);
				rdbtnStagiaire.setEnabled(false);
				rdbtnTuteur.setEnabled(false);
				rdbtnFormateur.setEnabled(false);
				rdbtnAdministrateur.setEnabled(false);
			}
			else
			{
				rdbtnTuteur.doClick();
				rdbtnTuteur.setSelected(true);
				rdbtnStagiaire.setEnabled(false);
				rdbtnTuteur.setEnabled(false);
				rdbtnFormateur.setEnabled(false);
				rdbtnAdministrateur.setEnabled(false);
			}
		}
		textField_NoAFPA.setText( utilisateurAModifier.getIdentifiantAFPA().toString());
		textField_Nom.setText(utilisateurAModifier.getNom());
		textField_Prenom.setText(utilisateurAModifier.getPrenom());
		textField_Email.setText(contactUtilisateurModifier.getMail());
		textField_DteNaissance.setDate((Date)utilisateurAModifier.getDateNaissance());
		listeFormData = getFormationUtilisateur();
		jListForma.setListData(listeFormData);
		
		
	}
	
	public String [] getFormationUtilisateur() throws Exception
	{
		
		List <Formation> listeFormationTemp =(List<Formation>) DaoFactory.getDaoFormation().readAllFormationFromUser(utilisateurAModifier);
	
		Iterator<Formation> it = listeFormationTemp.iterator();
		
		String [] listeFormationUtilisateur = new String [listeFormationTemp.size()];
		
	
		for ( int i = 0 ; i < listeFormationUtilisateur.length ; i++)
		{
		
			listeFormationUtilisateur[i] = listeFormationTemp.get(i).getIntitule();
		}	
	
		
		
		
		return listeFormationUtilisateur;
		
	}
	
}
