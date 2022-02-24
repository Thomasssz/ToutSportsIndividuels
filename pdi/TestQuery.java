package pdi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.GolfSport;
import data.Sport;
import data.Utilisateur;





/**
 * Run first {@link TestPersist} before running this test.
 */

public class TestQuery {
	

	
	public static void main(String[] args) {
		Session session = DBConnection.getSession();
		System.out.println("######### Initial read #############");
		//testPolymorphismQuery(session);
		
		
		String table = "";
		
		
		Query query = session.createQuery("from GolfSport where utilisateur_id_utilisateur =1");
	//	query.setInteger("id", user.getId());
		
		@SuppressWarnings("unchecked")
		ArrayList<Sport> result = (ArrayList<Sport>) query.list();

		session.close();
	}
	
	@SuppressWarnings("rawtypes")
	private static void testPolymorphismQuery(Session session) {
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from GolfSport  ");
		 GolfSport coup_golf = null;
		List result = readQuery.list();
		Iterator iterator = result.iterator();
		while (iterator.hasNext()) {
			 coup_golf = (GolfSport) iterator.next();
			System.out.println(coup_golf);
		}
		
		readTransaction.commit();
	}
	
	

	
	@SuppressWarnings("rawtypes")
	private static void testWhereClause(Session session, String nom) {
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from Utilisateur u where u.nom=:nom");
		readQuery.setString("nom", nom);
		List result = readQuery.list();
		Iterator iterator = result.iterator();
		while (iterator.hasNext()) {
			Utilisateur utilisateur = (Utilisateur) iterator.next();
			System.out.println(utilisateur.toString());
		}
		readTransaction.commit();
	}
	
	private static void testUpdate(Session session, String newNom, String newPrenom) {
		Transaction updateTransaction = session.beginTransaction();
		Query updateQuery = session.createQuery("update Person p set p.firstname = :firstname where p.lastname=:lastname");
		updateQuery.setString("nom", newNom);
		updateQuery.setString("prenom", newPrenom);
		updateQuery.executeUpdate();
		updateTransaction.commit();
		
	}
	
	private static void testDelete(Session session, String prenom) {
		Transaction updateTransaction = session.beginTransaction();
		Query updateQuery = session.createQuery("delete Utilisateur u where u.prenom=:prenom");
		updateQuery.setString("prenom", prenom);
		updateQuery.executeUpdate();
		updateTransaction.commit();	
	}

}
