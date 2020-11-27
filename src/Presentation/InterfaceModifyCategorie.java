package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Métier.Admin;

public class InterfaceModifyCategorie extends JDialog{
	
	static int ID_Categorie;
	JButton SignUp=new JButton("enregistrer");
	JPanel pane = new JPanel();
	public InterfaceModifyCategorie(JFrame a,String b,boolean c,int ID) throws Exception {
		super(a,b,c);
		this.ID_Categorie=ID;
		this.setSize(new Dimension(950,250));
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(false);
	    this.setLayout(new FlowLayout());

		ArrayList<Métier.Categorie> liste;
		liste=Métier.Categorie.SELECTCategorie(ID_Categorie);
		
	    JPanel LibelleCategorie = new JPanel();
	    LibelleCategorie.setPreferredSize(new Dimension(300,70));
	    JTextField tLib = new JTextField(liste.get(0).getLibelleCategorie());
	    tLib.setPreferredSize(new Dimension(125,30));
	    LibelleCategorie.setBorder(BorderFactory.createTitledBorder(null,"Libellé Catégorie", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		LibelleCategorie.add(tLib);
		

	    JPanel PourcentageReduction = new JPanel();
	    PourcentageReduction.setPreferredSize(new Dimension(300,70));
	    JTextField tPour = new JTextField(String.valueOf(liste.get(0).getPourcentageReduction()));
	    tPour.setPreferredSize(new Dimension(125,30));
	    PourcentageReduction.setBorder(BorderFactory.createTitledBorder(null,"Pourcentage Reduction", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		PourcentageReduction.add(tPour);
		
		this.add(LibelleCategorie);
		this.add(PourcentageReduction);
		
		pane.setPreferredSize(new Dimension(500,70));
	    pane.add(SignUp);
	    this.add(pane);
	    
	    SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Admin.ModifierCategorie(new Métier.Categorie( ID_Categorie, tLib.getText() , Double.valueOf(tPour.getText() ) ));
					dispose();
					JOptionPane.showMessageDialog(null, "Catégorie Modifiée avec succés","Message d'information",JOptionPane.INFORMATION_MESSAGE);
					new InterfaceAfficherModifyAddCategorie(null,"Boite D'affichage et de Modification De Categories",true);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	    	
	    });
	    
		this.setModal(false);
		this.setVisible(true);
		
	}

}
