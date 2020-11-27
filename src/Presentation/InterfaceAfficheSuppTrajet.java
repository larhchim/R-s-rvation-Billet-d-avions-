package Presentation;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Métier.Admin;
import Métier.Avion;
import Métier.Trajet;

public class InterfaceAfficheSuppTrajet extends JDialog{
	
	public InterfaceAfficheSuppTrajet(JFrame a, String b , boolean c) throws Exception {
		super(a,b,c);
		this.setSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		/**************/
		 ArrayList<Trajet> tab=Admin.afficherTrajet() ;

		
		    Object [][] data1 = new Object[tab.size()][8] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<9;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data1[i][j]=(int)tab.get(i).getNumT();
					  break;
					  case 1 : data1[i][j]=(String) tab.get(i).getVilleDepart();
					  break;
					  case 2 : data1[i][j]=(String)tab.get(i).getVilleArrivee();
					  break;
					  case 3 : data1[i][j]=(double)tab.get(i).getLatitudeVilleDepart();
					  break;
					  case 4 : data1[i][j]=(double) tab.get(i).getLongitudeVilleDepart();
					  break;
					  case 5 : data1[i][j]=(double)tab.get(i).getLatitudeVilleArrivee();
					  break;
					  case 6 : data1[i][j]=(double)tab.get(i).getLongitudeVilleArrivee();
					  break;
					  case 7 : data1[i][j]=(double)tab.get(i).getDistance();
					  break;
			
					  }
				  }
			  }
			  
			  String titre[]={"Numéro Trajet","Ville Depart","Ville Arrivee","Latitude Ville Depart","Longitude Ville Depart","Latitude Ville Arrivee","Longitude Ville Arrivee","Distance"};
			  JTable tabRes = new JTable(data1,titre);
			  this.add(new JScrollPane(tabRes));
			  
			  tabRes.addMouseListener( new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent evt) 
					{
						
				            int row = tabRes.rowAtPoint( evt.getPoint() );
				            int s=(int) tabRes.getModel().getValueAt(row, 0);
				            JOptionPane confirmation = new JOptionPane();
				            int conf = JOptionPane.showConfirmDialog(null, "voulez vous supprimer Ce Trajet ?","Confirmation de suppression",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				         if(conf==JOptionPane.OK_OPTION) {
				        
				        	 try {
				        		 
					        		  Admin.SupprimerTrajet(s);
				        	          dispose();
				  					new InterfaceAfficheSuppTrajet(null,"Boite D'affichage et De Suppression De Trajet",true);

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
