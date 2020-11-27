package Presentation;

import java.awt.Dimension;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Métier.Admin;
import Métier.Reservation;
import Métier.StatisquesClient;

public class InterfaceStatistiquesAdmin extends JDialog
{

	public InterfaceStatistiquesAdmin(JFrame a,String b,boolean c) throws Exception 
	{
		super(a,b,c);
		this.setSize(new Dimension(800,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(false);
		/**************/
		 ArrayList<StatisquesClient> tab=Admin.Statistiques() ;
		
		    Object [][] data = new Object[tab.size()][9] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<9;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data[i][j]=(int) tab.get(i).getID_Client();
					  break;
					  case 1 : data[i][j]=(String)tab.get(i).getNomPersonne();
					  break;
					  case 2 : data[i][j]=(String)tab.get(i).getPrenomPersonne();
					  break;
					  case 3 : data[i][j]=(String) tab.get(i).getHeureDepart().toString() ;
					  break;
					  case 4 : data[i][j]=(String)tab.get(i).getHeureArrivee().toString();
					  break;
					  case 5 : data[i][j]=(String)tab.get(i).getVilleDepart();
					  break;
					  case 6 : data[i][j]=(String)tab.get(i).getVilleArrivee();
					  break;
					  case 7 : data[i][j]=(java.sql.Date)tab.get(i).getDateDepart();
					  break;
					  case 8 : data[i][j]=(String)tab.get(i).getNomAvion();
					  break;
					  }
				  }
			  }
			  
			  String titre[]={"Numero Client","Nom Personne","Prenom Personne","heure Depart","heure Arrivee","Ville Depart","Ville Arrivee","Date Depart","Nom Avion" };
			  JTable tabRes = new JTable(data,titre);
			  this.add(new JScrollPane(tabRes));
		      this.setVisible(true);
		
		
		/*************/
		
		
		
	}
}
