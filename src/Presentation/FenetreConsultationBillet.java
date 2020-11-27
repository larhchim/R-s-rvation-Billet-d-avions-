package Presentation;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import M�tier.Admin;
import M�tier.Billet;
import M�tier.Classe;

public class FenetreConsultationBillet extends JDialog{
	
	static int IDClient;
	public FenetreConsultationBillet(JFrame a,String b,boolean c,int id) throws Exception {
		super(a,b,c);
		IDClient=id;
		this.setSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		/**************/
		 ArrayList<Billet> tab=Billet.EnsembleBillets(IDClient) ;

		
		    Object [][] data1 = new Object[tab.size()][4] ;
		 
			  for(int i=0;i<tab.size();i++) 
			  {
				  for(int j=0;j<5;j++) 
				  {
					  switch(j) 
					  {
					  case 0 : data1[i][j]=(int)tab.get(i).getIDBillet();
					  break;
					  case 1 : data1[i][j]=(int)tab.get(i).getIDResevation();
					  break;
					  case 2 : data1[i][j]=(int)tab.get(i).getIDClient();
					  break;
					  case 3 : 
						  double a1= tab.get(i).getPrixTotale();
						  data1[i][j]=(String) String.valueOf(a1)+" "+"DHS";
					  break;
					  }
				  }
			  }
			  
			  String titre[]={"Num�ro Billet","Num�ro de Reservation","Num�ro Client","Prix Totale"};
			  JTable tabRes = new JTable(data1,titre);
			  this.add(new JScrollPane(tabRes));
			  
			  this.setModal(false);
			  
		      this.setVisible(true);
	}

}
