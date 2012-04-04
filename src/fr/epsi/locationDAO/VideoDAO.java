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
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	
	
	public Video getVideo(DataSource ds, int idVideo) {
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
	
	public List<Video> getListeVideos(DataSource ds) {
		List<Video> listeVideos = new ArrayList<Video>();
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
	
	public void ajouterVideo(DataSource ds, Video video) {
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
	
	public void modifierVideo (DataSource ds, Video video, int idVideo) {
		String requete 	= 	"UPDATE VIDEO SET vid_titre = ?, vid_duree = ?, vid_dateSortie = ?, " +
							"vid_synopsis = ?, vid_idcat = ? WHERE vid_id = " + idVideo;
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
	
	public void supprimerVideo (DataSource ds, int idVideo) {
		String requete 	= 	"DELETE FROM VIDEO WHERE vid_id = " + idVideo;
		try {
			connection	= ds.getConnection();
			ps 			= connection.prepareStatement(requete);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, ps);
		}
	}
}
