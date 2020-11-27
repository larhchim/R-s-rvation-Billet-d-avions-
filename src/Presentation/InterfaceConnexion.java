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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Métier.Client;

public class InterfaceConnexion extends JDialog{
	
	ImageFull conn = new ImageFull();

	
	
	PasswordInterface pss = new PasswordInterface();
	LoginInterfaceImage lg = new LoginInterfaceImage();
	
	
	JTextField login = new JTextField();
	JPasswordField Pass = new JPasswordField();
	
	JButton btnconnec = new JButton(" Se Connecter ");
	
	
	public InterfaceConnexion(JFrame g,String title,boolean a) {
		 
		super(g,title,true);
		this.setSize(new Dimension(435,275));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
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
			public void actionPerformed(ActionEvent e) {
				try {
					if( Client.connecter(login.getText(),Pass.getText()) !=0  ) {
						
						new FenetreSeConnecter(null,"Espace Utilisateur",true,Client.connecter(login.getText(),Pass.getText()));
						dispose();
						
					}
					else
						JOptionPane.showMessageDialog(null, "Login ou Mot de passe incorrecte","Message erreur",JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		this.setModal(false);
		this.setVisible(true);
		
		
		
	}
	


}
