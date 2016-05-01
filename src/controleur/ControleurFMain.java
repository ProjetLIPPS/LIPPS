package controleur;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import actionListener.UtilisateurParTypeDeCompte;
import ihm.LippsIhm;
import ihm.fenetre.PanelCCompte;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;
import model.objet.UtilisateurToRole;

public class ControleurFMain

	{
	
	private static Utilisateur utilisateur ;
	
	
	
	public ControleurFMain()
	
	{
		init();
	}
		
		public void init() 
			{

			
				LippsIhm frame = new LippsIhm();
				frame.setVisible(true);
				try
				{
					
				} catch (Exception e)
				{
					System.out.println("erreur");
					e.printStackTrace();
				}

			}

		public static Utilisateur getUtilisateur()
		{
			return utilisateur;
		}

		public static void setUtilisateur(Utilisateur utilisateur)
		{
			ControleurFMain.utilisateur = utilisateur;
		}

		public static Boolean isUserAdmin()
		{
			Boolean isUserAdmin = false ;
			for (UtilisateurToRole it : utilisateur.getUtilisateurToRole())
			{
				if (it.getRole().getType().equals("Administrateur"))
				{
					isUserAdmin = true ;
				}
			}
			
			return isUserAdmin;	
			
		}

	}
