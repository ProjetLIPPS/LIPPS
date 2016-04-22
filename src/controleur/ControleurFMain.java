package controleur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.ScrollableResults;

import ihm.LippsIhm;
import model.baseDAO.DaoFactory;
import model.baseDAO.DaoUtilisateur;
import model.objet.Utilisateur;
import model.objet.UtilisateurToRole;

public class ControleurFMain

	{
		private List<Utilisateur> listeAdmin = new ArrayList<Utilisateur>();
		private List<Utilisateur> listeFormateur = new ArrayList<Utilisateur>();
		private List<Utilisateur> listeStagiaire = new ArrayList<Utilisateur>();
		private List<Utilisateur> listeTuteur = new ArrayList<Utilisateur>();

		public void init() throws Exception
			{

				 recupUtilisateurDb();
				LippsIhm frame = new LippsIhm();
				frame.setVisible(true);

			}

		public void recupUtilisateurDb() throws Exception

			{
				Object [][] resultat = DaoFactory.getDaoUtilisateur().readAdmin();
				
				
				
						
/*
						for (int i = 0; i < listeUtilisateur.size(); i++)
							{
								Utilisateur currentUser = listeUtilisateur.get(i);
								
								for (int j = 0 ; j < currentUser.getUtilisateurToRole().size(); j++)
									{
										UtilisateurToRole currentUTR = currentUser.getUtilisateurToRole().get(j);
										
									if (currentUTR.getRole().getType().equals("Administrateur"))
										{
											listeAdmin.add(currentUser);
										}
									else if (currentUTR.getRole().getType().equals("Formateur"))
										{
											listeFormateur.add(currentUser);
	
										}
									else if (currentUTR.getRole().getType().equals("Stagiaire"))
										{
											listeStagiaire.add(currentUser);
	
										}
									else
										{
											listeTuteur.add(currentUser);
	
										}
									}

							}*/

					}

				

			

		public List<Utilisateur> getListeAdmin()
			{
				return listeAdmin;
			}

		public void setListeAdmin(List<Utilisateur> listeAdmin)
			{
				this.listeAdmin = listeAdmin;
			}

		public List<Utilisateur> getListeFormateur()
			{
				return listeFormateur;
			}

		public void setListeFormateur(List<Utilisateur> listeFormateur)
			{
				this.listeFormateur = listeFormateur;
			}

		public List<Utilisateur> getListeStagiaire()
			{
				return listeStagiaire;
			}

		public void setListeStagiaire(List<Utilisateur> listeStagiaire)
			{
				this.listeStagiaire = listeStagiaire;
			}

		public List<Utilisateur> getListeTuteur()
			{
				return listeTuteur;
			}

		public void setListeTuteur(List<Utilisateur> listeTuteur)
			{
				this.listeTuteur = listeTuteur;
			}



	}
