package fr.epsi.location.remote;

import java.util.List;

import javax.ejb.Remote;

import fr.epsi.location.pojo.Categorie;
import fr.epsi.location.pojo.Client;
import fr.epsi.location.pojo.Exemplaire;
import fr.epsi.location.pojo.Location;
import fr.epsi.location.pojo.Video;

@Remote
public interface ILocation {
	
	
	
	// Categorie
	public Categorie getCategorie(int idCategorie);
	public List<Categorie> getListeCategories();
	public void ajouterCategorie(Categorie categorie);
	public void modifierCategorie (Categorie categorie, int idCategorie);
	public void supprimerCategorie (int idCategorie);
	
	// Client
	public Client getClient(int idClient);
	public List<Client> getListeClients();
	public void insereClient (Client client);
	public void modifierClient (Client client, int idClient);
	public void supprimerClient (int idClient);
	
	// Exemplaire
	public Exemplaire getExemplaire(int idExemplaire);
	public List<Exemplaire> getListeExemplaires();
	public void ajouterExemplaire(Exemplaire exemplaire);
	public void modifierExemplaire (Exemplaire exemplaire, int idExemplaire);
	public void supprimerExemplaire (int idExemplaire);
	
	// Location
	public Location getLocation(int idLocation);
	public List<Location> getListeLocations();
	public void ajouterLocation(Location location);
	public void modifierLocation (Location location, int idLocation);
	public void supprimerLocation (int idLocation);
	
	// Video
	public Video getVideo(int idVideo);
	public List<Video> getListeVideos() ;
	public void ajouterVideo(Video video);
	public void modifierVideo (Video video, int idVideo);
	public void supprimerVideo (int idVideo);
	
}
