package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Oxygene_plonger {

	@Id
	@GeneratedValue
	private int id_oxygene;
	
	private float consomation; // en litre
	private float profondeur;
	
	public Oxygene_plonger() {
		
	}

	public Oxygene_plonger(float consomation, float profondeur) {
		this.consomation = consomation;
		this.profondeur = profondeur;
	}

	public int getId_oxygene() {
		return id_oxygene;
	}

	public void setId_oxygene(int id_oxygene) {
		this.id_oxygene = id_oxygene;
	}

	public float getConsomation() {
		return consomation;
	}

	public void setConsomation(float consomation) {
		this.consomation = consomation;
	}

	public float getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(float profondeur) {
		this.profondeur = profondeur;
	}

	@Override
	public String toString() {
		return "Oxygene_plonger [id_oxygene=" + id_oxygene + ", consomation=" + consomation + ", profondeur="
				+ profondeur + "]";
	}
	
	
	
	
	
	
}
