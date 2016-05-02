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
		
		@SuppressWarnings("unchecked")
		JList<String> selection = (JList<String>) e.getSource();
		String selectedFormation = selection.getSelectedValue();
		
		String[] split = selectedFormation.split(" ");
		String intitule = split[0];
		String date = split[1];

		if (selection.getSelectedValue() != null)
		{	
		
			MngFormationRewriteInfo.showFormationInfo(panelCFormation, intitule, date);
		}
		


		
		
	}
	
	
	
	
	
}
