package controleur;

import java.util.ArrayList;
import java.util.List;

import ihm.LippsIhm;
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

			}

		

	}
