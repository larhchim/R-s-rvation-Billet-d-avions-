package Métier;

import java.sql.*;

import Connection.DataBase.ConnectionB;

public class Avion {

	private int ID_Avion;
	private Double Vitesse;
	private Double Autonomie;
	private String NomAvion;
	private Double Prix_km_eco;
	private Double Prix_km_affaire;
	private Double prix_km_1ere;
	private String EtatAvion;
	private int NombrePlaces1ere;
	private int NombrePlacesEco;
	private int NombrePlacesAff;


	public Avion(int id, Double vitesse, Double autonomie, String nomAvion, Double prix_km_eco, Double prix_km_affaire,Double prix_km_1ere, String etatAvion, int nombrePlaces1ere, int nombrePlacesEco, int nombrePlacesAff) {
	
	this.setID_Avion(id);
    this.setAutonomie(autonomie);
    this.setEtatAvion(etatAvion);
    this.setNomAvion(nomAvion);
    this.setNombrePlaces1ere(nombrePlaces1ere);
    this.setNombrePlacesAff(nombrePlacesAff);
    this.setNombrePlacesEco(nombrePlacesEco);
    this.setPrix_km_1ere(prix_km_1ere);
    this.setPrix_km_affaire(prix_km_affaire);
    this.setPrix_km_eco(prix_km_eco);
    this.setVitesse(vitesse);
		
	}


	public Double getVitesse() {
		
		return Vitesse;
		
	}
	
	
	public void setVitesse(Double vitesse) {
		
		Vitesse = vitesse;
		
	}
	
	
	public Double getAutonomie() {
		
		return Autonomie;
		
	}
	
	
	public void setAutonomie(Double autonomie) {
		
		Autonomie = autonomie;
		
	}
	
	
	public String getNomAvion() {
		
		return NomAvion;
		
	}
	
	
	public void setNomAvion(String nomAvion) {
		
		NomAvion = nomAvion;
		
	}
	
	
	public Double getPrix_km_eco() {
		
		return Prix_km_eco;
		
	}
	
	
	public void setPrix_km_eco(Double prix_km_eco) {
		
		Prix_km_eco = prix_km_eco;
		
	}
	
	
	public Double getPrix_km_affaire() {
		
		return Prix_km_affaire;
		
	}
	
	
	public void setPrix_km_affaire(Double prix_km_affaire) {
		
		Prix_km_affaire = prix_km_affaire;
		
	}
	
	
	public Double getPrix_km_1ere() {
		
		return prix_km_1ere;
		
	}
	
	
	public void setPrix_km_1ere(Double prix_km_1ere) {
		
		this.prix_km_1ere = prix_km_1ere;
		
	}

	
	public String getEtatAvion() {
		
		return EtatAvion;
		
	}


	public void setEtatAvion(String etatAvion) {
		
		EtatAvion = etatAvion;
		
	}
	
	


	public int getNombrePlaces1ere() {
		
		return NombrePlaces1ere;
		
	}


	public void setNombrePlaces1ere(int nombrePlaces1ere) {
		
		NombrePlaces1ere = nombrePlaces1ere;
		
	}


	public int getNombrePlacesEco() {
		
		return NombrePlacesEco;
		
	}


	public void setNombrePlacesEco(int nombrePlacesEco) {
		
		NombrePlacesEco = nombrePlacesEco;
		
	}
	


	public int getNombrePlacesAff() {
		
		return NombrePlacesAff;
		
	}


	public void setNombrePlacesAff(int nombrePlacesAff) {
		
		NombrePlacesAff = nombrePlacesAff;
		
	}

	
	public int getID_Avion() {
		return ID_Avion;
	}


	public void setID_Avion(int iD_Avion) {
		ID_Avion = iD_Avion;
	}
	
	@Override
	public String toString() {
		return "Avion [ID_Avion=" + ID_Avion + ", Vitesse=" + Vitesse + ", Autonomie=" + Autonomie + ", NomAvion="
				+ NomAvion + ", Prix_km_eco=" + Prix_km_eco + ", Prix_km_affaire=" + Prix_km_affaire + ", prix_km_1ere="
				+ prix_km_1ere + ", EtatAvion=" + EtatAvion + ", NombrePlaces1ere=" + NombrePlaces1ere
				+ ", NombrePlacesEco=" + NombrePlacesEco + ", NombrePlacesAff=" + NombrePlacesAff + "]";
	}


	public static void Ajouter(Avion ajout) throws Exception {
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Insert into tavion(Vitesse,Autonomie,NomAvion,Prix_km_eco,Prix_km_affaire,Prix_km_1ere,EtatAvion,NombrePlaces1ere,NombrePlacesEco,NombrePlacesAff) values(? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
		ps.setDouble(1, ajout.Vitesse); 
		ps.setDouble(2, ajout.Autonomie);
		ps.setString(3, ajout.NomAvion);
		ps.setDouble(4, ajout.Prix_km_eco);
		ps.setDouble(5, ajout.Prix_km_affaire);
		ps.setDouble(6, ajout.prix_km_1ere);
		ps.setString(7, ajout.EtatAvion);
		ps.setInt(8,ajout.NombrePlaces1ere);
		ps.setInt(9,ajout.NombrePlacesEco);
		ps.setInt(10,ajout.NombrePlacesAff);
		ps.executeUpdate();
		
	}
	
	public static void Supprimer(int ID_Avion) throws Exception {
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Delete from tavion where ID_Avion = ?");
		ps.setInt(1,ID_Avion);
		ps.executeUpdate();
		
	}
	
	public static String checkstate(int ID_Avion) throws Exception {
	
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Select * From tavion where ID_Avion=?");
		ps.setInt(1, ID_Avion);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getString("EtatAvion");
		
	}
	
	public static void ModifyState(int ID_Avion,String chaine)throws Exception{
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Update tavion set EtatAvion=? Where ID_Avion=?");
		ps.setString(1,chaine);
		ps.setInt(2,ID_Avion);
		ps.executeUpdate();
		
	}
	
	public static void Modifier(Avion rb) throws Exception {
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Update tavion set Vitesse=?,Autonomie=?,NomAvion=?,NombrePlaces1ere=?,NombrePlacesEco=?,NombrePlacesAff=?, Prix_Km_eco=?,Prix_km_affaire=?,Prix_km_1ere=?,EtatAvion=? WHERE ID_Avion=? ");
		ps.setDouble(1, rb.getVitesse());
		ps.setDouble(2, rb.getAutonomie());
		ps.setString(3, rb.getNomAvion());
		ps.setInt(4, rb.getNombrePlaces1ere());
		ps.setInt(5, rb.getNombrePlacesEco());
		ps.setInt(6, rb.getNombrePlacesAff());
		ps.setDouble(7, rb.getPrix_km_eco());
		ps.setDouble(8, rb.getPrix_km_affaire());
		ps.setDouble(9, rb.getPrix_km_1ere());
		ps.setString(10, rb.getEtatAvion());
		ps.setInt(11, rb.getID_Avion());
		ps.executeUpdate();
		
	}
	
}
