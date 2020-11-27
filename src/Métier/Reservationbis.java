package Métier;

import java.util.Date;

public class Reservationbis {
	
	private int id;
	private String VilleDepart;
	private String VilleArrivee;
	private Date DateDepart;
	private Date DateArrivee;
	private int hours;
	private int minutes;
	private int secondes;
	private String classe;
	private String NomPer;
	private String PrePer;
	private int NumCli;
	private int NumVol;
	private Date DateRes;
	private String NumPass;
	
	
public Reservationbis(int d,String villeDepart, String villeArrivee, Date dateDepart,Date dateArrivee, int hours, int minutes, int secondes,String classe,String f,String j,int nc,int nv,Date dr,String np) {
        
		this.setId(d);
		this.setClasse(classe);
		this.setDateDepart(dateDepart);
		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSecondes(secondes);
		this.setVilleArrivee(villeArrivee);
		this.setVilleDepart(villeDepart);
		this.setDateArrivee(dateArrivee);
		this.setPrePer(f);
		this.setNomPer(j);
		this.setNumCli(nc);
		this.setNumVol(nv);
		this.setDateRes(dr);
		this.setNumPass(np);
		
	}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getVilleDepart() {
	return VilleDepart;
}


public void setVilleDepart(String villeDepart) {
	VilleDepart = villeDepart;
}


public String getVilleArrivee() {
	return VilleArrivee;
}


public void setVilleArrivee(String villeArrivee) {
	VilleArrivee = villeArrivee;
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


public String getClasse() {
	return classe;
}


public void setClasse(String classe) {
	this.classe = classe;
}


public String getNomPer() {
	return NomPer;
}


public void setNomPer(String nomPer) {
	NomPer = nomPer;
}


public String getPrePer() {
	return PrePer;
}


public void setPrePer(String prePer) {
	PrePer = prePer;
}


public int getNumCli() {
	return NumCli;
}


public void setNumCli(int numCli) {
	NumCli = numCli;
}


public int getNumVol() {
	return NumVol;
}


public void setNumVol(int numVol) {
	NumVol = numVol;
}


public Date getDateRes() {
	return DateRes;
}


public void setDateRes(Date dateRes) {
	DateRes = dateRes;
}


public String getNumPass() {
	return NumPass;
}


public void setNumPass(String np) {
	NumPass = np;
}




}
