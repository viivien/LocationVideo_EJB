package fr.epsi.location.pojo;



public class Categorie implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8507463116713421990L;
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
