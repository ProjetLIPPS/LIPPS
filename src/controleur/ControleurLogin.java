package controleur;

import javax.swing.SwingUtilities;

import actionListener.LoginListener;
import ihm.fenetre.FenLogin;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;

public class ControleurLogin
{
	private FenLogin flogin;
	
	public void init()
	{
		LoginListener listener = new LoginListener(this);
		flogin = new FenLogin(listener);
		flogin.setVisible(true);
	}
	
	
	public void verifLogin()
	{
		Boolean resultat = true;
		
		
		if (flogin.getTxtEmail().getText().split("@").length != 2)
		{
			flogin.AfficheErreur("Entrez un email valide !");
		}
		else if (flogin.getTxtEmail().getText().split("\\.").length != 2)
		{
			flogin.AfficheErreur("Entrez un email valide !");
		}
		else if (!DaoFactory.getDaoContact().isPasswordCorrect(flogin.getTxtEmail().getText(), new String(flogin.getPwdMotDePasse().getPassword())))
		{
			flogin.AfficheErreur("Email ou mot de passe erroné !");
		}
		else
		{
			
			flogin.dispose();
		}
		
		
	}


	private boolean isPasswordCorrect(String email, String password)
	{
		
		if(DaoFactory.getDaoContact().isPasswordCorrect(email, password))
		{
			
		}
		
		
		return false;
	}


	public FenLogin getFlogin() {
		return flogin;
	}


	public void setFlogin(FenLogin flogin) {
		this.flogin = flogin;
	}
	
	
	
}
