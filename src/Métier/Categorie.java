package Métier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Connection.DataBase.ConnectionB;

public class Categorie 
{
	private int ID_Categorie ;
	private String LibelleCategorie;
	private double PourcentageReduction;
	
	public Categorie(int iD_Categorie, String libelleCategorie, double pourcentageReduction) 
	{
		ID_Categorie = iD_Categorie;
		LibelleCategorie = libelleCategorie;
		PourcentageReduction = pourcentageReduction;
	}
	

	public int getID_Categorie() {
		
		return ID_Categorie;
		
	}

	public void setID_Categorie(int iD_Categorie) {
		
		ID_Categorie = iD_Categorie;
		
	}

	public String getLibelleCategorie() {
		
		return LibelleCategorie;
		
	}

	public void setLibelleCategorie(String libelleCategorie) {
		
		LibelleCategorie = libelleCategorie;
		
	}

	public double getPourcentageReduction() {
		
		return PourcentageReduction;
		
	}

	public void setPourcentageReduction(double pourcentageReduction) {
		
		PourcentageReduction = pourcentageReduction;
		
	}
	
	public static void ModifyCategorie(Categorie cat) throws Exception 
	{
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=(PreparedStatement) conn.prepareStatement(" Update tcategorie set LibelleCategorie=? , PourcentageReduction=? WHERE ID_Categorie=? ");
		  ps.setString(1, cat.getLibelleCategorie());
		  ps.setDouble(2, cat.getPourcentageReduction());
		  ps.setInt(3, cat.getID_Categorie());
		  
		  ps.executeUpdate();
		  
	}
	
	public static void AjouterCategorie(String Lib,double Pour) throws Exception{
		 Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=(PreparedStatement) conn.prepareStatement(" insert into tcategorie(LibelleCategorie,PourcentageReduction) values(?,?) ");
		  ps.setString(1, Lib);
		  ps.setDouble(2, Pour);		  
		  ps.executeUpdate();
	}

	public static ArrayList<Categorie> afficherCategorie() throws Exception
	{
		ArrayList<Categorie> liste = new ArrayList<>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=(PreparedStatement) conn.prepareStatement(" SELECT * FROM tcategorie ");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) 
		  {
			  liste.add(new Categorie(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		  }
		return liste;
		
	}
	
	public static ArrayList<Categorie> SELECTCategorie(int id) throws Exception
	{
		ArrayList<Categorie> liste = new ArrayList<>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=(PreparedStatement) conn.prepareStatement(" SELECT * FROM tcategorie WHERE ID_Categorie=? ");
		  ps.setInt(1, id);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) 
		  {
			  liste.add(new Categorie(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		  }
		return liste;
		
	}


	
	
}
