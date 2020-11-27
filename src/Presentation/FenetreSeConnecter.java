package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.DateFormatter;

import Connection.DataBase.ConnectionB;
import Métier.Reservation;
import Métier.Vol;

public class FenetreSeConnecter extends JDialog {
	PanneauImagebtnReserver ty = new PanneauImagebtnReserver(); //tsswira dyal foog
	JButton btnReserver = new JButton("Chercher le Vol");
	static int IDClient;
	JMenuBar Parametre = new JMenuBar();
	btnReserverdown rr = new btnReserverdown();  //tsswira dyal te7t
    
	public FenetreSeConnecter(JFrame a,String titre,boolean b,int id) throws Exception {
		 
		super(a,titre,b);
		this.IDClient=id;
		this.setSize(new Dimension(800,500));
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		JMenu  param = new JMenu("Paramétre Compte");
		param.setMnemonic('P');
		JMenuItem modifier = new JMenuItem("Modifier Compte");
		modifier.setMnemonic('M');
		modifier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_DOWN_MASK));
		param.add(modifier);
		param.addSeparator();
		JMenuItem SupprimerRes = new JMenuItem("Supprimer Reservation");
		SupprimerRes.setMnemonic('S');
		SupprimerRes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
		param.add(SupprimerRes);
		param.addSeparator();
		JMenuItem Billet = new JMenuItem("Consultation de Billet");
		param.add(Billet);
		param.addSeparator();
		JMenuItem Consultation = new JMenuItem("Déconnexion");
		param.add(Consultation);
		Parametre.add(param);
		this.setJMenuBar(Parametre);
		rr.add(btnReserver);
		rr.setPreferredSize(new Dimension(400,70));
		this.add(rr,BorderLayout.SOUTH);
		
		/**/
		
			
			
			
			Pan1 daten = new Pan1();   
			JButton b1 = new JButton("choix date");
			JTextField td2 = new JTextField();
			b1.addActionListener(new ActionListener() 
	    	{
	    		public void actionPerformed(ActionEvent ae) 
	    		{
	    			td2.setText(new DatePicker(daten).setPickedDate());
	    		}
	        });
			
			
			daten.setPreferredSize(new Dimension(550,70));
			td2.setPreferredSize(new Dimension(150,30));
			daten.setBorder(BorderFactory.createTitledBorder(null, "Date depart de Client", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			JLabel DateN = new JLabel("                                           Saisissez la Date:");
			DateN.setForeground(Color.white);
			daten.add(DateN);
			daten.add(td2);
			daten.add(b1);
			
			
			Pan2 np = new Pan2();
			np.setPreferredSize(new Dimension(550,70));
			JComboBox tnp = new JComboBox();
			ArrayList<String> cot = new ArrayList<>();
			Connection conn=ConnectionB.EtablissementConn();
			PreparedStatement ps = conn.prepareStatement(" Select VilleDepart,VilleArrivee From ttrajet");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				
					cot.add(rs.getString(1)+"-"+rs.getString(2));
				
			}
			
			for(int i=0;i<=cot.size()-1;i++) 
			{
			tnp.addItem(cot.get(i));
			}
			tnp.setPreferredSize(new Dimension(150,30));
			np.setBorder(BorderFactory.createTitledBorder(null, "Ville Depart et Arrivee", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			JLabel Numero = new JLabel("choisissez les deux villes:");
			Numero.setForeground(Color.white);
			np.add(Numero);
			np.add(tnp);
			
			Pan3 nt = new Pan3();
			nt.setPreferredSize(new Dimension(550,70));
			/***********************/
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
	        calendar.set(Calendar.MINUTE, 0);
	        calendar.set(Calendar.SECOND, 0);
	        SpinnerDateModel model = new SpinnerDateModel();
	        model.setValue(calendar.getTime());
	        JSpinner spinner = new JSpinner(model);
	        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
	        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
	        formatter.setAllowsInvalid(false); // this makes what you want
	        formatter.setOverwriteMode(true);
	        spinner.setEditor(editor);
	
			/***********************/
			//JTextField tnt=new JTextField();
		
			spinner.setPreferredSize(new Dimension(150,30));
			nt.setBorder(BorderFactory.createTitledBorder(null, "heure Depart", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
			JLabel Nationalitee = new JLabel("    Saisissez heure Depart:");
			Nationalitee.setForeground(Color.white);
			nt.add(Nationalitee);
			nt.add(spinner);
			

			ty.add(daten);
			ty.add(np);
			ty.add(nt);
		   
		    
		
		
		/***/
		
		
		
		
		
		
		this.add(ty,BorderLayout.CENTER);
		
		
		modifier.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent ev) {
				try {
					new InterfaceModifierCompte(null,"Boite de Modification de Compte",true,IDClient);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		
		 SupprimerRes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
			
				try 
				{
					
				  new  SupprimerReservationInterface(null ,"Boite d'annulation de Reservations",true, IDClient);
				  
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		btnReserver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) 
			{
				String [] trajet =tnp.getSelectedItem().toString().split("-");
				
				ArrayList<Vol> tabVol = new ArrayList<Vol>();
				
				 try 
				{
				    Object value = spinner.getValue();
			        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			        String actualtime = localDateFormat.format(value);

					 
					 java.sql.Date R1 = java.sql.Date.valueOf(td2.getText());
					 String [] heure = actualtime.split(":");
					 Integer h=Integer.valueOf(heure[0]);
					 Integer m=Integer.valueOf(heure[1]);
					 Integer s=Integer.valueOf(heure[2]);
					 tabVol = Reservation.chercherTest(R1 , trajet[0], trajet[1] , FenetreSeConnecter.MethodeTime(h, m, s) ) ;
					 new PanneauBtnReserver(null,"Boite De Choix De Vol",true,tabVol,IDClient);
			
		         } catch (Exception e) {
		 		
		 		e.printStackTrace();
		 	                  }
		 	 
		           	}});
		
		Billet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				

				try{
				PreparedStatement psw=conn.prepareStatement(" SELECT * FROM treservation WHERE ID_Client=?");
				psw.setInt(1, IDClient);
				ResultSet rpsw=psw.executeQuery();
				
				while(rpsw.next()) 
				{
				
				if(rpsw.getString(8).equals("1ere")) 
				{
					PreparedStatement pqw = conn.prepareStatement(" SELECT Distance from ttrajet WHERE VilleDepart=? AND VilleArrivee=? ");
					pqw.setString(1, rpsw.getString(4));
					pqw.setString(2, rpsw.getString(5));
					ResultSet rpqw=pqw.executeQuery();
					rpqw.next();
					
					PreparedStatement mw=conn.prepareStatement(" SELECT  PourcentageReduction FROM tcategorie WHERE LibelleCategorie=? ");
					mw.setString(1, rpsw.getString(13));
					ResultSet rmw =mw.executeQuery();
					rmw.next();
					
					PreparedStatement m=conn.prepareStatement(" SELECT Prix_km_1ere FROM tavion WHERE ID_Avion =(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
					m.setInt(1, rpsw.getInt(3));
					ResultSet rmp =m.executeQuery();
					rmp.next();
					
					PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
					mp.setInt(1, rpsw.getInt(1));
					mp.setInt(2, IDClient);
					double T1;
					T1=rpqw.getDouble(1)*rmp.getDouble(1);
					T1=T1*(1-rmw.getDouble(1));
					mp.setDouble(3, T1 );
					mp.executeUpdate();
					

				}
				else 
					if(rpsw.getString(8).equals("Economie")) 
					{
						PreparedStatement pqw = conn.prepareStatement(" SELECT Distance from ttrajet WHERE VilleDepart=? AND VilleArrivee=? ");
						pqw.setString(1, rpsw.getString(4));
						pqw.setString(2, rpsw.getString(5));
						ResultSet rpqw=pqw.executeQuery();
						rpqw.next();
						
						PreparedStatement mw=conn.prepareStatement(" SELECT  PourcentageReduction FROM tcategorie WHERE LibelleCategorie=? ");
						mw.setString(1, rpsw.getString(13));
						ResultSet rmw =mw.executeQuery();
						rmw.next();
						
						PreparedStatement m=conn.prepareStatement(" SELECT Prix_Km_Eco FROM tavion WHERE ID_Avion =(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
						m.setInt(1, rpsw.getInt(3));
						ResultSet rmp =m.executeQuery();
						rmp.next();
						
						PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
						mp.setInt(1, rpsw.getInt(1));
						mp.setInt(2, IDClient);
						double T1;
						T1=rpqw.getDouble(1)*rmp.getDouble(1);
						T1=T1*(1-rmw.getDouble(1));
						mp.setDouble(3, T1 );
						mp.executeUpdate();
						
					}
					else
						if(rpsw.getString(8).equals("Affaire")) 
						{
							PreparedStatement pqw = conn.prepareStatement(" SELECT Distance from ttrajet WHERE VilleDepart=? AND VilleArrivee=? ");
							pqw.setString(1, rpsw.getString(4));
							pqw.setString(2, rpsw.getString(5));
							ResultSet rpqw=pqw.executeQuery();
							rpqw.next();
							
							PreparedStatement mw=conn.prepareStatement(" SELECT  PourcentageReduction FROM tcategorie WHERE LibelleCategorie=? ");
							mw.setString(1, rpsw.getString(13));
							ResultSet rmw =mw.executeQuery();
							rmw.next();
							
							PreparedStatement m=conn.prepareStatement(" SELECT Prix_km_affaire FROM tavion WHERE ID_Avion =(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
							m.setInt(1, rpsw.getInt(3));
							ResultSet rmp =m.executeQuery();
							rmp.next();
							
							PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
							mp.setInt(1, rpsw.getInt(1));
							mp.setInt(2, IDClient);
							double T1;
							T1=rpqw.getDouble(1)*rmp.getDouble(1);
							T1=T1*(1-rmw.getDouble(1));
							mp.setDouble(3, T1 );
							mp.executeUpdate();
							
						}
				}
				
				PreparedStatement delete =conn.prepareStatement("delete e1 from tbillet e1,tbillet e2 where e1.ID_Billet>e2.ID_Billet AND e1.ID_Reservation=e2.ID_Reservation");
				delete.executeUpdate();
				
				try {
					new FenetreConsultationBillet(null,"Espace Billet",true,IDClient);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
							}catch(Exception e2) {
								e2.printStackTrace();
								JOptionPane.showMessageDialog(null, "Montant non calculé","Message Error",JOptionPane.ERROR_MESSAGE);

							}
				
				
			}
			
		});

		Consultation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
			
		});


		
		this.setModal(false);
		this.setVisible(true);
	}
	
	public static java.sql.Timestamp MethodeTime( int heures, int minutes , int secondes)
	{
		
		java.util.Date dateinserer=new java.util.Date();
		dateinserer.setHours(heures);
		dateinserer.setMinutes(minutes);
		dateinserer.setSeconds(secondes);
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(dateinserer.getTime());
		return sqlTime;
		
	}

	
	
	

}
