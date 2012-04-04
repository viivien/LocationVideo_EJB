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

import fr.epsi.location.Location;
import fr.epsi.location.Video;

public class LocationDAO {
	
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public Location getLocation(DataSource ds, int idLocation) {
		String requete 	= "SELECT * FROM LOCATION WHERE loc_id = " + idLocation;
		
		try {
				
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(requete);
			
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
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} 
		finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return null;
	}

	public List<Location> getListeLocations(DataSource ds) {
		
		List<Location> listeLocations 	= new ArrayList<Location>();
		String requete 					= "SELECT * FROM LOCATION";
		
		try {
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(requete);
			
			while(rs.next()) {
				Location location = new Location();
				location.setId(rs.getInt("loc_id"));
				location.setDateLocation(rs.getDate("loc_date"));
				location.setPrixLocation(rs.getDouble("loc_prix"));
				location.setNbHeuresLocation(rs.getInt("loc_nbHeureLocation"));
				listeLocations.add(location);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return listeLocations;
	}
	
	public void ajouterLocation(DataSource ds, Location location) {
		
		String requete 			= "INSERT INTO LOCATION(loc_idclient, loc_idvideo, loc_date, loc_prix, loc_nbHeureLocation) VALUES(?,?,?,?,?)";
		try {
			connection 			= ds.getConnection();
			ps 					= connection.prepareStatement(requete);
			ps.setInt(1, location.getClient().getId());
			ps.setInt(2, location.getExemplaire().getId());
			ps.setDate(3, location.getDateLocation());
			ps.setDouble(4, location.getPrixLocation());
			ps.setInt(5, location.getNbHeuresLocation());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, ps);
		}
	}
	
	public void modifierLocation (DataSource ds, Location location, int idLocation) {
		String requete 	= 	"UPDATE LOCATION SET loc_idclient = ?, loc_idvideo = ?, loc_date = ?, loc_prix = ?," +
							" loc_nbHeureLocation = ? WHERE loc_id = " + idLocation;
		try {
			connection	= ds.getConnection();
			ps 			= connection.prepareStatement(requete);
			ps.setInt(1, location.getClient().getId());
			ps.setInt(2, location.getExemplaire().getId());
			ps.setDate(3, location.getDateLocation());
			ps.setDouble(4, location.getPrixLocation());
			ps.setInt(5, location.getNbHeuresLocation());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, ps);
		}
	}
	
	public void supprimerLocation (DataSource ds, int idLocation) {
		String requete 	= 	"DELETE FROM LOCATION WHERE loc_id = " + idLocation;
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
