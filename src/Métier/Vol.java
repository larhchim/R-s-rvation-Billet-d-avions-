package Métier;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Connection.DataBase.ConnectionB;
public class Vol 
{
	
	private int ID_Trajet;
	private int ID_Avion;
	private Date DateDepart;
	private Date DateArrivee;
	private String Duree;
	private int hours;
	private int minutes;
	private int secondes;
	private int hours2;
	private int minutes2;
	private int secondes2;
	static boolean var=false;


	public Vol(int iD_Trajet, int iD_Avion, Date dateDepart, Date dateArrivee, String duree, int hours, int minutes,int secondes, int hours2, int minutes2,int secondes2) {
		
		this.setDateArrivee(dateArrivee);
		this.setDateDepart(dateDepart);
		this.setDuree(duree);
		this.setHours(hours);
		this.setID_Avion(iD_Avion);
		this.setID_Trajet(iD_Trajet);
		this.setMinutes(minutes);
		this.setSecondes(secondes);
		this.setHours2(hours2);
		this.setMinutes2(minutes2);
		this.setSecondes2(secondes2);
	}

	
	public int getID_Trajet() {
		
		return ID_Trajet;
		
	}


	public void setID_Trajet(int iD_Trajet) {
		
		ID_Trajet =  iD_Trajet;
		
	}


	public int getID_Avion() {
		
		return ID_Avion;
		
	}


	public void setID_Avion(int iD_Avion) {
		
		ID_Avion = iD_Avion;
		
	}


	public Date getDateDepart() {
		
		return DateDepart;
		
	}


	public void setDateDepart(Date dateDepart) {
		
		DateDepart = dateDepart;
		
	}


	public Date getDateArrivee() {
		
		return DateArrivee;
		
	}


	public void setDateArrivee(Date dateArrivee) {
		
		DateArrivee = dateArrivee;
		
	}


	public String getDuree() {
		
		return Duree;
		
	}


	public void setDuree(String duree) {
		
		Duree = duree;
		
	}


	public int getHours() {
		
		return hours;
		
	}


	public void setHours(int hours) {
		
		this.hours = hours;
		
	}


	public int getMinutes() {
		
		return minutes;
		
	}


	public void setMinutes(int minutes) {
		
		this.minutes = minutes;
		
	}


	public int getSecondes() {
		
		return secondes;
		
	}


	public void setSecondes(int secondes) {
		
		this.secondes = secondes;
		
	}
	
	public int getHours2() {
		
		return hours2;
		
	}


	public void setHours2(int hours2) {
		
		this.hours2 = hours2;
		
	}


	public int getMinutes2() {
		
		return minutes2;
		
	}


	public void setMinutes2(int minutes2) {
		
		this.minutes2 = minutes2;
		
	}


	public int getSecondes2() {
		
		return secondes2;
		
	}


	public void setSecondes2(int secondes2) {
		
		this.secondes2 = secondes2;
		
	}
	
	public java.sql.Timestamp MethodeTime( int heures, int minutes , int secondes)
	{
		
		java.util.Date dateinserer=new java.util.Date();
		dateinserer.setHours(heures);
		dateinserer.setMinutes(minutes);
		dateinserer.setSeconds(secondes);
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(dateinserer.getTime());
		return sqlTime;
		
	}


	public static ArrayList Conc(String Villed ,String VilleA) throws Exception{

		ArrayList<Date> a=new ArrayList<Date>();
	 
       
	   Connection conn=ConnectionB.EtablissementConn();
       PreparedStatement sn=conn.prepareStatement("SELECT tvol.DateDepart  From tvol,ttrajet where ttrajet.ID_Trajet=tvol.ID_Trajet  and ttrajet.VilleDepart=? and ttrajet.VilleArrivee=? order by tvol.DateDepart ");
       sn.setString(1, Villed);
       sn.setString(2, VilleA);
     
       
       ResultSet rs=sn.executeQuery();
       
       while (rs.next()) 
       {
    	   Date v=rs.getDate(1);
    	   a.add(v);
       }
       return a;
       
	}
	
