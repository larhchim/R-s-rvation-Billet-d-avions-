package Métier;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Connection.DataBase.ConnectionB;

public class Reservation {
	
	private int id;
	private String VilleDepart;
	private String VilleArrivee;
	private Date DateDepart;
	private Date DateArrivee;
	private int hours;
	private int minutes;
	private int secondes;
	private String classe;
	private String NomPer;
	private String PrePer;
	
	public Reservation(int d,String villeDepart, String villeArrivee, Date dateDepart,Date dateArrivee, int hours, int minutes, int secondes,String classe,String f,String j) {
        
		this.setId(d);
		this.setClasse(classe);
		this.setDateDepart(dateDepart);
		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSecondes(secondes);
		this.setVilleArrivee(villeArrivee);
		this.setVilleDepart(villeDepart);
		this.setDateArrivee(dateArrivee);
		this.setPrePer(f);
		this.setNomPer(j);
		
	}
	
	

	public int getId() {
		
		return id;
		
	}



	public void setId(int id) {
		
		this.id = id;
		
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

	public String getClasse() {
		
		return classe;
		
	}

	public void setClasse(String classe) {
		
		this.classe = classe;
		
	}
	
	
	
	public String getNomPer() {
		
		return NomPer;
		
	}


	public void setNomPer(String nomPer) {
		
		NomPer = nomPer;
		
	}


	public String getPrePer() {
		
		return PrePer;
		
	}


	public void setPrePer(String prePer) {
		
		PrePer = prePer;
		
	}


	@SuppressWarnings("deprecation")
	public static java.sql.Timestamp MethodeTime( int heures, int minutes , int secondes)
	{
		
		java.util.Date dateinserer=new java.util.Date();
		dateinserer.setHours(heures);
		dateinserer.setMinutes(minutes);
		dateinserer.setSeconds(secondes);
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(dateinserer.getTime());
		
		return sqlTime;
		
	}
	
	public  static void supprimerReservation(int id) throws Exception 
	{
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("DELETE FROM treservation WHERE ID_Reservation=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		

		
		
	}
	
	public void ModifyReservation(Reservation R,int idvol,int idCli) throws Exception
	{
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement pd=conn.prepareStatement(" SELECT CURRENT_DATE ");
		ResultSet rf =pd.executeQuery();
		rf.next();
		
		PreparedStatement ps=conn.prepareStatement(" Update treservation set ID_Vol=? , VilleDepart=? , VilleArrivee=? , DateDepart=? , heureDepart=? , classe=? , DateReservation=? , NomPersonne=?,PrenomPersonne=? WHERE ID_Client=? ");
		ps.setInt(1, idvol);
		ps.setString(2, R.getVilleDepart());
		ps.setString(3, R.getVilleArrivee());
		ps.setDate(4, (java.sql.Date) R.getDateDepart());
		ps.setTimestamp(5, R.MethodeTime(R.getHours(), R.getMinutes(), R.getSecondes()));
		ps.setString(6, R.getClasse());
		ps.setDate(7, rf.getDate(1));
		ps.setString(8, R.getNomPer());
		ps.setString(9, R.getPrePer());
		ps.setInt(10, idCli);
		ps.executeUpdate(); 
		
	}


	
	
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	/*public static ArrayList<Vol> chercherTest(Date dtp,String vdp,String va,java.sql.Timestamp t) throws Exception 
	{
		
	    int A=t.getHours()-4;
	    int B=t.getHours()+4;
	    
		ArrayList<java.sql.Timestamp> arr = new ArrayList<java.sql.Timestamp>();
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps =conn.prepareStatement(" SELECT ID_Trajet FROM ttrajet WHERE VilleDepart=? AND VilleArrivee=? ");
		ps.setString(1,vdp );
		ps.setString(2, va);
		ResultSet r =ps.executeQuery();
		r.next();
		
		ArrayList<Vol> tabhour = new ArrayList<Vol>();
		
		if(r.first())
		{
			if( Vol.checkdate( dtp, vdp, va ).compareTo(dtp)==0 ) 
			{
				//java.sql.Date R2=java.sql.Date.valueOf("2020-10-12");
				arr=Vol.CheckHour( Reservation.MethodeTime(t.getHours(), t.getMinutes(), t.getSeconds()) , dtp,r.getInt(1),A,B );
				
				for(int i=0 ;i<arr.size() ; i++) 
				{
					PreparedStatement pq=conn.prepareStatement(" SELECT * FROM tvol WHERE DateDepart=? AND Hour(heureDepart)=? AND MINUTE(heureDepart)=? AND SECOND(heureDepart)=? AND ID_trajet=? ");
					pq.setDate(1, (java.sql.Date) dtp);
					pq.setInt(2, arr.get(i).getHours());
					pq.setInt(3, arr.get(i).getMinutes());
					pq.setInt(4, arr.get(i).getSeconds());
					pq.setInt(5, r.getInt(1));
					ResultSet rq =pq.executeQuery();
					rq.next();			
					
tabhour.add( new Vol( rq.getInt(2), rq.getInt(3) , rq.getDate(4) ,
		rq.getDate(5) , rq.getString(8) , rq.getTime("heureDepart").getHours() , 
		rq.getTime("heureDepart").getMinutes() , rq.getTime("heureDepart").getSeconds(),
		rq.getTime("heureArrivee").getHours() ,rq.getTime("heureArrivee").getMinutes() , rq.getTime("heureArrivee").getSeconds()  ) );  //1seule heure soit intervalle des heures

			        
				}
				
			}
	
		
		else
		{
			
				 Date a = Vol.checkdate(dtp,vdp, va) ;
				 PreparedStatement jh=conn.prepareStatement(" SELECT * FROM tvol WHERE ID_Trajet=? AND DateDepart=?  ");
				 jh.setInt(1, r.getInt(1));
				 jh.setDate(2, (java.sql.Date) a);
				 ResultSet jq = jh.executeQuery();
				 while(jq.next()) 
				 {

				  tabhour.add( new Vol( r.getInt(1), jq.getInt(3) , jq.getDate(4) , 
						  jq.getDate(5) , jq.getString(8) , jq.getTime("heureDepart").getHours() ,
						  jq.getTime("heureDepart").getMinutes() , jq.getTime("heureDepart").getSeconds(), 
						  jq.getTime("heureArrivee").getHours() ,jq.getTime("heureArrivee").getMinutes() , jq.getTime("heureArrivee").getSeconds()  ) );  
		
				 }
				 
		}
			
	}
		
		
		
		
		
		
		return tabhour;
				
	}*/
	
	
	public static ArrayList<Vol> chercherTest(Date dtp,String vdp,String va,java.sql.Timestamp t) throws Exception 
	{
		
	    int A=t.getHours()-4;
	    
	   
	    int B=t.getHours()+4;
	    
	   
	    
		ArrayList<java.sql.Timestamp> arr = new ArrayList<java.sql.Timestamp>();
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps =conn.prepareStatement(" SELECT ID_Trajet FROM ttrajet WHERE VilleDepart=? AND VilleArrivee=? ");
		ps.setString(1,vdp );
		ps.setString(2, va);
		ResultSet r =ps.executeQuery();
		r.next();
		
		ArrayList<Vol> tabhour = new ArrayList<Vol>();
		
		if(r.first())
		{
			if( Vol.checkdate( dtp, vdp, va )!=null ) 
			{
				arr=Vol.CheckHour( Reservation.MethodeTime(t.getHours(), t.getMinutes(), t.getSeconds()) , dtp,r.getInt(1),A,B );
				
				for(int i=0 ;i<arr.size() ; i++) 
				{
					PreparedStatement pq=conn.prepareStatement(" SELECT * FROM tvol WHERE DateDepart=? AND Hour(heureDepart)=? AND MINUTE(heureDepart)=? AND SECOND(heureDepart)=? AND ID_trajet=? ");
					pq.setDate(1, (java.sql.Date) dtp);
					pq.setInt(2, arr.get(i).getHours());
					pq.setInt(3, arr.get(i).getMinutes());
					pq.setInt(4, arr.get(i).getSeconds());
					pq.setInt(5, r.getInt(1));
					ResultSet rq =pq.executeQuery();
					rq.next();			
					
tabhour.add( new Vol( rq.getInt(2), rq.getInt(3) , rq.getDate(4) ,
		rq.getDate(5) , rq.getString(8) , rq.getTime("heureDepart").getHours() , 
		rq.getTime("heureDepart").getMinutes() , rq.getTime("heureDepart").getSeconds(),
		rq.getTime("heureArrivee").getHours() ,rq.getTime("heureArrivee").getMinutes() , rq.getTime("heureArrivee").getSeconds()  ) );  //1seule heure soit intervalle des heures

			        
				}
				
			}
	
		
		else
		{
			
				 Date a = Vol.recherche(dtp,vdp, va) ;
				 PreparedStatement jh=conn.prepareStatement(" SELECT * FROM tvol WHERE ID_Trajet=? AND DateDepart=?  ");
				 jh.setInt(1, r.getInt(1));
				 jh.setDate(2, (java.sql.Date) a);
				 ResultSet jq = jh.executeQuery();
				 while(jq.next()) 
				 {

				  tabhour.add( new Vol( r.getInt(1), jq.getInt(3) , jq.getDate(4) , 
						  jq.getDate(5) , jq.getString(8) , jq.getTime("heureDepart").getHours() ,
						  jq.getTime("heureDepart").getMinutes() , jq.getTime("heureDepart").getSeconds(), 
						  jq.getTime("heureArrivee").getHours() ,jq.getTime("heureArrivee").getMinutes() , jq.getTime("heureArrivee").getSeconds()  ) );  
		
				 }
				 
		}
			
	}
		
		
		
		
		
		
		return tabhour;
				
	}
	
	
	
	
	public static void insererReservation(int idv , String classe,int idc,String nm,String p,String cat , String NumP ) throws Exception
	{
		
		@SuppressWarnings("unused")
		ConcurrencePlaces cnP = new ConcurrencePlaces(idv,classe,idc,nm,p,cat,NumP);
		
	
	}
	
	@SuppressWarnings("deprecation")
	public static void testDateReservation() throws Exception   
	{
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps = conn.prepareStatement(" SELECT ID_Reservation,DateReservation FROM treservation ");
		ResultSet rt=ps.executeQuery();
		
		while(rt.next()) 
		{
			PreparedStatement pw=conn.prepareStatement(" SELECT CURRENT_DATE ");
			ResultSet rw =pw.executeQuery();
			rw.next();
			
			java.util.Date y=rt.getDate(2);
			java.util.Date u = y;
			u.setYear(y.getYear()+1);
		
			if(rw.getDate(1).compareTo(u)>=0) 
			{
				PreparedStatement pq=conn.prepareStatement(" DELETE FROM treservation WHERE ID_Reservation=? ");
				pq.setInt(1, rt.getInt(1));
				pq.executeUpdate();
			}
			
		}
		
		

	}
	
	public static ArrayList<Reservation> ResFonc(int idcli) throws Exception
	{
		
		ArrayList<Reservation> tabRes = new ArrayList<Reservation>();
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps = conn.prepareStatement(" SELECT * FROM treservation Where ID_Client=? ");
		ps.setInt(1, idcli);
		ResultSet rt=ps.executeQuery();
		
		
		
		while(rt.next()) 
		{
			
			PreparedStatement pf =conn.prepareStatement(" SELECT CURRENT_DATE ");
			ResultSet rf =pf.executeQuery();
			rf.next();
			
			
			if( rf.getDate(1).compareTo(rt.getDate(6)) <= 0 )
			{
			tabRes.add(new Reservation(rt.getInt(1),rt.getString(4), rt.getString(5), rt.getDate(6), rt.getDate(12), rt.getTime("heureDepart").getHours(),rt.getTime("heureDepart").getMinutes() , rt.getTime("heureDepart").getSeconds(), rt.getString(8), rt.getString(10),rt.getString(11) ));
			}
			
		}
		
		return tabRes;
		
		
		
	}
	


}

