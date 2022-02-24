package requete;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.Oxygene_plonger;
import data.PlongerSport;
import data.Profondeur_plonger;
import data.Utilisateur;

public class InsertPlonger {
	
	private int profondeur;
	private float temps;
	private float consommation;
	private float profondeur_oxygene;
	private int user;
	
	public InsertPlonger() {
	}
	public InsertPlonger(int profondeur, float temps,int user) {
		this.profondeur = profondeur;
		this.temps = temps;
		this.user = user;
	}
	
	public InsertPlonger(float consommation, float profondeur_oxygene,int user) {
		super();
		this.consommation = consommation;
		this.profondeur_oxygene = profondeur_oxygene;
		this.user = user;
	}
	public int getProfondeur() {
		return profondeur;
	}
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
	public float getTemps() {
		return temps;
	}
	public void setTemps(float temps) {
		this.temps = temps;
	}
	
public void insertPlonger_profondeur(int profondeur, float temps,int user) {
		
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(user);
		
		PlongerSport p = new PlongerSport(date, "profondeur");
		p.setUtilisateur(utilisateur1);	
		
		Profondeur_plonger profondeur_plonger = new Profondeur_plonger(profondeur, temps);
		p.addProfondeur(profondeur_plonger);
		
		session.save(profondeur_plonger);
		session.save(p);


		
		persistTransaction1.commit();
		session.close();
		

	}
	
public void insertPlonger_oxygene(float oxygene, float profondeur_oxygene,int user) {
	
	Date date = new Date(2022, 05, 05);
	Session session = DBConnection.getSession();
	Transaction persistTransaction1 = session.beginTransaction();
	
	Utilisateur utilisateur1 = new Utilisateur();
	utilisateur1.setId_utilisateur(user);
	
	PlongerSport p = new PlongerSport(date, "oxygene");
	p.setUtilisateur(utilisateur1);	
	
	Oxygene_plonger profondeur_plonger = new Oxygene_plonger(consommation, profondeur_oxygene);
	p.addProfondeur(profondeur_plonger);
	
	session.save(profondeur_plonger);
	session.save(p);


	
	persistTransaction1.commit();
	session.close();
	

}
	
	
	

}
