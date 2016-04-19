package ihm.actionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ihm.fenetre.PanelCFormation;

public class PanelCFormationListener implements ListSelectionListener {


	private PanelCFormation panelCFormation;

	public  PanelCFormationListener(PanelCFormation panelListened) 
	{
		this.panelCFormation = panelListened;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		// recup string selecitonné dans la list et va chercher objet dans BDD pour affichage
	}
	
	
	
	
	
}
