package Métier;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

import Connection.DataBase.ConnectionB;

public class Admin 
{
	private String NomAdmin;
	private String PrenomAdmin;
	private String LoginAdmin;
	private String PasswordAdmin;
	
	public Admin(String nomAdmin, String prenomAdmin, String loginAdmin, String passwordAdmin)
	{
		
		this.setLoginAdmin(loginAdmin);
		this.setNomAdmin(nomAdmin);
		this.setPasswordAdmin(passwordAdmin);
		this.setPrenomAdmin(prenomAdmin);
		
	}

	public String getNomAdmin() {
		
		return NomAdmin;
		
	}

	public void setNomAdmin(String nomAdmin) {
		
		NomAdmin = nomAdmin;
		
	}

	public String getPrenomAdmin() {
		
		return PrenomAdmin;
		
	}

	public void setPrenomAdmin(String prenomAdmin) {
		
		PrenomAdmin = prenomAdmin;
		
	}

	public String getLoginAdmin() {
		
		return LoginAdmin;
		
	}

	public void setLoginAdmin(String loginAdmin) {
		
		LoginAdmin = loginAdmin;
		
	}

	public String getPasswordAdmin() {
		
		return PasswordAdmin;
		
	}

	public void setPasswordAdmin(String passwordAdmin) {
		
		PasswordAdmin = passwordAdmin;
		
	}
	
	
	public static void ModifyAdmin(Admin ad,int id) throws Exception 
	{
		
		Connection conn=ConnectionB.EtablissementConn();
		
		PreparedStatement ps =conn.prepareStatement(" Update tadmin set NomAdmin=? , PrenomAdmin=? , LoginAdmin=? , PasswordAdmin=? Where ID_Admin=?  ");
		ps.setString(1, ad.getNomAdmin());
		ps.setString(2, ad.getPrenomAdmin());
		ps.setString(3, ad.getLoginAdmin());
		ps.setString(4, ad.getPasswordAdmin());
		ps.setInt(5, id);

		ps.executeUpdate();
	}
	

	
	public static ArrayList<StatisquesClient> Statistiques() throws Exception
	{
		ArrayList<StatisquesClient> liste = new ArrayList<>();
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps = conn.prepareStatement("SELECT treservation.ID_Client,treservation.NomPersonne,"
				+ "treservation.PrenomPersonne,tvol.heureDepart,tvol.heureArrivee,treservation.VilleDepart,"
				+ "treservation.VilleArrivee,treservation.DateDepart,tavion.NomAvion From treservation,tvol,"
				+ "ttrajet,tavion WHERE tvol.ID_Vol=treservation.ID_Vol and tvol.ID_Trajet=ttrajet.ID_Trajet "
				+ "and tvol.ID_Avion=tavion.ID_Avion"
				+ " group by treservation.ID_Client,treservation.NomPersonne,treservation.ID_Reservation");
        ResultSet rd =ps.executeQuery();
        while(rd.next()) 
        {
        	String a=String.valueOf(rd.getTime(4));
        	String b=String.valueOf(rd.getTime(5));
        	liste.add(   new StatisquesClient(  rd.getInt(1),rd.getString(2),rd.getString(3),a,b,rd.getString(6),rd.getString(7),rd.getDate(8),rd.getString(9)  ) );
        }
		
        return liste;
	}

	
	
	
	
