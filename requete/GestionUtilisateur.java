package requete;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.Utilisateur;





public class GestionUtilisateur 
{
	private Session session;
	private Transaction transaction;

	/**
	 * default Constructor
	 */
	public GestionUtilisateur() {	}
	
	/**
	 * Constructor with a user as parameter
	 * @param u
	 */
	public void addUser(Utilisateur u) 
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		
		session.save(u);
		transaction.commit();
	}
	
	/**
	 * deleting a user
	 * @param u
	 */
	public void deleteUser(Utilisateur u) 
	{
		session = DBConnection.getSession();
		transaction = session.beginTransaction();
		
		session.delete(u);
		transaction.commit();
	}
	
	/**
	 * @brief Method that verifies a user in the database based on his login and password
	 * @param login
	 * @param mdp
	 * @return User
	 */
	public Utilisateur findUser(String login, String password)
	{
		session = DBConnection.getSession();
		
		Query query = session.createQuery("from Utilisateur where login = :login and password = :password");
		query.setString("login", login);
		query.setString("password", password);
		Utilisateur u = null;

		@SuppressWarnings("rawtypes")
		List result = query.list();

		if(result.size() == 1)
		{
			System.out.println(result.size() + " utilisateur ok ");
			u = (Utilisateur) result.get(0);
			System.out.println(u);
		}
		else
			System.out.println("Inconnu");

			
		
		session.close();
		return u;		
	}
	
	public int findID(String login, String password) {
		session = DBConnection.getSession();

		Query query = session.createQuery("from Utilisateur where login = :login and password = :password");
		query.setString("login", login);
		query.setString("password", password);
		Utilisateur u = null;
		int id=0;

		@SuppressWarnings("rawtypes")
		List result = query.list();

		if(result.size() == 1)
		{
			System.out.println(result.size() + " Utilisateur ok");
			u = (Utilisateur) result.get(0);
			id=u.getId_utilisteur();
			System.out.println(id);

			//System.out.println(" test"+u);
			System.out.println(id);

		}
		else
			System.out.println("inconnu");

			
		
		session.close();
		
		return id;
	}
	
	


}
