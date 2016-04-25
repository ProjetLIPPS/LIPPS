package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ihm.popup.CreaForm;
import ihm.popup.CreationCompte;
import ihm.popup.CreationModele;
import ihm.popup.CreationModule;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;
import model.objet.UtilisateurToRole;

public class PopupListener implements ActionListener {

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
			creaComptePop.dispose();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//creaComptePop.dispose();
	}
	
	private void creerModele (CreationModele creaModelePop)
	{
		creaModelePop.dispose();
	}
	
	private void creerModule (CreationModule creaModulePop)
	{
		creaModulePop.dispose();
	}

}
