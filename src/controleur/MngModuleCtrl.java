package controleur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ihm.fenetre.PanelMngModule;
import ihm.fenetre.PanelMngModuleRowMod;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.FormationToModule;

public class MngModuleCtrl {


	
	private PanelMngModule panelMngModule;
	
	
	
	
	public static void myModuleRowDisplay(String intitule, String date, PanelMngModule panelMngModule)
	{
	
	JPanel panelLoadMod = panelMngModule.getPanelLoadMod();
	panelLoadMod.removeAll();
	
	panelMngModule.removePanelLoadMod();
	
	Formation formation = new Formation();
		
	try {
		
		formation= (Formation) DaoFactory.getDaoFormation().findFormationByIntituleAndDate(intitule, date);
		
		} 
	catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
	List<FormationToModule> allModule = formation.getFormationToModule();
	
	String[] listModule = new String[allModule.size()];
	
	for (int i = 0 ; i < listModule.length ; i++)
	{
		listModule[i] = allModule.get(i).getModule().getIntitule();
	}
	
	//Arrays.sort(listModule);
	
	for (String intitModule : listModule)
	{
		PanelMngModuleRowMod ModuleRowMod = new PanelMngModuleRowMod(intitModule);
		//ModuleRowMod.addFocusListener(l);
		
		panelLoadMod.add(ModuleRowMod);
					
	}
	
	
	panelMngModule.setPanelLoadMod(panelLoadMod);
	
	panelMngModule.refresh();
	
	
	
 }
	
}	
