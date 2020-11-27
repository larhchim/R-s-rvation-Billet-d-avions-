package Presentation;

import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Métier.Admin;
import Métier.Client;
import Métier.Reservationbis;

public class InterfaceAfficherResrvations extends JDialog{
	
	public InterfaceAfficherResrvations(JFrame a,String b,boolean c) throws Exception 
	{
		super(a,b,c);
		this.setSize(new Dimension(1200,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		ArrayList<Reservationbis> tab=Admin.afficherReservation();
		Object [][] data = new Object[tab.size()][13];
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<14;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data[i][j]=(int) tab.get(i).getId();
					  break;
					  case 1 : data[i][j]=(String)tab.get(i).getVilleDepart();
					  break;
					  case 2 : data[i][j]=(String)tab.get(i).getVilleArrivee();
					  break;
					  case 3 : data[i][j]=(Date) tab.get(i).getDateDepart();
					  break;
					  case 4 : data[i][j]=(Date)tab.get(i).getDateArrivee();
					  break;
					  case 5 :  String n=(String) (tab.get(i).getHours()+":"+tab.get(i).getMinutes()+":"+tab.get(i).getSecondes());
					  data[i][j]=(String)n;
					  break;
					  case 6 : data[i][j]=(String)tab.get(i).getClasse();
					  break;
					  case 7 : data[i][j]=(String)tab.get(i).getPrePer();
					  break;
					  case 8 : data[i][j]=(String)tab.get(i).getNomPer();
					  break;
					  case 9 : data[i][j]=(int)tab.get(i).getNumCli();
					  break;
					  case 10: data[i][j]=(int)tab.get(i).getNumVol();
					  break;
					  case 11: data[i][j]=(Date)tab.get(i).getDateRes();
					  break;
					  case 12: data[i][j]=(String)tab.get(i).getNumPass();
					  break;
				
			
					  }
				  }
			  }
			  
			  String titre[]={"Numéro Reservation","Ville Depart","Ville Arrivee","Date Depart","Date Arrivee","heure Depart","Classe Client","Prenom Personne","Nom Personne","Numéro Client","Numéro Vol","Date Reservation","Numéro Passeport" };
			  JTable tabRes = new JTable(data,titre);
			  this.add(new JScrollPane(tabRes));
			  this.setModal(false);
			  this.setVisible(true);
	}

}
