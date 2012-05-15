package fr.epsi.location.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table ( name = "client" )
public class Client implements java.io.Serializable {

	private static final long			serialVersionUID	= -2659391453478238804L;
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO )
	@Column ( name = "cli_id", nullable = false )
	private int							id;
	@Column ( name = "cli_nom", nullable = false )
	private String						nom;
	@Column ( name = "cli_prenom", nullable = false )
	private String						prenom;
	@Column ( name = "cli_datedenaissance", nullable = false )
	private Date						dateDeNaissance;
	@Column ( name = "cli_adresse", nullable = false )
	private String						adresse;
	@Column ( name = "cli_ville", nullable = false )
	private String						ville;
	@Column ( name = "cli_cp", nullable = false )
	private String						codePostal;
	@Column ( name = "cli_telephone", nullable = false )
	private String						telephone;
	@Column ( name = "cli_email", nullable = false )
	private String						email;
	@Column ( name = "cli_password", nullable = false )
	private String						password;
	
	/*
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client", fetch=FetchType.EAGER)
	private List<Location>	listeLocations = new ArrayList<Location>();
	*/
	public Client(String nom, String prenom, Date dateDeNaissance, String adresse, String ville, String codePostal,
			String pays, String telephone, String mail, String password, List<Location> listeLocations) {
		super ();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.email = mail;
		this.password = password;
		//this.listeLocations = listeLocations;
	}

	public Client() {

	}

	public int getId () {
		return id;
	}

	public void setId ( int id ) {
		this.id = id;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword ( String password ) {
		this.password = password;
	}

	public String getNom () {
		return nom;
	}

	public void setNom ( String nom ) {
		this.nom = nom;
	}

	public String getPrenom () {
		return prenom;
	}

	public void setPrenom ( String prenom ) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance () {
		return dateDeNaissance;
	}

	public void setDateDeNaissance ( Date dateDeNaissance ) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAdresse () {
		return adresse;
	}

	public void setAdresse ( String adresse ) {
		this.adresse = adresse;
	}

	public String getVille () {
		return ville;
	}

	public void setVille ( String ville ) {
		this.ville = ville;
	}

	public String getCodePostal () {
		return codePostal;
	}

	public void setCodePostal ( String codePostal ) {
		this.codePostal = codePostal;
	}

	public String getTelephone () {
		return telephone;
	}

	public void setTelephone ( String telephone ) {
		this.telephone = telephone;
	}

	public String getMail () {
		return email;
	}

	public void setMail ( String mail ) {
		this.email = mail;
	}
/*
	public List<Location> getListeLocations () {
		return listeLocations;
	}
	
	public void setListeLocations ( List<Location> listeLocations ) {
		this.listeLocations = listeLocations;
	}
	*/
	/*public HashMap<Integer, Location> getListeLocations () {
		return listeLocations;
	}

	public void setListeLocations ( HashMap<Integer, Location> listeLocations ) {
		this.listeLocations = listeLocations;
	}*/
}
