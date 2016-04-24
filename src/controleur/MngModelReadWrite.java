package controleur;

import javax.swing.SwingUtilities;

import ihm.fenetre.PanelMngModel;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Specialisation;

public class MngModelReadWrite {

	
	public static void showModelInfo(PanelMngModel panel, String intituleFormation) {
		
		Formation formation = null;
		Specialisation specialisation = null;
		
		try {
		formation= DaoFactory.getDaoFormation().findFormationByIntitule(intituleFormation);
		specialisation = DaoFactory.getDaoSpecialisation().findSpeById(formation.getSpecialisation().getId());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	panel.getTxtIntitule().setText(formation.getIntitule());
	panel.getTxtSpe().setText(specialisation.getNom());
	panel.getTxtGrn().setText(formation.getGrn().toString());
	panel.getTxtDuree().setText(formation.getDuree().toString());
	panel.getTxtDebouche().setText(formation.getDebouche());
	
	SwingUtilities.updateComponentTreeUI(panel);

					
	}
	
	
}
