package actionListener;

import java.util.List;

import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.LoadModSeqList;
import ihm.fenetre.PanelMngModule;
import ihm.fenetre.PanelMngModuleRowMod;
import model.objet.Formation;
import model.objet.Module;

public class PanelMngModuleListener implements ListSelectionListener {

	
	private PanelMngModule panelMngModule;
	
	public  PanelMngModuleListener(PanelMngModule panelListened) 
	{
		this.panelMngModule = panelListened;
	}
	
	// réagit à une selection de formation et affiche modules correspondants
	
	public void valueChanged(ListSelectionEvent e) {
		
		JList selection = (JList) e.getSource();
		String selectedFormation = selection.getSelectedValue().toString();
		
		// recup formation depuis l'intitulé TODO
		// test en dur>>
		
		panelMngModule.getPanelAllModList().removeAll();
		panelMngModule.remove(panelMngModule.getPanelAllModList());
		
		Module mod1 = new  Module();
		mod1.setIntitule("test intitulew");
		Formation formation =  new  Formation();
		formation.addModule(mod1);
		
		
		// fin test en dur
		
		if (formation.getListModule() != null)
			{
			List<PanelMngModuleRowMod> listMod = LoadModSeqList.listeAllModule(formation);
			
				for (PanelMngModuleRowMod mod : listMod)  
				{
					panelMngModule.getPanelAllModList().add(mod);
				}
			}
		
		
		
		panelMngModule.add(panelMngModule.getPanelAllModList());
		SwingUtilities.updateComponentTreeUI(panelMngModule);
		
		
	}

}
