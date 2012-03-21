package fr.epsi.location;

import java.util.Date;

public class Location {
	private int 	id;
	private Video 	video;
	private Date 	dateLocation;
	private double 	prixLocation;
	private int 	nbHeuresLocation;
	
	public Location(Video video, Date dateLocation, double prixLocation,
			int nbHeuresLocation) {
		super();
		this.video = video;
		this.dateLocation = dateLocation;
		this.prixLocation = prixLocation;
		this.nbHeuresLocation = nbHeuresLocation;
	}
	public Location() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
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
	
}
