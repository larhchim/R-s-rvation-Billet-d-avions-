package Connection.DataBase;

import java.sql.*;

public class ConnectionB 
{

private static String url="jdbc:mysql://localhost:3306/reservationbilletsavions";
private static String utilisateur="root";
private static String password="";
private static Connection conn;

public static Connection EtablissementConn() throws Exception
{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(url,utilisateur,password);
	return conn;
}


public static String getUrl() {
	return url;
}


public static void setUrl(String url) {
	ConnectionB.url = url;
}


public static String getUtilisateur() {
	return utilisateur;
}


public static void setUtilisateur(String utilisateur) {
	ConnectionB.utilisateur = utilisateur;
}


public static String getPassword() {
	return password;
}


public static void setPassword(String password) {
	ConnectionB.password = password;
}

	
}
