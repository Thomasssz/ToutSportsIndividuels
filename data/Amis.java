package data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Amis {
	@Id
	@GeneratedValue
	private int id_amis;
	
	@ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	private Utilisateur amis;

	@ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	private Utilisateur utilisateur;

	private int accepter;
	
	public Amis() {
	}

	public Amis(Utilisateur amis, Utilisateur utilisateur) {
		this.amis = amis;
		this.utilisateur = utilisateur;
	}

	public int getId_amis() {
		return id_amis;
	}

	public void setId_amis(int id_amis) {
		this.id_amis = id_amis;
	}

	public Utilisateur getAmis() {
		return amis;
	}

	public void setAmis(Utilisateur amis) {
		this.amis = amis;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

	public int getAccepter() {
		return accepter;
	}

	public void setAccepter(int accepter) {
		this.accepter = accepter;
	}

	@Override
	public String toString() {
		return "Amis [id_amis=" + id_amis + ", amis=" + amis + ", utilisateur=" + utilisateur + "]";
	}
	
	
	
}
