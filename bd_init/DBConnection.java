package bd_init;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import data.Cotation_escalade;
import data.CourseSport;
import data.EscaladeSport;
import data.GolfSport;
import data.Kilometre_course;
import data.Oxygene_plonger;
import data.Penalite_Rugby;
import data.PlongerSport;
import data.Prise_escalade;
import data.Profondeur_plonger;
import data.RugbySport;
import data.Statistique_Rugby;
import data.Trou_golf;
import data.Utilisateur;
import data.Vitesse_course;
import data.Vitesse_golf;

public class DBConnection {
	private static SessionFactory sessionFactory;
	private static AnnotationConfiguration config;

	public static AnnotationConfiguration getConfig() {
		if (config == null) {
			config = new AnnotationConfiguration();
			config.addAnnotatedClass(Utilisateur.class);
			config.addAnnotatedClass(Trou_golf.class);
			config.addAnnotatedClass(GolfSport.class);
			config.addAnnotatedClass(Vitesse_golf.class);
			config.addAnnotatedClass(RugbySport.class);
			config.addAnnotatedClass(Statistique_Rugby.class);
			config.addAnnotatedClass(Penalite_Rugby.class);
			config.addAnnotatedClass(PlongerSport.class);
			config.addAnnotatedClass(Profondeur_plonger.class);
			config.addAnnotatedClass(Oxygene_plonger.class);
			config.addAnnotatedClass(CourseSport.class);
			config.addAnnotatedClass(Vitesse_course.class);
			config.addAnnotatedClass(Kilometre_course.class);
			config.addAnnotatedClass(EscaladeSport.class);
			config.addAnnotatedClass(Prise_escalade.class);
			config.addAnnotatedClass(Cotation_escalade.class);





			String packageName = DBConnection.class.getPackage().getName();
			config.configure(packageName + "/connection.cfg.xml");
		}
		return config;
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				AnnotationConfiguration config = getConfig();
				sessionFactory = config.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
