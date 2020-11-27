package Presentation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
	

public class ClassePrincipale extends JFrame 
{

	private static final long serialVersionUID = 1L;
	
	private JButton btnCreer =new JButton("Créer un Compte Client");
	private JButton btnconnec =new JButton("Connection au Compte Client");
	JPanel jpButtons=new JPanel();
	JMenuBar menuAdmin1 = new JMenuBar();
	InterfaceImage1 ty = new InterfaceImage1();
	Interface2 img = new Interface2();
	//JLabel h =new JLabel(); 
	String r;
	
	public ClassePrincipale() 
	{
		
		super("Reservation Billets Avions");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//this.setSize(800,500);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, (int) dim.getWidth()+5, (int) dim.getHeight()-20);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		JMenu menuAdmin2 = new JMenu("Administrateur");
		menuAdmin2.setMnemonic('A');
		
		JMenuItem menuitemAdmin = new JMenuItem("Se connecter");
		menuitemAdmin.setMnemonic('S');
		menuitemAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
		menuAdmin2.add(menuitemAdmin);
		
		menuAdmin2.addSeparator();
		
		JMenuItem menuitemquitter =new JMenuItem("Exit");
		menuitemquitter.setMnemonic('E');
		menuitemquitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));
		menuAdmin2.add(menuitemquitter);
		menuitemquitter.addActionListener( this :: test );
		menuAdmin1.add(menuAdmin2);
		
		this.setJMenuBar(menuAdmin1);
		
		img.setPreferredSize(new Dimension(400,50));
		img.add(btnCreer);
		img.add(btnconnec);
		
		this.add(img,BorderLayout.SOUTH);
		this.add(ty,BorderLayout.CENTER);
		
		btnCreer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					new FenetreInscription(null,"Boite d'inscription",true);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				
				}

			}
			
		});
		
		btnconnec.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new InterfaceConnexion(null,"Boite de Connection",true);
				
			 }
			
		});
		
		menuitemAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				
				new LoginPasswordAdmin(null,"Boite De Connection Administrateur",true);
			}
			
		});
		

		
		
		Horlog y=new Horlog();
		
		y.addObservavle(new ObservateueConcret());
		JPanel g=new JPanel();
		g.add(ObservateueConcret.getH());
		ty.add(g);
		this.setVisible(true);
		y.run();		
		
	}

	
	public void test(ActionEvent e) {
		
		System.exit(-1);
		
	}
	
	
	public static void main(String args []) throws Exception 
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new ClassePrincipale();
	}
	
}