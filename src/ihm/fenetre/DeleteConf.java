package ihm.fenetre;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteConf extends JOptionPane  {
	

	public DeleteConf(JPanel panel) {
		
		int answer = JOptionPane.showConfirmDialog(panel, "Etes-vous sûr?");
		
		if (answer == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(getParent(), "Modèle supprimé!");
		}
		else if (answer == JOptionPane.NO_OPTION) {
			
		}
		
		
	}

}
