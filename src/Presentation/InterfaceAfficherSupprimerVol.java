package Presentation;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Métier.Admin;
import Métier.Trajet;
import Métier.Vol;
import Métier.Volbis;

public class InterfaceAfficherSupprimerVol extends JDialog{
	
	public InterfaceAfficherSupprimerVol(JFrame a,String b,boolean c) throws Exception {
		super(a,b,c);
		
		this.setSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		/**************/
		 ArrayList<Volbis> tab=Admin.afficherVol() ;

		
		    Object [][] data1 = new Object[tab.size()][8] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<9;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data1[i][j]=(int)tab.get(i).getID_Vol();
					  break;
					  case 1 : data1[i][j]=(int)tab.get(i).getID_Trajet();
					  break;
					  case 2 : data1[i][j]=(int) tab.get(i).getID_Avion();
					  break;
					  case 3 : data1[i][j]=(Date)tab.get(i).getDateDepart();
					  break;
					  case 4 : data1[i][j]=(Date)tab.get(i).getDateArrivee();
					  break;
					  case 5 : data1[i][j]=(String) tab.get(i).getDuree();
					  break;
					  case 6 : String n=tab.get(i).getHours()+":"+tab.get(i).getMinutes()+":"+tab.get(i).getSecondes();
						  String table1[]=n.split(":");
						  int A1 =Integer.valueOf(table1[0]);
						  int A2 =Integer.valueOf(table1[1]);
						  int A3 =Integer.valueOf(table1[2]);
						  if(A1<10 && A2>=10 && A3>=10) {
							  String M1="0"+A1;
							  n=M1+":"+tab.get(i).getMinutes()+":"+tab.get(i).getSecondes();
							  data1[i][j]=(String)n;
						  }
						  else if(A2<10 && A1>=10 && A3>=10) {
							  String M2="0"+A2;
							  n=tab.get(i).getHours()+":"+M2+":"+tab.get(i).getSecondes();
							  data1[i][j]=(String)n;
						  }
						  else if(A3<10 && A1>=10 && A2>=10) {
							  String M3="0"+A3;
							  n=tab.get(i).getHours()+":"+tab.get(i).getMinutes()+":"+M3;
							  data1[i][j]=(String)n;
						  }
						  else if(A3<10 && A2<10 && A1<10) {
							  String M1="0"+A1;
							  String M2="0"+A2;
							  String M3="0"+A3;
							  n=M1+":"+M2+":"+M3;
							  data1[i][j]=(String)n;
						  }
						  else
							data1[i][j]=(String)n ;
						  
					  break;
					  case 7 : String v=tab.get(i).getHours2()+":"+tab.get(i).getMinutes2()+":"+tab.get(i).getSecondes2();
					  String table2[]=v.split(":");
					  int AA1 =Integer.valueOf(table2[0]);
					  int AA2 =Integer.valueOf(table2[1]);
					  int AA3 =Integer.valueOf(table2[2]);
					  if(AA1<10 && AA2>=10 && AA3>=10) {
						  String M1="0"+AA1;
						  v=M1+":"+tab.get(i).getMinutes()+":"+tab.get(i).getSecondes();
						  data1[i][j]=(String)v;
					  }
					  else if(AA2<10 && AA1>=10 && AA3>=10) {
						  String M2="0"+AA2;
						  v=tab.get(i).getHours()+":"+M2+":"+tab.get(i).getSecondes();
						  data1[i][j]=(String)v;
					  }
					  else if(AA3<10 && AA1>=10 && AA2>=10) {
						  String M3="0"+AA3;
						  v=tab.get(i).getHours()+":"+tab.get(i).getMinutes()+":"+M3;
						  data1[i][j]=(String)v;
					  }
					  else if(AA3<10 && AA2<10 && AA1<10) {
						  String M1="0"+AA1;
						  String M2="0"+AA2;
						  String M3="0"+AA3;
						  v=M1+":"+M2+":"+M3;
						  data1[i][j]=(String)v;
					  }
					  else
					      data1[i][j]=(String)v;
					  break;
					  }
				  }
			  }
			  
			  String titre[]={"Numéro Vol","Numéro Trajet","Numéro Avion","Date Depart","Date Arrivee","Duree","Heure Depart","Heure Arrivee"};
			  JTable tabRes = new JTable(data1,titre);
			  this.add(new JScrollPane(tabRes));
			  
			  tabRes.addMouseListener( new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent evt) 
					{
						
				            int row = tabRes.rowAtPoint( evt.getPoint() );
				            int s=(int) tabRes.getModel().getValueAt(row, 0);
				            JOptionPane confirmation = new JOptionPane();
				            int conf = JOptionPane.showConfirmDialog(null, "voulez vous supprimer Ce Vol ?","Confirmation de suppression",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				         if(conf==JOptionPane.OK_OPTION) {
				        
				        	 try {
				        		 
					        		  Admin.SupprimerVol(s);
				        	          dispose();
				  					  new InterfaceAfficherSupprimerVol(null,"Boite D'affichage et De Suppression De Vol",true);


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
				            
			
			  this.setModal(false);
			  
		      this.setVisible(true);
		
	}

}
