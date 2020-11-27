package Presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InterfaceImage1 extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics A) {
		
		Image avionimg;
		try {
			avionimg = ImageIO.read(new File("src\\Presentation\\avionbienvenue1.jpg"));
			A.drawImage(avionimg,0,0,this.getWidth(),this.getHeight(),this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
