package controleur;

import java.util.ArrayList;
import java.util.List;

import ihm.LippsIhm;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;

public class ControleurFMain

	{
		private List<Utilisateur> listeAdmin = new ArrayList<Utilisateur>();
		private List<Utilisateur> listeFormateur = new ArrayList<Utilisateur>();
		private List<Utilisateur> listeStagiaire = new ArrayList<Utilisateur>();
		private List<Utilisateur> listeTuteur = new ArrayList<Utilisateur>();

		public void init() 
			{

			
				LippsIhm frame = new LippsIhm();
				frame.setVisible(true);

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
