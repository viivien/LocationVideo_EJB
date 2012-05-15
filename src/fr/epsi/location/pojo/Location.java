package fr.epsi.location.pojo;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table ( name = "location" )
public class Location implements java.io.Serializable {

	private static final long	serialVersionUID	= 8214238646469550769L;
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO )
	@Column ( name = "loc_id", nullable = false )
	private int					id;	
	@Column ( name = "loc_date", nullable = false )
	private Date				dateLocation;
	@Column ( name = "loc_prix", nullable = false )
	private double				prixLocation;
	@Column ( name = "loc_nbHeureLocation", nullable = false )
	private int					nbHeuresLocation;
	
	private Exemplaire			exemplaire;
	private Client				client;

	public Location(Exemplaire exemplaire, Date dateLocation, double prixLocation, int nbHeuresLocation) {
		super ();
		this.exemplaire = exemplaire;
		this.dateLocation = dateLocation;
		this.prixLocation = prixLocation;
		this.nbHeuresLocation = nbHeuresLocation;
	}

	public Location() {

	}

	public int getId () {
		return id;
	}

	public void setId ( int id ) {
		this.id = id;
	}

	@OneToOne
	public Exemplaire getExemplaire () {
		return exemplaire;
	}

	public void setExemplaire ( Exemplaire exemplaire ) {
		this.exemplaire = exemplaire;
	}

	public Date getDateLocation () {
		return dateLocation;
	}

	public void setDateLocation ( Date dateLocation ) {
		this.dateLocation = dateLocation;
	}

	public double getPrixLocation () {
		return prixLocation;
	}

	public void setPrixLocation ( double prixLocation ) {
		this.prixLocation = prixLocation;
	}

	public int getNbHeuresLocation () {
		return nbHeuresLocation;
	}

	public void setNbHeuresLocation ( int nbHeuresLocation ) {
		this.nbHeuresLocation = nbHeuresLocation;
	}
	
	@OneToOne
	public Client getClient () {
		return client;
	}

	public void setClient ( Client client ) {
		this.client = client;
	}
}
