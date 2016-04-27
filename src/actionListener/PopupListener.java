package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ihm.fenetre.PanelCCompte;
import ihm.popup.CreaForm;
import ihm.popup.CreationCompte;
import ihm.popup.CreationModele;
import ihm.popup.CreationModule;
import model.baseDAO.DaoFactory;
import model.objet.Contact;
import model.objet.Formation;
import model.objet.Specialisation;
import model.objet.Utilisateur;
import model.objet.UtilisateurToRole;


//TODO controle de saisie
//TODO creationModele : verifier intitulé unique et premiere lettre en majuscule

public class PopupListener implements ActionListener, ListSelectionListener 
{

	private PanelCCompte panelCcompte ;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton source = (JButton)e.getSource();
		
		int confirmation = JOptionPane.showConfirmDialog(source.getRootPane(), "Verifiez bien tout les champs avant de valider, vous ne pourrez plus les modifier ensuite.\rContinuer ?", "Confirmation", JOptionPane.YES_NO_OPTION);

		if (confirmation == JOptionPane.YES_OPTION)
		{
			
			if (source.getName().equals("formation"))
			{
				creerFormation((CreaForm) source.getRootPane().getParent());
			}
			else if (source.getName().equals("compte"))
			{
				creerCompte((CreationCompte) source.getRootPane().getParent());
				
			}
			else if (source.getName().equals("modele"))
			{
				creerModele((CreationModele) source.getRootPane().getParent());
			}
			else if (source.getName().equals("module"))
			{
				creerModule((CreationModule) source.getRootPane().getParent());
			}
			
		}
		
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		@SuppressWarnings("unchecked")
		JList<String> jliste = (JList<String>) e.getSource();
		
		CreaForm popup = (CreaForm) jliste.getRootPane().getParent();
		
		
		Formation currentFrm = new Formation();
		
		try 
		{
			currentFrm = DaoFactory.getDaoFormation().findFormationByIntitule(jliste.getSelectedValue());
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		popup.getTextField_specialite().setText(currentFrm.getSpecialisation().getNom());
		popup.getTextField_duree().setText(""+currentFrm.getDuree());
		popup.getTextField_grn().setText(""+currentFrm.getGrn());
		popup.getChampEmploisAccessibles().setText(currentFrm.getDebouche());
		
		
	}
	
	
	
	
	
	
	
	
	
	private void creerFormation (CreaForm creaFormPop)
	{
		creaFormPop.dispose();
	}
	
	
	
	
	private void creerCompte (CreationCompte creaComptePop)
	{
		String type = creaComptePop.getSelectionType();
		Integer NoAFPA = Integer.parseInt(creaComptePop.getTextField_NoAFPA().getText());
		String nom = creaComptePop.getTextField_Nom().getText();
		String prenom = creaComptePop.getTextField_Prenom().getText();
		String email = creaComptePop.getTextField_Email().getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try 
		{
			date = dateFormat.parse(creaComptePop.getTextField_DteNaissance().getText());
		} 
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		
		Utilisateur user = new Utilisateur(null, nom, prenom, date, NoAFPA, null, null, null, null) ;
		
		try 
		{
			DaoFactory.getDaoUtilisateur().save(user);
			DaoFactory.getDaoUtilisateur().save(new UtilisateurToRole(user, DaoFactory.getDaoRole().findByName(type)));
			DaoFactory.getDaoContact().save(new Contact(null, null, null, null, null, null, email, user));
			creaComptePop.dispose();
			Object [][] refreshModel = DaoFactory.getDaoUtilisateur().executeLastQuery();
			PanelCCompte.getTableau().setModel(new DefaultTableModel( refreshModel,PanelCCompte.getEnteteTableau()));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private void creerModele (CreationModele creaModelePop)
	{
		String intitule = creaModelePop.getTextField_Intitule().getText();
		Integer noGRN = Integer.parseInt(creaModelePop.getTextField_GRN().getText());
		String specialite = (String) creaModelePop.getComboBoxSpecialite().getSelectedItem();
		String emploisAccessibles = creaModelePop.getJtextEmploisAccessibles().getText();
		Integer duree = Integer.parseInt(creaModelePop.getTextField_Duree().getText());
		Specialisation specialisation = new Specialisation();
		try 
		{
			specialisation = DaoFactory.getDaoSpecialisation().findByName(specialite);
			Formation frm = new Formation(null, noGRN, null, intitule, duree, emploisAccessibles, null, null, null, specialisation, null, true);
			DaoFactory.getDaoFormation().save(frm);
			creaModelePop.dispose();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private void creerModule (CreationModule creaModulePop)
	{
		creaModulePop.dispose();
	}

	

}
