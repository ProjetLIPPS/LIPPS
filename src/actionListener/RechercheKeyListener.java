package actionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ihm.fenetre.PanelCCompte;

public class RechercheKeyListener implements KeyListener
{

	private PanelCCompte panelCCompte;
	private Object[][] resultatRecherche;
	
	public RechercheKeyListener(PanelCCompte panelCcompte)
	{
		this.panelCCompte = panelCcompte;
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
		
	}
	
	public void afficheResultatRecherche( KeyEvent e)
	{
		
	}

}
