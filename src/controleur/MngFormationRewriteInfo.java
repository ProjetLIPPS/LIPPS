package controleur;

import ihm.fenetre.PanelCFormation;
import ihm.fenetre.PanelMngModele;
import model.baseDAO.DaoFactory;
import model.objet.Formation;

public class MngFormationRewriteInfo {

	
		
	public static void suppressionModele(PanelMngModele panelMngModel) throws Exception	{
					
		String modelSelected = panelMngModel.getList().getSelectedValue();
		
		DaoFactory.getDaoFormation().delete((Formation) DaoFactory.getDaoFormation().findModeleByIntitule(modelSelected));
		
		panelMngModel.initList();
		panelMngModel.getList().clearSelection();		
		
	}
	
	
	
	public static void showModelInfo(PanelMngModele panel, String intituleFormation) {
		
		Formation formation = new Formation();
		
		
			
			try {
				
				formation= (Formation) DaoFactory.getDaoFormation().findModeleByIntitule(intituleFormation);
				
				System.out.println(formation.getIntitule());
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			panel.getTxtIntitule().setText(formation.getIntitule());
			panel.getTxtSpe().setText(formation.getSpecialisation().getNom());
			panel.getTxtGrn().setText(formation.getGrn().toString());
			panel.getTxtDuree().setText(formation.getDuree().toString());
			panel.getTxtDebouche().setText(formation.getDebouche());
		}
	
public static void showFormationInfo(PanelCFormation panelCFormation, String intituleFormation) {
		
		Formation formation = new Formation();
		
				try {
				
				formation= (Formation) DaoFactory.getDaoFormation().findFormationByIntitule(intituleFormation);
				
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
				panelCFormation.getTxtIntitule().setText(formation.getIntitule());
				panelCFormation.getTxtDuree().setText(formation.getDuree().toString());
				panelCFormation.getTxtGrn().setText(formation.getGrn().toString());
				panelCFormation.getTxtNbStage().setText(formation.getNombreStage().toString());
				panelCFormation.getTxtOffre().setText(formation.getOffre().toString());
				panelCFormation.getTxtSpe().setText(formation.getSpecialisation().getNom());
				panelCFormation.getTextCcp().setText(formation.getCcp());
				panelCFormation.getTextDebouche().setText(formation.getDebouche());
		}
	
	
}
