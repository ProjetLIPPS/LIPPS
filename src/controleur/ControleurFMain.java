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

public class ControleurFMain

	{
	
	private Utilisateur utilisateur ;
	
	
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

		

	}
