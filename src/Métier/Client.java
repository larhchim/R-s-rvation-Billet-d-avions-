package Métier;
import java.sql.*;



import Connection.DataBase.ConnectionB;

public class Client {
	

	private String NomClient;
	private String PrenomClient;
	private Date DateNaissance;
	private String CINClient;
	private String NumPasseport;
	private String Nationalite;
	private String LoginClient;
	private String PasswordClient;
	private String CategorieClient;
	
	
	
	public Client(String nomClient, String prenomClient, Date dateNaissance, String cINClient, String numPasseport,String nationalite, String loginClient, String passwordClient, String categorieClient) 
	{
		
		NomClient = nomClient;
		PrenomClient = prenomClient;
		DateNaissance = dateNaissance;
		CINClient = cINClient;
		NumPasseport = numPasseport;
		Nationalite = nationalite;
		LoginClient = loginClient;
		PasswordClient = passwordClient;
		CategorieClient = categorieClient;
		
	}
	
	
	public String getNomClient() {
		
		return NomClient;
		
	}
	
	
	public void setNomClient(String nomClient) {
		
		NomClient = nomClient;
		
	}
	
	
	public String getPrenomClient() {
		
		return PrenomClient;
		
	}
	
	
	public void setPrenomClient(String prenomClient) {
		
		PrenomClient = prenomClient;
		
	}
	
	
	public Date getDateNaissance() {
		
		return DateNaissance;
		
	}
	
	
	public void setDateNaissance(Date dateNaissance) {
		
		DateNaissance = dateNaissance;
		
	}
	
	
	public String getCINClient() {
		
		return CINClient;
		
	}
	
	
	public void setCINClient(String cINClient) {
		
		CINClient = cINClient;
		
	}
	
	
	public String getNumPasseport() {
		
		return NumPasseport;
		
	}
	
	
	public void setNumPasseport(String numPasseport) {
		
		NumPasseport = numPasseport;
		
	}
	
	
	public String getNationalite() {
		
		return Nationalite;
		
	}
	
	
	public void setNationalite(String nationalite) {
		
		Nationalite = nationalite;
		
	}
	
	
	public String getLoginClient() {
		
		return LoginClient;
		
	}
	
	
	public void setLoginClient(String loginClient) {
		
		LoginClient = loginClient;
		
	}
	
	
	public String getPasswordClient() {
		
		return PasswordClient;
		
	}
	
	
	public void setPasswordClient(String passwordClient) {
		
		PasswordClient = passwordClient;
		
	}
	
	
	public String getCategorieClient() {
		
		return CategorieClient;
		
	}
	
	
	public void setCategorieClient(String categorieClient) {
		
		CategorieClient = categorieClient;
		
	}
	
	public static void Inscription(Client t) throws Exception
	{
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps=conn.prepareStatement("Insert into tclient(NomClient,PrenomClient,DateNaissance,CINClient,NumPasseport,Nationalite,LoginClient,PasswordClient,CategorieClient) values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,t.NomClient);
		ps.setString(2, t.PrenomClient);
		ps.setDate(3,t.DateNaissance) ;
		ps.setString(4, t.CINClient);
		ps.setString(5,t.NumPasseport);
		ps.setString(6, t.Nationalite);
		ps.setString(7, t.LoginClient);
		ps.setString(8, t.PasswordClient);
		ps.setString(9, t.CategorieClient);
		ps.executeUpdate();
		
	}
	
	public void Modifier(Client c , int id) throws Exception
	{
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps =conn.prepareStatement("Update tclient set NomClient=? ,PrenomClient=?, DateNaissance=? , CINClient=? , NumPasseport=? , Nationalite=? , CategorieClient=? ,LoginClient=? ,PasswordClient=? WHERE ID_Client=? ");
		ps.setString(1,c.NomClient);
		ps.setString(2, c.PrenomClient);
		ps.setDate(3,c.DateNaissance) ;
		ps.setString(4, c.CINClient);
		ps.setString(5,c.NumPasseport);
		ps.setString(6, c.Nationalite);
		ps.setString(7, c.CategorieClient);
		ps.setString(8, c.LoginClient);
		ps.setString(9, c.PasswordClient);
		ps.setInt(10, id);
		ps.executeUpdate();

	}


	@Override
	public String toString() {
		
		return "Client [NomClient=" + NomClient + ", PrenomClient=" + PrenomClient + ", DateNaissance=" + DateNaissance
				+ ", CINClient=" + CINClient + ", NumPasseport=" + NumPasseport + ", Nationalite=" + Nationalite
				+ ", LoginClient=" + LoginClient + ", PasswordClient=" + PasswordClient + ", CategorieClient="
				+ CategorieClient + "]";
		
	}
	
	public static int connecter(String login , String Pass) throws Exception{
		

		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps =conn.prepareStatement(" SELECT ID_Client FROM tclient WHERE LoginClient=? AND PasswordClient=?  ");
		ps.setString(1,login);
		ps.setString(2,Pass);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		if(rs.first()) {
			return rs.getInt(1);
		}
		return 0;
		
			
		
	}
	
	public static Client methode(int idcli) throws Exception {
		
		Connection conn=ConnectionB.EtablissementConn();
		PreparedStatement ps =conn.prepareStatement(" SELECT * FROM tclient WHERE ID_Client=?  ");
		ps.setInt(1, idcli);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return new Client(rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
	}
	
	

}
