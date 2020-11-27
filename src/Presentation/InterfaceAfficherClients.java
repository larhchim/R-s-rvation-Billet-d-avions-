package Presentation;

import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Métier.Admin;
import Métier.Avion;
import Métier.Client;

public class InterfaceAfficherClients extends JDialog
{
	
	public InterfaceAfficherClients(JFrame a,String b,boolean c) throws Exception 
	{
		super(a,b,c);
		this.setSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(false);
		/**************/
		 ArrayList<Client> tab=Admin.afficherClients() ;
		
		
		    Object [][] data = new Object[tab.size()][9] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<10;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data[i][j]=(String) tab.get(i).getNomClient();
					  break;
					  case 1 : data[i][j]=(String)tab.get(i).getPrenomClient();
					  break;
					  case 2 : data[i][j]=(String)tab.get(i).getCategorieClient();
					  break;
					  case 3 : data[i][j]=(String) tab.get(i).getCINClient() ;
					  break;
					  case 4 : data[i][j]=(Date)tab.get(i).getDateNaissance();
					  break;
					  case 5 : data[i][j]=(String)tab.get(i).getLoginClient();
					  break;
					  case 6 : data[i][j]=(String)tab.get(i).getPasswordClient();
					  break;
					  case 7 : data[i][j]=(String)tab.get(i).getNumPasseport();
					  break;
					  case 8 : data[i][j]=(String)tab.get(i).getNationalite();
					  break;
				
			
					  }
				  }
			  }
			  
			  String titre[]={"Nom Client","Prenom Client","Categorie Client","CIN Client","Date Naissance Client","Login Client","Password Client","Numéro Passeport","Nationalité" };
			  JTable tabRes = new JTable(data,titre);
			  this.add(new JScrollPane(tabRes));
			  
			  this.setVisible(true);
	}

}
