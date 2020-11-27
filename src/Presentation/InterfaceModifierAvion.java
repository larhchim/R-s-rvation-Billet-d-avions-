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

public class InterfaceModifierAvion extends JDialog{
	
	public InterfaceModifierAvion(JFrame a,String b , boolean c) throws Exception {
		 super(a,b,c);
		 this.setSize(new Dimension(1100,500));
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setModal(false);
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
					            int conf = confirmation.showConfirmDialog(null, "voulez vous Modifier cette Avion ?","Confirmation de Modification",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					         if(conf==JOptionPane.OK_OPTION) {
					        
					        	 try {
					        
						        		
                                new ConfirmationDeModificationAvion(null,"Boite De Confirmation De Modification Avion",true,s);
                                dispose();
					        	
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
	}

}
