package requete;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.Penalite_Rugby;
import data.RugbySport;
import data.Statistique_Rugby;
import data.Trou_golf;
import data.Utilisateur;
import data.Vitesse_golf;

public class InsertRugby {

	private String saison;
	private int nombre_match;
	private int essai;
	private int plaquage;
	
	private int penalite_tenter;
	private int distance;
	private int reussi ;
	private int echec;
	
	private int id_utilisateur;
	
	
	
	public InsertRugby() {
	}
	
	
	public InsertRugby(String saison, int nombre_match, int essai, int plaquage,int id_utilisateur) {
		this.saison = saison;
		this.nombre_match = nombre_match;
		this.essai = essai;
		this.plaquage = plaquage;
		this.id_utilisateur = id_utilisateur;
	}
	
	


	public InsertRugby(int penalite_tenter, int distance, int reussi, int echec, int id_utilisateur) {
		this.penalite_tenter = penalite_tenter;
		this.distance = distance;
		this.reussi = reussi;
		this.echec = echec;
		this.id_utilisateur = id_utilisateur;
	}


	public String getSaison() {
		return saison;
	}


	public void setSaison(String saison) {
		this.saison = saison;
	}


	public int getNombre_match() {
		return nombre_match;
	}


	public void setNombre_match(int nombre_match) {
		this.nombre_match = nombre_match;
	}


	public int getEssai() {
		return essai;
	}


	public void setEssai(int essai) {
		this.essai = essai;
	}


	public int getPlaquage() {
		return plaquage;
	}


	public void setPlaquage(int plaquage) {
		this.plaquage = plaquage;
	}
	
	

	public int getPenalite_tenter() {
		return penalite_tenter;
	}


	public void setPenalite_tenter(int penalite_tenter) {
		this.penalite_tenter = penalite_tenter;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public int getReussi() {
		return reussi;
	}


	public void setReussi(int reussi) {
		this.reussi = reussi;
	}


	public int getEchec() {
		return echec;
	}


	public void setEchec(int echec) {
		this.echec = echec;
	}


	public void insertRugby_statistique(String saison, int nombre_match, int essai, int plaquage,int id_utilisateur) {
		
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(id_utilisateur);
		
		RugbySport r = new RugbySport(date, "statistique");
		r.setUtilisateur(utilisateur1);	
		
		Statistique_Rugby statistique_rugby = new Statistique_Rugby(saison, nombre_match, essai, plaquage);
		r.addStatistique(statistique_rugby);
		
		session.save(statistique_rugby);
		session.save(r);


		
		persistTransaction1.commit();
		session.close();
		

	}
	
public void insertRugby_penalite(int penalite_tenter, int distance, int reussi, int echec, int id_utilisateur) {
		
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(id_utilisateur);
		
		RugbySport r = new RugbySport(date, "penalite");
		r.setUtilisateur(utilisateur1);	
		
		Penalite_Rugby penalite_rugby = new Penalite_Rugby(penalite_tenter, distance, reussi, echec);
		r.addPenalite(penalite_rugby);
		
		session.save(penalite_rugby);
		session.save(r);


		
		persistTransaction1.commit();
		session.close();
		

	}
	
	

	
}
