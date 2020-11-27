package Métier;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.*;

import Connection.DataBase.ConnectionB;
public class datetestMain {
	
	public static void main(String  args []) throws Exception {
		
			/*Date*/
			
			//System.out.println(date2);
			
			
			/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			// replace with your start date string
			Date d = df.parse("2008-04-05 13:37:00");
			
			Long time = d.getTime();
			
			time +=(4*60*60*1000);
			//System.out.println(df.getTime());
			java.util.Date d2 = new Date(time);
			System.out.println(d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds());*/
			
			/*GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(d);
			System.out.println("Mois : " + (calendar.get(GregorianCalendar.MONTH) )+"-year :"+(calendar.get(GregorianCalendar.YEAR))+"-jour :"+(calendar.get(GregorianCalendar.DAY_OF_WEEK)));*/
			   
			
			  
				/*java.sql.Connection conn= ConnectionB.EtablissementConn();
			PreparedStatement ps = conn.prepareStatement("insert into tdate(DATE) values(?)");
			ps.setDate(1,date2);
			ps.executeUpdate();*/
			
			  /* Date date = new Date(2018,04,30);
			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			   String strDate = dateFormat.format(date);  
			   System.out.println("Converted String: " + strDate);  */
			
			/*String stringDate="2020-05-27 16:49:00";   
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			java.util.Date date1=formatter1.parse(stringDate);  
			java.sql.Date date2 = new java.sql.Date(date1.getTime());
			
			Calendar calendar =Calendar.getInstance();
			calendar.setTime(date2);
			System.out.println("jour: "+(calendar.get(Calendar.DAY_OF_MONTH)+6));                  
			System.out.println("Mois: "+((calendar.get(Calendar.MONTH)+1)+4));
			System.out.println("annee: "+(calendar.get(Calendar.YEAR)+5));
			
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//Date d = df.parse("2008-04-05 13:37:00");
			Long time = date1.getTime();
			time +=(2*60*60*1000);
			java.util.Date d2 = new Date(time);
			System.out.println("heure: "+d2.getHours()+":"+d2.getMinutes()+":"+d2.getSeconds());*/
			
			//java.sql.Date R1=java.sql.Date.valueOf("2050-04-10");
			//java.sql.Date R2=java.sql.Date.valueOf("2070-10-20");
			//java.util.Date temps= new java.util.Date(R1.getTime());
			   // System.out.println(temps);
			   
			   // testDate y= new testDate(R1,R2,"arfoud","zagora");
			  //  int t=y.DetectionDate(R2, "casa", "fes");
			//System.out.println("valeur===?"+t);
			   // y.checkdate(R1,"casa","fes");
			//y.inseretion(y);
			   /* String a="12:00:00";
			    String b="04:00:00";
			    String c=a+b;
			    System.out.println(c);*/
			 
			    
				/*java.sql.Connection conn= ConnectionB.EtablissementConn();
			PreparedStatement ps = conn.prepareStatement("insert into ins (Date,DateAriver) values(?,?)");
			ps.setDate(1,R1);
			ps.setDate(2,R2);
			ps.executeUpdate();*/

	}
   
}
