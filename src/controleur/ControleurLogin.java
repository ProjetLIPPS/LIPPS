package controleur;

import java.sql.Date;
import java.time.Instant;

import actionListener.LoginListener;
import ihm.fenetre.FenLogin;
import model.baseDAO.DaoFactory;
import model.objet.Log;
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
			Utilisateur user = DaoFactory.getDaoUtilisateur().getUserFromMail(flogin.getTxtEmail().getText());
			
			
			for (UtilisateurToRole utr : user.getUtilisateurToRole())
			{
				if (utr.getRole().getType().equals("Formateur") || utr.getRole().getType().equals("Administrateur"))
				{
					flogin.dispose();
					
					try 
					{
						DaoFactory.getDaoLog().save(new Log(null, Date.from(Instant.now()), DaoFactory.getDaoContact().getContactFromUser(user).getMail()));
					}
					catch (Exception e)
					{e.printStackTrace();}
					
					ControleurFMain cfm = new ControleurFMain(user);
					return;
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
