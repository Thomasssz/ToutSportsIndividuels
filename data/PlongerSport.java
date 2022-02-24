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

public class PlongerSport extends Sport {
	
	private String type;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Profondeur_plonger.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Profondeur_plonger> profondeur_plonger;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Oxygene_plonger.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Oxygene_plonger> oxyegene_plonger;

	public PlongerSport() {
		super();
	}

	public PlongerSport(Date date,String type) {
		super(date);
		this.type = type;
		this.profondeur_plonger = new ArrayList<Profondeur_plonger>();
		this.oxyegene_plonger = new ArrayList<Oxygene_plonger>();

	}
	
	public void addProfondeur(Profondeur_plonger p) {
		profondeur_plonger.add(p);
	}
	
	public void addProfondeur(Oxygene_plonger o) {
		oxyegene_plonger.add(o);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Profondeur_plonger> getProfondeur_plonger() {
		return profondeur_plonger;
	}

	public void setProfondeur_plonger(List<Profondeur_plonger> profondeur_plonger) {
		this.profondeur_plonger = profondeur_plonger;
	}
	
	

	public List<Oxygene_plonger> getOxyegene_plonger() {
		return oxyegene_plonger;
	}

	public void setOxyegene_plonger(List<Oxygene_plonger> oxyegene_plonger) {
		this.oxyegene_plonger = oxyegene_plonger;
	}

	@Override
	public String toString() {
		return "PlongerSport [type=" + type + ", profondeur_plonger=" + profondeur_plonger + ", oxyegene_plonger="
				+ oxyegene_plonger + "]";
	}

	
	
	
	
	
	

}
