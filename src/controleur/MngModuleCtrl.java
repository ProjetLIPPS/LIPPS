package controleur;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import actionListener.MngModuleListener;
import ihm.fenetre.PanelMngModule;
import ihm.fenetre.PanelMngModuleRowMod;
import ihm.fenetre.PanelMngModuleRowSeq;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.FormationToModule;
import model.objet.Module;
import model.objet.Sequence;

public class MngModuleCtrl {


	
	
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
	

	for (String intitModule : listModule)
	{
		PanelMngModuleRowMod moduleRowMod = new PanelMngModuleRowMod(intitModule);
		moduleRowMod.addMouseListener(new MngModuleListener(panelMngModule));
		panelLoadMod.add(moduleRowMod);
					
	}
	
	
	panelMngModule.setPanelLoadMod(panelLoadMod);
	
	panelMngModule.refresh();
	
	
	
 }
	
	
	public static void mySequenceRowDisplay(String intituleModule, PanelMngModule panelMngModule)  {
	
	JPanel panelLoadSeq = panelMngModule.getPanelLoadSeq();
	panelLoadSeq.removeAll();	
	panelMngModule.removePanelLoadSeq();
	
	String intitFormation = panelMngModule.getListFormation().getSelectedValue().toString();
	System.out.println(intitFormation);
	String[] split = intitFormation.split(" ");
	String intituleFormation = split[0];
	String dateFormation = split[1];
	
	Formation formation = new Formation();
	ArrayList<Module> listModule = new ArrayList<Module>();
		
	System.out.println(formation.getIntitule());
	try {
		
		formation= (Formation) DaoFactory.getDaoFormation().findFormationByIntituleAndDate(intituleFormation, dateFormation);
		
		listModule = (ArrayList<Module>) DaoFactory.getDaoModule().findModuleByFormation(formation);
		
		} 
	catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
	
	int i = 0;
	Module module = new Module();
	
	for (Module mod : listModule)  {
		
		System.out.println(mod.getIntitule());
		
		if (mod.getIntitule().equals(intituleModule)) {
		
			i++;
			module = mod;
			
		}
	}
	
	if (i > 1) {
		JOptionPane.showMessageDialog(null, "Plus de 1 module possédant le même intitulé a été trouvé, opération impossible.", "Doublon", JOptionPane.WARNING_MESSAGE);
		return;
	}
	
		
	List<Sequence> listSeq = new ArrayList<Sequence>();
	try {
		listSeq = DaoFactory.getDaoSequence().findSequenceFromModule(module);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
    String[] listSequence = new String[listSeq.size()];
	
	for (int y = 0 ; i < listSequence.length ; i++)
	{
		listSequence[y] = listSeq.get(y).getIntitule();
		System.out.println(listSequence[y]);
		
	}
	
	
	for (String intitSequence : listSequence)
	{
		PanelMngModuleRowSeq moduleRowSeq = new PanelMngModuleRowSeq(intitSequence);
		panelLoadSeq.add(moduleRowSeq);
					
	}
		
	panelMngModule.setPanelLoadMod(panelLoadSeq);
	
	panelMngModule.refresh();
	
	
	}
	
}	
