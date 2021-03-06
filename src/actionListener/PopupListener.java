package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controleur.ControleurFMain;
import ihm.fenetre.PanelCCompte;
import ihm.popup.CreaForm;
import ihm.popup.CreationCompte;
import ihm.popup.CreationModele;
import ihm.popup.CreationModule;
import ihm.popup.ModificationCompte;
import ihm.popup.RowSequence;
import model.baseDAO.DaoFactory;
import model.objet.AnnexeLivret;
import model.objet.Contact;
import model.objet.Formation;
import model.objet.FormationToModule;
import model.objet.Livret;
import model.objet.Module;
import model.objet.ModuleLivret;
import model.objet.Periode;
import model.objet.PeriodeLivret;
import model.objet.PlanningPrevisionnelLivret;
import model.objet.ProjetProLivret;
import model.objet.ResultatParcoursLivret;
import model.objet.Role;
import model.objet.Sequence;
import model.objet.SequenceLivret;
import model.objet.Specialisation;
import model.objet.SuiviLivret;
import model.objet.Utilisateur;
import model.objet.UtilisateurToFormation;
import model.objet.UtilisateurToRole;
import model.objet.UtilisateurToSpecialisation;


//TODO controle de saisie
//TODO creationModele : verifier intitulé unique et premiere lettre en majuscule

public class PopupListener implements ActionListener, ListSelectionListener, FocusListener 
{

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton source = (JButton)e.getSource();
		
		
		
