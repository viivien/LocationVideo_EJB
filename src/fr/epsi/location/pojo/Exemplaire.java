package fr.epsi.location.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

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
	@OneToOne
	@JoinColumn(name="exe_idvideo")
	private Video				video;

	public Exemplaire(DateTime dateAchat, Video video) {
		super ();
		this.setDateAchat(dateAchat);
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

	public DateTime getDateAchat () {
		return new DateTime(dateAchat);
	}

	public void setDateAchat ( DateTime dateAchat ) {
		this.dateAchat = dateAchat.toDate();
	}

	@OneToOne
	public Video getVideo () {
		return video;
	}

	public void setVideo ( Video video ) {
		this.video = video;
	}

}
