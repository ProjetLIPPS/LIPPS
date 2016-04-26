package controleur;

import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ihm.fenetre.PanelMngModele;
import model.baseDAO.DaoFactory;
import model.objet.Formation;

public class MngModelReadWrite {

	
		
	public static void suppressionModele(PanelMngModele panelMngModel) throws Exception	{
					
		String modelSelected = panelMngModel.getList().getSelectedValue();
		
		DaoFactory.getDaoFormation().delete((Formation) DaoFactory.getDaoFormation().findFormationByIntitule(modelSelected));
		
		panelMngModel.initList();
		panelMngModel.getList().clearSelection();		
	}
	
	
	
	public static void showModelInfo(PanelMngModele panel, String intituleFormation) {
		
		Formation formation = null;
		
		
			
			try {
				
				formation= (Formation) DaoFactory.getDaoFormation().findFormationByIntitule(intituleFormation);
				
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			panel.getTxtIntitule().setText(formation.getIntitule());
			panel.getTxtSpe().setText(formation.getSpecialisation().getNom());
			panel.getTxtGrn().setText(formation.getGrn().toString());
			panel.getTxtDuree().setText(formation.getDuree().toString());
			panel.getTxtDebouche().setText(formation.getDebouche());
		}
	
	
	
}
