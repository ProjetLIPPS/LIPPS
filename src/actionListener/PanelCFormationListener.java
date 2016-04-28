package actionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.MngFormationRewriteInfo;
import ihm.fenetre.PanelCFormation;

public class PanelCFormationListener implements ListSelectionListener {


	private PanelCFormation panelCFormation;

	public  PanelCFormationListener(PanelCFormation panelListened) 
	{
		this.panelCFormation = panelListened;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		JList selection = (JList) e.getSource();
		String selectedFormation = selection.getSelectedValue().toString();
		
		if (selection.getSelectedValue() != null)
		{	
		
			MngFormationRewriteInfo.showFormationInfo(panelCFormation, selectedFormation);
		}
		


		
		
	}
	
	
	
	
	
}
