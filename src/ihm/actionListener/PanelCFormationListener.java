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
		
		String formSelected = e.getSource().toString();
		
		// TODO recup String selectionné dans la list et va chercher objet formation dans BDD
		
		panelCFormation.getTxtIntitule().setText(null);
		panelCFormation.getTxtDuree().setText(null);
		panelCFormation.getTxtGrn().setText(null);
		panelCFormation.getTxtNbStage().setText(null);
		panelCFormation.getTxtOffre().setText(null);
		panelCFormation.getTxtSpe().setText(null);
		panelCFormation.getTextCcp().setText(null);
		panelCFormation.getTextDebouche().setText(null);

		
		
	}
	
	
	
	
	
}
