package Presentation;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Connection.DataBase.ConnectionB;
import Métier.Reservation;
import Métier.Vol;

public class PanneauBtnReserver extends JDialog{
	 static int ID;
	
	 public PanneauBtnReserver(JFrame a , String b,boolean c,ArrayList<Vol> tableau,int idcli) throws Exception {
		 
		 super(a,b,c);
		 this.ID=idcli;
         ArrayList<Vol> tabVol=tableau;;
         this.setSize(new Dimension(800,500));
 		 this.setLocationRelativeTo(null);
 		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         
         Connection conn=ConnectionB.EtablissementConn();
		 
		 
		  Object [][] data = new Object[tabVol.size()][8] ;
		
			  for(int i=0;i<tabVol.size();i++) 
			  {
				  for(int j=0;j<8;j++) 
				  {
					  switch(j) 
					  {
					  
					  case 0 :
						  
					  PreparedStatement pq = conn.prepareStatement(" SELECT NomAvion FROM tavion WHERE ID_Avion=? ");
					  pq.setInt(1, tabVol.get(i).getID_Avion());
					  ResultSet rq =pq.executeQuery();
					  rq.next();
					  data[i][j]= (String) rq.getString(1);
					  break;
					  
					  case 1 : data[i][j]=(Date) tabVol.get(i).getDateDepart();
					  break;
					  
					 
					  case 2 : data[i][j]=(Date) tabVol.get(i).getDateArrivee();
					  break;
					  
					  case 3 : data[i][j]=(String)tabVol.get(i).getDuree();
					  break;
					  
					  case 4 :
							/*DecimalFormat df = new DecimalFormat("00");
							String n= df.format(tabVol.get(i).getHours())+":"+df.format(tabVol.get(i).getMinutes())+":"+df.format(tabVol.get(i).getSecondes());
							data[i][j]=(String)n;*/
							
						 String n=tabVol.get(i).getHours() +":"+tabVol.get(i).getMinutes()+":"+tabVol.get(i).getSecondes();
						 data[i][j]=(String)n;
				       break;
					  
					  case 5 :
						   /*DecimalFormat df2 = new DecimalFormat("00");
							String n2= df2.format(tabVol.get(i).getHours2())+":"+df2.format(tabVol.get(i).getMinutes2())+":"+df2.format(tabVol.get(i).getSecondes2());
							data[i][j]=(String)n2;*/
						  String n2=tabVol.get(i).getHours2() +":"+tabVol.get(i).getMinutes2()+":"+tabVol.get(i).getSecondes2();
						  data[i][j]=(String)n2;
					  break;
					  
					  case 6 :  PreparedStatement p3 = conn.prepareStatement(" SELECT VilleDepart FROM ttrajet WHERE ID_Trajet=? ");
					  p3.setInt(1, tabVol.get(i).getID_Trajet());
					  ResultSet rp =p3.executeQuery();
					  rp.next();
					            data[i][j]=(String)rp.getString(1);
					  break;
					  
					  case 7 :  PreparedStatement q = conn.prepareStatement(" SELECT VilleArrivee FROM ttrajet WHERE ID_Trajet=? ");
					  q.setInt(1, tabVol.get(i).getID_Trajet());
					  ResultSet w =q.executeQuery();
					  w.next();
					             data[i][j]=(String)w.getString(1);
					  break;
					  }
				  }
			  }
			  
			  String titre[]={"NomAvion","Date Depart","Date Arrivee","Duree","heureDepart","heureArrivee","Ville Depart","Ville Arrivee"};
			  JTable tabRes = new JTable(data,titre);
			  /***************begin**********/
			tabRes.addMouseListener( new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent evt) 
				{
			          
					    JTable source = (JTable)evt.getSource();
			            int row = source.rowAtPoint( evt.getPoint() );
			            int column = source.columnAtPoint( evt.getPoint() );
			            String e=(String) source.getModel().getValueAt(row, 0); //NomAvion
			            Date   f=(Date) source.getModel().getValueAt(row,1 ); //date depart
			            Date   g=(Date) source.getModel().getValueAt(row, 2); //date arrivee
			            String h=(String) source.getModel().getValueAt(row, 3); //duree
			            String i=(String) source.getModel().getValueAt(row, 4); //heuredepart
			            String k=(String) source.getModel().getValueAt(row, 6); //ville depart
			            String l=(String) source.getModel().getValueAt(row, 7);  //ville arrivee
			            
			             String tabheure[]=i.split(":");
			             Integer hh=Integer.valueOf(tabheure[0]);
						 Integer mm=Integer.valueOf(tabheure[1]);
						 Integer ss=Integer.valueOf(tabheure[2]);
						 
						 java.sql.Timestamp HD=FenetreSeConnecter.MethodeTime(hh,mm,ss);
			            JOptionPane confirmation = new JOptionPane();
			            
			           int conf = confirmation.showConfirmDialog(null, "voulez vous reserver ce Vol ?","Confirmation de reservation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			            
			            
			           if(conf==JOptionPane.OK_OPTION) 
			            {
			            try {
			           
						 
						 
						 PreparedStatement p = conn.prepareStatement(" SELECT ID_Avion from tavion WHERE NomAvion like ?");
						 p.setString(1, e);
						 ResultSet u=p.executeQuery();
						 u.next();
						 
						 PreparedStatement pz = conn.prepareStatement(" SELECT ID_Trajet from ttrajet WHERE VilleDepart=? AND VilleArrivee=?");
						 pz.setString(1, k);
						 pz.setString(2, l);
						 ResultSet rz=pz.executeQuery();
						 rz.next();

						 
						 PreparedStatement pp = conn.prepareStatement(" SELECT ID_Vol from tvol WHERE ID_Avion=? AND DateDepart=? AND heureDepart=? AND ID_Trajet=?");
						 pp.setInt(1, u.getInt(1));
						 pp.setDate(2, f);
						 pp.setTimestamp(3, HD);
						 pp.setInt(4, rz.getInt(1));
						 ResultSet ry = pp.executeQuery();
						 ry.next();
						 
						 
				         
				        


								
				             new PaneauInterfaceReservation(null,"Boite De Reservation De Vol",true,ID,ry.getInt(1));
							
							
				    
				            
				            
			            
			            
			            }catch(Exception e1) {
			            	e1.printStackTrace();
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
			
			/**************End Mouse Listener**********/
			
			this.add(new JScrollPane(tabRes));
	
	
	        this.setVisible(true);
}
	 
	 

}
