package Métier;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Connection.DataBase.ConnectionB;


public class TestApplication 
{
	public static void main(String args[]) throws Exception
	{
		/***********************************test metier***********************************/
		//Client Ismail =new Client("BENREFAD","MEHDI", "15-10-1999", "AD5155", 548918564, "Maroc", "mehdi864","12345","A");
		//Ismail.Inscription();
		//Client Yahya =new Client("elkafhali","said","15-10-1970","AD287433",785245245, "Maroc","mehdi864","12345","B");
		//Ismail.Modifier(Yahya);
		//System.out.println("etat de l'avion est "+Avion.checkstate(1));
		//Avion airbus1900 = new Avion(2000.0,3000.0,"Airbus900",25,50,100,"bonne",200,300,70);
		//airbus1900.Ajouter(airbus1900);
		//airbus1900.ModifyState(6,"Mauvaise");
		//System.out.println(airbus1900.checkstate(6));
		//Trajet.ajouterTrajet(new Trajet("Rabat","Paris",34.022405, -6.834543, 48.8566969,2.3514616));
		//Trajet.SupprimerTrajet(2);
		//Date mehdi = new Date(15,10,1999,17,45,33);
		//mehdi.InsererDate(mehdi);
		//System.out.println(mehdi.toString());
		//Date e = new Date();
		/*String stringDate1="1999-02-23";   
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date date1=formatter1.parse(stringDate1);  
		java.sql.Date date2 = new java.sql.Date(date1.getTime());*/
		
		/*Calendar calendar =Calendar.getInstance();
		calendar.setTime(date2);
		System.out.println("jour: "+(calendar.get(Calendar.DAY_OF_MONTH)+6));                  
		System.out.println("Mois: "+((calendar.get(Calendar.MONTH)+1)+4));
		System.out.println("annee: "+(calendar.get(Calendar.YEAR)+5));*/
		/*String stringDate2="2013-11-20";   
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");  
	    java.util.Date date10=formatter2.parse(stringDate2);  
		java.sql.Date date20 = new java.sql.Date(date10.getTime());*/
		
		//testDate a = new testDate(date2,date20,"casa","fes");
		//a.inseretion(a);
		//Date h=new Date(2000,02,23, 0, 0, 0);
		//testDate.verfierDate("2001-02-23", "casa", "fes");
		//java.sql.Date R1=java.sql.Date.valueOf("2020-10-10");
		//java.sql.Date R2=java.sql.Date.valueOf("2020-10-10");
		//java.sql.Date R3=java.sql.Date.valueOf("2020-10-10 17:00:00");
		//java.sql.Date R4=java.sql.Date.valueOf("2020-10-10 18:30:00");
		//java.sql.Date R5=java.sql.Date.valueOf("2020-10-10 01:30:00");
	
		//Vol prem=new Vol(0,R1, R2, R3, R4, R5);
		//prem.inseretion(prem,3);
		
		/*SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		java.util.Date d = df.parse("13:37:00");
		Long time1 = d.getTime();
		time1 +=(1*60*60*1000);
		java.util.Date heuredepart = new Date(time1);
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  
		String stringdate1 = dateFormat.format(heuredepart);  
		java.sql.Date RJ=java.sql.Date.valueOf(stringdate1);
		System.out.println(stringdate1);*/
		
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// replace with your start date string
		Date d = df.parse("2008-04-05 13:37:00");
		Long time = d.getTime();
		time +=(4*60*60*1000);
		java.util.Date d2 = new Date(time);
		System.out.println(d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds());*/
	
	
			/*
			java.util.Date date=new java.util.Date();
		
			date.setHours(18);
			date.setMinutes(45);
			date.setSeconds(30);
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
			
			java.util.Date date2=new java.util.Date();
	
			Long time1 = sqlTime.getTime();
			time1 +=(1*60*60*1000);
			java.util.Date heuredepart = new Date(time1);
			date2.setHours(heuredepart.getHours());
			date2.setMinutes(sqlTime.getMinutes());
			date2.setSeconds(sqlTime.getSeconds());
			java.sql.Date sqlDate2=new java.sql.Date(date2.getTime());
			java.sql.Timestamp sqlTime2=new java.sql.Timestamp(date.getTime());
			
			
			
			
			
			
			Connection conn=ConnectionB.EtablissementConn();
			PreparedStatement ps=conn.prepareStatement("insert into date (date,temps) values(?,?)");
			ps.setDate(1,sqlDate2);
			ps.setTimestamp(2,(Timestamp) heuredepart);
			ps.executeUpdate();*/
			//java.sql.Date R1=java.sql.Date.valueOf("2020-10-10");
			//java.sql.Date R2=java.sql.Date.valueOf("2019-05-12");
		    //Vol ismail = new Vol(3,3,R1,R2,"01:30:00",17,0,0,18,30,0);
			//Vol.SuppVol();
		    //ismail.TestinsererVol(ismail, 3);
		//Prix h= new Prix(3,Prix.getPourcentageJunior(),Prix.getPourcentageSenior());
		//h.CalculPrix(h);
		
		//Trajet y= new Trajet("Casablanca", "London",33.5950627, -7.6187768, 51.5073219, -0.1276474);
		//y.ajouterTrajet(y);
		
		//Prix h2=new Prix(4, 0.40,0.25, 20.00,40.00, 80.000);
		//h2.SupprimerPrix(2);
		
		 /*String s1=new String("asmaa") ;
		 int len=s1.length() ; 
		 Scanner sc= new Scanner(System.in);
		 System.out.println(" enter your fucking name :");
		 String user=sc.nextLine();
		 if(user.length()>len) 
		 {
		  System.out.println("you are loyal +"+( user.length()-len)) ;
		  sc.close();
		 }
		 else if(user.length()==len) 
		 {
		  System.out.println("you are fucking loyal") ;
		  sc.close();
		 }
		 else
		 {
		 System.out.println("you are not fucking loyal ok!!! ");
		 sc.close();
		 }*/
		
		/*java.util.Date dateinserer=new java.util.Date();
		dateinserer.setHours(20);
		dateinserer.setMinutes(04);
		dateinserer.setSeconds(00);
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(dateinserer.getTime());*/
		
		//java.sql.Date R1=java.sql.Date.valueOf("2020-10-10");
		//java.sql.Date R2=java.sql.Date.valueOf("2020-10-12");
		
       // Reservation R = new Reservation("Rabat", "Paris",R1,R2, 16, 32, 30, "Eco");
		//Reservation.run(R);
		
		//Vol t = new Vol(4, 4, R1, R2, "01:30:00",8, 0, 0, 9, 30, 0);
		//t.TestinsererVol(t);
		
		//Trajet.ajouterTrajet(new Trajet("Rabat","NewYork",33.931264,-6.9009408,40.7127281,-74.0060152));
		//java.sql.Date R1=java.sql.Date.valueOf("2021-10-10");
		//System.out.println(Vol.checkdate(R1, "Rabat", "Paris"));
		//t.TestinsererVol(t);
		
       //Reservation.insererReservation(1, "1ère",2,"laachfoubii","fatiha");
		//Connection conn=ConnectionB.EtablissementConn();
		/*PreparedStatement pd=conn.prepareStatement(" SELECT now() ");
		ResultSet rf =pd.executeQuery();
		rf.next();
		
		PreparedStatement ps=conn.prepareStatement(" insert into times(temps) values(?) ");
		ps.setDate(1, rf.getDate(1));
		ps.executeUpdate();*/

       
        //Reservation.insererReservation(8, "1ere",2,"LARHCHIM", "ISMAIL");
        
		
		//Reservation.testDateReservation();
	
			//Admin.Statistiques();
	/***************************************************test presentation*********************************************************/
		
		
		
		/*int rp=Client.connecter("ismail864@gmail.com", "azertyuiop");
		
		if(rp==0) {
			System.out.println("*****************************");
		}
		else
			System.out.println("8796520  id="+rp);*/
		
		/*Integer a=new Integer(10);
		Integer b= new Integer(10);
		if(a.equals(b)) {
			System.out.print("hello");
		}*/
		
		
      /* Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(calendar.getTime());
        JSpinner spinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter.setOverwriteMode(true);
        spinner.setEditor(editor);
        
        Object value = spinner.getValue();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(value);*/
		//java.sql.Date R1=java.sql.Date.valueOf("2020-10-10");
		//java.sql.Date R2=java.sql.Date.valueOf("2020-10-12");
		/*Date a=Vol.checkdate(R1, "Rabat", "Paris");
		System.out.println(a);*/
		
		/*ArrayList<java.sql.Timestamp> tb = new ArrayList<java.sql.Timestamp>();
		
		java.sql.Timestamp b=Reservation.MethodeTime(16,00 ,00 );
		int a=b.getHours()+4;
		int c=b.getHours()-4;
		
		tb=Vol.CheckHour(b, R1, R2, 3,c,a);
		
		for(int i=0;i<tb.size();i++) 
		{
			System.out.println(tb.get(i).getHours()+":"+tb.get(i).getMinutes()+":"+tb.get(i).getMinutes());
		}
*/
			/*Connection conn =ConnectionB.EtablissementConn();
			PreparedStatement ps =conn.prepareStatement(" SELECT heureDepart from tvol where ID_Vol=? ");
			ps.setInt(1, 2);
			ResultSet r = ps.executeQuery();
			r.next();
			
			int x=r.getTime("heureDepart").getHours();
			int y=r.getTime("heureDepart").getMinutes();
			int z=r.getTime("heureDepart").getSeconds();      
			
			System.out.println(x+":"+y+":"+z);*/
		
			/*Timestamp a = Reservation.MethodeTime(23, 0, 30);
			
	  
	        
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		    java.util.Date d = df.parse(a.toString());
		    System.out.println(d);*/
		
		/*int a=01;
		DecimalFormat df = new DecimalFormat("00");
		String c= df.format(a);
		System.out.println(c);*/
		//Avion airbus1900 = new Avion(5 ,2000.0,3000.0,"Airbus900",25.00,50.00,100.00,"bonne",200,300,70);
      // airbus1900.Ajouter(airbus1900);
		java.sql.Date R1=java.sql.Date.valueOf("2020-09-11");
		java.sql.Date R2=java.sql.Date.valueOf("2020-10-11");
		Vol t = new Vol(13, 13, R1, R2, "01:30:00",11, 0, 0, 12, 30, 0);
		Vol.TestinsererVol(t);
		
		
	
		
	
	
	
	}

}
