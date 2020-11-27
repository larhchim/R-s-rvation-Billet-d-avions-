package Métier;


import java.sql.*;

import Connection.DataBase.ConnectionB;

public class Trajet{
	
	private String VilleDepart;
	private String VilleArrivee;
    private static Double LatitudeVilleDepart;
    private static Double LongitudeVilleDepart;
    private static Double LatitudeVilleArrivee;
    private static Double LongitudeVilleArrivee;
    private int numT;
    private double distance;

	public Trajet(String villeDepart, String villeArrivee, Double latitudeVilleDepart, Double longitudeVilleDepart,Double latitudeVilleArrivee, Double longitudeVilleArrivee,int n,double d) {
		
	this.setLatitudeVilleArrivee(latitudeVilleArrivee);
	this.setLatitudeVilleDepart(latitudeVilleDepart);
	this.setLongitudeVilleArrivee(longitudeVilleArrivee);
	this.setLongitudeVilleDepart(longitudeVilleDepart);
	this.setVilleArrivee(villeArrivee);
	this.setVilleDepart(villeDepart);
	this.setNumT(n);
	this.setDistance(d);

		
	}

	public String getVilleDepart() {
		
		return VilleDepart;
		
	}

	public void setVilleDepart(String villeDepart) {
		
		VilleDepart = villeDepart;
		
	}

	public String getVilleArrivee() {
		
		return VilleArrivee;
		
	}

	public void setVilleArrivee(String villeArrivee) {
		
		VilleArrivee = villeArrivee;
		
	}

	
	public Double getLatitudeVilleDepart() {
		
		return LatitudeVilleDepart;
		
	}
	

	public static void setLatitudeVilleDepart(Double latitudeVilleDepart) {
		
		LatitudeVilleDepart = latitudeVilleDepart;
		
	}

	public  Double getLongitudeVilleDepart() {
		
		return LongitudeVilleDepart;
		
	}

	public static void setLongitudeVilleDepart(Double longitudeVilleDepart) {
		
		LongitudeVilleDepart = longitudeVilleDepart;
		
	}

	public  Double getLatitudeVilleArrivee() {
		
		return LatitudeVilleArrivee;
		
	}

	public static void setLatitudeVilleArrivee(Double latitudeVilleArrivee) {
		
		LatitudeVilleArrivee = latitudeVilleArrivee;
		
	}

	public Double getLongitudeVilleArrivee() {
		
		return LongitudeVilleArrivee;
		
	}

	public static void setLongitudeVilleArrivee(Double longitudeVilleArrivee) {
		
		LongitudeVilleArrivee = longitudeVilleArrivee;
		
	}
	
	public int getNumT() {
		
		return numT;
		
	}

	public void setNumT(int numT) {
		
		this.numT = numT;
		
	}
	
	

	public double getDistance() {
		
		return distance;
		
	}

	
	public void setDistance(double d) {
		this.distance = d;
	}

	public static void  ajouterTrajet(String VD,String VA,double D1,double D2,double D3,double D4) throws Exception {
		
	
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Insert into ttrajet(VilleDepart,LatitudeVilleDepart,LongitudeVilleDepart,VilleArrivee,LatitudeVilleArrivee,LongitudeVilleArrivee,Distance) values(? , ? , ? , ? , ? , ? , ?) ");
		ps.setString(1, VD);
		ps.setDouble(2, D1);
		ps.setDouble(3, D2);
		ps.setString(4,VA);
		ps.setDouble(5, D3);
		ps.setDouble(6, D4);
		ps.setDouble(7, Trajet.CalculDistance(D1,D2,D3,D4));
		ps.executeUpdate();
		
		
	}
	
	public static void SupprimerTrajet(int iD_Trajet) throws Exception{
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Delete From ttrajet where ID_Trajet=?");
		ps.setInt(1,iD_Trajet);
		ps.executeUpdate();
		
	}
	
	 public static double CalculDistance(double lat1, double lon1, double lat2, double lon2) {
		 
		 
	      double dist = Math.acos( Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(lon1 - lon2)) );
	      dist = rad2deg(dist);
	      dist = dist * 111.3;
	      return dist;
	      
	      
	    }


	    private static double deg2rad(double deg) {
	      return (deg * Math.PI / 180.0);
	    }


	    private static double rad2deg(double rad) {
	      return (rad * 180.0 / Math.PI);
	    }

}
