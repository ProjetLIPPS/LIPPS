package ihm.actionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import ihm.fenetre.PanelCCompte;

public class RechercheListener implements FocusListener

{
	private PanelCCompte panelCCompte ;

	public  RechercheListener(PanelCCompte panelCCompte) 
	{
		this.panelCCompte = panelCCompte;
	}

	@Override
	public void focusGained(FocusEvent e) 
	{
		JTextField source = (JTextField) e.getSource() ;
		if (source.getText().equals("Nom ou n°AFPA") )
				{
					panelCCompte.getBarreRecherche().setText("");
				}
		
	}

	@Override
	public void focusLost(FocusEvent e) 
	
	{
		JTextField source = (JTextField) e.getSource() ;
		if (source.getText().equals("") )
				{
					panelCCompte.getBarreRecherche().setText("Nom ou n°AFPA");
				}
		
	}

	

	
}
