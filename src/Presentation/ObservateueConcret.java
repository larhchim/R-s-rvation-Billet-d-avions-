package Presentation;


import javax.swing.JLabel;

public class ObservateueConcret implements Observateur {
   private static JLabel h=new JLabel();
	@Override
	public void updt(String c) {
		h.setText(c);
		
	}
	public static JLabel getH() {
		return h;
	}
	public void setH(JLabel h) {
		this.h = h;
	}

}
