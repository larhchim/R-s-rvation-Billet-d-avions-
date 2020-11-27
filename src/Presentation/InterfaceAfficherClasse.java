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
import Métier.Classe;
import Métier.Volbis;

public class InterfaceAfficherClasse extends JDialog{
	
	public InterfaceAfficherClasse(JFrame a,String b,boolean c) throws Exception {
		
		super(a,b,c);
		this.setSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		/**************/
		 ArrayList<Classe> tab=Admin.afficherClasse() ;

		
		    Object [][] data1 = new Object[tab.size()][2] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<3;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data1[i][j]=(int)tab.get(i).getID_Classe();
					  break;
					  case 1 : data1[i][j]=(String)tab.get(i).getLibelleClasse();
					  break;
					  }
				  }
			  }
			  
			  String titre[]={"Numéro Classe","Libbellé Classe"};
			  JTable tabRes = new JTable(data1,titre);
			  this.add(new JScrollPane(tabRes));
			  
			  this.setModal(false);
			  
		      this.setVisible(true);
		
	}

}
