package requete;

import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.CourseSport;
import data.Kilometre_course;
import data.RugbySport;
import data.Sport;
import data.Statistique_Rugby;
import data.Trou_golf;
import data.Utilisateur;
import data.Vitesse_course;

public class InsertCourse {

	private float vitesse_moyenne;
	private int nombre_ligne;
	
	private float kilometre;
	
	private int id_user;
	private ArrayList<Sport> sportList ;


	public InsertCourse() {
	}

	public InsertCourse(float vitesse_moyenne,int id_user) {
		this.vitesse_moyenne = vitesse_moyenne;
		this.id_user = id_user;
	}
	


	

	public float getVitesse_moyenne() {
		return vitesse_moyenne;
	}

	public void setVitesse_moyenne(float vitesse_moyenne) {
		this.vitesse_moyenne = vitesse_moyenne;
	}

	public int getId_utilisateur() {
		return id_user;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_user = id_utilisateur;
	}
	public int getNombre_ligne() {
		return nombre_ligne;
	}

	public void setNombre_ligne(int nombre_ligne) {
		this.nombre_ligne = nombre_ligne;
	}
	
	public void insertCourse_vitesse(float vitesse_moyenne,int id_user) {
	
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Query query = session.createQuery("from CourseSport where type ='vitesse' and utilisateur_id_utilisateur ="+id_user);
		
		 sportList = (ArrayList<Sport>) query.list();
		nombre_ligne =  sportList.size();
		
		
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(id_user);
		
		CourseSport r = new CourseSport(date, "vitesse");
		r.setUtilisateur(utilisateur1);	
		
		Vitesse_course vitesse_course = new Vitesse_course(vitesse_moyenne,nombre_ligne+1);
		r.addVitesse(vitesse_course);
		
		session.save(vitesse_course);
		session.save(r);


		
		persistTransaction1.commit();
		session.close();
		

	}

	public void insertCourse_kilometre(float vitesse_moyenne,int id_user) {
		
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Query query = session.createQuery("from CourseSport where type ='kilometre' and utilisateur_id_utilisateur ="+id_user);
		
		 sportList = (ArrayList<Sport>) query.list();
		nombre_ligne =  sportList.size();
		System.out.println("verifi"+nombre_ligne);
		
		
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(id_user);
		
		CourseSport r = new CourseSport(date, "kilometre");
		r.setUtilisateur(utilisateur1);	
		
		Kilometre_course kilometre_course = new Kilometre_course(vitesse_moyenne,nombre_ligne+1);
		r.addKilometre(kilometre_course);
		
		session.save(kilometre_course);
		session.save(r);


		
		persistTransaction1.commit();
		session.close();
		

	}


}
