package Presentation;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.mysql.jdbc.PreparedStatement;

import Connection.DataBase.ConnectionB;
import Métier.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

public class FenetreInscription extends JDialog{

	Colored ui = new Colored();
	JButton SignUp = new JButton("enregistrer");
	
 
	public FenetreInscription(JFrame g,String title,boolean a) throws Exception {
		
		super(g,title,a);
		this.setSize(new Dimension(1080,400));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    /************************************************/
	    Colored2 pn = new Colored2();
		pn.setPreferredSize(new Dimension(300,70));
		JTextField tn=new JTextField();
		tn.setPreferredSize(new Dimension(125,30));
		pn.setBorder(BorderFactory.createTitledBorder(null, "Nom de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel Nom = new JLabel("Saisissez votre Nom:");
		Nom.setForeground(Color.white);
		pn.add(Nom);
		pn.add(tn);
		
		
		
		Prenom pp = new Prenom();
		pp.setPreferredSize(new Dimension(315,70));
		JTextField tp=new JTextField();
		tp.setPreferredSize(new Dimension(125,30));
		pp.setBorder(BorderFactory.createTitledBorder(null, "Prenom de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel PreNom = new JLabel("Saisissez votre Prenom:");
		PreNom.setForeground(Color.white);
		pp.add(PreNom);
		pp.add(tp);
		
		
		DateNaissance daten = new DateNaissance();
		//////////////
		JButton b = new JButton("choix date");
		
		JTextField td2 = new JTextField("yyyy-mm-dd");
		b.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent ae) 
    		{
    			//set text i.e. date
    			td2.setText(new DatePicker(daten).setPickedDate());
    		}
        });
		
		/////////////////
		
		daten.setPreferredSize(new Dimension(410,70));
		//MaskFormatter td=new MaskFormatter("####   -  ##  - ##");
		//JFormattedTextField td2 = new JFormattedTextField(td);
		
		td2.setPreferredSize(new Dimension(125,30));
		daten.setBorder(BorderFactory.createTitledBorder(null, "Date Naissance de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel DateN = new JLabel("Saisissez la Date:");
		DateN.setForeground(Color.white);
		daten.add(DateN);
		daten.add(td2);
		daten.add(b);
		
	
		
		
		Colored2 ci = new Colored2();
		ci.setPreferredSize(new Dimension(300,70));
		JTextField tc=new JTextField();
		tc.setPreferredSize(new Dimension(125,30));
		ci.setBorder(BorderFactory.createTitledBorder(null, "CIN de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel CIN = new JLabel("Saisissez votre CIN:");
		CIN.setForeground(Color.white);
		ci.add(CIN);
		ci.add(tc);
		
		NumeroPasseport np = new NumeroPasseport();
		np.setPreferredSize(new Dimension(400,70));
		JTextField tnp=new JTextField();
		//JFormattedTextField tnp =new JFormattedTextField(NumberFormat.getNumberInstance());
		tnp.setPreferredSize(new Dimension(125,30));
		np.setBorder(BorderFactory.createTitledBorder(null, "Numero Passeport de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel Numero = new JLabel("Saisissez votre Numero de Passeport:");
		Numero.setForeground(Color.white);
		np.add(Numero);
		np.add(tnp);
		
		Nationalite nt = new Nationalite();
		nt.setPreferredSize(new Dimension(320,70));
		JTextField tnt=new JTextField();
		tnt.setPreferredSize(new Dimension(125,30));
		nt.setBorder(BorderFactory.createTitledBorder(null, "Nationalite de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel Nationalitee = new JLabel("Saisissez votre Nationalité:");
		Nationalitee.setForeground(Color.white);
		nt.add(Nationalitee);
		nt.add(tnt);
		
		
		Login ln = new Login();
		ln.setPreferredSize(new Dimension(350,70));
		JTextField tln=new JTextField();
		tln.setPreferredSize(new Dimension(125,30));
		ln.setBorder(BorderFactory.createTitledBorder(null, "Login de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel login = new JLabel("Saisissez votre Login:");
		login.setForeground(Color.white);
		ln.add(login);
		ln.add(tln);
		
		
		MotDePasse pass = new MotDePasse();
		pass.setPreferredSize(new Dimension(350,70));
		JPasswordField tpass=new JPasswordField();
		tpass.setPreferredSize(new Dimension(125,30));
		pass.setBorder(BorderFactory.createTitledBorder(null, "Mot de Passe de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		JLabel password = new JLabel("Saisissez votre mot de passe:");
		password.setForeground(Color.white);
		pass.add(password);
		pass.add(tpass);
		
		
		Categorie cat = new Categorie();
		ArrayList<String> cot = new ArrayList<>();
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement pb=(PreparedStatement) conn.prepareStatement(" SELECT LibelleCategorie from tcategorie ");
		ResultSet rb=pb.executeQuery();
		while(rb.next()) {
			cot.add(rb.getString(1));
		}
		cat.setPreferredSize(new Dimension(320,70));
		cat.setBorder(BorderFactory.createTitledBorder(null, "Categorie du Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		
		JComboBox<String> Categoriee = new JComboBox<>();
		
		for(int i=0;i<=cot.size()-1;i++) 
		{
		Categoriee.addItem(cot.get(i));
		}
		
		JLabel Cate = new JLabel("Choisissez votre Categorie:");
		Cate.setForeground(Color.white);
		cat.add(Cate);
	    cat.add(Categoriee);
		
		
	    Interface2 paneau = new Interface2();
	    paneau.setPreferredSize(new Dimension(300,70));
	    paneau.add(SignUp);
	    
	   
		
		
	    this.add(paneau,BorderLayout.SOUTH);
		
		ui.add(pn);
		ui.add(pp);
		ui.add(daten);
		ui.add(ci);
		ui.add(np);
		ui.add(nt);
		ui.add(ln);
		ui.add(pass);
		ui.add(cat);
		this.add(ui);
		
		
	    
	    
	    /**************************************************/
	   
	    
	    SignUp.addActionListener(new ActionListener() {


	    			
		
			public void actionPerformed(ActionEvent e){
				
				
			    java.sql.Date R1 =java.sql.Date.valueOf(td2.getText());
				Client cli = new Client(tn.getText(), tp.getText(),R1, tc.getText(), tnp.getText(), tnt.getText(), tln.getText(), tpass.getText(),Categoriee.getSelectedItem().toString());
			     
			
				try {
					if(!tn.getText().equals("")&& !tp.getText().equals("")&& !td2.getText().equals("")&& !tc.getText().equals("")&& !tnp.getText().equals("")&& !tnt.getText().equals("")&& !tln.getText().equals("")&& !tpass.getText().equals("")&& ( Client.connecter(tln.getText(), tpass.getText())==0 ) ) 
			        {
						cli.Inscription(cli);
						JOptionPane eo = new JOptionPane();
						SignUp.setEnabled(false);
						eo.showMessageDialog(null,"Inscription réussie vous pouvez se connecter","Message information",JOptionPane.INFORMATION_MESSAGE);
			        }
						
				
				    
				} catch (Exception e1) {
					
                  
					e1.printStackTrace();
                 
					
				}
			

		
				

			}
			
		});
	    
	    SignUp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e){
					
		        if(tn.getText().equals("")||tp.getText().equals("")||td2.getText().equals("")||tc.getText().equals("")||tnp.getText().equals("")||tnt.getText().equals("")||tln.getText().equals("")||tpass.getText().equals("")) 
		        {
					JOptionPane.showMessageDialog(null,"Inscription non réussie respectez l'ordre","Message erreur",JOptionPane.ERROR_MESSAGE);

		        }

			
					

				}
				
			});
	    
	    SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent im) {
				
				
				
				try {
					
					int a =new Integer( Client.connecter(tln.getText(), tpass.getText()));
					if(a!= 0 && !tpass.getText().equals("") && !tln.getText().equals("") ) {
						
						JOptionPane.showMessageDialog(null,"Veuillez taper un autre Login ou Mot de passe","Message erreur Login/Password",JOptionPane.ERROR_MESSAGE);

						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        
				
				
			}
	    	
	    });
	    
	    SignUp.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					if( isDateValid(td2.getText())==false && !td2.getText().equals("")  ) {
						JOptionPane.showMessageDialog(null,"Veuillez entrer la date de naissance sous la forme yyyy-mm-dd ou bien cliquer sur choix date pour entrer la date","Message erreur Date de Naissance",JOptionPane.ERROR_MESSAGE);

					}
					
				} catch (Exception e1) 
				{
					e1.printStackTrace();
				}
			}
			
		});
		    
	    
	    this.setVisible(true);
		
		
	}
	
	

	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	

	
	
	
	
	
	
	
}
