package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connecteur {
	
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
