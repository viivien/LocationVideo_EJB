package fr.epsi.location.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "categorie" )
public class Categorie implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8507463116713421990L;
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO )
	@Column ( name = "cat_id", nullable = false )
	private int					id;
	@Column ( name = "cat_libelle", nullable = false )
	private String				libelle;

	public Categorie() {

	}

	public Categorie(String libelle) {
		super ();
		this.libelle = libelle;
	}

	public int getId () {
		return id;
	}

	public void setId ( int id ) {
		this.id = id;
	}

	public String getLibelle () {
		return libelle;
	}

	public void setLibelle ( String libelle ) {
		this.libelle = libelle;
	}
}
