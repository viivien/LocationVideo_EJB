package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import fr.epsi.location.Video;

public class VideoDAO {
	
	public Video getVideo(DataSource ds, int idVideo) {
		Connection conn = null;
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String request 	= "select * from VIDEO where v_id = " + idVideo;
		try {
			conn 	= ds.getConnection();
			stmt 	= conn.createStatement();
			rs 		= stmt.executeQuery(request);
			
			if(rs.next()) {
				CategorieDAO DAOcateg = new CategorieDAO();
				Video video = new Video(
						rs.getString("v_titre"),
						rs.getInt("v_duree"),
						rs.getDate("v_dateSortie"),
						rs.getString("v_synopsis"),
						DAOcateg.getCategorie(ds, rs.getInt("v_idcat"))
				);
				
				return video;
			}
			
		} 
		catch (SQLException e) {
			System.out.println("exception lors de l'ex�cution de la requ�te:"+e.getMessage());
		} 
		finally {
			try {
				if (rs 	 != null){  rs.close();}
				if (stmt != null){stmt.close();}
				if (conn != null){conn.close();}
			} 
			catch (SQLException e) {
				System.out.println("exception lors de la fermeture des ressources:"+e.getMessage());
			}
		}
		return null;
	}
}
