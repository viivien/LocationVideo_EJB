package fr.epsi.locationDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.location.pojo.Client;

public class ClientDAO {

	private Connection			connection;
	private Statement			stmt;
	private ResultSet			rs;
	private PreparedStatement	ps;

	public Client getClient ( int idClient ) {
		// préparation des ressources utilisées
		String request = "SELECT * FROM CLIENT WHERE cli_id = " + idClient;
		try {
			// exécution de la requête
			connection = Connecteur.openConnection ();
			stmt = connection.createStatement ();
			rs = stmt.executeQuery (request);

			// parcours du résultat
			if (rs.next ()) {
				Client client = new Client ();
				client.setId (rs.getInt ("cli_id"));
				client.setNom (rs.getString ("cli_nom"));
				client.setPrenom (rs.getString ("cli_prenom"));
				client.setDateDeNaissance (rs.getDate ("cli_datedenaissance"));
				client.setAdresse (rs.getString ("cli_adresse"));
				client.setVille (rs.getString ("cli_ville"));
				client.setCodePostal (rs.getString ("cli_cp"));
				client.setTelephone (rs.getString ("cli_telephone"));
				client.setMail (rs.getString ("cli_email"));
				client.setPassword (rs.getString ("cli_password"));
				return client;
			}

		}
		catch (SQLException e) {
			System.out.println ("exception lors de l'exécution de la requête:" + e.getMessage ());
		}
		finally {
			Connecteur.closeConnection (connection, stmt, rs);
		}
		return null;
	}

	public List<Client> getListeClients () {

		List<Client> listeClients = new ArrayList<Client> ();
		String requete = "SELECT * FROM CLIENT";
		try {
			connection = Connecteur.openConnection ();
			stmt = connection.createStatement ();
			rs = stmt.executeQuery (requete);

			while (rs.next ()) {
				Client client = new Client ();
				client.setId (rs.getInt ("cli_id"));
				client.setNom (rs.getString ("cli_nom"));
				client.setPrenom (rs.getString ("cli_prenom"));
				client.setDateDeNaissance (rs.getDate ("cli_datedenaissance"));
				client.setAdresse (rs.getString ("cli_adresse"));
				client.setVille (rs.getString ("cli_ville"));
				client.setCodePostal (rs.getString ("cli_cp"));
				client.setTelephone (rs.getString ("cli_telephone"));
				client.setMail (rs.getString ("cli_email"));
				client.setPassword (rs.getString ("cli_password"));

				listeClients.add (client);
			}

		}
		catch (SQLException e) {
			System.out.println ("Exception lors de l'exécution de la requête : " + e.getMessage ());
		}
		finally {
			Connecteur.closeConnection (connection, stmt, rs);
		}
		return listeClients;
	}

	public void insereClient ( Client client ) {
		// préparation des ressources utilisées
		String request = "INSERT INTO CLIENT (cli_nom, cli_prenom, cli_datedenaissance, "
				+ "cli_adresse, cli_ville, cli_cp, cli_pays, cli_telephone, cli_mail, cli_password) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			// exécution de la requête d'insertion
			connection = Connecteur.openConnection ();
			ps = connection.prepareStatement (request);
			ps.setString (1, client.getNom ());
			ps.setString (2, client.getPrenom ());
			ps.setDate (3, (Date) client.getDateDeNaissance ());
			ps.setString (4, client.getAdresse ());
			ps.setString (5, client.getVille ());
			ps.setString (6, client.getCodePostal ());
			ps.setString (8, client.getTelephone ());
			ps.setString (9, client.getMail ());
			ps.setString (10, client.getPassword ());
			ps.executeUpdate ();

		}
		catch (SQLException e) {
			System.out.println ("exception lors de l'exécution de la requête:" + e.getMessage ());
		}
		finally {
			Connecteur.closeConnection (connection, ps);
		}
	}

	public void modifierClient ( Client client, int idClient ) {
		String requete = "UPDATE CLIENT SET cli_nom = ?, cli_prenom = ?, cli_datedenaissance = ?, "
				+ "cli_adresse = ?, cli_ville = ?, cli_cp = ?, cli_pays = ?, cli_telephone = ?,"
				+ " cli_mail = ?, cli_password = ? WHERE cli_id = " + idClient;
		try {
			connection = Connecteur.openConnection ();
			ps = connection.prepareStatement (requete);
			ps.setString (1, client.getNom ());
			ps.setString (2, client.getPrenom ());
			ps.setDate (3, (Date) client.getDateDeNaissance ());
			ps.setString (4, client.getAdresse ());
			ps.setString (5, client.getVille ());
			ps.setString (6, client.getCodePostal ());
			ps.setString (8, client.getTelephone ());
			ps.setString (9, client.getMail ());
			ps.setString (10, client.getPassword ());
			ps.executeUpdate ();

		}
		catch (SQLException e) {
			System.out.println ("Exception lors de l'exécution de la requête : " + e.getMessage ());
		}
		finally {
			Connecteur.closeConnection (connection, ps);
		}
	}

	public void supprimerClient ( int idClient ) {
		String requete = "DELETE FROM CLIENT WHERE cli_id = " + idClient;
		try {
			connection = Connecteur.openConnection ();
			ps = connection.prepareStatement (requete);
			ps.executeUpdate ();

		}
		catch (SQLException e) {
			System.out.println ("Exception lors de l'exécution de la requête : " + e.getMessage ());
		}
		finally {
			Connecteur.closeConnection (connection, ps);
		}
	}
}
