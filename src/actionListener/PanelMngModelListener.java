package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.MngModelReadWrite;
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
		 
			int answer = JOptionPane.showConfirmDialog(delete, "Etes-vous sûr?");
			
			if (answer == JOptionPane.YES_OPTION) {
				
				try {
					SuppressionModele del = new SuppressionModele();
					del.deleteModele();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(delete, "Erreur lors de la suppression");
				}
				
				JOptionPane.showMessageDialog(delete, "Modèle supprimé avec succès");
								
			}
			
		
		
	}



	// réagit à une selection de formation et affiche modules correspondants
	
	public void valueChanged(ListSelectionEvent e) {
		
		JList selection = (JList) e.getSource();
		String selectedFormation = selection.getSelectedValue().toString();
		
		MngModelReadWrite.showModelInfo(panelMngModel, selectedFormation);
	

	}
	
	

}
