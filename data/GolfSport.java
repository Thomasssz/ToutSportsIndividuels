package data;


import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class GolfSport extends Sport{
	
	private String type;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Trou_golf.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Trou_golf> trou_golf;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Vitesse_golf.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Vitesse_golf> vitesse_golf;
	


	public GolfSport() {
		
	}
	public GolfSport(Date date, int temps,String type) {
		super(date, temps);
		this.type = type;
		this.trou_golf = new ArrayList<Trou_golf>();
		this.vitesse_golf = new ArrayList<Vitesse_golf>();
	}
	
	public void addTrou_golf(Trou_golf t) {
		trou_golf.add(t);
	}
	
	public void addVitesse_golf( Vitesse_golf v) {
		vitesse_golf.add(v);
	}
	
	
	
	
	public List<Trou_golf> getTrou_golf() {
		return trou_golf;
	}
	
	public List<Vitesse_golf> getVitesse_golf(){
		return vitesse_golf;
	}
	
	@Override
	public String toString() {
		return "GolfSport " + "date : " + super.getDate() + " temps :" + super.getTemps() 
		+ " utilisateur : " + super.getUtilisateur() + " trou_golf: "+ trou_golf  + " vitesse_golf: "+vitesse_golf;
	}
	
	
	
	
	

	
	
	
	
}
