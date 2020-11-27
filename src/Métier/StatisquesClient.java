package Métier;

import java.sql.Date;

public class StatisquesClient 
{
	private int ID_Client;
	private String NomPersonne;
	private String PrenomPersonne;
	private String heureDepart;
	private String heureArrivee;
	private String VilleDepart;
	private String VilleArrivee;
	private Date DateDepart;
	private String NomAvion;
	
	public StatisquesClient(int iD_Client, String nomPersonne, String prenomPersonne, String heureDepart,String heureArrivee, String villeDepart, String villeArrivee, Date dateDepart, String nomAvion) 
	{
		ID_Client = iD_Client;
		NomPersonne = nomPersonne;
		PrenomPersonne = prenomPersonne;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		VilleDepart = villeDepart;
		VilleArrivee = villeArrivee;
		DateDepart = dateDepart;
		NomAvion = nomAvion;
	}

	public int getID_Client() {
		return ID_Client;
	}

	public void setID_Client(int iD_Client) {
		ID_Client = iD_Client;
	}

	public String getNomPersonne() {
		return NomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		NomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return PrenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		PrenomPersonne = prenomPersonne;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
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

	public String getNomAvion() {
		return NomAvion;
	}

	public void setNomAvion(String nomAvion) {
		NomAvion = nomAvion;
	}
	


	
	
}
