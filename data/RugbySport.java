package data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class RugbySport extends Sport{
	
	private String type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Statistique_Rugby.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Statistique_Rugby> statistique_rugby;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Penalite_Rugby.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Penalite_Rugby> penalite_rugby;

	public RugbySport() {
	}


	public RugbySport(Date date, String type) {
		super(date);
		this.type = type;
		this.statistique_rugby = new ArrayList<Statistique_Rugby>();
		this.penalite_rugby = new ArrayList<Penalite_Rugby>();


	}

	
	public void addStatistique(Statistique_Rugby s) {
		statistique_rugby.add(s);
	}
	
	public void addPenalite(Penalite_Rugby p) {
		penalite_rugby.add(p);
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Statistique_Rugby> getStatistique_rugby() {
		return statistique_rugby;
	}
	
	


	public List<Penalite_Rugby> getPenalite_rugby() {
		return penalite_rugby;
	}


	public void setPenalite_rugby(List<Penalite_Rugby> penalite_rugby) {
		this.penalite_rugby = penalite_rugby;
	}


	public void setStatistique_rugby(List<Statistique_Rugby> statistique_rugby) {
		this.statistique_rugby = statistique_rugby;
	}


	@Override
	public String toString() {
		return "RugbySport [type=" + type + ", statistique_rugby=" + statistique_rugby + "]";
	}
	
	
	

	
	
	
	

}
