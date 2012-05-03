package fr.epsi.location.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Video implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 602800370154442392L;
	private int					id;
	private String				titre;
	private int					duree;
	private Date				dateSortie;
	private String				synopsis;
	private Categorie			categorie;

	public Video(String titre, int duree, Date dateSortie, String synopsis, Categorie categorie) {
		super ();
		this.titre = titre;
		this.duree = duree;
		this.dateSortie = dateSortie;
		this.synopsis = synopsis;
		this.categorie = categorie;
	}

	public Video() {

	}

	@Id
	@GeneratedValue
	public int getId () {
		return id;
	}

	public void setId ( int id ) {
		this.id = id;
	}

	public String getTitre () {
		return titre;
	}

	public void setTitre ( String titre ) {
		this.titre = titre;
	}

	public int getDuree () {
		return duree;
	}

	public void setDuree ( int duree ) {
		this.duree = duree;
	}

	public Date getDateSortie () {
		return dateSortie;
	}

	public void setDateSortie ( Date dateSortie ) {
		this.dateSortie = dateSortie;
	}

	public String getSynopsis () {
		return synopsis;
	}

	public void setSynopsis ( String synopsis ) {
		this.synopsis = synopsis;
	}

	public Categorie getCategorie () {
		return categorie;
	}

	public void setCategorie ( Categorie categorie ) {
		this.categorie = categorie;
	}
}
