package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;

import java.sql.*;

import Connection.DataBase.ConnectionB;
import Métier.Admin;
import Métier.Vol;
import Métier.Vol;

public class InterfaceInsérerVol extends JDialog{
	JButton SignUp = new JButton("enregistrer");
	public InterfaceInsérerVol(JFrame a , String b , boolean c ) throws Exception{
		super(a,b,c);
		this.setSize(new Dimension(950,650));
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		Connection conn=ConnectionB.EtablissementConn();
		
		JPanel NumTrajet = new JPanel();
	    NumTrajet.setPreferredSize(new Dimension(550,70));
	    JComboBox tnumT = new JComboBox();
		ArrayList<Integer> cot = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement(" Select ID_Trajet from ttrajet");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			
				cot.add(rs.getInt(1));
			
		}
		for(int i=0;i<=cot.size()-1;i++) 
		{
		tnumT.addItem(cot.get(i));
		}
		tnumT.setPreferredSize(new Dimension(150,30));
	    NumTrajet.setBorder(BorderFactory.createTitledBorder(null,"Numéro Trajet", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		NumTrajet.add(tnumT);
		
		
		JPanel NumAvion = new JPanel();
	    NumAvion.setPreferredSize(new Dimension(550,70));
	    JComboBox tnumA = new JComboBox();
		ArrayList<Integer> cot1 = new ArrayList<>();
		PreparedStatement ps1 = conn.prepareStatement(" Select ID_Avion from tavion");
		ResultSet rs1 = ps1.executeQuery();
		while(rs1.next()) 
		{
			
				cot1.add(rs1.getInt(1));
			
		}
		for(int i=0;i<=cot1.size()-1;i++) 
		{
		tnumA.addItem(cot1.get(i));
		}
		tnumA.setPreferredSize(new Dimension(150,30));
	    NumAvion.setBorder(BorderFactory.createTitledBorder(null,"Numéro Avion", TitledBorder.LEFT, TitledBorder.TOP,new Font("times new roman",Font.BOLD,17),Color.WHITE));
		NumAvion.add(tnumA);
		
		
		
		JPanel dated = new JPanel();
		JButton butt = new JButton("choix date");
		
		JTextField td2 = new JTextField("yyyy-mm-dd");
		butt.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent ae) 
    		{
    			td2.setText(new DatePicker(dated).setPickedDate());
    		}
        });
		dated.setPreferredSize(new Dimension(550,70));
		td2.setPreferredSize(new Dimension(125,30));
		dated.setBorder(BorderFactory.createTitledBorder(null, "Date Depart", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		dated.add(td2);
		dated.add(butt);
		
		
		
		JPanel datea = new JPanel();
		JButton butto = new JButton("choix date");
		
		JTextField td3 = new JTextField("yyyy-mm-dd");
		butto.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent ae) 
    		{
    			td3.setText(new DatePicker(datea).setPickedDate());
    		}
        });
		datea.setPreferredSize(new Dimension(550,70));
		td3.setPreferredSize(new Dimension(125,30));
		datea.setBorder(BorderFactory.createTitledBorder(null, "Date Arrivee", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		datea.add(td3);
		datea.add(butto);
		
		
		JPanel nt = new JPanel();
		nt.setPreferredSize(new Dimension(550,70));
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
		spinner.setPreferredSize(new Dimension(150,30));
		nt.setBorder(BorderFactory.createTitledBorder(null, "Duree", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		nt.add(spinner);
		
		
		
		
		
		
		
		JPanel nt2 = new JPanel();
		nt2.setPreferredSize(new Dimension(550,70));
        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setValue(calendar.getTime());
        JSpinner spinner2 = new JSpinner(model2);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spinner2, "HH:mm:ss");
        DateFormatter formatter2 = (DateFormatter)editor2.getTextField().getFormatter();
        formatter2.setAllowsInvalid(false); // this makes what you want
        formatter2.setOverwriteMode(true);
        spinner2.setEditor(editor2);
		spinner2.setPreferredSize(new Dimension(150,30));
		nt2.setBorder(BorderFactory.createTitledBorder(null, "heure Depart", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		nt2.add(spinner2);
		
		
		
		JPanel nt3 = new JPanel();
		nt3.setPreferredSize(new Dimension(550,70));
        SpinnerDateModel model3 = new SpinnerDateModel();
        model3.setValue(calendar.getTime());
        JSpinner spinner3 = new JSpinner(model3);
        JSpinner.DateEditor editor3 = new JSpinner.DateEditor(spinner3, "HH:mm:ss");
        DateFormatter formatter3 = (DateFormatter)editor3.getTextField().getFormatter();
        formatter3.setAllowsInvalid(false); // this makes what you want
        formatter3.setOverwriteMode(true);
        spinner3.setEditor(editor3);
		spinner3.setPreferredSize(new Dimension(150,30));
		nt3.setBorder(BorderFactory.createTitledBorder(null, "heure Arrivee", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.BOLD,17), Color.white));
		nt3.add(spinner3);
		
		
		this.add(NumTrajet);
		this.add(NumAvion);
		this.add(dated);
		this.add(datea);
		this.add(nt);
		this.add(nt2);
		this.add(nt3);
		
		JPanel Sign =new JPanel();
		Sign.setPreferredSize(new Dimension(550,70));
		SignUp.setPreferredSize(new Dimension(100,50));
		Sign.add(SignUp);
		this.add(Sign);
		
		SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
			
				int idTrajet=Integer.valueOf(tnumT.getSelectedItem().toString() );
				int idAvion=Integer.valueOf(tnumA.getSelectedItem().toString());
				java.sql.Date R1 =java.sql.Date.valueOf(td2.getText());
				java.sql.Date R2 =java.sql.Date.valueOf(td3.getText());
				
				Object value = spinner.getValue();
				SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
				String duration = localDateFormat.format(value);
				
				Object value2 = spinner2.getValue();
				String heureDepart = localDateFormat.format(value2);
				
				Object value3 = spinner3.getValue();
				String heureArrivee = localDateFormat.format(value3);
				
				String [] heure1 = heureDepart.split(":");
				Integer h1=Integer.valueOf(heure1[0]);
				Integer m1=Integer.valueOf(heure1[1]);
				Integer s1=Integer.valueOf(heure1[2]);
				
				String [] heure2 = heureArrivee.split(":");
				Integer h2=Integer.valueOf(heure2[0]);
				Integer m2=Integer.valueOf(heure2[1]);
				Integer s2=Integer.valueOf(heure2[2]);
				
				try {
					Admin.insererVol(new Vol(idTrajet,idAvion,R1,R2,duration,h1,m1,s1,h2,m2,s2 ));
					JOptionPane.showMessageDialog(null,"Vol insérée avec succés","Message D'information",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Vol n'est pas insérée avec succés","Message ERROR",JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
						
			}
			
		});
		
		this.setModal(false);
		this.setVisible(true);
		
	}

}
