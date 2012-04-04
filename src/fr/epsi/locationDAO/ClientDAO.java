package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import fr.epsi.location.Client;

public class ClientDAO {
	
	private Connection connection;
	
	public Client getClient(DataSource ds, int idClient) {
		// pr�paration des ressources utilis�es
		Statement stmt 	= null;
		ResultSet rs 	= null;
		String request 	= "select * from CLIENT where id = " + idClient;
		try {
			//ex�cution de la requ�te
			connection 	= ds.getConnection();
			stmt 		= connection.createStatement();
			rs 			= stmt.executeQuery(request);
			
			//parcours du r�sultat
			if(rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt("cli_id"));
				client.setNom(rs.getString("cli_nom"));
				client.setPrenom(rs.getString("cli_prenom"));
				client.setDateDeNaissance(rs.getDate("cli_datedenaissance"));
				client.setAdresse(rs.getString("cli_adresse"));
				client.setVille(rs.getString("cli_ville"));
				client.setCodePostal(rs.getString("cli_cp"));
				client.setTelephone(rs.getString("cli_telephone"));
				client.setMail(rs.getString("cli_email"));
				client.setNom(rs.getString("cli_nom"));
				client.setPassword(rs.getString("cli_password"));
				return client;
			}
			
		} 
		catch (SQLException e) {
			System.out.println("exception lors de l'ex�cution de la requ�te:"+e.getMessage());
		} 
		finally {
			Connecteur.closeConnection (connection, stmt, rs);
		}
		return null;
	}
	
	public void insereClient(DataSource ds, Client client) {
		// pr�paration des ressources utilis�es
		PreparedStatement ps 	= null;
		String request 			= 	"insert into CLIENT (cli_nom, cli_prenom, cli_datedenaissance, " +
									"cli_adresse, cli_ville, cli_cp, cli_pays, cli_telephone, cli_mail, cli_password) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			//ex�cution de la requ�te d'insertion
			connection 	= ds.getConnection();
			ps 			= connection.prepareStatement(request);
			ps.setString(1, client.getNom());
			ps.setString(1, client.getPrenom());
			ps.setDate(1, 	(Date) client.getDateDeNaissance());
			ps.setString(1, client.getAdresse());
			ps.setString(1, client.getVille());
			ps.setString(1, client.getCodePostal());
			ps.setString(1, client.getPays());
			ps.setString(1, client.getTelephone());
			ps.setString(1, client.getMail());
			ps.setString(1, client.getPassword());
			ps.executeUpdate();
			
		} 
		catch (SQLException e) {
			System.out.println("exception lors de l'ex�cution de la requ�te:"+e.getMessage());
		} 
		finally {
			Connecteur.closeConnection (connection, ps);
		}
	}
}
