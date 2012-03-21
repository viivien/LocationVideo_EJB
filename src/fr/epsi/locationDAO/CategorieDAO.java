package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import fr.epsi.location.*;

public class CategorieDAO {

	public Categorie getCategorie(DataSource ds, int idCategorie) {
		
		Connection conn = null;
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String request 	= "select * from CATEGORIE where id = " + idCategorie;
		try {
			
			conn 	= ds.getConnection();
			stmt 	= conn.createStatement();
			rs 		= stmt.executeQuery(request);
			
			
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
