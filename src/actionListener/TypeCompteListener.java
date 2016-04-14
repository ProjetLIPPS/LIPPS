package actionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import fenetre.PanelCCompte;

public class TypeCompteListener implements MouseListener {

	private PanelCCompte panelCCompte ;
	
	public TypeCompteListener ( PanelCCompte panelCCompte)
	{
		this.panelCCompte = panelCCompte;
	}
	
	public void actionPerformed(ActionEvent e) 
	
	{
		
		
	}
	
	
	public void setLblColor()
	{
		panelCCompte.getLblAdmin().setForeground(Color.WHITE);
		panelCCompte.getLblForm().setForeground(Color.WHITE);
		panelCCompte.getLblSta().setForeground(Color.WHITE);
		panelCCompte.getLblTut().setForeground(Color.WHITE);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		 
		 
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel source  = (JLabel) e.getSource() ;
		
		 if (source.equals(panelCCompte.getLblAdmin()))
		 {
			 setLblColor();
			 panelCCompte.getLblAdmin().setForeground(new Color(30, 144, 255));
		 }
		 else if (source.equals(panelCCompte.getLblForm()))
		 {
			 setLblColor();
			 panelCCompte.getLblForm().setForeground(new Color(30, 144, 255));
		 }
		 else if (source.equals(panelCCompte.getLblSta()))
		 {
			 setLblColor();
			 panelCCompte.getLblSta().setForeground(new Color(30, 144, 255));
		 }
		 else 
		 {
			 setLblColor();
			 panelCCompte.getLblTut().setForeground(new Color(30, 144, 255));
		 }
		 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
