package requete;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import bd_init.DBConnection;
import data.Sport;

public class ListSport {

	private ArrayList<Sport> sportList ;
	public ListSport(ArrayList<Sport> sportList) {
		this.sportList=sportList;
	}
	
	 public ArrayList<Sport> arraySport (String sport,int id_utilisateur,String type) {
		Session session = DBConnection.getSession();
		System.out.println("######### Initial read #############");
		//testPolymorphismQuery(session);		
		
		Query query = session.createQuery("from "+sport+" where type ='"+type +"' and utilisateur_id_utilisateur ="+id_utilisateur);
		
		 sportList = (ArrayList<Sport>) query.list();

	
		session.close();
		return sportList;
	 }
	 
	 
}
