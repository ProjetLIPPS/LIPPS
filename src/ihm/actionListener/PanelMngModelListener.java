package ihm.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.SuppressionModele;
import ihm.fenetre.PanelMngModel;

public class PanelMngModelListener implements ActionListener, ListSelectionListener  {

	
	private PanelMngModel panelMngModel ;

		public  PanelMngModelListener (PanelMngModel panelMngModel) 
		{
			
			this.panelMngModel = panelMngModel;
			
		}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton delete = (JButton) e.getSource();
		if (delete.getText() == "Supprimer"  ) 
		{
			SuppressionModele.deleteModele(panelMngModel);
		}
		
	}



	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selection = (String) e.getSource();
		
		// appel methode controller pour recherche bdd et instanciation objet modele 
		// recup des attributs objet formation pour redispatcher dans textfields
		
		panelMngModel.getTxtIntitule().setText(null);
		panelMngModel.getTxtGrn().setText(null);
		panelMngModel.getTxtDuree().setText(null);
		panelMngModel.getTxtSpe().setText(null);
		panelMngModel.getTxtCcp().setText(null);
		panelMngModel.getTxtDebouche().setText(null);
		
		
	}
	
	

}
