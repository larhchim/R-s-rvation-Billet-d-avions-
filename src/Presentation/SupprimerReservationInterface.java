package Presentation;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Connection.DataBase.ConnectionB;
import Métier.Reservation;

public class SupprimerReservationInterface extends JDialog{
	int ID;
	

	public SupprimerReservationInterface(JFrame a, String b ,boolean c,int idcli) throws Exception 
	{ 
	  super(a,b,c);
	  this.ID=idcli;
	  this.setSize(new Dimension(1090,150));
	  this.setLocationRelativeTo(null);
	  this.setResizable(false);
	  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	  
	  
	  ArrayList<Reservation> tab=Reservation.ResFonc(ID) ;
	  
	 
	  Object [][] data = new Object[tab.size()][9] ;
	 
		  for(int i=0;i<tab.size();i++) 
		  {
			  for(int j=0;j<9;j++) 
			  {
				  switch(j) 
				  {
				  case 0 : data[i][j]=(int)tab.get(i).getId();
				  break;
				  case 1 : data[i][j]=(String)tab.get(i).getVilleDepart();
				  break;
				  case 2 : data[i][j]=(String)tab.get(i).getVilleArrivee();
				  break;
				  case 3 :
					  String n=tab.get(i).getHours() +":"+tab.get(i).getMinutes()+":"+tab.get(i).getSecondes();
				  data[i][j]=(String)n;
				  
				  break;
				  case 4 : data[i][j]=(String)tab.get(i).getClasse();
				  break;
				  case 5 : data[i][j]=(String)tab.get(i).getNomPer();
				  break;
				  case 6 : data[i][j]=(String)tab.get(i).getPrePer();
				  break;
				  case 7 : data[i][j]=(java.sql.Date)tab.get(i).getDateDepart();
				  break;
				  case 8 : data[i][j]=(java.sql.Date)tab.get(i).getDateArrivee();
				  break;
				  }
			  }
		  }
		  
		  String titre[]={"Numero Reservation","Ville Depart","Ville Arrivee","heure Depart","Classe","Nom Personne","Prenom personne","Date Depart","Date Arrivee" };
		  JTable tabRes = new JTable(data,titre);
		  
		tabRes.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent evt) 
			{
				
				    JTable source = (JTable)evt.getSource();
		            int row = source.rowAtPoint( evt.getPoint() );
		            //int column = source.columnAtPoint( evt.getPoint() );
		            int s=(int) source.getModel().getValueAt(row, 0);
		            String h=(String) source.getModel().getValueAt(row, 4);
		            JOptionPane confirmation = new JOptionPane();
		            int conf = confirmation.showConfirmDialog(null, "voulez vous supprimer cette reservation ?","Confirmation de suppression",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		            if(conf==JOptionPane.OK_OPTION) {
		            	try {
						
		            	
		            		Connection conn=ConnectionB.EtablissementConn();
		            		PreparedStatement ps=conn.prepareStatement(" SELECT ID_Vol From treservation Where ID_Reservation=?");
		            		ps.setInt(1, s);
		            		ResultSet rs =ps.executeQuery();
		            		rs.next();
		            		
		            		if(h.equals("1ère")) 
		            		{
		            			
		            				PreparedStatement pf=conn.prepareStatement(" Update tvol set NbrePlace1ere=NbrePlaces1ere+1 WHERE ID_Vol=? ");
		            				pf.setInt(1, rs.getInt(1));
		            				pf.executeUpdate();
		            		}
		            		else if(h.equals("Affaire")) 
		            		{
		            				PreparedStatement pf=conn.prepareStatement(" Update tvol set NbrePlacesAff=NbrePlacesAff+1 WHERE ID_Vol=? ");
		            				pf.setInt(1, rs.getInt(1));
		            				pf.executeUpdate();
		            		}
		            		else if(h.equals("Economie")) 
		            		{
		            				PreparedStatement pf=conn.prepareStatement(" Update tvol set NbrePlacesEco=NbrePlacesEco+1 WHERE ID_Vol=? ");
		            				pf.setInt(1, rs.getInt(1));
		            				pf.executeUpdate();
		            		}
		            		Reservation.supprimerReservation(s);
		            		
		            		dispose();
		            		new SupprimerReservationInterface(null,"Boite d'annulation de Reservations",true, FenetreSeConnecter.IDClient);
		            		
					
						} catch (Exception e) {
							// TODO Auto-generated catch block
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
		  
		  
		  this.add(new JScrollPane(tabRes));
		  
	  
	 
	      this.setVisible(true);
	  
	}
	

	


}
