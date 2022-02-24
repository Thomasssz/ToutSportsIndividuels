package data;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
@Entity

public class Utilisateur {

	@Id
	@GeneratedValue
	private int id_utilisateur;
	
	private String nom;
	private String prenom;
	private String date_naissance;
	private String login;
	private String password;
	
	
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
	

	


	public Utilisateur(String nom, String prenom, String date_naissance, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.login = login;
		this.password = password;
	}





	public int getId_utilisteur() {
		return id_utilisateur;
	}
	




	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}





	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getDate_naissance() {
		return date_naissance;
	}


	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}





	@Override
	public String toString() {
		return "Utilisateur [id_utilisateur=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom
				+ ", date_naissance=" + date_naissance + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	

}
