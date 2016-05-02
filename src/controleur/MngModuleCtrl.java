package controleur;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import actionListener.MngModuleListener;
import ihm.fenetre.PanelMngModule;
import ihm.fenetre.PanelMngRowMod;
import ihm.fenetre.PanelMngRowSeq;
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
	
	for (int i = 0 ; i < allModule.size() ; i++)
	{
		listModule[i] = allModule.get(i).getModule().getIntitule();
	}
	

	for (String intitModule : listModule)
	{
		PanelMngRowMod moduleRowMod = new PanelMngRowMod(intitModule, panelMngModule);
//		//moduleRowMod.addFocusListener(new MngModuleListener(panelMngModule));
		panelLoadMod.add(moduleRowMod);
					
	}
	
	panelMngModule.remove(panelMngModule.getPanelLoadMod());
	panelMngModule.setPanelLoadMod(panelLoadMod);
	panelMngModule.revalidate();
		
 }
	
	
	public static void mySequenceRowDisplay(String intituleModule, PanelMngModule panelMngModule)  {
	
	
	JPanel panelLoadSeq = panelMngModule.getPanelLoadSeq();
	panelLoadSeq.removeAll();	
	panelMngModule.removePanelLoadSeq();
	
	String intitFormation = panelMngModule.getListFormation().getSelectedValue();
	System.out.println(intitFormation + "intitformation devrait etre la");
	String[] split = intitFormation.split(" ");
	String intituleFormation = split[0];
	String dateFormation = split[1];
	
	Formation formation = new Formation();
	ArrayList<Module> listModule = new ArrayList<Module>();
		
	
	try {
		
		formation= (Formation) DaoFactory.getDaoFormation().findFormationByIntituleAndDate(intituleFormation, dateFormation);
		System.out.println(formation.getIntitule()+ " on est ds le try ligne 90");
		
		listModule = (ArrayList<Module>) DaoFactory.getDaoModule().findModuleByFormation(formation);
		
		} 
	catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
	
	int i = 0;
	Module module = new Module();
	
	for (Module mod : listModule)  {
		
		
		System.out.println(mod.getIntitule() + "1 2" + intituleModule + " comparaison");
		
		if (mod.getIntitule().equals(intituleModule)) {
		
			i++;
			module = mod;
			System.out.println(module.getIntitule() + " on a le module wesh");
			
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
	
	for (int y = 0 ; y < listSequence.length ; y++)
	{
		listSequence[y] = listSeq.get(y).getIntitule();
		System.out.println(listSequence[y]);
		
	}
	
	
	for (String intitSequence : listSequence)
	{
		PanelMngRowSeq moduleRowSeq = new PanelMngRowSeq(intitSequence);
		panelLoadSeq.add(moduleRowSeq);
					
	}
		
	panelMngModule.setPanelLoadMod(panelLoadSeq);
	
	panelMngModule.revalidate();
	
	
	}
	
}	
