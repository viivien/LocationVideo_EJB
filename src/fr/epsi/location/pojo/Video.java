package fr.epsi.location.pojo;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table ( name = "video" )
public class Video implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 602800370154442392L;
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO )
	@Column ( name = "vid_id", nullable = false )
	private int					id;
	@Column ( name = "vid_titre", nullable = false )
	private String				titre;
	@Column ( name = "vid_duree", nullable = false )
	private int					duree;
	@Column ( name = "vid_datesortie", nullable = false )
	private DateTime				dateSortie;
	@Column ( name = "vid_synopsis", nullable = false )
	private String				synopsis;
	@Column ( name = "vid_prix", nullable = false )
	private float				prix;
	@OneToOne
	@JoinColumn(name="vid_idcat")
	private Categorie			categorie;

	public Video(String titre, int duree, DateTime dateSortie, String synopsis, Categorie categorie) {
		super ();
		this.titre = titre;
		this.duree = duree;
		this.dateSortie = dateSortie;
		this.synopsis = synopsis;
		this.categorie = categorie;
	}

	public Video() {

	}

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

	public DateTime getDateSortie () {
		return dateSortie;
	}

	public void setDateSortie ( DateTime dateSortie ) {
		this.dateSortie = dateSortie;
	}

	public String getSynopsis () {
		return synopsis;
	}

	public void setSynopsis ( String synopsis ) {
		this.synopsis = synopsis;
	}

	public float getPrix () {
		return prix;
	}

	public void setPrix ( float prix ) {
		this.prix = prix;
	}
	
	@OneToOne
	public Categorie getCategorie () {
		return categorie;
	}

	public void setCategorie ( Categorie categorie ) {
		this.categorie = categorie;
	}
}
