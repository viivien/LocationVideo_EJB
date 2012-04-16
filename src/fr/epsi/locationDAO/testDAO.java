package fr.epsi.locationDAO;

import java.sql.*;

public class testDAO {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/LocationVideo";
	   private static final String login = "locationvideo";
	   private static final String password = "locationvideo";
	   private Connection con;
	   
	   public testDAO()
	   {
	       try {
	           Class.forName("com.mysql.jdbc.Driver");
	           con = DriverManager.getConnection(url, login, password);
	       } catch (ClassNotFoundException cnfe) {
	           System.out.println("Le driver n'a pas pu être chargé");
	       } catch (SQLException sqle) {
	           System.out.println("Impossible de se connecter à la base");
	       }
	   }
}
