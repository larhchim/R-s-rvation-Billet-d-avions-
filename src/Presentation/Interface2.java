package Presentation;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Interface2 extends JPanel{
	
	
public void paintComponent(Graphics A) {
		
		Image avionimg;
		try {
			avionimg = ImageIO.read(new File("bin\\Presentation\\avion2.jpg"));
			A.drawImage(avionimg,0,0,this.getWidth(),this.getHeight(),this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	

}
