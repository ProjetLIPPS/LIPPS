package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.MngModuleCtrl;
import ihm.fenetre.PanelMngModule;
import ihm.fenetre.PanelMngRowMod;

public class MngModuleListener implements ListSelectionListener , FocusListener {

	
	private PanelMngModule panelMngModule;
	//private PanelMngModuleRowMod panelMngModuleRowMod = null;
	
	
	
	public  MngModuleListener(PanelMngModule panelListened) 
	{
		this.panelMngModule = panelListened;
	}
	
	/*public  MngModuleListener(PanelMngModuleRowMod panelListened) 
	{
		this.panelMngModuleRowMod = panelListened;
	}*/
	
	
	
	// réagit à une selection de formation et affiche modules correspondants
	
	public void valueChanged(ListSelectionEvent e) {
		
				@SuppressWarnings("unchecked")
				JList<String> selection = (JList<String>) e.getSource();
				
				if (selection.getSelectedValue() != null)  {
					
					String selectedFormation = selection.getSelectedValue();
					
     				String[] split = selectedFormation.split(" ");
					String intitule = split[0];
					String date = split[1];
								
										
					MngModuleCtrl.myModuleRowDisplay(intitule, date, panelMngModule);
								
				}
											
	}
	
	
	@Override
	public void focusGained(FocusEvent e) {
		
		JTextArea text = (JTextArea)e.getSource();
		String moduleName = text.getText();
		System.out.println(moduleName + "mouseclick should be here");
		
		MngModuleCtrl.mySequenceRowDisplay(moduleName, panelMngModule);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextArea text = (JTextArea) e.getSource();	
		String moduleName = text.getText();
		System.out.println(moduleName);
		
		MngModuleCtrl.mySequenceRowDisplay(moduleName, panelMngModule);		
		
	}*/

	

		
	
	
}
	
	
	
		
	


