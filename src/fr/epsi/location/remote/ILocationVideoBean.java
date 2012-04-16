package fr.epsi.location.remote;

import java.util.List;

import javax.ejb.Remote;

import fr.epsi.location.pojo.*;


@Remote
public interface ILocationVideoBean 
{
	public Video ajoutVideo(Video video);
	public void deleteVideo(int id);
	public List<Video> getVideos();
	public Video getVideo(int id);
	public List<Video> getVideosByCategorie(int idCat);

	
	public Categorie ajoutCategorie(Categorie cat);
	public void deleteCategorie(int id);
	public List<Categorie> getCategories();
	public Categorie getCategorie(int id);

	
	public Support ajoutSupport(Support sup);
	public void deleteSupport(int id);
	public List<Support> getSupports();
	public Support getSupport(int id);
	
	public Client ajoutUtilisateur(Client uti);
	public void deleteUtilisateur(int id);
	public List<Client> getUtilisateurs();
	public Client getUtilisateur(int id);
	public Client getUtilisateurbyLogin(String login);
	public Client IdentificationUtilisateur(String login, String mdp);
	
	public List<Location> getHistorique(int id_uti);
	
}
