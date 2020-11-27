package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.PreparedStatement;

import Connection.DataBase.ConnectionB;
import Métier.Admin;

public class ModifierCompteAdmin extends JDialog{
	 int ID;
	 JButton SignUp = new JButton("enregistrer");
	
	public ModifierCompteAdmin(JFrame a,String b,boolean c,int id) throws Exception 
	{
		super(a,b,c);
		this.ID=id;
		this.setSize(new Dimension(800,500));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(false);
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps= (PreparedStatement) conn.prepareStatement("SELECT * FROM tadmin WHERE ID_Admin=?");
		ps.setInt(1, ID);
		ResultSet rs=ps.executeQuery();
		rs.next();
		
		JPanel pn = new JPanel();
		pn.setPreferredSize(new Dimension(500,70));
		JTextField tn=new JTextField(rs.getString("NomAdmin"));
		tn.setPreferredSize(new Dimension(125,30));
		pn.setBorder(BorderFactory.createTitledBorder(null, "Nom Admin", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel Nom = new JLabel("Saisissez votre Nom:");
		Nom.setForeground(Color.white);
		pn.add(Nom);
		pn.add(tn);
		
		
		JPanel pprenom = new JPanel();
		pn.setPreferredSize(new Dimension(500,70));
		JTextField tprenom=new JTextField(rs.getString("PrenomAdmin"));
		tprenom.setPreferredSize(new Dimension(125,30));
		pprenom.setBorder(BorderFactory.createTitledBorder(null, "Prenom Admin", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel Prenom = new JLabel("Saisissez votre Prenom:");
		Prenom.setForeground(Color.white);
		pprenom.add(Prenom);
		pprenom.add(tprenom);
		
		JPanel Login = new JPanel();
		Login.setPreferredSize(new Dimension(500,70));
		JTextField tlogin=new JTextField(rs.getString("LoginAdmin"));
		tlogin.setPreferredSize(new Dimension(125,30));
		Login.setBorder(BorderFactory.createTitledBorder(null, "Login Admin", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel log = new JLabel("Saisissez votre Login:");
		log.setForeground(Color.white);
		Login.add(log);
		Login.add(tlogin);
		
		JPanel Password = new JPanel();
		Password.setPreferredSize(new Dimension(500,70));
		JPasswordField tpass=new JPasswordField(rs.getString("PasswordAdmin"));
		tpass.setPreferredSize(new Dimension(125,30));
		Password.setBorder(BorderFactory.createTitledBorder(null, "Password Admin", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel Pss = new JLabel("Saisissez votre Password:");
		Pss.setForeground(Color.white);
		Password.add(Pss);
		Password.add(tpass);
		
		//GridLayout abcd=new GridLayout(5,1);
		//abcd.setHgap(20);
		this.setLayout(new GridLayout(5,1));
		this.add(pn);
		this.add(pprenom);
		this.add(Login);
		this.add(Password);
		this.add(SignUp);
		
		SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				
				

				try {
					Admin.ModifyAdmin(new Admin(tn.getText(),tprenom.getText(),tlogin.getText(),tpass.getText()),ID);
					JOptionPane.showMessageDialog(null, "Modification effectuée avec succés","Message informatif",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Modification non effectuée","Message informatif",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				
			}
			
		});
		
		
		this.setVisible(true);
	}

}
