package controleur;

import javax.swing.SwingUtilities;

import ihm.fenetre.PanelMngModel;
import model.objet.Formation;
import model.objet.Specialisation;

public class MngModelReadWrite {

	
	public static void showModelInfo(PanelMngModel panel, String intituleFormation) {
		
		// recup formation depuis l'intitulé TODO
		// test en dur>>
		
	Specialisation spe = new Specialisation("java");	
	Formation formation = new Formation(123, 456, "informatique", 1200, "debouchesblabla", 2, 3, spe);
	
	panel.getTxtIntitule().setText(formation.getIntitule());
	panel.getTxtSpe().setText(formation.getSpe_id().getNom());
	panel.getTxtGrn().setText(formation.getGrn().toString());
	panel.getTxtDuree().setText(formation.getDuree().toString());
	panel.getTxtDebouche().setText(formation.getDebouche());
	
	SwingUtilities.updateComponentTreeUI(panel);

					
	}
	
public static void delete(PanelMngModel panel, String intituleFormation) {
		
		// recup formation depuis l'intitulé TODO
		// test en dur>>
		
	Specialisation spe = new Specialisation("java");	
	Formation formation = new Formation(123, 456, "informatique", 1200, "debouchesblabla", 2, 3, spe);
	
	
	
	SwingUtilities.updateComponentTreeUI(panel);

					
	}
	
	
}
