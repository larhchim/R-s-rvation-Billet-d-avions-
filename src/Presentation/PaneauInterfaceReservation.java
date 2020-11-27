package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.DateFormatter;

import Connection.DataBase.ConnectionB;
import Métier.Reservation;

public class PaneauInterfaceReservation extends JDialog{
	static int ID_Vol;
    static int ID_Client;
	PanelReservation ty = new PanelReservation(); //tsswira dyal foog
	JButton btnreserver =new JButton("Reserver");

	
	public PaneauInterfaceReservation(JFrame a,String b,boolean c,int idclient, int idVol) throws Exception{
		
		super(a,b,c);
		this.ID_Vol=idVol;
		this.ID_Client=idclient;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(800,500));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		Connection conn =ConnectionB.EtablissementConn();
		PreparedStatement pm=conn.prepareStatement(" SELECT NomClient,PrenomClient FROM tclient WHERE ID_Client=? ");
		pm.setInt(1, ID_Client);
		ResultSet rm = pm.executeQuery();
		rm.next();

		    CapturePaneau1 pnom = new CapturePaneau1();
			pnom.setPreferredSize(new Dimension(700,70));
			JTextField tnom=new JTextField(rm.getString(1));
			tnom.setPreferredSize(new Dimension(150,30));
			pnom.setBorder(BorderFactory.createTitledBorder(null, "Nom", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,20), Color.white));
			JLabel Nom = new JLabel("   Saisissez votre Nom:");
			Nom.setForeground(Color.black);
			pnom.add(Nom);
			pnom.add(tnom);
			
			
			CapturePaneau2 prenom = new CapturePaneau2();
			prenom.setPreferredSize(new Dimension(700,70));
			JTextField tprenom=new JTextField(rm.getString(2));
			tprenom.setPreferredSize(new Dimension(150,30));
			prenom.setBorder(BorderFactory.createTitledBorder(null, "Prenom", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,20), Color.white));
			JLabel PreNom = new JLabel("Saisissez votre Prenom:");
			PreNom.setForeground(Color.black);
			prenom.add(PreNom);
			prenom.add(tprenom);
			
			
			CapturePaneau3 classe = new CapturePaneau3();
			classe.setPreferredSize(new Dimension(700,70));
			JComboBox tnp = new JComboBox();
			ArrayList<String> cot = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(" Select LibelleClasse FROM tclasse");
			ResultSet rs = ps.executeQuery();
			cot.add("tapez votre choix:");
			while(rs.next()) 
			{
				
					cot.add(rs.getString(1));
				
			}
			for(int i=0;i<=cot.size()-1;i++) 
			{
			tnp.addItem(cot.get(i));
			}
			tnp.setPreferredSize(new Dimension(150,30));
			classe.setBorder(BorderFactory.createTitledBorder(null, "Classe", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,20), Color.white));
			JLabel Class = new JLabel("    Saisissez votre Classe:");
			Class.setForeground(Color.black);
			classe.add(Class);
			classe.add(tnp);
			
			
			
			
			CapturePaneau4 categorie = new CapturePaneau4();
			categorie.setPreferredSize(new Dimension(700,70));
			JComboBox tp = new JComboBox();
			ArrayList<String> co = new ArrayList<>();
			
			PreparedStatement py = conn.prepareStatement(" Select LibelleCategorie FROM tcategorie");
			ResultSet ry = py.executeQuery();
			
			
			PreparedStatement pa = conn.prepareStatement(" Select CategorieClient,NumPasseport FROM tclient WHERE ID_Client=?");
			pa.setInt(1, ID_Client);
			ResultSet ra = pa.executeQuery();
			ra.next();
			
			while(ry.next()) 
			{
					co.add(ry.getString(1));
				
			}
			tp.addItem(ra.getString(1));
			
			for(int i=0;i<=co.size()-1;i++) 
			{
				
			if(co.get(i).compareTo(ra.getString(1))!=0)
			tp.addItem(co.get(i));
			
			}
			tp.setPreferredSize(new Dimension(150,30));
			categorie.setBorder(BorderFactory.createTitledBorder(null, "Categorie", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,20), Color.white));
			JLabel Categorie = new JLabel("Saisissez votre Categorie:");
			Categorie.setForeground(Color.black);
			categorie.add(Categorie);
			categorie.add(tp);
			
			
			CapturePaneau5 NumeroPass = new CapturePaneau5();
			NumeroPass.setPreferredSize(new Dimension(700,70));
			
			JTextField tnpass=new JTextField(ra.getString(2));
			tnpass.setPreferredSize(new Dimension(150,30));
			NumeroPass.setBorder(BorderFactory.createTitledBorder(null, "Numero Passeport", TitledBorder.LEFT, TitledBorder.BOTTOM, new Font("times new roman",Font.BOLD,20), Color.white));
			JLabel Pass = new JLabel("Saisissez le Numero de Passeport:");
			Pass.setForeground(Color.black);
			NumeroPass.add(Pass);
			NumeroPass.add(tnpass);
			
		
			btnreserver.setPreferredSize(new Dimension(100,40));
		
		    ty.add(pnom);
			ty.add(prenom);
			ty.add(classe);
			ty.add(categorie);
			ty.add(NumeroPass);
			ty.add(btnreserver);
		
			this.add(ty,BorderLayout.CENTER);
			
			btnreserver.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ev) {
					
					try {
						Reservation.insererReservation(ID_Vol, tnp.getSelectedItem().toString(), ID_Client, tnom.getText(), tprenom.getText(),tp.getSelectedItem().toString() ,tnpass.getText() );
						 JOptionPane.showMessageDialog(null, "votre reservation a été effectuée ","Confirmation de Reservation",JOptionPane.INFORMATION_MESSAGE);

						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			
			btnreserver.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent ev) {
					try {
					PreparedStatement pl=conn.prepareStatement(" Update tclient set CategorieClient=? Where ID_Client=? AND NumPasseport=? ");
					pl.setString(1, tp.getSelectedItem().toString());
					pl.setInt(2, ID_Client);
					pl.setString(3, tnpass.getText());
					pl.executeUpdate();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
			});
			
			/*btnreserver.addActionListener(new ActionListener() {

			
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					try{
					PreparedStatement psw=conn.prepareStatement(" SELECT ID_Trajet FROM tvol WHERE ID_Vol=?");
					psw.setInt(1, ID_Vol);
					ResultSet rpsw=psw.executeQuery();
					rpsw.next();
					
					PreparedStatement pqw = conn.prepareStatement(" SELECT Distance from ttrajet WHERE ID_Trajet=? ");
					pqw.setInt(1, rpsw.getInt(1));
					ResultSet rpqw=pqw.executeQuery();
					rpqw.next();
					
					PreparedStatement mw=conn.prepareStatement(" SELECT  PourcentageReduction FROM tcategorie WHERE LibelleCategorie=? ");
					mw.setString(1, tp.getSelectedItem().toString());
					ResultSet rmw =mw.executeQuery();
					rmw.next();
					
					PreparedStatement mh=conn.prepareStatement(" SELECT ID_Reservation FROM treservation WHERE ID_Reservation=(SELECT max(ID_Reservation) FROM treservation where ID_Client=?)");
					mh.setInt(1, ID_Client);
					ResultSet rmh =mh.executeQuery();
					rmh.next();
					
					
					if(tnp.getSelectedItem().equals("1ere")) 
					{
						PreparedStatement m=conn.prepareStatement(" SELECT Prix_km_1ere FROM tavion WHERE ID_Avion in(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
						m.setInt(1, ID_Vol);
						ResultSet rmp =m.executeQuery();
						rmp.next();
						
						PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
						mp.setInt(1, rmh.getInt(1));
						mp.setInt(2, ID_Client);
					    Double Price=( rpqw.getDouble(1)*rmp.getDouble(1)- rpqw.getDouble(1)*rmp.getDouble(1)*rmw.getDouble(1) );
						mp.setDouble(3, Price);
						mp.executeUpdate();
						

					}
					else 
						if(tnp.getSelectedItem().equals("Economie")) 
						{
							PreparedStatement m=conn.prepareStatement(" SELECT Prix_km_Eco FROM tavion WHERE ID_Avion in(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
							m.setInt(1, ID_Vol);
							ResultSet rmp =m.executeQuery();
							rmp.next();
							
							PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
							mp.setInt(1, rmh.getInt(1));
							mp.setInt(2, ID_Client);
						    Double Price=( rpqw.getDouble(1)*rmp.getDouble(1)- rpqw.getDouble(1)*rmp.getDouble(1)*rmw.getDouble(1) );
							mp.setDouble(3, Price);
							mp.executeUpdate();
						}
						else
							if(tnp.getSelectedItem().equals("Affaire")) 
							{
								PreparedStatement m=conn.prepareStatement(" SELECT Prix_km_Aff FROM tavion WHERE ID_Avion in(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
								m.setInt(1, ID_Vol);
								ResultSet rmp =m.executeQuery();
								rmp.next();
								
								PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
								mp.setInt(1, rmh.getInt(1));
								mp.setInt(2, ID_Client);
							    Double Price=( rpqw.getDouble(1)*rmp.getDouble(1)- rpqw.getDouble(1)*rmp.getDouble(1)*rmw.getDouble(1) );
								mp.setDouble(3, Price);
								mp.executeUpdate();
							}
					
								}catch(Exception e2) {
									e2.printStackTrace();
								}
								
				}
			
				
			});*/
			/*btnreserver.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					

					try{
					PreparedStatement psw=conn.prepareStatement(" SELECT * FROM treservation WHERE ID_Client=?");
					psw.setInt(1, ID_Client);
					ResultSet rpsw=psw.executeQuery();
					
					while(rpsw.next()) 
					{
					
					if(rpsw.getString(13).equals("1ere")) 
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
						
						PreparedStatement m=conn.prepareStatement(" SELECT Prix_km_1ere FROM tavion WHERE ID_Avion in(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
						m.setInt(1, rpsw.getInt(3));
						ResultSet rmp =m.executeQuery();
						rmp.next();
						
						PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
						mp.setInt(1, rpsw.getInt(1));
						mp.setInt(2, ID_Client);
						mp.setDouble(3, rpqw.getDouble(1)*rmp.getDouble(1)- rpqw.getDouble(1)*rmp.getDouble(1)*rmw.getDouble(1));
						mp.executeUpdate();
						

					}
					else 
						if(rpsw.getString(13).equals("Economie")) 
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
							
							PreparedStatement m=conn.prepareStatement(" SELECT Prix_Km_Eco FROM tavion WHERE ID_Avion in(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
							m.setInt(1, rpsw.getInt(3));
							ResultSet rmp =m.executeQuery();
							rmp.next();
							
							PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
							mp.setInt(1, rpsw.getInt(1));
							mp.setInt(2,  ID_Client);
							mp.setDouble(3, rpqw.getDouble(1)*rmp.getDouble(1)- rpqw.getDouble(1)*rmp.getDouble(1)*rmw.getDouble(1) );
							mp.executeUpdate();
						}
						else
							if(rpsw.getString(13).equals("Affaire")) 
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
								
								PreparedStatement m=conn.prepareStatement(" SELECT Prix_km_Aff FROM tavion WHERE ID_Avion in(SELECT ID_Avion FROM tvol WHERE ID_Vol=?) ");
								m.setInt(1, rpsw.getInt(3));
								ResultSet rmp =m.executeQuery();
								rmp.next();
								
								PreparedStatement mp=conn.prepareStatement(" insert into tbillet(ID_Reservation,ID_Client,PrixTotale) values(?,?,?)");
								mp.setInt(1, rpsw.getInt(1));
								mp.setInt(2, ID_Client);
								mp.setDouble(3, rpqw.getDouble(1)*rmp.getDouble(1)- rpqw.getDouble(1)*rmp.getDouble(1)*rmw.getDouble(1) );
								mp.executeUpdate();
							}
					}
					
					
					JOptionPane.showMessageDialog(null, "Montant calculé avec succés","Message informatif",JOptionPane.INFORMATION_MESSAGE);

					
								}catch(Exception e2) {
									e2.printStackTrace();
								}
					
					
				}
				
			});*/
			
		
			this.setVisible(true);
		
		   
		
	}
	

	
	
}
