package fr.epsi.location;

import java.util.Date;
import java.util.HashMap;

public class Client {
	
	private int 	id;
	private String 	nom;
	private String 	prenom;
	private Date 	dateDeNaissance;
	private String 	adresse;
	private String 	ville;
	private String 	codePostal;
	private String 	pays;
	private String 	telephone;
	private String 	mail;
	private String 	password;
	
	private HashMap <Integer, Location> listeLocations;
	
	
	public Client(String nom, String prenom, Date dateDeNaissance,
			String adresse, String ville, String codePostal, String pays,
			String telephone, String mail, String password,
			HashMap<Integer, Location> listeLocations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
		this.telephone = telephone;
		this.mail = mail;
		this.password = password;
		this.listeLocations = listeLocations;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HashMap<Integer, Location> getListeLocations() {
		return listeLocations;
	}
	public void setListeLocations(HashMap<Integer, Location> listeLocations) {
		this.listeLocations = listeLocations;
	}
}
