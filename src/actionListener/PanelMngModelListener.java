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
		 
			int answer = JOptionPane.showConfirmDialog(null, "Etes-vous sûr?");
			
			if (answer == JOptionPane.YES_OPTION) {
			try {
				
				new SuppressionModele();
				JOptionPane.showMessageDialog(null, "Modèle supprimé avec succès.");
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erreur lors de la tentative de suppression.");
				e1.printStackTrace();
			}
									
			}
			else if (answer == JOptionPane.NO_OPTION) {
			
			JOptionPane.showMessageDialog(null, "Aucune suppression n'a été effectuée.");
			}
			
	}



	// réagit à une selection de formation et affiche modules correspondants
	
	public void valueChanged(ListSelectionEvent e) {
		
		JList selection = (JList) e.getSource();
		String selectedFormation = selection.getSelectedValue().toString();
		
		MngModelReadWrite.showModelInfo(panelMngModel, selectedFormation);
	

	}
	
	

}
