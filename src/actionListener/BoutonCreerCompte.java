package actionListener;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import ihm.fenetre.PanelCCompte;
import ihm.popup.CreationCompte;

public class BoutonCreerCompte implements MouseListener
{
	
	private PanelCCompte panelCcompte;
	
	public  BoutonCreerCompte(PanelCCompte panelCCompte)
	{
		this.panelCcompte = panelCCompte;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		JButton source = (JButton) e.getSource();
		if (source.equals(panelCcompte.getBtnCreer()))
		{
			
			
			CreationCompte popupCreerCompte = new CreationCompte();
			
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
