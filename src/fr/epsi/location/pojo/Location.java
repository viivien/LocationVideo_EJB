package fr.epsi.location.pojo;

import java.util.Date;

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

import org.joda.time.DateTime;

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
	@OneToOne
	@JoinColumn(name="loc_idexemplaire")
	private Exemplaire			exemplaire;
	@OneToOne
	@JoinColumn(name="loc_idclient")
	private Client				client;
	@OneToOne
	@JoinColumn(name="loc_idtyppai")
	private TypePaiement		typePaiement;
	
	public Location(Exemplaire exemplaire, DateTime dateLocation, double prixLocation, int nbHeuresLocation, TypePaiement typePaiement) {
		super ();
		this.exemplaire = exemplaire;
		this.setDateLocation(dateLocation);
		this.prixLocation = prixLocation;
		this.nbHeuresLocation = nbHeuresLocation;
		this.typePaiement = typePaiement;
	}

	public Location() {

	}

	public int getId () {
		return id;
	}

	public void setId ( int id ) {
		this.id = id;
	}

	public Exemplaire getExemplaire () {
		return exemplaire;
	}

	public void setExemplaire ( Exemplaire exemplaire ) {
		this.exemplaire = exemplaire;
	}

	public DateTime getDateLocation () {
		return new DateTime(dateLocation);
	}

	public void setDateLocation ( DateTime dateLocation ) {
		this.dateLocation = dateLocation.toDate();
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
	
	public Client getClient () {
		return client;
	}

	public void setClient ( Client client ) {
		this.client = client;
	}
	
	public TypePaiement getTypePaiement() {
		return typePaiement;
	}
	
	public void setTypePaiement ( TypePaiement typePaiement ) {
		this.typePaiement = typePaiement;
	}
}
