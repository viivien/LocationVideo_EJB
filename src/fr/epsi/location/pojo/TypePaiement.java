package fr.epsi.location.pojo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "typepaiement" )
public class TypePaiement implements Serializable {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO )
	@Column ( name = "typpai_id", nullable = false )
	private int					id;	
	@Column ( name = "typpai_libelle", nullable = false )
	private String				libelle;
	
	public TypePaiement(String typePaiement) {
		libelle = typePaiement;
	}
	
	public TypePaiement() {
		
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
