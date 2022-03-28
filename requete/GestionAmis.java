package requete;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.Amis;
import data.Sport;
import data.Utilisateur;

public class GestionAmis {
	private Session session;
	private Transaction transaction;
	private ArrayList<Amis> amistList ;

	public GestionAmis() {

	
	}
	
	
	public int addAmis(Utilisateur amis,Utilisateur user) {
		
		
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		Amis ajoutAmis /*= new Amis(amis,user)*/ = null;
		//deleteAmis.setId_amis(amis.getId_utilisteur());
		Query query = session.createQuery("from Amis where utilisateur_id_utilisateur ="+amis.getId_utilisteur()+" and amis_id_utilisateur ="+user.getId_utilisteur());
		//System.out.println("essai"+deleteAmis);
		
		@SuppressWarnings("rawtypes")
		List result = query.list();
		//Utilisateur u = null;

		if(result.size() == 1) {
			System.out.println("essai");

			ajoutAmis = (Amis) result.get(0);
			ajoutAmis.setAccepter(1);
			session.persist(ajoutAmis);

		}
		
		
		
		
		transaction.commit();
		return ajoutAmis.getAccepter();

	}
	
public int rejetAmis(Utilisateur amis,Utilisateur user) {
		
		
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		Amis ajoutAmis /*= new Amis(amis,user)*/ = null;
		//deleteAmis.setId_amis(amis.getId_utilisteur());
		Query query = session.createQuery("from Amis where utilisateur_id_utilisateur ="+user.getId_utilisteur()+" and amis_id_utilisateur ="+amis.getId_utilisteur());
		//System.out.println("essai"+deleteAmis);
		
		@SuppressWarnings("rawtypes")
		List result = query.list();
		//Utilisateur u = null;

		if(result.size() == 1) {

			ajoutAmis = (Amis) result.get(0);
			ajoutAmis.setAccepter(2);
			session.persist(ajoutAmis);

		}
		
		
		
		
		transaction.commit();
		return ajoutAmis.getAccepter();

	}
	
	public int dejaAmis(Utilisateur amis,Utilisateur user) {
		int valider = 0;
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Amis where utilisateur_id_utilisateur ="+user.getId_utilisteur()+" and amis_id_utilisateur ="+amis.getId_utilisteur());
		List result = query.list();
		//Utilisateur u = null;

		if(result.size() == 1)
		{
			valider=1;

		}
		else {
			valider=0;
		}
		
		
		transaction.commit();
		return valider;
	}
	public int dejaAmisRefuser(Utilisateur amis,Utilisateur user) {
		int refuser = 0;
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		Amis dejaAmisRefuser /*= new Amis(amis,user)*/ = null;

		Query query = session.createQuery("from Amis where utilisateur_id_utilisateur ="+user.getId_utilisteur()+" and amis_id_utilisateur ="+amis.getId_utilisteur()+" and accepter=2");
		List result = query.list();
		//Utilisateur u = null;

		if(result.size() == 1)
		{
			refuser=1;
			dejaAmisRefuser = (Amis) result.get(0);
			session.delete(dejaAmisRefuser);
			

		}
		else {
			refuser=0;
		}
		
		
		transaction.commit();
		return refuser;
	}
	
	public int requeteAmis(Utilisateur amis,Utilisateur user) {
		Amis ajoutAmis = new Amis(amis,user);
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		
		session.save(ajoutAmis);
		transaction.commit();
		return ajoutAmis.getAccepter();
	}
	
public void deleteRequeteAmis() {
		
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		Amis deleteAmis /*= new Amis(amis,user)*/;
		//deleteAmis.setId_amis(amis.getId_utilisteur());
		Query query = session.createQuery("from Amis where accepter= 2");
		//System.out.println("essai"+deleteAmis);
		
		@SuppressWarnings("rawtypes")
		List result = query.list();
		//Utilisateur u = null;

		for (int i = 0 ; i < result.size() ; i++) {
			//System.out.println(result.size() + " cest ok ");
			deleteAmis = (Amis) result.get(i);
			System.out.println(deleteAmis);
			session.delete(deleteAmis);

		
		}
		
		transaction.commit();

	}
	
