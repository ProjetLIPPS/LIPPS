package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.MngModelReadWrite;
import ihm.fenetre.PanelMngModel;

public class MngModeleListener implements ActionListener, ListSelectionListener  {

	
	private PanelMngModel panelMngModel;
	

		public  MngModeleListener (PanelMngModel panelMngModel) 
		{
			
			this.panelMngModel = panelMngModel;
			
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//JButton delete = (JButton) e.getSource();
		 
			int answer = JOptionPane.showConfirmDialog(null, "Etes-vous sûr?");
			
			if (answer == JOptionPane.YES_OPTION) {
			try {
				
				MngModelReadWrite.suppressionModele(this.panelMngModel);
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
		
		if (selection.getSelectedValue() != null)
		{	
		String selectedFormation = selection.getSelectedValue().toString();
		MngModelReadWrite.showModelInfo(panelMngModel, selectedFormation);
		}

	}
	
	

}
