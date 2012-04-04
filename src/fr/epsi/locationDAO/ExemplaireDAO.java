package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.epsi.location.Exemplaire;
import fr.epsi.location.Video;

public class ExemplaireDAO {
	
	private Connection connection;
	
	public Exemplaire getExemplaire(DataSource ds, int idExemplaire) {
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String requete 	= "SELECT * FROM EXEMPLAIRE WHERE exe_id = " + idExemplaire;
		
		try {
				
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(requete);
			
			if(rs.next()) {
				Exemplaire exemplaire 	= new Exemplaire();
				exemplaire.setId(rs.getInt("exe_id"));
				exemplaire.setDateAchat(rs.getDate("exe_dateachat"));
				VideoDAO video 			= new VideoDAO ();
				exemplaire.setVideo(video.getVideo(ds, rs.getInt("exe_idvideo")));
				return exemplaire;
			}
		} 
		catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} 
		finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return null;
	}

	public void ajouterExemplaire(DataSource ds, Exemplaire exemplaire) {
		
		PreparedStatement ps = null;
		String requete 	= "INSERT INTO EXEMPLAIRE(exe_dateachat, exe_idvideo) VALUES(?,?)";
		try {
			connection	= ds.getConnection();
			ps 			= connection.prepareStatement(requete);
			ps.setDate(1, (Date) exemplaire.getDateAchat());
			ps.setInt(2, exemplaire.getVideo().getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, ps);
		}
	}
	
	public List<Exemplaire> getListeExemplaires(DataSource ds) {
		
		List<Exemplaire> listeExemplaires = new ArrayList<Exemplaire>();
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String requete 	= "SELECT * FROM EXEMPLAIRE";
		
		try {
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(requete);
			
			while(rs.next()) {
				Exemplaire exemplaire 	= new Exemplaire();
				exemplaire.setId(rs.getInt("exe_id"));
				exemplaire.setDateAchat(rs.getDate("exe_dateachat"));
				VideoDAO video 			= new VideoDAO ();
				exemplaire.setVideo(video.getVideo(ds, rs.getInt("exe_idvideo")));
				listeExemplaires.add(exemplaire);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return listeExemplaires;
	}
}
