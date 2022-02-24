package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Penalite_Rugby {
	@Id
	@GeneratedValue
	private int id_penalite;
	
	private int penalite_tenter;
	private int distance;
	private int reussi;
	private int echec;
	
	
	
	public Penalite_Rugby() {
	}



	public Penalite_Rugby(int penalite_tenter, int distance, int reussi, int echec) {
		this.penalite_tenter = penalite_tenter;
		this.distance = distance;
		this.reussi = reussi;
		this.echec = echec;
	}



	public int getId_penalite() {
		return id_penalite;
	}



	public void setId_penalite(int id_penalite) {
		this.id_penalite = id_penalite;
	}



	public int getPenalite_tenter() {
		return penalite_tenter;
	}



	public void setPenalite_tenter(int penalite_tenter) {
		this.penalite_tenter = penalite_tenter;
	}



	public int getDistance() {
		return distance;
	}



	public void setDistance(int distance) {
		this.distance = distance;
	}



	public int getReussi() {
		return reussi;
	}



	public void setReussi(int reussi) {
		this.reussi = reussi;
	}



	public int getEchec() {
		return echec;
	}



	public void setEchec(int echec) {
		this.echec = echec;
	}



	@Override
	public String toString() {
		return "Penalite_Rugby [id_penalite=" + id_penalite + ", penalite_tenter=" + penalite_tenter + ", distance="
				+ distance + ", reussi=" + reussi + ", echec=" + echec + "]";
	}
	
	
	
	
	
}