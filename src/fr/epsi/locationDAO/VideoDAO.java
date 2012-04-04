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

public class VideoDAO {
	
	private Connection connection;
	
	public Video getVideo(DataSource ds, int idVideo) {
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String request 	= "SELECT * FROM VIDEO WHERE vid_id = " + idVideo;
		try {
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(request);
			
			if(rs.next()) {
				CategorieDAO DAOcateg 	= new CategorieDAO ();
				Video video 			= new Video (
						rs.getString("vid_titre"),
						rs.getInt("vid_duree"),
						rs.getDate("vid_dateSortie"),
						rs.getString("vid_synopsis"),
						DAOcateg.getCategorie(ds, rs.getInt("vid_idcat"))
				);
				video.setId(idVideo);
				return video;
			}
			
		} 
		catch (SQLException e) {
			System.out.println("exception lors de l'execution de la requete:"+e.getMessage());
		} 
		finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return null;
	}
	
	public void ajouterVideo(DataSource ds, Video video) {
		
		PreparedStatement ps = null;
		String requete 	= "INSERT INTO VIDEO (exe_dateachat, exe_idvideo) VALUES(?,?)";
		try {
			connection	= ds.getConnection();
			ps 			= connection.prepareStatement(requete);
			ps.setString (1, video.getTitre());
			ps.setInt (2, video.getDuree());
			ps.setDate (3, (Date) video.getDateSortie());
			ps.setString (4, video.getSynopsis());
			ps.setInt(5, video.getCategorie().getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, ps);
		}
	}
	
	public List<Video> getListeVideos(DataSource ds) {
		
		List<Video> listeVideos = new ArrayList<Video>();
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String requete 	= "SELECT * FROM VIDEO";
		
		try {
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(requete);
			
			while(rs.next()) {
				CategorieDAO DAOcateg 	= new CategorieDAO ();
				Video video 			= new Video (
						rs.getString("vid_titre"),
						rs.getInt("vid_duree"),
						rs.getDate("vid_dateSortie"),
						rs.getString("vid_synopsis"),
						DAOcateg.getCategorie(ds, rs.getInt("vid_idcat"))
				);
				video.setId(rs.getInt("vid_id"));

				listeVideos.add(video);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return listeVideos;
	}
}
