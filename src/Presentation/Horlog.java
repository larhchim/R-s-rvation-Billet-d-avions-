package Presentation;


import java.util.ArrayList;
import java.util.Calendar;

public class Horlog extends Thread implements Observavle {
	 private Calendar cal;
	  private String hour ;
	 private ArrayList<Observateur> x=new ArrayList<Observateur>();
	  public void run() {
	    while(true){
	   
	    this.cal = Calendar.getInstance();
	    this.hour =  
	      this.cal.get(Calendar.HOUR_OF_DAY) + " : " 
	      + 
	      (    
	        this.cal.get(Calendar.MINUTE) < 10
	        ? "0" + this.cal.get(Calendar.MINUTE)
	        : this.cal.get(Calendar.MINUTE)
	      )
	      + " : " 
	      +
	      (    
	        (this.cal.get(Calendar.SECOND)< 10) 
	        ? "0"+this.cal.get(Calendar.SECOND) 
	        :this.cal.get(Calendar.SECOND)
	      );
	      NotifertObservavle();
	      try {
	        Thread.sleep(1000);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
}
	  }
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	@Override
	public void addObservavle(Observateur o) {
		x.add(o);
		
	}

	@Override
	public void deletObservavle(Observateur o) {
		x.remove(o);
		
	}

   @Override
	public void NotifertObservavle() {
		for(Observateur v:x) {
			v.updt(this.hour);
		}
		
	}
}
