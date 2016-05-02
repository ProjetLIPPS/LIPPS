package actionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controleur.ControleurFMain;
import ihm.fenetre.PanelCCompte;
import ihm.popup.CreaForm;
import ihm.popup.CreationCompte;
import ihm.popup.ModificationCompte;
import model.baseDAO.DaoFactory;
import model.objet.Contact;
import model.objet.Formation;
import model.objet.ResultatParcoursLivret;
import model.objet.Role;
import model.objet.Specialisation;
import model.objet.Utilisateur;
import model.objet.UtilisateurToFormation;
import model.objet.UtilisateurToRole;
import model.objet.UtilisateurToSpecialisation;

public class ModifierCompteListener implements MouseListener
{

private PanelCCompte panelCcompte;
private Object [][] resultatRecherche;
private ModificationCompte popupModifCompte ;
	
	
	
	public  ModifierCompteListener (ModificationCompte modifCompte)
	{
		this.popupModifCompte = modifCompte;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		JButton source = (JButton) e.getSource();
		
		
			try
			{
				validerCompte();
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
			
		
	
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void validerCompte() throws Exception
	
	{
		
			
			
			resultatRecherche = DaoFactory.getDaoUtilisateur().executeLastQuery();
			Integer currentRow = PanelCCompte.getTableau().getSelectedRow();
			Integer idAfpa = (Integer) resultatRecherche[currentRow][0];
			String role = (String) resultatRecherche[currentRow][3];
			Utilisateur utilisateurAModifier = DaoFactory.getDaoUtilisateur().findByIdAfpa(idAfpa);
			
			
			
				String type = popupModifCompte.getSelectionType();
				Integer NoAFPA = Integer.parseInt(popupModifCompte.getTextField_NoAFPA().getText());
				String nom = popupModifCompte.getTextField_Nom().getText();
				String prenom = popupModifCompte.getTextField_Prenom().getText();
				String email = popupModifCompte.getTextField_Email().getText();
				String [] formations = popupModifCompte.getFormations();
				Role roleUtilisateur = DaoFactory.getDaoRole().findByName(type);
				Date date = popupModifCompte.getTextField_DteNaissance().getDate();
				Contact contact = DaoFactory.getDaoContact().getContactFromUser(utilisateurAModifier);
				contact.setMail(email);
				DaoFactory.getDaoContact().update(contact);
				utilisateurAModifier.setDateNaissance(date);
				utilisateurAModifier.setIdentifiantAFPA(NoAFPA);
				utilisateurAModifier.setNom(nom);
				utilisateurAModifier.setPrenom(prenom);
				List <UtilisateurToFormation> utilisateurToFormation = (List<UtilisateurToFormation>) DaoFactory.getDaoUtilisateurToFormation().readUtilisateurToFormationFromUser(utilisateurAModifier); 
				if (!roleUtilisateur.getType().equals("Administrateur"))
				{
					for (int i = 0 ; i< utilisateurToFormation.size();i++)
					{
						DaoFactory.getDaoUtilisateurToFormation().delete(utilisateurToFormation.get(i));
					}
					for (int i = 0; i < formations.length; i++)
					{
						String[] split = formations[i].split(" ");
						String intitule = split[0];
						String dateForm = split[1];
						Formation form = DaoFactory.getDaoFormation().findFormationByIntituleAndDate(intitule ,dateForm);
						UtilisateurToFormation utf = new UtilisateurToFormation(utilisateurAModifier, form);
						DaoFactory.getDaoFormation().save(utf);
						Specialisation spe = form.getSpecialisation();
						DaoFactory.getDaoUtilisateur().saveOrUpdate(new UtilisateurToSpecialisation(utilisateurAModifier, spe));
					}
				}
				DaoFactory.getDaoUtilisateur().update(utilisateurAModifier);
				popupModifCompte.dispose();
				Object [][] refreshModel = DaoFactory.getDaoUtilisateur().executeLastQuery();
				PanelCCompte.getTableau().setModel(new DefaultTableModel( refreshModel,PanelCCompte.getEnteteTableau()));
				
			
		
	}
	
	
		
		
		
		
	

}
