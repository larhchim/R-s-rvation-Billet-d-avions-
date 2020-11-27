package Presentation;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.PreparedStatement;

import Connection.DataBase.ConnectionB;
import Métier.Admin;
import Métier.Avion;
import Métier.StatisquesClient;

public class InterfaceAfficherSupprimerAdmin extends JDialog {
	
	public InterfaceAfficherSupprimerAdmin(JFrame a , String b , boolean c) throws Exception 
	{
		super(a,b,c);
		this.setSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(false);
		/**************/
		 ArrayList<Avion> tab=Admin.afficherAvion() ;
		
		
		    Object [][] data = new Object[tab.size()][11] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<12;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data[i][j]=(int) tab.get(i).getID_Avion();
					  break;
					  case 1 : data[i][j]=(double)tab.get(i).getVitesse();
					  break;
					  case 2 : data[i][j]=(double)tab.get(i).getAutonomie();
					  break;
					  case 3 : data[i][j]=(double) tab.get(i).getPrix_km_eco() ;
					  break;
					  case 4 : data[i][j]=(double)tab.get(i).getPrix_km_affaire();
					  break;
					  case 5 : data[i][j]=(double)tab.get(i).getPrix_km_1ere();
					  break;
					  case 6 : data[i][j]=(String)tab.get(i).getEtatAvion();
					  break;
					  case 7 : data[i][j]=(double)tab.get(i).getNombrePlaces1ere();
					  break;
					  case 8 : data[i][j]=(double)tab.get(i).getNombrePlacesEco();
					  break;
					  case 9:  data[i][j]=(double)tab.get(i).getNombrePlacesAff();
						  break;
					  case 10 : data[i][j]=(String)tab.get(i).getNomAvion();
						  break;
					  }
				  }
			  }
			  
			  String titre[]={"Numero Avion","Vitesse","Autonomie","Prix KM Economie","Prix KM Affaire","Prix KM 1ère","Etat Avion","Nombres Places 1ere","Nombre Places Economie","Nombre Places Affaire","Nom Avion" };
			  JTable tabRes = new JTable(data,titre);
			  this.add(new JScrollPane(tabRes));
			  
			  tabRes.addMouseListener( new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent evt) 
					{
						
				            int row = tabRes.rowAtPoint( evt.getPoint() );
				            int s=(int) tabRes.getModel().getValueAt(row, 0);
				            JOptionPane confirmation = new JOptionPane();
				            int conf = confirmation.showConfirmDialog(null, "voulez vous supprimer cette Avion ?","Confirmation de suppression",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				         if(conf==JOptionPane.OK_OPTION) {
				        
				        	 try {
				        		 
				        	/*	 Connection conn =ConnectionB.EtablissementConn();
					        	 PreparedStatement ps =(PreparedStatement) conn.prepareStatement(" SELECT * FROM tvol WHERE ID_Avion=?");
					        	 ps.setInt(1, s);
					        	 ResultSet rs =ps.executeQuery();
					        	 rs.next();*/
					        	 
					        	// if(!rs.first()) 
					        	// {
					        		  Admin.SupprimerAvion(s);
				        	          dispose();
									  new InterfaceAfficherSupprimerAdmin(null,"Boite De Consultation et Suppression d'Avions",true);


					        	// }
					        	 /*else 
					        	 {
					        		 int confirm = confirmation.showConfirmDialog(null, "etes vous sure de supprimer cette avion car elle occupe un ou plusieurs  Vol","Confirmation de suppression",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					        		 if(confirm==JOptionPane.OK_OPTION) 
					        		 {
					        			 try 
					        			 {
					        				 /*Connection conn1 =ConnectionB.EtablissementConn();
								        	 PreparedStatement ps1 =(PreparedStatement) conn1.prepareStatement(" DELETE FROM tvol WHERE ID_Avion=?");
								        	 ps1.setInt(1, s);
								        	 ps1.executeUpdate();
								        	 Admin.SupprimerAvion(s);
								        	 dispose();
											  new InterfaceAfficherSupprimerAdmin(null,"Boite De Consultation et Suppression d'Avions",true);

					        			 }catch(Exception e) {
					        				 e.printStackTrace();
					        			 }
					        		 }
					        	  }*/

				        		 
				        		 
				        		 
				        	
				        	 }catch(Exception e) {
				        		 e.printStackTrace();
				        	 }

				         }
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			  });
				            
			
			  
			  
		      this.setVisible(true);
		
		
		/*************/
		
	}

}
