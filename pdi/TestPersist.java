package pdi;

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

public class TestPersist {
	private ArrayList<Sport> sportList;

	public static void main(String[] args) {
		Date date = new Date(2022, 05, 05);
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Utilisateur utilisateur1 = new Utilisateur("Jean", "Dupont","30-01-1999","jean3310","jean");
		session.persist(utilisateur1);
		
		Utilisateur utilisateur2 = new Utilisateur("Paul", "Vincent","30-01-1999","vince958","vince");
		session.persist(utilisateur2);
		
		Trou_golf trou = new Trou_golf("lac",5,6);
		session.persist(trou);
		Trou_golf trou2 = new Trou_golf("green",6,5);
		session.persist(trou2);
		Trou_golf trou3 = new Trou_golf("winter",3,5);
		session.persist(trou3);
		
		GolfSport coup_golf = new GolfSport(date, 30,"coup");
		coup_golf.setUtilisateur(utilisateur1);
		session.persist(coup_golf);
		GolfSport coup_golf2 = new GolfSport(date,40,"coup");
		GolfSport coup_golf3 = new GolfSport(date , 60,"coup");
		coup_golf2.setUtilisateur(utilisateur1);
		coup_golf3.setUtilisateur(utilisateur2);
		
		coup_golf.addTrou_golf(trou);
		coup_golf2.addTrou_golf(trou2);
		coup_golf3.addTrou_golf(trou3);
		
		Trou_golf trou4= new Trou_golf("even",3,7);
		session.persist(trou);
		coup_golf.addTrou_golf(trou4);
		

		GolfSport coup_golf_point1 = new GolfSport(date,20,"vitesse");
		GolfSport coup_golf_point2 = new GolfSport(date,20,"vitesse");
		GolfSport coup_golf_point3 = new GolfSport(date,20,"vitesse");
		GolfSport coup_golf_point4 = new GolfSport(date,20,"vitesse");
		GolfSport coup_golf_point5 = new GolfSport(date,20,"vitesse");
		
		coup_golf_point1.setUtilisateur(utilisateur1);
		coup_golf_point2.setUtilisateur(utilisateur1);
		coup_golf_point3.setUtilisateur(utilisateur1);
		coup_golf_point4.setUtilisateur(utilisateur1);
		coup_golf_point5.setUtilisateur(utilisateur1);


	


		Vitesse_golf vitesse_golf = new Vitesse_golf(30, 80);
		Vitesse_golf vitesse_golf2 = new Vitesse_golf(35, 82);
		Vitesse_golf vitesse_golf3 = new Vitesse_golf(31, 78);
		Vitesse_golf vitesse_golf4 = new Vitesse_golf(37, 85);
		Vitesse_golf vitesse_golf5 = new Vitesse_golf(25, 75);
		




	

		coup_golf_point1.addVitesse_golf(vitesse_golf);
		coup_golf_point2.addVitesse_golf(vitesse_golf2);
		coup_golf_point3.addVitesse_golf(vitesse_golf3);
		coup_golf_point4.addVitesse_golf(vitesse_golf4);
		coup_golf_point5.addVitesse_golf(vitesse_golf5);

		


		
		

		//coup_golf2.addTrou_golf(trou2);
		
		session.persist(coup_golf2);
		session.persist(coup_golf3);
		
		session.persist(coup_golf_point1);
		session.persist(coup_golf_point2);
		session.persist(coup_golf_point3);
		session.persist(coup_golf_point4);
		session.persist(coup_golf_point5);
		
		session.persist(vitesse_golf);
		session.persist(vitesse_golf2);
		session.persist(vitesse_golf3);
		session.persist(vitesse_golf4);
		session.persist(vitesse_golf5);

		//Very useful, the save method can return an auto-generated Id.
		
		persistTransaction1.commit();

		session.close();

	}
}