	public static Date checkdate(Date dateClient , String villiD,String VillA) throws Exception
	{
		Date attribut;
		Connection conn=ConnectionB.EtablissementConn();
	    PreparedStatement sn=conn.prepareStatement("select tvol.DateDepart,tvol.DateArrivee From tvol,ttrajet where ttrajet.ID_Trajet=tvol.ID_Trajet and ttrajet.VilleDepart=? and ttrajet.VilleArrivee=? and tvol.DateDepart=?");
	    sn.setString(1, villiD);
	    sn.setString(2, VillA);
	    sn.setDate(3, (java.sql.Date) dateClient);
	    
	    ResultSet rs=sn.executeQuery();
	    rs.next();
	 
		if(rs.first())
		{
			attribut= rs.getDate(1);
			return attribut;
		}
		/*else
		{
		    attribut=recherche(dateClient, villiD , VillA );
			
		}
		return attribut;*/
		else
			return null;
	  }
	
	public static Date recherche(Date dateClient,String Villed ,String VilleA ) throws Exception
	{
			ArrayList<Date> a=Conc( Villed , VilleA );
			Iterator c=a.iterator();
			 while (c.hasNext()) 
			    {
				 Date date =(Date)c.next();    
	             if(date.compareTo(dateClient)>0) 
	              return date;
		        }
		 return null;
	}
	
	/*public static  ArrayList CheckHour( java.sql.Timestamp temps , Date departure , Date Arrival ,int id ,int A , int B ) throws Exception
	{
		ArrayList<java.sql.Timestamp > timer =new ArrayList <java.sql.Timestamp > ();
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps = conn.prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND DateArrivee=? AND ID_Trajet=? AND heureDepart=? ");
		ps.setDate(1, (java.sql.Date) departure);
		ps.setDate(2, (java.sql.Date) Arrival);
		ps.setInt(3, id);
		ps.setTimestamp(4, temps);
		
		ResultSet rd = ps.executeQuery();
		rd.next();
		
		if(rd.first()) 
		{
			timer.add(rd.getTimestamp(1));
			var=true;
		}
		else
		{
			
		PreparedStatement ps3 = conn.prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND DateArrivee=? AND ID_Trajet=? AND Hour(heureDepart) BETWEEN ? AND ? ");
	 	ps3.setDate(1, (java.sql.Date) departure);
		ps3.setDate(2, (java.sql.Date) Arrival);
		ps3.setInt(3, id);
		ps3.setInt(4,A);
		ps3.setInt(5,B);
		ResultSet j=ps3.executeQuery();
		while(j.next()) 
		{
		   timer.add(j.getTimestamp(1));
		}
		
		}
		
		return timer;
	}*/
	
	
	public static  ArrayList CheckHour( java.sql.Timestamp temps , Date departure , int id ,int A , int B ) throws Exception
	{
		ArrayList<java.sql.Timestamp > timer =new ArrayList <java.sql.Timestamp > ();
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps = conn.prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND ID_Trajet=? AND heureDepart=? ");
		ps.setDate(1, (java.sql.Date) departure);
		ps.setInt(2, id);
		ps.setTimestamp(3, temps);
		
		ResultSet rd = ps.executeQuery();
		rd.next();
		
		if(rd.first()) 
		{
			timer.add(rd.getTimestamp(1));
			var=true;
		}
		else
		{
			
		PreparedStatement ps3 = conn.prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND ID_Trajet=? AND Hour(heureDepart) BETWEEN ? AND ? ");
	 	ps3.setDate(1, (java.sql.Date) departure);
		ps3.setInt(2, id);
		ps3.setInt(3,A);
		ps3.setInt(4,B);
		ResultSet j=ps3.executeQuery();
		
		while(j.next()) 
		{
		   timer.add(j.getTimestamp(1));
		}
		

				
			
		
		}
		
		return timer;
	}
	
