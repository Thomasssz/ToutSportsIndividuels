package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Profondeur_plonger {

	@Id
	@GeneratedValue
	private int id_profondeur;
	
	private int profondeur;
	private float temps;
	
	public Profondeur_plonger() {
	}
	public Profondeur_plonger(int profondeur, float temps) {
		this.profondeur = profondeur;
		this.temps = temps;
	}
	public int getId_profondeur() {
		return id_profondeur;
	}
	public void setId_profondeur(int id_profondeur) {
		this.id_profondeur = id_profondeur;
	}
	public int getProfondeur() {
		return profondeur;
	}
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
	public float getTemps() {
		return temps;
	}
	public void setTemps(float temps) {
		this.temps = temps;
	}
	@Override
	public String toString() {
		return "Profondeur_plonger [id_profondeur=" + id_profondeur + ", profondeur=" + profondeur + ", temps=" + temps
				+ "]";
	}
	
	
	
	
}
