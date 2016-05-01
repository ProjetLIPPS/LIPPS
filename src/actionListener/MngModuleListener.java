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
		
			if (selection.getSelectedValue() !=null)
		
			{
					
					String selectedFormation = selection.getSelectedValue().toString();
						
					String[] split = selectedFormation.split(" ");
					String intitule = split[0];
					String date = split[1];
							
									
					MngModuleCtrl.myModuleRowDisplay(intitule, date, panelMngModule);
							
			}
			
			
	}
		
	
	
}
	
	
	
		
	


