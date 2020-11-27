package Métier;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Connection.DataBase.ConnectionB;

public class Billet {

	private int IDBillet;
	private int IDResevation;
	private int IDClient;
	private double PrixTotale;
	
	public Billet(int iDBillet, int iDResevation, int iDClient, double prixTotale) {
		IDBillet = iDBillet;
		IDResevation = iDResevation;
		IDClient = iDClient;
		PrixTotale = prixTotale;
	}

	public int getIDBillet() {
		return IDBillet;
	}

	public void setIDBillet(int iDBillet) {
		IDBillet = iDBillet;
	}

	public int getIDResevation() {
		return IDResevation;
	}

	public void setIDResevation(int iDResevation) {
		IDResevation = iDResevation;
	}

	public int getIDClient() {
		return IDClient;
	}

	public void setIDClient(int iDClient) {
		IDClient = iDClient;
	}

	public double getPrixTotale() {
		return PrixTotale;
	}

	public void setPrixTotale(double prixTotale) {
		PrixTotale = prixTotale;
	}
	
	public static ArrayList<Billet> EnsembleBillets(int id) throws Exception{
		ArrayList<Billet> liste = new ArrayList<Billet>();
		Connection conn=(Connection) ConnectionB.EtablissementConn();
		PreparedStatement Billet =(PreparedStatement) conn.prepareStatement("SELECT * FROM tbillet WHERE ID_Client=?");
		Billet.setInt(1, id);
		ResultSet rs=Billet.executeQuery();
		
		while(rs.next()) {
			liste.add(new Billet(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4)));
		}
		
		return liste;
	}
	
}