			if (source.getName().equals("formation"))
			{
				int confirmation = JOptionPane.showConfirmDialog(source.getRootPane(), "Verifiez bien tout les champs avant de valider, vous ne pourrez plus les modifier ensuite. Continuer ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (confirmation == JOptionPane.YES_OPTION)
				{
					creerFormation((CreaForm) source.getRootPane().getParent());
				}
			}
			else if (source.getName().equals("compte"))
			{
				int confirmation = JOptionPane.showConfirmDialog(source.getRootPane(), "Verifiez bien tout les champs avant de valider. Continuer ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (confirmation == JOptionPane.YES_OPTION)
				{
					creerCompte((CreationCompte) source.getRootPane().getParent());
				}
			}
			else if (source.getName().equals("modele"))
			{
				int confirmation = JOptionPane.showConfirmDialog(source.getRootPane(), "Verifiez bien tout les champs avant de valider, vous ne pourrez plus les modifier ensuite. Continuer ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (confirmation == JOptionPane.YES_OPTION)
				{
					creerModele((CreationModele) source.getRootPane().getParent());
				}
			}
			else if (source.getName().equals("module"))
			{
				
				int confirmation = JOptionPane.showConfirmDialog(source.getRootPane(), "Verifiez bien tout les champs avant de valider, vous ne pourrez plus les modifier ensuite. Continuer ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (confirmation == JOptionPane.YES_OPTION)
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
			currentFrm = DaoFactory.getDaoFormation().findModeleByIntitule(jliste.getSelectedValue());
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
		Formation modelF = new Formation();
		
		try 
		{
			modelF = DaoFactory.getDaoFormation().findModeleByIntitule(creaFormPop.getListModele().getSelectedValue());
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
		Specialisation spe = modelF.getSpecialisation();
		String ccp = creaFormPop.getTextPaneCCP().getText();
		Integer noOffre = Integer.parseInt(creaFormPop.getTextFieldNoOffre().getText());
		Integer nbStage = Integer.parseInt(creaFormPop.getTextField_nb_stage().getText());
		Date dateDu = creaFormPop.getDateChooserDu().getDate();
		Date dateAu = creaFormPop.getDateChooserAu().getDate();
		
		Formation form = new Formation(null, modelF.getGrn(), noOffre, modelF.getIntitule(), modelF.getDuree(), modelF.getDebouche(), ccp, nbStage, dateDu, dateAu, spe, false);
		
		try 
		{
			DaoFactory.getDaoFormation().save(form);
			creaFormPop.dispose();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try
		{
			DaoFactory.getDaoFormation().save(new UtilisateurToFormation(ControleurFMain.getUtilisateur(), form));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	private void creerCompte (CreationCompte creaComptePop)
	{
		String type = creaComptePop.getSelectionType();
		Integer NoAFPA = Integer.parseInt(creaComptePop.getTextField_NoAFPA().getText());
		String nom = creaComptePop.getTextField_Nom().getText();
		String prenom = creaComptePop.getTextField_Prenom().getText();
		String email = creaComptePop.getTextField_Email().getText();
		String [] formations = creaComptePop.getFormations();
		Role role = DaoFactory.getDaoRole().findByName(type);
		
		
		Date date = creaComptePop.getTextField_DteNaissance().getDate();
		Utilisateur user = new Utilisateur(null, nom, prenom, date, NoAFPA, null, null, null, null) ;
		
		Formation form = new Formation();
		
		try 
		{
			DaoFactory.getDaoUtilisateur().save(user);
			DaoFactory.getDaoUtilisateur().save(new UtilisateurToRole(user, role));
			DaoFactory.getDaoContact().save(new Contact(null, null, null, null, null, null, email, user));
			if (!role.getType().equals("Administrateur") && !role.getType().equals("Formateur") )
			{
				if (formations.length == 0)
				{
					JOptionPane.showMessageDialog(null, "Ce type de compte doit être associé à une formation !", "Aucune formation associée", JOptionPane.WARNING_MESSAGE);
					creaComptePop.dispose();
					return;
				}
					String[] split = formations[0].split(" ");
					String intitule = split[0];
					String dateForm = split[1];
					
					form = DaoFactory.getDaoFormation().findFormationByIntituleAndDate(intitule, dateForm);
					UtilisateurToFormation utf = new UtilisateurToFormation(user, form);
					DaoFactory.getDaoFormation().save(utf);
					Specialisation spe = form.getSpecialisation();
					DaoFactory.getDaoUtilisateur().save(new UtilisateurToSpecialisation(user, spe));
				
			}
			else if (role.getType().equals("Formateur"))
			{
				Specialisation spe = DaoFactory.getDaoSpecialisation().findByName((String) creaComptePop.getComboBoxSpe().getSelectedItem());
				DaoFactory.getDaoUtilisateur().save(new UtilisateurToSpecialisation(user, spe));
			}
			
			if (role.getType().equals("Stagiaire"))
			{
				//creerLivret (user, form);
			}
			creaComptePop.dispose();
			Object [][] refreshModel = DaoFactory.getDaoUtilisateur().executeLastQuery();
			PanelCCompte.getTableau().setModel(new DefaultTableModel( refreshModel,PanelCCompte.getEnteteTableau()));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	private void creerLivret(Utilisateur user, Formation form)
	{
		Livret livret = new Livret(null, false, user);
		try 
		{
			DaoFactory.getDaoLivret().save(livret);
			
			DaoFactory.getDaoProjetProLivret().save(
					new ProjetProLivret(null, null, null, null, null, null, livret));
			
			DaoFactory.getDaoSuiviLivret().save(
					new SuiviLivret(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, livret));
			
			DaoFactory.getDaoResultatParcoursLivret().save(
					new ResultatParcoursLivret(null, null, null, null, null, null, null, null, null, null, livret));
			
			DaoFactory.getDaoAnnexeLivret().save(
					new AnnexeLivret(null, null, null, null, null, null, null, livret));
			
			PlanningPrevisionnelLivret ppl = new PlanningPrevisionnelLivret(null, null, null, livret);
			DaoFactory.getDaoLivret().save(ppl);
			
			
			
			List<FormationToModule> listeFTM = (List<FormationToModule>) DaoFactory.getDaoFormationToModule().getAllFormationToModuleFromFormation(form);
			
			ArrayList<Periode> listPeriode = new ArrayList<Periode>();
			PeriodeLivret currentPeriodeLivret = null;
			
			for (FormationToModule ftm : listeFTM)
			{
				Periode currentPeriode = ftm.getPeriode();
				Module currentModule = ftm.getModule();
				
				
				if (!listPeriode.contains(currentPeriode))
				{
					listPeriode.add(currentPeriode);
					
					currentPeriodeLivret = new PeriodeLivret(null, null, null, null, null, null, null, ftm.getPositionPeriodeDansFormation(), ppl);
					DaoFactory.getDaoPeriodeLivret().save(currentPeriodeLivret);
				}
				
				ModuleLivret currentModuleLivret = new ModuleLivret(null, currentModule.getIntitule(), false, null, ftm.getPositionModuleDansPeriode(), currentPeriodeLivret);
				DaoFactory.getDaoModuleLivret().save(currentModuleLivret);
				
				List<Sequence> currentListeSequence = DaoFactory.getDaoSequence().findSequenceFromModule(currentModule);
				for (Sequence currentSequence : currentListeSequence)
				{
					DaoFactory.getDaoSequenceLivret().save(new SequenceLivret(null, currentSequence.getIntitule(), null, null, null, null, null, null, currentSequence.getPosition(), currentModuleLivret));
				}
				
			}
			
			
			
			
			// TODO : terminer avec periodeLivret / type periodeLivret et moduleLivret / sequencesLivret
		}
		catch (Exception e)
		{e.printStackTrace();}
		
		
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
			Formation frm = new Formation(null, noGRN, null, intitule, duree, emploisAccessibles, null, null, null, null, specialisation, true);
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
		
		String descriptionModule = creaModulePop.getTextAreaDescription().getText();
		Module module = new Module(null, descriptionModule);
		
		try
		{
			DaoFactory.getDaoModule().save(module);
		}
		catch (Exception e)
		{e.printStackTrace();}
		
		
		for (int i = 1; i < creaModulePop.getListeSequence().size() ; i++)
		{
			RowSequence currentRow = creaModulePop.getListeSequence().get(i);
			String descriptionSeq = currentRow.getTextAreaSequenceDescription().getText();
			Sequence seq = new Sequence(null, descriptionSeq, module, i);
			
			try 
			{
				DaoFactory.getDaoSequence().save(seq);
			} 
			catch (Exception e)
			{e.printStackTrace();}
		}
		
		try
		{
			DaoFactory.getDaoModule().save(new FormationToModule(creaModulePop.getFormation(), module, null, null));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		creaModulePop.dispose();
	}

	
	
	

	@Override
	public void focusGained(FocusEvent e) 
	{
		JRadioButton radbut = (JRadioButton) e.getSource();
		if ( radbut.getRootPane().getParent().getClass().getSimpleName().equals("CreationCompte"))
		{
			CreationCompte creaComptePop = (CreationCompte) radbut.getRootPane().getParent();
			
			
			if (radbut.getName().equals("admin"))
			{
				creaComptePop.getComboBoxSpe().setEnabled(false);
				creaComptePop.getComboBoxForm().setEnabled(false);
				creaComptePop.getBtnAjouter().setEnabled(false);
				
			}
			else if (radbut.getName().equals("form"))
			{
				creaComptePop.getComboBoxSpe().setEnabled(true);
				creaComptePop.getComboBoxForm().setEnabled(false);
				creaComptePop.getBtnAjouter().setEnabled(false);
				
			}
			else
			{
				creaComptePop.getComboBoxSpe().setEnabled(true);
				creaComptePop.getComboBoxForm().setEnabled(true);
				creaComptePop.getBtnAjouter().setEnabled(true);
			}
		}
		else if (radbut.getRootPane().getParent().getClass().getSimpleName().equals("ModificationCompte"))
		{
			ModificationCompte modifComptePop = (ModificationCompte) radbut.getRootPane().getParent();
			if (radbut.getName().equals("adminModif"))
			{
				modifComptePop.getComboBoxSpe().setEnabled(false);
				modifComptePop.getComboBoxForm().setEnabled(false);
				modifComptePop.getBtnAjouter().setEnabled(false);
				
			}
			else
			{
				modifComptePop.getComboBoxSpe().setEnabled(true);
				modifComptePop.getComboBoxForm().setEnabled(true);
				modifComptePop.getBtnAjouter().setEnabled(true);
			}
		}
		
		
		
	}


	@Override
	public void focusLost(FocusEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	

}
