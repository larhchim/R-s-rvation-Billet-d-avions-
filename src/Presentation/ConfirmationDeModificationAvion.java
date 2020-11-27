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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;

import Connection.DataBase.ConnectionB;
import Métier.Admin;
import Métier.Avion;

public class ConfirmationDeModificationAvion extends JDialog{
	
	 JButton SignUp =new JButton("enregistrer");
	 static int ID_Avion;
		
		public ConfirmationDeModificationAvion(JFrame a,String b,boolean c,int ID_Av) throws Exception 
		{
			super(a,b,c);
			ConfirmationDeModificationAvion.ID_Avion=ID_Av;
			this.setSize(new Dimension(950,390));
			this.setResizable(false);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			Connection conn=(Connection) ConnectionB.EtablissementConn();
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(" SELECT * FROM tavion WHERE ID_Avion=? ");
			ps.setInt(1, ID_Avion);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			JPanel Vitesse = new JPanel();
			JTextField td2 = new JTextField(String.valueOf(rs.getDouble(2)));
			Vitesse.setPreferredSize(new Dimension(300,70));
			td2.setPreferredSize(new Dimension(150,30));
			Vitesse.setBorder(BorderFactory.createTitledBorder(null, "Vitesse d'Avion", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			Vitesse.add(td2);
			
			
			JPanel Autonomie = new JPanel();
			JTextField ta = new JTextField(String.valueOf(rs.getDouble(3)));
			Autonomie.setPreferredSize(new Dimension(300,70));
			ta.setPreferredSize(new Dimension(150,30));
			Autonomie.setBorder(BorderFactory.createTitledBorder(null, "Autonomie d'Avion", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
	        Autonomie.add(ta);
	        
	        JPanel NomAvion = new JPanel();
			JTextField tn = new JTextField(rs.getString(4));
			NomAvion.setPreferredSize(new Dimension(300,70));
			tn.setPreferredSize(new Dimension(150,30));
			NomAvion.setBorder(BorderFactory.createTitledBorder(null, "Nom d'Avion", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
	        NomAvion.add(tn);
	        
	        JPanel PrixEco = new JPanel();
	        JTextField tp = new JTextField(String.valueOf(rs.getDouble(5)));
	        PrixEco.setPreferredSize(new Dimension(300,70));
	        tp.setPreferredSize(new Dimension(150,30));
			PrixEco.setBorder(BorderFactory.createTitledBorder(null, "Prix 6m Economie", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
	        JLabel Pr = new JLabel("PRIX KM ECO");
	        PrixEco.add(tp);
	        
	        JPanel PrixAff= new JPanel();
	        JTextField tpA = new JTextField(String.valueOf(rs.getDouble(6)));
	        PrixAff.setPreferredSize(new Dimension(300,70));
	        tpA.setPreferredSize(new Dimension(150,30));
			PrixAff.setBorder(BorderFactory.createTitledBorder(null, "Prix km Affaire", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
	        PrixAff.add(tpA);
	        
	        JPanel Prix1ere = new JPanel();
	        JTextField tp1 = new JTextField(String.valueOf(rs.getDouble(7)));
	        Prix1ere.setPreferredSize(new Dimension(300,70));
	        tp1.setPreferredSize(new Dimension(150,30));
			Prix1ere.setBorder(BorderFactory.createTitledBorder(null, "Prix km 1ere", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
	        Prix1ere.add(tp1);
	        
	        
	        JPanel EtatAvion = new JPanel();
			JTextField tstate = new JTextField(rs.getString(8));
			EtatAvion.setPreferredSize(new Dimension(300,70));
			tstate.setPreferredSize(new Dimension(150,30));
			EtatAvion.setBorder(BorderFactory.createTitledBorder(null, "Etat Avion", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			EtatAvion.add(tstate);
			
			
			  
	        JPanel Nbre1ere = new JPanel();
			JTextField tnbr1ere = new JTextField(String.valueOf(rs.getInt(9)));
			Nbre1ere.setPreferredSize(new Dimension(300,70));
			tnbr1ere.setPreferredSize(new Dimension(150,30));
			Nbre1ere.setBorder(BorderFactory.createTitledBorder(null, "Nombre Places 1ere", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			Nbre1ere.add(tnbr1ere);
			  
	        JPanel NbreEco = new JPanel();
			JTextField tnEco = new JTextField(String.valueOf(rs.getInt(10)));
			NbreEco.setPreferredSize(new Dimension(300,70));
			tnEco.setPreferredSize(new Dimension(150,30));
			NbreEco.setBorder(BorderFactory.createTitledBorder(null, "Nombre Places Economie", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			NbreEco.add(tnEco);
			  
	        JPanel NbreAff = new JPanel();
			JTextField tnAff = new JTextField(String.valueOf(rs.getInt(11)));
			NbreAff.setPreferredSize(new Dimension(300,70));
			tnAff.setPreferredSize(new Dimension(150,30));
			NbreAff.setBorder(BorderFactory.createTitledBorder(null, "Nombres Places Affaire", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			NbreAff.add(tnAff);
			
	        
	        this.setLayout(new FlowLayout());
	        
	        this.add(Vitesse);
	        this.add(Autonomie);
	        this.add(NomAvion);
	        this.add(PrixEco);
	        this.add(PrixAff);
	        this.add(Prix1ere);
	        this.add(EtatAvion);
	        this.add(Nbre1ere);
	        this.add(NbreEco);
	        this.add(NbreAff);
	        
	        JPanel p = new JPanel();
	        p.setPreferredSize(new Dimension(1000,70));
	        SignUp.setPreferredSize(new Dimension(125,50));
	        p.add(SignUp);
	        this.add(p);
	        
	        
	        SignUp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ev) {
					

					Double b=Double.valueOf(td2.getText());
					Double c=Double.valueOf(ta.getText());
					Double d=Double.valueOf(tp.getText());
					Double e=Double.valueOf(tpA.getText());
					Double f=Double.valueOf(tp1.getText());
					
					Integer g=Integer.valueOf(tnbr1ere.getText());
					Integer h=Integer.valueOf(tnEco.getText());
					Integer i=Integer.valueOf(tnAff.getText());

					
					
					try {
						Admin.ModifierAvion(new Avion(ID_Avion, b, c, tn.getText(), d,e, f, tstate.getText(),g , h, i));
						JOptionPane.showMessageDialog(null,"Avion Modifiée avec succés","Message informatif",JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
				
			});
			
	        
	        this.setVisible(true);
	        

}
		
}
