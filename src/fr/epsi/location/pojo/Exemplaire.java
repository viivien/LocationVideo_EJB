package fr.epsi.location.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exemplaire implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8548195354813978213L;
	private int					id;
	private Date				dateAchat;
	private Video				video;

	public Exemplaire(Date dateAchat, Video video) {
		super ();
		this.dateAchat = dateAchat;
		this.video = video;
	}

	public Exemplaire() {

	}

	@Id
	@GeneratedValue
	public int getId () {
		return id;
	}

	public void setId ( int id ) {
		this.id = id;
	}

	public Date getDateAchat () {
		return dateAchat;
	}

	public void setDateAchat ( Date dateAchat ) {
		this.dateAchat = dateAchat;
	}

	public Video getVideo () {
		return video;
	}

	public void setVideo ( Video video ) {
		this.video = video;
	}

}
