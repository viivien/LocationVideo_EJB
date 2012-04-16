package fr.epsi.location.remote;

import java.util.List;

import javax.ejb.Stateful;

import fr.epsi.location.pojo.*;

@Stateful
public class LocationBean implements ILocation {

	@Override
	public Categorie getCategorie(int idCategorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getListeCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierCategorie(Categorie categorie, int idCategorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCategorie(int idCategorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client getClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getListeClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insereClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierClient(Client client, int idClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerClient(int idClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Exemplaire getExemplaire(int idExemplaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exemplaire> getListeExemplaires() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterExemplaire(Exemplaire exemplaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierExemplaire(Exemplaire exemplaire, int idExemplaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerExemplaire(int idExemplaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location getLocation(int idLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getListeLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterLocation(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierLocation(Location location, int idLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerLocation(int idLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Video getVideo(int idVideo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getListeVideos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterVideo(Video video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierVideo(Video video, int idVideo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerVideo(int idVideo) {
		// TODO Auto-generated method stub
		
	}

}