	public static void SuppVol(int id) throws Exception
	{
		Connection conn=ConnectionB.EtablissementConn();
	    PreparedStatement ps=conn.prepareStatement("Delete from tvol WHERE ID_Vol=? " );
	    ps.setInt(1, id);
	    ps.executeUpdate();
	    
	}
	
	
	
	
	public static void TestinsererVol(Vol t) throws Exception
	{
		  //  ArrayList<Avion> listAvion=new ArrayList<>();
		   Connection conn=ConnectionB.EtablissementConn();
	       PreparedStatement ps=conn.prepareStatement("select * from ttrajet where ID_Trajet=?" );
	       ps.setInt(1,t.ID_Trajet );
	       ResultSet rs=ps.executeQuery();
	       rs.next();
	       //************************************************************************
	       /*PreparedStatement ps1=conn.prepareStatement("select * from tavion where Autonomie >=? and EtatAvion='Bonne' " );
	       ps1.setDouble(1,Trajet.CalculDistance(rs.getDouble(3),rs.getDouble(4),rs.getDouble(6), rs.getDouble(7)));
	       ResultSet rs1=ps1.executeQuery();*/
	       //**********************************************************************
	     rs.first();
	    	   PreparedStatement ps2=conn.prepareStatement("select * from tavion  where Autonomie >=? and EtatAvion='Bonne' and tavion.ID_Avion not in (select tvol.ID_Avion From tvol) " );
		       ps2.setDouble(1,Trajet.CalculDistance(rs.getDouble(3),rs.getDouble(4),rs.getDouble(6), rs.getDouble(7)));
	    	   ResultSet rs2=ps2.executeQuery();
	    	   rs2.next();
	    	   if(rs2.first()) {
	    		   
	    		   PreparedStatement mp=conn.prepareStatement(" SELECT NombrePlacesEco,NombrePlacesAff,NombrePlaces1ere FROM tavion WHERE ID_Avion=? ");
	    		   mp.setInt(1, rs2.getInt(1));
	    		   ResultSet mpr =mp.executeQuery();
	    		   mpr.next();
	    		   
	        	   PreparedStatement ps3=conn.prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree,NbrePlacesEco,NbrePlacesAff,NbrePlaces1ere) values(?,?,?,?,?,?,?,?,?,?)" );
	        	   ps3.setInt(1,t.ID_Trajet );
	        	   ps3.setInt(2,rs2.getInt(1));
	        	   ps3.setDate(3,(java.sql.Date) t.DateDepart);
	        	   ps3.setDate(4,(java.sql.Date) t.DateArrivee);
	        	   ps3.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes(),t.getSecondes()));
	        	   ps3.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2(), t.getSecondes2()));
	        	   ps3.setString(7, t.Duree);
	        	   ps3.setInt(8, mpr.getInt(1));
	        	   ps3.setInt(9, mpr.getInt(2));
	        	   ps3.setInt(10, mpr.getInt(3));
	        	   ps3.executeUpdate();
	        	   return;
	    	       }
	    	   
	        //*************************************************************************************************************************************************************************

			PreparedStatement ps4=conn.prepareStatement("SELECT tavion.ID_Avion from tavion WHERE  Autonomie>=? and EtatAvion='Bonne' AND ID_Avion not in(select tvol.ID_Avion from tvol WHERE DateDepart=? AND DateArrivee=?)");
		    ps4.setDouble(1,Trajet.CalculDistance(rs.getDouble(3),rs.getDouble(4),rs.getDouble(6), rs.getDouble(7)));
			ps4.setDate(2,(java.sql.Date) t.DateDepart);
			ps4.setDate(3,(java.sql.Date) t.DateArrivee);
			ResultSet rs4=ps4.executeQuery();
			if(rs4.next())
			{
				   PreparedStatement mp1=conn.prepareStatement(" SELECT NombrePlacesEco,NombrePlacesAff,NombrePlaces1ere FROM tavion WHERE ID_Avion=? ");
	    		   mp1.setInt(1, rs4.getInt(1));
	    		   ResultSet mpr1 =mp1.executeQuery();
	    		   mpr1.next();

	        	   PreparedStatement ps5=conn.prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree,NbrePlacesEco,NbrePlacesAff,NbrePlaces1ere) values(?,?,?,?,?,?,?,?,?,?)" );
	        		       
	        			   ps5.setInt(1,t.ID_Trajet );
	        			   ps5.setInt(2,rs4.getInt(1));
	        			   ps5.setDate(3,(java.sql.Date) t.DateDepart);
	        			   ps5.setDate(4,(java.sql.Date) t.DateArrivee);
	        			   ps5.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes(),t.getSecondes()));
	    	        	   ps5.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2(), t.getSecondes2()));
	        			   ps5.setString(7, t.Duree);
	        			   ps5.setInt(8, mpr1.getInt(1));
	        			   ps5.setInt(9, mpr1.getInt(2));
	    	        	   ps5.setInt(10, mpr1.getInt(3));
	        			   ps5.executeUpdate();
	        			   return ;
			}
			
	      //***************************************************************************************************************************************************************************
	   
	    	 
	    	   PreparedStatement ps6=conn.prepareStatement("select tvol.ID_Vol,tvol.ID_Trajet,tvol.ID_Avion,tvol.DateDepart,tvol.DateArrivee,tvol.heureDepart,tvol.heureArrivee,tvol.Duree from tvol,tavion where tvol.ID_Avion = tavion.ID_Avion and tvol.DateDepart = ? and tvol.DateArrivee = ?  and Autonomie >=? and EtatAvion='Bonne' order by tvol.heureDepart  " );
	    	   ps6.setDate(1,(java.sql.Date) t.DateDepart);
	           ps6.setDate(2,(java.sql.Date) t.DateArrivee);
		       ps6.setDouble(3,Trajet.CalculDistance(rs.getDouble(3),rs.getDouble(4),rs.getDouble(6), rs.getDouble(7)));
	           ResultSet rs6=ps6.executeQuery(); 
	           
	          ArrayList<Vol> liste=new ArrayList<Vol>();
	          while(rs6.next()) 
	           {

	              
	        	   liste.add(new Vol(rs6.getInt(2),rs6.getInt(3),rs6.getDate(4),rs6.getDate(5),rs6.getString(8), rs6.getTime("heureDepart").getHours(),rs6.getTime("heureDepart").getMinutes() , rs6.getTime("heureDepart").getSeconds(),rs6.getTime("heureArrivee").getHours(), rs6.getTime("heureArrivee").getMinutes() , rs6.getTime("heureArrivee").getSeconds() ) );
	        
	        	   
	           }
	           
	           if(rs6.first()) {
	           Vol var=liste.get(0);
	           Vol bar=liste.get(liste.size()-1);
	           if( (t.getHours2()+1) <= var.getHours() || (t.getHours() >=bar.getHours2()+1) ) {
	        	   
	        	   PreparedStatement mp2=conn.prepareStatement(" SELECT NombrePlacesEco,NombrePlacesAff,NombrePlaces1ere FROM tavion WHERE ID_Avion=? ");
	    		   mp2.setInt(1,var.getID_Avion());
	    		   ResultSet mpr2 =mp2.executeQuery();
	    		   mpr2.next();
	    		   
	        	   PreparedStatement ps8=conn.prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree,NbrePlacesEco,NbrePlacesAff,NbrePlaces1ere) values(?,?,?,?,?,?,?,?,?,?)" );
	   	        
	        	   ps8.setInt(1,t.ID_Trajet );
	        	   ps8.setInt(2,var.getID_Avion());
	        	   ps8.setDate(3,(java.sql.Date) t.DateDepart);
	        	   ps8.setDate(4,(java.sql.Date) t.DateArrivee);
    			   ps8.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes(),t.getSecondes()));
	        	   ps8.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2(), t.getSecondes2()));
	        	   ps8.setString(7, t.Duree);
	        	   ps8.setInt(8, mpr2.getInt(1));
    			   ps8.setInt(9, mpr2.getInt(2));
	        	   ps8.setInt(10, mpr2.getInt(3));
	        	   ps8.executeUpdate(); 
	        	   return;
	           }
	           
	           
	           for(int i=1;i<liste.size()-1;i++) 
	           {
	        	   
	        	   if(t.getHours2()+1<=liste.get(i).getHours() && t.getHours()>=liste.get(i).getHours2()+1) 
	        	   {
	        		   PreparedStatement mp3=conn.prepareStatement(" SELECT NombrePlacesEco,NombrePlacesAff,NombrePlaces1ere FROM tavion WHERE ID_Avion=? ");
		    		   mp3.setInt(1,var.getID_Avion());
		    		   ResultSet mpr3 =mp3.executeQuery();
		    		   mpr3.next();
	        		   
		           PreparedStatement ps7=conn.prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree,NbrePlacesEco,NbrePlacesAff,NbrePlaces1ere) values(?,?,?,?,?,?,?,?,?,?)" );
	        
	        	   ps7.setInt(1,t.ID_Trajet );
	        	   ps7.setInt(2,var.getID_Avion());
	        	   ps7.setDate(3,(java.sql.Date) t.DateDepart);
	        	   ps7.setDate(4,(java.sql.Date) t.DateArrivee);
	        	   ps7.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes(),t.getSecondes()));
	        	   ps7.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2(), t.getSecondes2()));
	        	   ps7.setString(7, t.Duree);
	        	   ps7.setInt(8, mpr3.getInt(1));
    			   ps7.setInt(9, mpr3.getInt(2));
	        	   ps7.setInt(10, mpr3.getInt(3));
	        	   ps7.executeUpdate(); 
	        	   return;
	        	   
	        	   }
	           }
	          
	           }
	       
	       System.out.println("il faut ajouter une avion dans sans atonomi superieur ou egale a "+Trajet.CalculDistance(rs.getDouble(3),rs.getDouble(4),rs.getDouble(6), rs.getDouble(7))+"inserer un autre jour");
	       
		}
		//*****************************************************************************fin Programme***********************************************************************************
}
