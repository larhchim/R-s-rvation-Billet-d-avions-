package Presentation;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Nationalite extends JPanel{
	

	private static final long serialVersionUID = 1L;

	/*public void paintComponent(Graphics A) {
		
		Graphics2D ref =(Graphics2D)A;
		GradientPaint a = new GradientPaint(0,0,java.awt.Color.decode("#FFFFCC"),20,20,java.awt.Color.decode("#FFFFCC"),true);
		ref.setPaint(a);
		ref.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}*/
	public void paintComponent(Graphics A) {
		
		Image avionimg;
		try {
			avionimg = ImageIO.read(new File("src\\Presentation\\nationalite.jpg"));
			A.drawImage(avionimg,0,0,this.getWidth(),this.getHeight(),this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}


}
