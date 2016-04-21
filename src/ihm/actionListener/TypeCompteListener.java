package ihm.actionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import ihm.fenetre.PanelCCompte;
import ihm.theme.ThemeLIPPS;

public class TypeCompteListener implements MouseListener  {

	private PanelCCompte panelCCompte ;
	private Integer isSelected = 0;
	
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
	
	public void setBorder()
	
	{
		
		
			panelCCompte.getLblAdmin().setBorder(null);
			panelCCompte.getLblForm().setBorder(null);
			panelCCompte.getLblSta().setBorder(null);
			panelCCompte.getLblTut().setBorder(null);
			
		
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
			 setBorder();
			 isSelected = 1;
		 }
		 else if (source.equals(panelCCompte.getLblForm()))
		 {
			 setLblColor();
			 panelCCompte.getLblForm().setForeground(new Color(30, 144, 255));
			 panelCCompte.getLblForm().setBorder(new MatteBorder(0, 3, 0, 0,  ThemeLIPPS.BLUE));
			 isSelected = 2;
			 setBorder();

		 }
		 else if (source.equals(panelCCompte.getLblSta()))
		 {
			 setLblColor();
			 panelCCompte.getLblSta().setForeground(new Color(30, 144, 255));
			 panelCCompte.getLblSta().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			 isSelected = 3;
			 setBorder();

		 }
		 else 
		 {
			 setLblColor();
			 panelCCompte.getLblTut().setForeground(new Color(30, 144, 255));
			 panelCCompte.getLblTut().setBorder(new MatteBorder(0, 3, 0, 0, ThemeLIPPS.BLUE));
			 isSelected = 4;
			 setBorder();

		 }
		 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel source  = (JLabel) e.getSource() ; 
		
		if (source.equals(panelCCompte.getLblAdmin())&& isSelected != 1)
		 {
			 
			 panelCCompte.getLblAdmin().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		 }
		 else if (source.equals(panelCCompte.getLblForm())&& isSelected != 2)
		 {
			 
			
			 panelCCompte.getLblForm().setBorder(new MatteBorder(0, 3, 0, 0, (Color) Color.WHITE));
		 }
		 else if (source.equals(panelCCompte.getLblSta())&& isSelected != 3)
		 {
			
			 
			 panelCCompte.getLblSta().setBorder(new MatteBorder(0, 3, 0, 0, (Color)Color.WHITE));
		 }
		 else if (source.equals(panelCCompte.getLblTut())&& isSelected != 4) 
		 {
			 
			
			 panelCCompte.getLblTut().setBorder(new MatteBorder(0, 3, 0, 0, (Color)Color.WHITE));
		 }
		 
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
JLabel source  = (JLabel) e.getSource() ; 
if (source.equals(panelCCompte.getLblAdmin()))
{
	 
	setBorder();
}
else if (source.equals(panelCCompte.getLblForm()))
{
	 
	
	setBorder();
}
else if (source.equals(panelCCompte.getLblSta()))
{
	
	 
	setBorder();
}
else 
{
	 
	setBorder();
}
		
		
	}

}
