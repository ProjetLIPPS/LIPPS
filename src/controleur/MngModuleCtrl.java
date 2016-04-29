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
	
	
	public static void allModuleRowDisplay(String selectedFormation, PanelMngModule panelMngModule)
	{
	
	JPanel panelAllModList = panelMngModule.getPanelAllModList();
	panelAllModList.removeAll();
	
	panelMngModule.getPanelLeft().remove(panelAllModList);
	
	Formation formation = new Formation();
	List<FormationToModule> allModule = new ArrayList<FormationToModule>();		
	
	try {
		
		formation= (Formation) DaoFactory.getDaoFormation().findFormationByIntitule(selectedFormation);
		allModule = formation.getFormationToModule();
		
		} 
	catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
	String[] listModule = new String[allModule.size()];
	
	for (int i = 0 ; i < listModule.length ; i++)
	{
		listModule[i] = allModule.get(i).getModule().getIntitule();
	}
	
	Arrays.sort(listModule);
	
	for (String intitModule : listModule)
	{
		PanelMngModuleRowMod ModuleRowMod = new PanelMngModuleRowMod(intitModule);
		//ModuleRowMod.addFocusListener(l);
		
		panelAllModList.add(ModuleRowMod);
					
	}
	
	
	panelMngModule.setPanelLeft(panelAllModList);
	
	
	

	
	
 }

	
	public static void myModuleRowDisplay(String selectedFormation, PanelMngModule panelMngModule)
	{
	
	JPanel panelAllModList = panelMngModule.getPanelAllModList();
	panelAllModList.removeAll();
	
	panelMngModule.getPanelLeft().remove(panelAllModList);
	
	Formation formation = new Formation();
	List<FormationToModule> allModule = new ArrayList<FormationToModule>();		
	
	try {
		
		formation= (Formation) DaoFactory.getDaoFormation().findFormationByIntitule(selectedFormation);
		allModule = formation.getFormationToModule();
		
		} 
	catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
	String[] listModule = new String[allModule.size()];
	
	for (int i = 0 ; i < listModule.length ; i++)
	{
		listModule[i] = allModule.get(i).getModule().getIntitule();
	}
	
	Arrays.sort(listModule);
	
	for (String intitModule : listModule)
	{
		PanelMngModuleRowMod ModuleRowMod = new PanelMngModuleRowMod(intitModule);
		//ModuleRowMod.addFocusListener(l);
		
		panelAllModList.add(ModuleRowMod);
					
	}
	
	
	panelMngModule.setPanelLeft(panelAllModList);
	
	
	

	
	
 }
	
}	
