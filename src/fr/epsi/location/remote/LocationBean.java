package fr.epsi.location.remote;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.epsi.location.pojo.Categorie;
import fr.epsi.location.pojo.Client;
import fr.epsi.location.pojo.Exemplaire;
import fr.epsi.location.pojo.Location;
import fr.epsi.location.pojo.Video;

@Stateful
public class LocationBean implements ILocation {

	@PersistenceContext ( unitName = "LocationVideo" )
	private EntityManager	entityManager;

	// ***************** Categorie *****************
	@Override
	public Categorie getCategorie ( int idCategorie ) {
		return entityManager.find (Categorie.class, idCategorie);
	}

	@Override
	public List<Categorie> getListeCategories () {
		Query query = entityManager.createQuery ("FROM CATEGORIE");
		return query.getResultList ();
	}

	@Override
	public void ajouterCategorie ( Categorie categorie ) {
		entityManager.persist (categorie);
	}

	@Override
	public void modifierCategorie ( Categorie categorie ) {
		entityManager.merge (categorie);
	}

	@Override
	public void supprimerCategorie ( Categorie categorie ) {
		entityManager.remove (categorie);
	}

	// ***************** CLient *****************
	@Override
	public Client getClient ( int idClient ) {
		return entityManager.find (Client.class, idClient);
	}

	@Override
	public List<Client> getListeClients () {
		Query query = entityManager.createQuery ("FROM CLIENT");
		return query.getResultList ();
	}

	@Override
	public Client getClientParIdentifiant ( String identifiant ) {
		String MaClause = "FROM CLIENT WHERE cli_ ='" + identifiant + "'";
		Query query = entityManager.createQuery (MaClause);
		if (query.getResultList ().size () > 0)
			return (Client) query.getResultList ().get (0);
		return null;
	}

	@Override
	public void ajouterClient ( Client client ) {
		entityManager.persist (client);
	}

	@Override
	public void modifierClient ( Client client ) {
		entityManager.merge (client);
	}

	@Override
	public void supprimerClient ( Client client ) {
		entityManager.remove (client);
	}

	// ***************** Exemplaire *****************
	@Override
	public Exemplaire getExemplaire ( int idExemplaire ) {
		return entityManager.find (Exemplaire.class, idExemplaire);
	}

	@Override
	public List<Exemplaire> getListeExemplaires () {
		Query query = entityManager.createQuery ("FROM EXEMPLAIRE");
		return query.getResultList ();
	}

	@Override
	public List<Exemplaire> getListeExemplairesParVideo ( int idVideo ) {
		String MaClause = "FROM EXEMPLAIRE WHERE exe_idvideo = '" + idVideo + "'";
		Query query = entityManager.createQuery (MaClause);
		if (query.getResultList ().size () > 0)
			return query.getResultList ();
		return null;
	}

	@Override
	public void ajouterExemplaire ( Exemplaire exemplaire ) {
		entityManager.persist (exemplaire);
	}

	@Override
	public void modifierExemplaire ( Exemplaire exemplaire ) {
		entityManager.merge (exemplaire);
	}

	@Override
	public void supprimerExemplaire ( Exemplaire exemplaire ) {
		entityManager.remove (exemplaire);
	}

	// ***************** Location *****************
	@Override
	public Location getLocation ( int idLocation ) {
		return entityManager.find (Location.class, idLocation);
	}

	@Override
	public List<Location> getListeLocations () {
		Query query = entityManager.createQuery ("FROM LOCATION");
		return query.getResultList ();
	}

	@Override
	public void ajouterLocation ( Location location ) {
		entityManager.persist (location);
	}

	@Override
	public void modifierLocation ( Location location ) {
		entityManager.merge (location);
	}

	@Override
	public void supprimerLocation ( Location location ) {
		entityManager.remove (location);
	}

	// ***************** Video *****************
	@Override
	public Video getVideo ( int idVideo ) {
		return entityManager.find (Video.class, idVideo);
	}

	@Override
	public List<Video> getListeVideos () {
		Query query = entityManager.createQuery ("FROM VIDEO");
		return query.getResultList ();
	}

	@Override
	public List<Video> getListeVideosParCategorie ( int idCategorie ) {
		Query query = entityManager.createQuery ("FROM VIDEO WHERE vid_idcat = '" + idCategorie + "'");
		return query.getResultList ();
	}

	@Override
	public void ajouterVideo ( Video video ) {
		entityManager.persist (video);
	}

	@Override
	public void modifierVideo ( Video video ) {
		entityManager.merge (video);
	}

	@Override
	public void supprimerVideo ( Video video ) {
		entityManager.remove (video);
	}
}
