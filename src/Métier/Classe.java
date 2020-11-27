package Métier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Connection.DataBase.ConnectionB;

public class Classe 
{
	private int ID_Classe;
	private String LibelleClasse;
	
	
	public Classe(int iD_Classe, String libelleClasse) 
	{
		ID_Classe = iD_Classe;
		LibelleClasse = libelleClasse;
	}
	

	public static ArrayList<Classe> afficherClasse() throws Exception
	{
		ArrayList<Classe> liste = new ArrayList<>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=(PreparedStatement) conn.prepareStatement(" SELECT * FROM tclasse ");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) 
		  {
			  liste.add(new Classe(rs.getInt(1),rs.getString(2)));
		  }
		return liste;
		
	}


	public int getID_Classe() {
		
		return ID_Classe;
		
	}


	public void setID_Classe(int iD_Classe) {
		
		ID_Classe = iD_Classe;
		
	}


	public String getLibelleClasse() {
		
		return LibelleClasse;
		
	}


	
	public void setLibelleClasse(String libelleClasse) {
		
		LibelleClasse = libelleClasse;
		
	}
	
	

}
