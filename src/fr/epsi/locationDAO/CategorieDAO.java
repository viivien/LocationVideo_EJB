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

import fr.epsi.location.*;

public class CategorieDAO {
	
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	
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
			System.out.println("exception lors de l'execution de la requete:"+e.getMessage());
		} 
		finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return null;
	}
	
	public List<Categorie> getListeCategories(DataSource ds) {
		List<Categorie> listeCategories = new ArrayList<Categorie>();
		String requete 	= "SELECT * FROM CATEGORIE";
		
		try {
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(requete);
			
			while(rs.next()) {
				Categorie categorie = new Categorie (
						rs.getString("cat_libelle")
				);
				categorie.setId(rs.getInt("cat_id"));

				listeCategories.add(categorie);
			}
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, stmt, rs);
		}
		return listeCategories;
	}
	
	public void ajouterCategorie(DataSource ds, Categorie categorie) {
		String requete 	= "INSERT INTO CATEGORIE (cat_libelle) VALUES(?)";
		try {
			connection	= ds.getConnection();
			ps 			= connection.prepareStatement(requete);
			ps.setString (1, categorie.getLibelle());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, ps);
		}
	}
	
	public void modifierCategorie (DataSource ds, Categorie categorie, int idCategorie) {
		String requete 	= 	"UPDATE CATEGORIE SET cat_libelle = ? WHERE cat_id = " + idCategorie;
		try {
			connection	= ds.getConnection();
			ps 			= connection.prepareStatement(requete);
			ps.setString (1, categorie.getLibelle());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception lors de l'exécution de la requête : "+e.getMessage());
		} finally {
			Connecteur.closeConnection(connection, ps);
		}
	}
	
	public void supprimerCategorie (DataSource ds, int idCategorie) {
		String requete 	= 	"DELETE FROM CATEGORIE WHERE cat_id = " + idCategorie;
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
