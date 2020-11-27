package Métier;

import java.util.Date;

public class Volbis {
	
	private int ID_Trajet;
	private int ID_Avion;
	private Date DateDepart;
	private Date DateArrivee;
	private String Duree;
	private int hours;
	private int minutes;
	private int secondes;
	private int hours2;
	private int minutes2;
	private int secondes2;
	private int ID_Vol;
	
public Volbis(int iD_Trajet, int iD_Avion, Date dateDepart, Date dateArrivee, String duree, int hours, int minutes,int secondes, int hours2, int minutes2,int secondes2,int idv) {
		
		this.setDateArrivee(dateArrivee);
		this.setDateDepart(dateDepart);
		this.setDuree(duree);
		this.setHours(hours);
		this.setID_Avion(iD_Avion);
		this.setID_Trajet(iD_Trajet);
		this.setMinutes(minutes);
		this.setSecondes(secondes);
		this.setHours2(hours2);
		this.setMinutes2(minutes2);
		this.setSecondes2(secondes2);
		this.setID_Vol(idv);
	}
	
	
public int getID_Trajet() {
		
		return ID_Trajet;
		
	}


	public void setID_Trajet(int iD_Trajet) {
		
		ID_Trajet =  iD_Trajet;
		
	}


	public int getID_Avion() {
		
		return ID_Avion;
		
	}


	public void setID_Avion(int iD_Avion) {
		
		ID_Avion = iD_Avion;
		
	}


	public Date getDateDepart() {
		
		return DateDepart;
		
	}


	public void setDateDepart(Date dateDepart) {
		
		DateDepart = dateDepart;
		
	}


	public Date getDateArrivee() {
		
		return DateArrivee;
		
	}


	public void setDateArrivee(Date dateArrivee) {
		
		DateArrivee = dateArrivee;
		
	}


	public String getDuree() {
		
		return Duree;
		
	}


	public void setDuree(String duree) {
		
		Duree = duree;
		
	}


	public int getHours() {
		
		return hours;
		
	}


	public void setHours(int hours) {
		
		this.hours = hours;
		
	}


	public int getMinutes() {
		
		return minutes;
		
	}


	public void setMinutes(int minutes) {
		
		this.minutes = minutes;
		
	}


	public int getSecondes() {
		
		return secondes;
		
	}


	public void setSecondes(int secondes) {
		
		this.secondes = secondes;
		
	}
	
	public int getHours2() {
		
		return hours2;
		
	}


	public void setHours2(int hours2) {
		
		this.hours2 = hours2;
		
	}


	public int getMinutes2() {
		
		return minutes2;
		
	}


	public void setMinutes2(int minutes2) {
		
		this.minutes2 = minutes2;
		
	}


	public int getSecondes2() {
		
		return secondes2;
		
	}


	public void setSecondes2(int secondes2) {
		
		this.secondes2 = secondes2;
		
	}


	public int getID_Vol() {
		return ID_Vol;
	}


	public void setID_Vol(int iD_Vol) {
		
		ID_Vol = iD_Vol;
		
	}
	
	
}
