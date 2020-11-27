package Presentation;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InterfaceCordonnéesGPS extends JDialog{
	
	public InterfaceCordonnéesGPS(JFrame a,String b,boolean c) 
	{
		super(a,b,c);
		
		this.setSize(new Dimension(1100,600));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		Object [][] tabGPS = { {"Rabat","33.956775199999996","-6.893655" } ,
				{"Casablanca","33.5950627","-7.6187768"}, {"Marrakech","31.6258257","-7.9891608"},
				{"Madrid","40.4167047","-3.7035825"},{"Barcelone","41.3828939","2.1774322"},
				{"Paris","48.8566969","2.3514616"},{"Marseille","43.2961743","5.3699525"},
				{"Saudia Arabia","25.6242618","42.3528328"},{"New York","40.7127281","-74.0060152"},
				{"Washington","38.8949855","-77.0365708"},{"Brésil","-10.3333333","-53.2"},
				{"Russia","64.6863136","97.7453061"},{"Japon","36.5748441","139.2394179"},
				{"China","35.000074","104.999927"}
				};
		String Titre []= {"Ville","Latitude Ville","Longitude Ville"};
		JTable tbGPS = new JTable(tabGPS,Titre);
		this.add(new JScrollPane(tbGPS));
		this.setModal(false);
		this.setVisible(true);
	}

}
