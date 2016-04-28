package actionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.MngModuleCtrl;
import ihm.fenetre.PanelMngModule;

public class MngModuleListener implements ListSelectionListener {

	
	private PanelMngModule panelMngModule;
	
	public  MngModuleListener(PanelMngModule panelListened) 
	{
		this.panelMngModule = panelListened;
	}
	
	// réagit à une selection de formation et affiche modules correspondants
	
	public void valueChanged(ListSelectionEvent e) {
		
		JList selection = (JList) e.getSource();
		String selectedFormation = selection.getSelectedValue().toString();
		
		MngModuleCtrl.moduleRowDisplay(selectedFormation, panelMngModule);
		

	
		
		
	}

}
