package fr.epsi.location;

public class Categorie {
	
	private int 	id;
	private String 	libelle;

	
	public Categorie() {
		
	}
	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
