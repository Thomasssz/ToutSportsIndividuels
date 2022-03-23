package requete;

import java.sql.Date;

import javax.swing.JRadioButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.Cotation_escalade;
import data.EscaladeSport;
import data.Prise_escalade;
import data.Trou_golf;
import data.Utilisateur;

public class InsertEscalade {
	private String cotation;
	private int block;
	private int tentatives;
	
	private int prisesMin;
	private int prises;
	
	private int user;
	public InsertEscalade() {
	}
	public InsertEscalade(String cotation, int block, int tentatives, int user) {
		this.cotation = cotation;
		this.block = block;
		this.tentatives = tentatives;
		this.user = user;
	}
	public InsertEscalade(int prisesMin, int prises) {
		this.prisesMin = prisesMin;
		this.prises = prises;
	}
	
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getTentatives() {
		return tentatives;
	}
	public void setTentatives(int tentatives) {
		this.tentatives = tentatives;
	}
	public int getPrisesMin() {
		return prisesMin;
	}
	public void setPrisesMin(int prisesMin) {
		this.prisesMin = prisesMin;
	}
	public int getPrises() {
		return prises;
	}
	public void setPrises(int prises) {
		this.prises = prises;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	public void insertEscalade_cotation(String cotation, int block, int tentatives, int user) {
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();

		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(user);

		EscaladeSport g = new EscaladeSport (date,"cotation_escalade");
		g.setUtilisateur(utilisateur1);

		Cotation_escalade cotation_escalade = null;
		switch(cotation)
		{
			case "1-4c":
				cotation_escalade = new Cotation_escalade(cotation, block, tentatives);
				break;
			case "5a-5c":
				cotation_escalade = new Cotation_escalade(cotation, block, tentatives);
				break;
			case "6a-6c":
				cotation_escalade = new Cotation_escalade(cotation, block, tentatives);
				break;
			case "7a-7c":
				cotation_escalade = new Cotation_escalade(cotation, block, tentatives);
				break;
			case "8a-8c":
				cotation_escalade = new Cotation_escalade(cotation, block, tentatives);
				break;
			case "9a-9b+":
				cotation_escalade = new Cotation_escalade(cotation, block, tentatives);
				break;

		}
		g.addCotation_escalade(cotation_escalade);

		session.save(cotation_escalade);
		session.save(g);



		persistTransaction1.commit();
		session.close();
	}
	
	public void insertEscalade_prise(int prisesMin, int prises , int user) {
		Date date = new Date(2022, 05, 05);
		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();

		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setId_utilisateur(user);

		EscaladeSport g = new EscaladeSport (date,"prise_escalade");
		g.setUtilisateur(utilisateur1);

		Prise_escalade prise_escalade = new Prise_escalade(prisesMin, prises);
		g.addPrise_escalade(prise_escalade);

		session.save(prise_escalade);
		session.save(g);



		persistTransaction1.commit();
		session.close();
	}

}
