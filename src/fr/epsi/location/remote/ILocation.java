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
	public Categorie getCategorie ( int idCategorie );

	public List<Categorie> getListeCategories ();

	public void ajouterCategorie ( Categorie categorie );

	public void modifierCategorie ( Categorie categorie );

	public void supprimerCategorie ( Categorie categorie );

	// Client
	public Client getClient ( int idClient );

	public List<Client> getListeClients ();

	// public Client getClientParIdentifiant ( String identifiant );

	public void ajouterClient ( Client client );

	public void modifierClient ( Client client );

	public void supprimerClient ( Client client );

	// Exemplaire
	public Exemplaire getExemplaire ( int idExemplaire );

	public List<Exemplaire> getListeExemplaires ();

	public List<Exemplaire> getListeExemplairesParVideo ( int idVideo );

	public void ajouterExemplaire ( Exemplaire exemplaire );

	public void modifierExemplaire ( Exemplaire exemplaire );

	public void supprimerExemplaire ( Exemplaire exemplaire );

	// Location
	public Location getLocation ( int idLocation );

	public List<Location> getListeLocations ();

	public void ajouterLocation ( Location location );

	public void modifierLocation ( Location location );

	public void supprimerLocation ( Location location );

	// Video
	public Video getVideo ( int idVideo );

	public List<Video> getListeVideos ();

	public List<Video> getListeVideosParCategorie ( int idCategorie );

	public void ajouterVideo ( Video video );

	public void modifierVideo ( Video video );

	public void supprimerVideo ( Video video );

}
