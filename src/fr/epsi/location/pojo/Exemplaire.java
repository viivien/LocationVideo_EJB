package fr.epsi.location.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table ( name = "exemplaire" )
public class Exemplaire implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8548195354813978213L;
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO )
	@Column ( name = "exe_id", nullable = false )
	private int					id;
	@Column ( name = "exe_dateachat", nullable = false )
	private Date				dateAchat;
	@Column ( name = "exe_idvideo", nullable = false )
	private Video				video;

	public Exemplaire(Date dateAchat, Video video) {
		super ();
		this.dateAchat = dateAchat;
		this.video = video;
	}

	public Exemplaire() {

	}

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

	@OneToOne
	public Video getVideo () {
		return video;
	}

	public void setVideo ( Video video ) {
		this.video = video;
	}

}
