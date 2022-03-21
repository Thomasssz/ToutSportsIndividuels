package requete;

import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import bd_init.DataInit;
import data.GolfSport;
import data.Sport;
import data.Trou_golf;
import data.Utilisateur;
import data.Vitesse_golf;


import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.GolfSport;
import data.Vitesse_golf;

public class InsertGolf {
	
	private Trou_golf trou_golf;
	private String parcours;
	private int coup_effectuer;
	private int coup;
	
	private float vitesse;
	private float distance;
	private int user;
	
	public InsertGolf() {
	}
	public InsertGolf(float vitesse, float distance, int user) {
		this.vitesse = vitesse;
		this.distance = distance;
		this.user = user;
	}
	
	
	public InsertGolf(String parcours, int coup_effectuer,int user) {
		this.parcours = parcours;
		this.coup_effectuer = coup_effectuer;
		this.user = user;

	}
	public String getParcours() {
		return parcours;
	}
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}
	public int getCoup_effectuer() {
		return coup_effectuer;
	}
	public void setCoup_effectuer(int coup_effectuer) {
		this.coup_effectuer = coup_effectuer;
	}
	public int getCoup() {
		return coup;
	}
	public void setCoup(int coup) {
		this.coup = coup;
	}
	public float getVitesse() {
		return vitesse;
	}
	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public void insertGolf_vitesse(float vitesse, float distance, int user) {
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(user);

		GolfSport g = new GolfSport (date,20,"vitesse");
		g.setUtilisateur(utilisateur1);
		
		Vitesse_golf vitesse_golf = new Vitesse_golf(vitesse, distance);
		g.addVitesse_golf(vitesse_golf);
		
		session.save(vitesse_golf);
		session.save(g);


		
		persistTransaction1.commit();
		session.close();
	}
	
	
	public void insertGolf_coup(String parcours, int coup_effectuer,int user) {
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(user);

		GolfSport g = new GolfSport (date,20,"coup");
		g.setUtilisateur(utilisateur1);
		Trou_golf trou_golf = null;
		switch(parcours)
		{
			case "green":
				trou_golf = new Trou_golf(parcours,6, coup_effectuer);
				break;
			case "lac":
				trou_golf = new Trou_golf(parcours,5, coup_effectuer);
				break;
			case "practice":
				trou_golf = new Trou_golf(parcours,3, coup_effectuer);
				break;
			case "winter":
				trou_golf = new Trou_golf(parcours,3, coup_effectuer);
				break;
			case "medium":
				trou_golf = new Trou_golf(parcours,4, coup_effectuer);
				break;
			case "hard":
				trou_golf = new Trou_golf(parcours,7, coup_effectuer);
				break;		
		}
		
			g.addTrou_golf(trou_golf);
			
			session.save(trou_golf);
	
		System.out.println(trou_golf);
		
		
		session.save(g);


		
		persistTransaction1.commit();
		session.close();
	}
	
}
