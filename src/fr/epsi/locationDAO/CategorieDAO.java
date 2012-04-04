package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import fr.epsi.location.*;

public class CategorieDAO {
	
	private Connection connection;
	
	public Categorie getCategorie(DataSource ds, int idCategorie) {
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String request 	= "select * from CATEGORIE where id = " + idCategorie;
		try {
			
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(request);
			
			
			if(rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setId(rs.getInt("cat_id"));
				categorie.setLibelle(rs.getString("cat_libelle"));
				return categorie;
			}
			
		} 
		catch (SQLException e) {
			System.out.println("exception lors de l'ex�cution de la requ�te:"+e.getMessage());
		} 
		finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return null;
	}
}
