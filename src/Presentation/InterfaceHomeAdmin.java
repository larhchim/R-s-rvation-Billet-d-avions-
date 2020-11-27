package Presentation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class InterfaceHomeAdmin extends JDialog{
	JMenuBar MenuAdmin = new JMenuBar();
	int Id;

	String title[]= {"Statistiques","Afficher / Supprimer Avions","Ajouter Avion","Modifier Avion","Afficher Client","Afficher Reservation","Afficher / Supprimer Trajet","Ajouter Trajet","Afficher / Supprimer Vol","Insérer Vol","Afficher Classe","Afficher / Modifier / Ajouter Categorie"};
	JButton tableButtons[]=new JButton[title.length];
	public InterfaceHomeAdmin(JFrame a,String b,boolean c,int id) 
	{
		
		super(a,b,c);
		this.Id=id;
		this.setSize(new Dimension(800,500));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(4,4,5,5));
		JMenu admin = new JMenu("Paramètre Compte");
		JMenuItem ad = new JMenuItem("Modifier Compte Admin");
		admin.add(ad);
		MenuAdmin.add(admin);
		this.setJMenuBar(MenuAdmin);
		
		for(int i=0;i<tableButtons.length;i++) 
		{
			
			tableButtons[i]=new JButton(title[i]);
		}
		
		
		for(int i=0;i<tableButtons.length;i++) 
		{
			this.add(tableButtons[i]);
		}
		
		ad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				
				try {
					new ModifierCompteAdmin(null,"Boite De Modification de Compte Admin",true,Id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		tableButtons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				try {
					new InterfaceStatistiquesAdmin(null,"Boite De Statistiques",true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		tableButtons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				try {
					new InterfaceAfficherSupprimerAdmin(null,"Boite De Consultation et Suppression d'Avions",true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		tableButtons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				new InterfaceAjouterAvion(null,"Boite D'ajout D'avion",true);
				
			}
			
		});
		
		tableButtons[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					new InterfaceModifierAvion(null,"Boite De Modification D'avion",true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		tableButtons[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					new InterfaceAfficherClients(null,"Boite D'afficahge de Tous les Clients",true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		tableButtons[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					new InterfaceAfficherResrvations(null,"Boite D'affichage de tous les Reservations",true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		tableButtons[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					new InterfaceAfficheSuppTrajet(null,"Boite D'affichage et De Suppression De Trajet",true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		tableButtons[7].addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new InterfaceAjouterTrajet(null,"Boite D'ajout De Tarjet",true);
				
			}
			
		});
		
		tableButtons[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new InterfaceAfficherSupprimerVol(null,"Boite D'affichage et De Suppression De Vol",true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		tableButtons[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new InterfaceInsérerVol(null,"Boite D'ajout De Vols",true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		tableButtons[10].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					new InterfaceAfficherClasse(null,"Boite D'affichage de Tous les Classes",true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		tableButtons[11].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new InterfaceAfficherModifyAddCategorie(null,"Boite D'affichage et de Modification De Categories",true);
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
