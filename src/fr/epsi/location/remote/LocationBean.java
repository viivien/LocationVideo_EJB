package fr.epsi.location.remote;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hsqldb.types.Binary;

import fr.epsi.location.pojo.Categorie;
import fr.epsi.location.pojo.Client;
import fr.epsi.location.pojo.Exemplaire;
import fr.epsi.location.pojo.Location;
import fr.epsi.location.pojo.Video;

@Stateless
public class LocationBean implements ILocation {

	@PersistenceContext ( unitName = "LocationBean" )
	private EntityManager	entityManager;

	// ***************** Categorie *****************
	@Override
	public Categorie getCategorie ( int idCategorie ) {
		return entityManager.find (Categorie.class, idCategorie);
	}

	@Override
	public List<Categorie> getListeCategories () {
		Query query = entityManager.createQuery ("from Categorie");
		return query.getResultList ();
	}

	@Override
	public void ajouterCategorie ( Categorie categorie ) {
		entityManager.persist (categorie);
	}

	@Override
	public void modifierCategorie ( Categorie categorie ) {
		entityManager.refresh (categorie);
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
		Query query = entityManager.createQuery ("from Client");
		return query.getResultList ();
	}

	@Override
	public Client getClientParIdentifiants ( String email, String motDePasse ) {
		Query query = entityManager
				.createQuery ("from Client where email = :email and password = :password")
				.setParameter ("email", email).setParameter ("password", motDePasse);
		if (!query.getResultList ().isEmpty ())
			return (Client) query.getResultList ().get (0);
		else
			return null;
	}

	@Override
	public void ajouterClient ( Client client ) {
		entityManager.persist (client);
	}

	@Override
	public void modifierClient ( Client client ) {
		entityManager.refresh (client);
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
		Query query = entityManager.createQuery ("from Exemplaire");
		return query.getResultList ();
	}

	@Override
	public List<Exemplaire> getListeExemplairesParVideo ( int idVideo ) {
		Query query = entityManager.createQuery ("from Exemplaire where Exemplaire.id = :id").setParameter ("id",
				idVideo);
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
		entityManager.refresh (exemplaire);
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
	public List<Location> getListeLocationsDuClient ( int idClient) {
		Query query = entityManager.
						createQuery("from Location where loc_idclient = :idclient").
						setParameter("idclient", idClient);
		return query.getResultList();
	}
	
	@Override
	public List<Location> getListeLocations () {
		Query query = entityManager.createQuery ("from Location");
		return query.getResultList ();
	}

	@Override
	public void ajouterLocation ( Location location ) {
		entityManager.persist (location);
	}

	@Override
	public void modifierLocation ( Location location ) {
		entityManager.refresh (location);
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
		Query query = entityManager.createQuery ("from Video");
		return query.getResultList ();
	}
	
	@Override
	public List<Video> getListeNouveautesVideos () {
		Query query = entityManager.createQuery ("from Video order by id desc");
		return query.getResultList ();
	}

	@Override
	public List<Video> getTop10Videos () {
		Query query = entityManager.createQuery("SELECT v.vid_titre, count(exe_id) as nombre_de_locations "+
										"FROM location l inner join exemplaire e ON l.exemplaire = e "+ 
										"INNER JOIN video v ON e.video = v "+
										"group by v.titre");
		return query.getResultList ();
	}
	
	@Override
	public List<Video> getListeVideosParCategorie ( int idCategorie ) {
		Query query = entityManager.createQuery ("from Video where vid_idcat = :categorie").setParameter (
				"categorie", idCategorie);
		return query.getResultList ();
	}

	@Override
	public void ajouterVideo ( Video video ) {
		entityManager.persist (video);
	}

	@Override
	public void modifierVideo ( Video video ) {
		entityManager.refresh (video);
	}

	@Override
	public void supprimerVideo ( Video video ) {
		entityManager.remove (video);
	}
}
