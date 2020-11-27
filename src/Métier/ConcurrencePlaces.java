package Métier;



import java.sql.*;

import Connection.DataBase.ConnectionB;

public class ConcurrencePlaces extends Thread
{
	 static long id;     //idvol
	 static String cl;    //classe
	 static long idcli;    //idclient
	 static String nompersonne;
	 static String prenompersonne;
	 static String cate;
	 static String nump;
	 
	
	public ConcurrencePlaces(int d,String c,int z,String nm,String pm,String cat,String numerop)
	{
		

		ConcurrencePlaces.cl=c;
		ConcurrencePlaces.id=d;
		ConcurrencePlaces.idcli=z;
		ConcurrencePlaces.nompersonne=nm;
		ConcurrencePlaces.prenompersonne=pm;
		ConcurrencePlaces.cate=cat;
		ConcurrencePlaces.nump=numerop;
		start();
		
		
	}
	
	


	public synchronized void run(){
	
			
		try {
			
			
			
			Connection conn=ConnectionB.EtablissementConn();
			PreparedStatement ps =conn.prepareStatement(" SELECT NbrePlacesEco,NbrePlacesAff,NbrePlaces1ere From tvol Where tvol.ID_Vol=?  ");
			ps.setInt(1, (int) ConcurrencePlaces.id);
			ResultSet ys =ps.executeQuery();
			ys.next();
			
			if(cl.equals("1ere")) {
				if(ys.getInt(3)>0) {
					System.out.println("vous avez le droit de reserver");
					PreparedStatement pd=conn.prepareStatement(" Update tvol set NbrePlaces1ere=NbrePlaces1ere-1 WHERE tvol.ID_Vol=?");
					pd.setInt(1, (int) ConcurrencePlaces.id);
					pd.executeUpdate();
					
					PreparedStatement ps1 =conn.prepareStatement(" SELECT ID_Trajet,DateDepart,heureDepart,DateArrivee FROM tvol WHERE tvol.ID_Vol=? ");
					ps1.setInt(1, (int) ConcurrencePlaces.id);
					ResultSet rt = ps1.executeQuery();
					rt.next();
					
					PreparedStatement pj =conn.prepareStatement(" SELECT VilleDepart,VilleArrivee From ttrajet WHERE ID_Trajet=? ");
					pj.setInt(1, rt.getInt(1));
					ResultSet rj = pj.executeQuery();
					rj.next();
					
					PreparedStatement pw=conn.prepareStatement(" SELECT CURRENT_DATE ");
					ResultSet rw =pw.executeQuery();
					rw.next();
					
					PreparedStatement pv =conn.prepareStatement(" insert into treservation(ID_Client,ID_Vol,VilleDepart,VilleArrivee,DateDepart,heureDepart,classe,DateReservation,NomPersonne,PrenomPersonne,DateArrivee,Categorie,NumeroPasseport) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					pv.setInt(1, (int) ConcurrencePlaces.idcli );
					pv.setInt(2,(int) ConcurrencePlaces.id);
					pv.setString(3, rj.getString(1));
					pv.setString(4, rj.getString(2));
					pv.setDate(5, rt.getDate(2));
					pv.setTime(6, rt.getTime(3));
					pv.setString(7, ConcurrencePlaces.cl);
					pv.setDate(8, rw.getDate(1));
					pv.setString(9, ConcurrencePlaces.nompersonne);
					pv.setString(10, ConcurrencePlaces.prenompersonne);
					pv.setDate(11, rt.getDate(4));
					pv.setString(12, ConcurrencePlaces.cate);
					pv.setString(13, ConcurrencePlaces.nump);
					pv.executeUpdate();
					
					System.out.println(" Reservation effectuée ");
					return;
					
				}
				else 
					System.out.println("vous n'avez pas le droit de reserver");
				    

			}
			else if(cl.equals("Economie")) {
				if(ys.getInt(1)>0) {
					System.out.println("vous avez le droit de reserver");
					PreparedStatement pd=conn.prepareStatement(" Update tvol set NbrePlacesEco=NbrePlacesEco-1 WHERE tvol.ID_Vol=? ");
					pd.setInt(1, (int) ConcurrencePlaces.id);
					pd.executeUpdate();
					
					PreparedStatement ps1 =conn.prepareStatement(" SELECT ID_Trajet,DateDepart,heureDepart,DateArrivee FROM tvol WHERE tvol.ID_Vol=? ");
					ps1.setInt(1, (int) ConcurrencePlaces.id);
					ResultSet rt = ps1.executeQuery();
					rt.next();
					
					PreparedStatement pj =conn.prepareStatement(" SELECT VilleDepart,VilleArrivee From ttrajet WHERE ID_Trajet=? ");
					pj.setInt(1, rt.getInt(1));
					ResultSet rj = pj.executeQuery();
					rj.next();
					
					PreparedStatement pw=conn.prepareStatement(" SELECT CURRENT_DATE ");
					ResultSet rw =pw.executeQuery();
					rw.next();
					
					PreparedStatement pv =conn.prepareStatement(" insert into treservation(ID_Client,ID_Vol,VilleDepart,VilleArrivee,DateDepart,heureDepart,classe,DateReservation,NomPersonne,PrenomPersonne,DateArrivee,Categorie,NumeroPasseport) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					pv.setInt(1, (int) ConcurrencePlaces.idcli );
					pv.setInt(2,(int) ConcurrencePlaces.id);
					pv.setString(3, rj.getString(1));
					pv.setString(4, rj.getString(2));
					pv.setDate(5, rt.getDate(2));
					pv.setTime(6, rt.getTime(3));
					pv.setString(7, ConcurrencePlaces.cl);
					pv.setDate(8, rw.getDate(1));
					pv.setString(9, ConcurrencePlaces.nompersonne);
					pv.setString(10, ConcurrencePlaces.prenompersonne);
					pv.setDate(11, rt.getDate(4));
					pv.setString(12, ConcurrencePlaces.cate);
					pv.setString(13, ConcurrencePlaces.nump);
					pv.executeUpdate();
					
					System.out.println(" Reservation effectuée ");
					
					return;
				
				}
				else 
					System.out.println("vous n'avez pas le droit de reserver");
			}
			else if(cl.equals("Affaire"))
			{
				if(ys.getInt(2)>0) {
					System.out.println("vous avez le droit de reserver");
					PreparedStatement pd=conn.prepareStatement(" Update tvol set NbrePlacesAff=NbrePlacesAff-1 WHERE tvol.ID_Vol=? ");
					pd.setInt(1, (int) ConcurrencePlaces.id);
					pd.executeUpdate();
					
					PreparedStatement ps1 =conn.prepareStatement(" SELECT ID_Trajet,DateDepart,heureDepart,DateArrivee FROM tvol WHERE tvol.ID_Vol=? ");
					ps1.setInt(1, (int) ConcurrencePlaces.id);
					ResultSet rt = ps1.executeQuery();
					rt.next();
					
					PreparedStatement pj =conn.prepareStatement(" SELECT VilleDepart,VilleArrivee From ttrajet WHERE ID_Trajet=? ");
					pj.setInt(1, rt.getInt(1));
					ResultSet rj = pj.executeQuery();
					rj.next();
					
					PreparedStatement pw=conn.prepareStatement(" SELECT CURRENT_DATE ");
					ResultSet rw =pw.executeQuery();
					rw.next();
					
					PreparedStatement pv =conn.prepareStatement(" insert into treservation(ID_Client,ID_Vol,VilleDepart,VilleArrivee,DateDepart,heureDepart,classe,DateReservation,NomPersonne,PrenomPersonne,DateArrivee,Categorie,NumeroPasseport) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					pv.setInt(1, (int) ConcurrencePlaces.idcli );
					pv.setInt(2,(int) ConcurrencePlaces.id);
					pv.setString(3, rj.getString(1));
					pv.setString(4, rj.getString(2));
					pv.setDate(5, rt.getDate(2));
					pv.setTime(6, rt.getTime(3));
					pv.setString(7, ConcurrencePlaces.cl);
					pv.setDate(8, rw.getDate(1));
					pv.setString(9, ConcurrencePlaces.nompersonne);
					pv.setString(10, ConcurrencePlaces.prenompersonne);
					pv.setDate(11, rt.getDate(4));
					pv.setString(12, ConcurrencePlaces.cate);
					pv.setString(13, ConcurrencePlaces.nump);
					pv.executeUpdate();
					
					System.out.println(" Reservation effectuée ");
					return;

				}
				else 
					System.out.println("vous n'avez pas le droit de reserver");
				
				return;
			}
			else 
				System.out.println("vous n'avez pas le droit de reserver entrer une classe valide Economie ou Affaire ou 1ère classe");
		  
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	

}