	public void deleteAmis(Utilisateur amis,Utilisateur user) {
		
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		Amis deleteAmis /*= new Amis(amis,user)*/;
		//deleteAmis.setId_amis(amis.getId_utilisteur());
		Query query = session.createQuery("from Amis where utilisateur_id_utilisateur ="+user.getId_utilisteur()+" and amis_id_utilisateur ="+amis.getId_utilisteur());
		//System.out.println("essai"+deleteAmis);
		
		@SuppressWarnings("rawtypes")
		List result = query.list();
		//Utilisateur u = null;

		if(result.size() == 1)
		{
			//System.out.println(result.size() + " cest ok ");
			deleteAmis = (Amis) result.get(0);
			System.out.println(deleteAmis);
			session.delete(deleteAmis);

		}
		
		
		transaction.commit();

	}
	public ArrayList<Amis> arrayDemandeAmis (int id_utilisateur) {
		Session session = DBConnection.getSession();
		//System.out.println("######### Initial read #############");
		//testPolymorphismQuery(session);		
		
		Query query = session.createQuery("from Amis where amis ="+id_utilisateur);
		
		amistList = (ArrayList<Amis>) query.list();

	
		session.close();
		return amistList;
	 }
	
	public ArrayList<Amis> arrayAmis (int id_utilisateur) {
		Session session = DBConnection.getSession();
		//System.out.println("######### Initial read #############");
		//testPolymorphismQuery(session);		
		
		Query query = session.createQuery("from Amis where utilisateur_id_utilisateur ="+id_utilisateur
				+" or amis_id_utilisateur ="+id_utilisateur+" and accepter =1");
		
		amistList = (ArrayList<Amis>) query.list();

	
		session.close();
		return amistList;
	 }
	
	public Utilisateur findUser(String login)
	{
		session = DBConnection.getSession();
		
		Query query = session.createQuery("from Utilisateur where login = :login");
		query.setString("login", login);
		Utilisateur u = null;

		@SuppressWarnings("rawtypes")
		List result = query.list();

		if(result.size() == 1)
		{
			u = (Utilisateur) result.get(0);
			//System.out.println(u);
		}
		else
			System.out.println("Inconnu");

			
		
		session.close();
		return u;		
	}
	
	public Utilisateur findIdAmis(int id_amis,int id_user)
	{
		session = DBConnection.getSession();
		
		Query query = session.createQuery("from Amis where amis_id_utilisateur ="+id_amis+" and utilisateur_id_utilisateur ="+id_user);
		//query.setString("id_amis", id_amis);
		Utilisateur u = null;
		Amis a = null;
		@SuppressWarnings("rawtypes")
		List result = query.list();

		if(result.size() == 1)
		{
			//System.out.println(result.size() + " amis ok ");
			 a  =  (Amis) result.get(0);
			 u = a.getAmis();
			//System.out.println(u);
		}
		else
			System.out.println(u);

			
		
		session.close();
		return u;		
	}
	public Utilisateur findID(int id_utilisateur) {
		session = DBConnection.getSession();

		Query query = session.createQuery("from Utilisateur where id_utilisateur = :id_utilisateur");
		query.setInteger("id_utilisateur", id_utilisateur);
		Utilisateur u = null;
		//int id=0;

		@SuppressWarnings("rawtypes")
		List result = query.list();

		if(result.size() == 1)
		{
			u = (Utilisateur) result.get(0);
			//id=u.getId_utilisteur();

			//System.out.println(" test"+u);

		}
		else
			System.out.println("inconnu");

			
		
		session.close();
		
		return u;
	}
	

}
