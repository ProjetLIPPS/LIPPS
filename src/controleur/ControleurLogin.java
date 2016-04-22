package controleur;

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
		flogin = new FenLogin(this, listener);
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
		else if (isPasswordCorrect(flogin.getTxtEmail().getText(), new String(flogin.getPwdMotDePasse().getPassword())))
		{
			
		}
		else
		{
			flogin.dispose();
		}
		
		
	}


	private boolean isPasswordCorrect(String email, String password)
	{
		
		//TODO DaoContact
		
		
		return false;
	}


	public FenLogin getFlogin() {
		return flogin;
	}


	public void setFlogin(FenLogin flogin) {
		this.flogin = flogin;
	}
	
	
	
}
