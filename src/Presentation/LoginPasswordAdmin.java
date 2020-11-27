package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.mysql.jdbc.PreparedStatement;

import Connection.DataBase.ConnectionB;
import Métier.Client;

public class LoginPasswordAdmin extends JDialog{
	
	ImageFull conn = new ImageFull();

	
	
	PasswordInterface pss = new PasswordInterface();
	LoginInterfaceImage lg = new LoginInterfaceImage();
	
	
	JTextField login = new JTextField();
	JPasswordField Pass = new JPasswordField();
	
	JButton btnconnec = new JButton(" Se Connecter ");
	
	
	public LoginPasswordAdmin(JFrame g,String title,boolean a) {
		 
		super(g,title,true);
		this.setSize(new Dimension(435,275));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(false);
		
		lg.setPreferredSize(new Dimension(347,70));
		login.setPreferredSize(new Dimension(129,34));
		lg.setBorder(BorderFactory.createTitledBorder(null, "Login ", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel lb1 = new JLabel("              Saisissez votre Login:");
		lb1.setForeground(Color.white);
		lg.add(lb1);
		lg.add(login);
		
		pss.setPreferredSize(new Dimension(347,70));
		Pass.setPreferredSize(new Dimension(129,34));
		pss.setBorder(BorderFactory.createTitledBorder(null, "Password", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel lb2 = new JLabel("Saisissez votre mot de passe:");
		lb2.setForeground(Color.white);
		pss.add(lb2);
		pss.add(Pass);
		
		
		conn.add(lg);
		conn.add(pss);
		conn.add(btnconnec);
		
		this.setContentPane(conn);
		
		btnconnec.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try {
				Connection conn=ConnectionB.EtablissementConn();
				PreparedStatement pl=(PreparedStatement) conn.prepareStatement(" SELECT LoginAdmin,PasswordAdmin,ID_Admin FROM tadmin  ");
				ResultSet rl =pl.executeQuery();
				
				while(rl.next()) {
					if( rl.getString(1).compareTo(login.getText())==0 && rl.getString(2).compareTo(Pass.getText())==0 ) {
						new InterfaceHomeAdmin(null,"Boite De Controle Admin",true,rl.getInt(3));
						dispose();
					}
					else 
						JOptionPane.showMessageDialog(null,"Votre Login ou Mot de passe est incorrecte","Message information",JOptionPane.ERROR_MESSAGE );
				
				}
				
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		

		
		this.setVisible(true);
		
		
		
	}
	


}
