package fr.epsi.location;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
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
	
	@Id
	@GeneratedValue
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