	  public static ArrayList<Avion> afficherAvion() throws Exception 
	  {
		  
		  ArrayList<Avion> liste = new ArrayList<Avion>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=conn.prepareStatement(" SELECT * FROM tavion ");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) 
		  {
		

			  liste.add(new Avion(rs.getInt(1),rs.getDouble(2), rs.getDouble(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
			  
			  
		  }
		return liste;
        	
        	
       }
	  
	  
	  
	  
	  
	  public static void ajouterAvion(Avion e) throws Exception 
	  {
		  Avion.Ajouter(e);
	  }
	  
	  
	  
	  
	  
	  public static void ModifierAvion(Avion av) throws Exception 
	  {
		  Avion.Modifier(av);
	  }
	  
	  
	  
	  
	  public static void SupprimerAvion(int id) throws Exception 
	  {
		  Avion.Supprimer(id);
	  }
	  
	  
	  
	  
	  public static void ModifierEtatAvion(int id , String chaine) throws Exception 
	  {
		  Avion.ModifyState(id, chaine);
	  }
	  
	  
	  
	  
	  public static ArrayList<Client> afficherClients() throws Exception 
	  {
		  ArrayList<Client> liste = new ArrayList<Client>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=conn.prepareStatement(" SELECT * FROM tclient ");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) {
		

          liste.add(new Client(rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
          
			  
		  }
		return liste;
        	
		  
	  }
	  
	  public static ArrayList<Reservationbis> afficherReservation() throws Exception
	  {
		  ArrayList<Reservationbis> liste = new ArrayList<Reservationbis>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=conn.prepareStatement(" SELECT * FROM treservation ");
		  ResultSet rt=ps.executeQuery();
		  
		  while(rt.next()) 
		  {
			  
		   liste.add(new Reservationbis(rt.getInt(1),rt.getString(4), rt.getString(5), rt.getDate(6), rt.getDate(12), rt.getTime("heureDepart").getHours(),rt.getTime("heureDepart").getMinutes() , rt.getTime("heureDepart").getSeconds(), rt.getString(8), rt.getString(10),rt.getString(11),rt.getInt(2),rt.getInt(3),rt.getDate(9),rt.getString(14) ));

		  }
	

		  return liste;
		  
	  }
	  
	  public static void main(String [] args) throws Exception {
		  
		  ArrayList<Reservationbis> cat =Admin.afficherReservation();
		  
		  for (int i = 0; i < cat.size(); i++) {
			  
			  System.out.println(cat.get(i).getId());
			
		}
		  
		  
	  }
	  
	  
	  public static ArrayList<Trajet> afficherTrajet() throws Exception
	  {
		  ArrayList<Trajet> liste = new ArrayList<Trajet>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=conn.prepareStatement(" SELECT * FROM ttrajet ");
		  ResultSet rs =ps.executeQuery();
		  
		  while(rs.next()) 
		  {
			  liste.add(new Trajet(rs.getString("VilleDepart"), rs.getString("VilleArrivee"), rs.getDouble("LatitudeVilleDepart"), rs.getDouble("LongitudeVilleDepart"),rs.getDouble("LatitudeVilleArrivee"), rs.getDouble("LongitudeVilleArrivee"),rs.getInt(1),rs.getDouble("Distance")));
		  }
		return liste;
		  
	  }
	  
	  
	  
	  
	  public static void AjouterTrajet(String VD,String VA,double D1,double D2,double D3,double D4) throws Exception 
	  {
		  Trajet.ajouterTrajet(VD,VA,D1,D2,D3,D4);
	  }
	  
	  
	  
	  public static void SupprimerTrajet(int id) throws Exception 
	  {
		  Trajet.SupprimerTrajet(id);
	  }
	  
	  
	  
	  public static ArrayList<Volbis> afficherVol() throws Exception
	  {
		  ArrayList<Volbis> liste = new ArrayList<Volbis>();
		  Connection conn=ConnectionB.EtablissementConn();
		  PreparedStatement ps=conn.prepareStatement(" SELECT * FROM tvol ");
		  ResultSet rs6 =ps.executeQuery();
		  while(rs6.next()) {
   	   liste.add(new Volbis(rs6.getInt(2),rs6.getInt(3),rs6.getDate(4),rs6.getDate(5),rs6.getString(8), rs6.getTime("heureDepart").getHours(),rs6.getTime("heureDepart").getMinutes() , rs6.getTime("heureDepart").getSeconds(),rs6.getTime("heureArrivee").getHours(), rs6.getTime("heureArrivee").getMinutes() , rs6.getTime("heureArrivee").getSeconds(),rs6.getInt(1) ) );
		  }
       return liste;
	  }
	  
	  
	  
	  
	  public static void insererVol(Vol v) throws Exception 
	  {
		  Vol.TestinsererVol(v);
	  }
	  
	  
	  
	  
	  public static void SupprimerVol(int id) throws Exception 
	  {
		  Vol.SuppVol(id);
	  }
	  
	  
	  
	  
	  
	  public static ArrayList<Classe> afficherClasse() throws Exception {
		  
		  return Classe.afficherClasse();
	  }
	  
	  
	  
	  
	  public static ArrayList<Categorie> afficherCategorie() throws Exception{
		  return Categorie.afficherCategorie();
	  }
	  
	  
	  
	  
	  public static void ModifierCategorie(Categorie cat) throws Exception {
		  Categorie.ModifyCategorie(cat);
	  }
	  
	  public static void AjouterCategorie(String Lib,double Pour)throws Exception{
		  Categorie.AjouterCategorie(Lib,Pour);
	  }
	  
	  
	  
	  

	
	  
	  
	  
		

}
