package fr.epsi.location.pojo;

import java.sql.Date;

public class Location implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8214238646469550769L;
	private int 		id;
	private Exemplaire 	exemplaire;
	private Date 		dateLocation;
	private double 		prixLocation;
	private int 		nbHeuresLocation;
	private Client		client;
	
	public Location(Exemplaire exemplaire, Date dateLocation, double prixLocation,
			int nbHeuresLocation) {
		super();
		this.exemplaire 		= exemplaire;
		this.dateLocation 		= dateLocation;
		this.prixLocation 		= prixLocation;
		this.nbHeuresLocation 	= nbHeuresLocation;
	}
	public Location() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}
	public Date getDateLocation() {
		return dateLocation;
	}
	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}
	public double getPrixLocation() {
		return prixLocation;
	}
	public void setPrixLocation(double prixLocation) {
		this.prixLocation = prixLocation;
	}
	public int getNbHeuresLocation() {
		return nbHeuresLocation;
	}
	public void setNbHeuresLocation(int nbHeuresLocation) {
		this.nbHeuresLocation = nbHeuresLocation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
