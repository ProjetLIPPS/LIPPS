package controleur;

import javax.swing.JOptionPane;

import ihm.fenetre.PanelMngModel;
import model.baseDAO.DaoFactory;
import model.objet.Formation;

public class SuppressionModele {
	

	private PanelMngModel panelMngModel;
	
	
	public SuppressionModele() throws Exception	{
	
		
		String modelSelected = panelMngModel.getList().getSelectedValue();
		
		Formation formation= DaoFactory.getDaoFormation().findFormationByIntitule("cdi");

		//formation = DaoFactory.getDaoFormation().findFormationByIntitule("cdi");
		System.out.println(formation.getDebouche());
		//DaoFactory.getDaoFormation().delete(formation);
			

				
	}



}
