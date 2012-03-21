package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public void ajouterLocation(DataSource ds, Location location) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String request 	= "INSERT INTO LOCATION(loc_idclient, loc_idvideo, loc_date, loc_prix, loc_nbHeureLocation) VALUES(?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(request);
			ps.setInt(1, location.getClient().getId());
			ps.setInt(2, location.getVideo().getId());
			ps.setDate(3, location.getDateLocation());
			ps.setDouble(4, location.getPrixLocation());
			ps.setInt(5, location.getNbHeuresLocation());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("exception lors de l'exécution de la requête:"+e.getMessage());
		} finally {
			//fermeture des ressources
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("exception lors de la fermeture des ressources:"+e.getMessage());
			}
		}
	}
}
