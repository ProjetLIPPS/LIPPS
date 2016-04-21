package ihm.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.ControleurLogin;

public class LoginListener implements FocusListener, MouseListener , ActionListener
{
	private ControleurLogin controleur;
	
	public LoginListener(ControleurLogin controleur)
	{
		this.controleur = controleur;
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (e.getSource().getClass().getSimpleName().equals("JTextField"))
		{
			JTextField source = (JTextField) e.getSource();
			if(source.getText().equals("Email"))
			{
				source.setText("");
			}
			
			controleur.getFlogin().getLblChampDerreur().setText("");
			
		}
		else if (e.getSource().getClass().getSimpleName().equals("JPasswordField"))
		{
			JPasswordField source = (JPasswordField) e.getSource();
			if(new String (source.getPassword()).equals("Mot de passe"))
			{
				source.setText("");
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
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
	public void focusGained(FocusEvent e)
	{
		
		

	}

	@Override
	public void focusLost(FocusEvent e)
	{
		if (e.getSource().getClass().getSimpleName().equals("JTextField"))
		{
			JTextField source = (JTextField) e.getSource();
			if(source.getText().equals(""))
			{
				source.setText("Email");
			}
		}
		else if (e.getSource().getClass().getSimpleName().equals("JPasswordField"))
		{
			JPasswordField source = (JPasswordField) e.getSource();
			if(new String (source.getPassword()).equals(""))
			{
				source.setText("Mot de passe");
			}
			
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		controleur.verifLogin();
		
	}

}
