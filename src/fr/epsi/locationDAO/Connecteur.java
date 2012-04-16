package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connecteur {
	
	public static final String url 		= "jdbc:mysql://127.0.0.1:3306/location_video";
	public static final String login 	= "locationvideo";
	public static final String password = "locationvideo";
	
	public static Connection openConnection () {
		try {
           Class.forName("com.mysql.jdbc.Driver");
           return DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException cnfe) {
           System.out.println("Le driver n'a pas pu être chargé");
		} catch (SQLException sqle) {
           System.out.println("Impossible de se connecter à la base");
		}
		return null;
	}
	
	public static void closeConnection (Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} 
		catch (SQLException e) {
			System.out.println("exception lors de la fermeture des ressources:"+e.getMessage());
		}
	}
	
	public static void closeConnection (Connection conn, Statement stmt, ResultSet rs) {
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
}
