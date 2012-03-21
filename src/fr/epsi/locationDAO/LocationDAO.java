package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import fr.epsi.location.Client;
import fr.epsi.location.Location;

public class LocationDAO {
	
	public Location getLocation(DataSource ds, int idLocation) {
		// préparation des ressources utilisées
		Connection conn = null;
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String request 	= "select * from LOCATION WHERE loc_id = " + idLocation;
		try {
			//exécution de la requête
			conn 	= ds.getConnection();
			stmt 	= conn.createStatement();
			rs 		= stmt.executeQuery(request);
			
			//parcours du résultat
			if(rs.next()) {
				Location location = new Location();
				location.setId(rs.getInt("loc_id"));
				location.setDateLocation(rs.getDate("loc_date"));
				location.setPrixLocation(rs.getDouble("loc_prix"));
				location.setNbHeuresLocation(rs.getInt("loc_nbHeureLocation"));
				
				return location;
			}
			
		} 
		catch (SQLException e) {
			System.out.println("exception lors de l'exécution de la requête:"+e.getMessage());
		} 
		finally {
			//fermeture des ressources
			try {
				if (rs 		!= null) {
					rs.close();
				}
				if (stmt 	!= null) {
					stmt.close();
				}
				if (conn 	!= null) {
					conn.close();
				}
			} 
			catch (SQLException e) {
				System.out.println("exception lors de la fermeture des ressources:"+e.getMessage());
			}
		}
		return null;
	}

}
