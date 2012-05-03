package fr.epsi.location.remote;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.epsi.location.pojo.Categorie;
import fr.epsi.location.pojo.Video;

@Stateful
public class LocationVideoBean implements ILocationVideoBean {

	@PersistenceContext ( unitName = "LocationVideo" )
	private EntityManager	entityManager;

	@Override
	public void ajoutVideo ( Video video ) {
		entityManager.persist (video);
	}

	@Override
	public void deleteVideo ( int id ) {
		Video video = entityManager.find (Video.class, id);
		entityManager.remove (video);
	}

	@Override
	public List<Video> getVideos () {
		Query query = entityManager.createQuery ("from Video");
		return query.getResultList ();
	}

	@Override
	public Video getVideo ( int id ) {
		return entityManager.find (Video.class, id);
	}

	@Override
	public List<Video> getVideosByCategorie ( int idCat ) {
		Query query = entityManager.createQuery ("from Video where categorie = '" + idCat + "'");
		return query.getResultList ();
	}

	@Override
	public Categorie ajoutCategorie ( Categorie cat ) {
		entityManager.persist (cat);
		return cat;
	}

	@Override
	public void deleteCategorie ( int id ) {
		Categorie cat = entityManager.find (Categorie.class, id);
		entityManager.remove (cat);
	}

	@Override
	public List<Categorie> getCategories () {
		Query query = entityManager.createQuery ("from Categorie");
		return query.getResultList ();
	}

	@Override
	public Categorie getCategorie ( int id ) {
		return entityManager.find (Categorie.class, id);
	}

	public Support ajoutSupport ( Support sup ) {
		entityManager.persist (sup);
		return sup;
	}

	@Override
	public void deleteSupport ( int id ) {
		Support sup = entityManager.find (Support.class, id);
		entityManager.remove (sup);
	}

	@Override
	public List<Support> getSupports () {
		Query query = entityManager.createQuery ("from Support");
		return query.getResultList ();
	}

	@Override
	public Support getSupport ( int id ) {
		return entityManager.find (Support.class, id);
	}

	public Utilisateur ajoutUtilisateur ( Utilisateur uti ) {
		entityManager.persist (uti);
		return uti;
	}

	@Override
	public void deleteUtilisateur ( int id ) {
		Utilisateur uti = entityManager.find (Utilisateur.class, id);
		entityManager.remove (uti);
	}

	@Override
	public List<Utilisateur> getUtilisateurs () {
		Query query = entityManager.createQuery ("from Utilisateur");
		return query.getResultList ();
	}

	@Override
	public Utilisateur getUtilisateur ( int id ) {
		return entityManager.find (Utilisateur.class, id);
	}

	@Override
	public Utilisateur getUtilisateurbyLogin ( String login ) {
		String MaClause = "from Utilisateur where login='" + login + "'";
		Query query = entityManager.createQuery (MaClause);
		if (query.getResultList ().size () > 0)
			return (Utilisateur) query.getResultList ().get (0);

		return null;
	}

	@Override
	public Utilisateur IdentificationUtilisateur ( String login, String mdp ) {

		String MaClause = "from Utilisateur where login='" + login + "' and mdp='" + mdp + "'";
		Query query = entityManager.createQuery (MaClause);
		if (query.getResultList ().size () > 0)
			return (Utilisateur) query.getResultList ().get (0);

		return null;
	}

	@Override
	public List<Historique> getHistorique ( int id_uti ) {
		String MaClause = "from Historique where utilisateur_id='" + id_uti + "'";
		System.out.println ("MaClause  :" + MaClause);
		Query query = entityManager.createQuery (MaClause);
		if (query.getResultList ().size () > 0)
			return query.getResultList ();

		return null;
	}

}
