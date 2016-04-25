package controleur;

import actionListener.LoginListener;
import ihm.fenetre.FenLogin;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;
import model.objet.UtilisateurToRole;

public class ControleurLogin
{
	private FenLogin flogin;
	
	public ControleurLogin()
	{
		init();
	}
	
	public void init()
	{
		LoginListener listener = new LoginListener(this);
		flogin = new FenLogin(listener);
		flogin.setLocationRelativeTo(null);
		flogin.setVisible(true);
	}
	
	
	public void verifLogin()
	{
				
		if (flogin.getTxtEmail().getText().split("@").length != 2)
		{
			flogin.AfficheErreur("Entrez un email valide !");
		}
		else if (flogin.getTxtEmail().getText().split("@")[1].split("\\.").length < 2)
		{
			flogin.AfficheErreur("Entrez un email valide !");
		}
		else if (!DaoFactory.getDaoContact().isPasswordCorrect(flogin.getTxtEmail().getText(), new String(flogin.getPwdMotDePasse().getPassword())))
		{
			flogin.AfficheErreur("Email ou mot de passe erroné !");
		}
		else
		{
			Utilisateur user = DaoFactory.getDaoContact().getUserFromMail(flogin.getTxtEmail().getText());
			
			
			for (UtilisateurToRole utr : user.getUtilisateurToRole())
			{
				if (utr.getRole().getType().equals("Formateur") || utr.getRole().getType().equals("Administrateur"))
				{
					flogin.dispose();
					ControleurFMain cfm = new ControleurFMain(/*user*/);
					try 
					{
						cfm.init();
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					flogin.AfficheErreur("Accès non autorisé.");
				}
			}
			
			
		}
		
		
	}


	public FenLogin getFlogin() {
		return flogin;
	}


	public void setFlogin(FenLogin flogin) {
		this.flogin = flogin;
	}
	
	
	
}
