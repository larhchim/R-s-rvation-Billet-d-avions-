package Presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import M�tier.Admin;
import M�tier.Classe;

public class InterfaceAfficherModifyAddCategorie extends JDialog
{
	JMenuBar ajouterCategorie = new JMenuBar();
	private static final long serialVersionUID = 1L;

	public InterfaceAfficherModifyAddCategorie(JFrame a,String b,boolean c) throws Exception {
		
		super(a,b,c);
		this.setSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		JMenu ADD = new JMenu("Ajouter");
		JMenuItem addMoore= new JMenuItem("Ajouter D'autres Cat�gories");
		ADD.add(addMoore);
		ajouterCategorie.add(ADD);
		this.setJMenuBar(ajouterCategorie);
		
		 ArrayList<M�tier.Categorie> tab=Admin.afficherCategorie() ;

		
		    Object [][] data1 = new Object[tab.size()][3] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<4;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data1[i][j]=(int)tab.get(i).getID_Categorie();
					  break;
					  case 1 : data1[i][j]=(String)tab.get(i).getLibelleCategorie();
					  break;
					  case 2 : data1[i][j]=(double)tab.get(i).getPourcentageReduction();
					  break;
					  }
				  }
			  }
			  
			  String titre[]={"Num�ro Cat�gorie","Libbell� Cat�gorie","Pourcentage R�duction"};
			  JTable tabRes = new JTable(data1,titre);
			  this.add(new JScrollPane(tabRes));
			  
			  tabRes.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent evt) {
					
					
				     int row = tabRes.rowAtPoint( evt.getPoint() );
			            int s=(int) tabRes.getModel().getValueAt(row, 0);
			            JOptionPane confirmation = new JOptionPane();
			            int conf = JOptionPane.showConfirmDialog(null, "voulez vous Modifier cette Cat�gorie ?","Confirmation de Modification",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			         if(conf==JOptionPane.OK_OPTION) {
			        
			        	 try {
			        		 
				        		new InterfaceModifyCategorie(null,"Boite De Modification De Cat�gorie",true,s);
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
			  
			  addMoore.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					new InterfaceAjouterCat�gorie(null,"Boite D'ajout De Cat�gories",true);
					
				}
				  
			  });
			  
			  this.setModal(false);
			  
		      this.setVisible(true);
		
	}

}
