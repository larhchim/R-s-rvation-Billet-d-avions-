package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Métier.Admin;

public class InterfaceAjouterTrajet extends JDialog
{
	JButton SignUp= new JButton("enregistrer");
	JMenuBar aide = new JMenuBar();

	public InterfaceAjouterTrajet(JFrame a,String b,boolean c) 
	{
		super(a,b,c);
		this.setSize(new Dimension(950,300));
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	    JPanel VilleDepart = new JPanel();
	    VilleDepart.setPreferredSize(new Dimension(300,70));
	    JTextField tvilleD = new JTextField();
	    tvilleD.setPreferredSize(new Dimension(125,30));
	    VilleDepart.setBorder(BorderFactory.createTitledBorder(null,"Ville Depart", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		VilleDepart.add(tvilleD);
		
		
	    JPanel VilleArrivee = new JPanel();
	    VilleArrivee.setPreferredSize(new Dimension(300,70));
	    JTextField tvilleA = new JTextField();
	    tvilleA.setPreferredSize(new Dimension(125,30));
	    VilleArrivee.setBorder(BorderFactory.createTitledBorder(null,"Ville Arrivee", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		VilleArrivee.add(tvilleA);
		
		JPanel LatitudeVilleDepart = new JPanel();
	    LatitudeVilleDepart.setPreferredSize(new Dimension(300,70));
	    JTextField LtvilleD = new JTextField();
	    LtvilleD.setPreferredSize(new Dimension(125,30));
	    LatitudeVilleDepart.setBorder(BorderFactory.createTitledBorder(null,"Latitude Ville Depart", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		LatitudeVilleDepart.add(LtvilleD);
			
	    JPanel LatitudeVilleArrivee = new JPanel();
	    LatitudeVilleArrivee.setPreferredSize(new Dimension(300,70));
	    JTextField LtvilleA = new JTextField();
	    LtvilleA.setPreferredSize(new Dimension(125,30));
	    LatitudeVilleArrivee.setBorder(BorderFactory.createTitledBorder(null,"Latitude Ville Arrivee", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		LatitudeVilleArrivee.add(LtvilleA);
		
		JPanel LongitudeVilleDepart = new JPanel();
	    LongitudeVilleDepart.setPreferredSize(new Dimension(300,70));
	    JTextField LgtvilleD = new JTextField();
	    LgtvilleD.setPreferredSize(new Dimension(125,30));
	    LongitudeVilleDepart.setBorder(BorderFactory.createTitledBorder(null,"Longitude Ville Depart", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
	    LongitudeVilleDepart.add(LgtvilleD);
			
	    JPanel LongitudeVilleArrivee = new JPanel();
	    LongitudeVilleArrivee.setPreferredSize(new Dimension(300,70));
	    JTextField LgtvilleA = new JTextField();
	    LgtvilleA.setPreferredSize(new Dimension(125,30));
	    LongitudeVilleArrivee.setBorder(BorderFactory.createTitledBorder(null,"Longitude Ville Arrivee", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
	    LongitudeVilleArrivee.add(LgtvilleA);
	    
	    this.setLayout(new FlowLayout());
	    this.add(VilleDepart);
	    this.add(VilleArrivee);
	    this.add(LatitudeVilleDepart);
	    this.add(LongitudeVilleDepart);
	    this.add(LatitudeVilleArrivee);
	    this.add(LongitudeVilleArrivee);
	    
	    JPanel button = new JPanel();
	    button.add(SignUp);
	    this.add(button);
	    
	    JMenu menuaide = new JMenu("Aide");
	    JMenuItem mn= new JMenuItem("Liste des Coordonnées de quelques Villes");
	    menuaide.add(mn);
	    aide.add(menuaide);
	    this.setJMenuBar(aide);
	    this.setModal(false);
	    
	    SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Admin.AjouterTrajet( tvilleD.getText() , tvilleA.getText() , Double.valueOf(LtvilleD.getText()) , Double.valueOf(LgtvilleD.getText()) ,Double.valueOf(LtvilleA.getText()) , Double.valueOf(LgtvilleA.getText())  )  ;
					JOptionPane.showMessageDialog(null,"Trajet ajoutée avec succés","Message informatif",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	    	
	    });
	    
	    mn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new InterfaceCordonnéesGPS(null,"Boite De Coordonnées GPS",true);
				
			}
	    	
	    });

	    this.setVisible(true);
		
	}
	
}
