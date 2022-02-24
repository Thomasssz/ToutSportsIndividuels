package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Kilometre_course {
	@Id
	@GeneratedValue
	private int id_kilometre;
	
	private float kilometre;
	private int jour;
	
	public Kilometre_course() {
	}
	public Kilometre_course(float kilometre, int jour) {
		
		this.kilometre = kilometre;
		this.jour = jour;
	}
	public Kilometre_course(float kilometre) {
		this.kilometre = kilometre;
	}
	public int getId_kilometre() {
		return id_kilometre;
	}
	public void setId_kilometre(int id_kilometre) {
		this.id_kilometre = id_kilometre;
	}
	public float getKilometre() {
		return kilometre;
	}
	public void setKilometre(float kilometre) {
		this.kilometre = kilometre;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	@Override
	public String toString() {
		return "Kilometre_course [id_kilometre=" + id_kilometre + ", kilometre=" + kilometre + ", jour=" + jour + "]";
	}
	
	
	

}
