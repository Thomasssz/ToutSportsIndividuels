package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Statistique_Rugby {
	@Id
	@GeneratedValue
	private int id_statistique;
	
	private String saison;
	private int nombre_match;
	private int essai;
	private int plaquage;
	
	public Statistique_Rugby() {
	}

	public Statistique_Rugby(String saison, int nombre_match, int essai, int plaquage) {
		this.saison = saison;
		this.nombre_match = nombre_match;
		this.essai = essai;
		this.plaquage = plaquage;
	}

	public int getId_statistique() {
		return id_statistique;
	}

	public void setId_statistique(int id_statistique) {
		this.id_statistique = id_statistique;
	}

	public String getSaison() {
		return saison;
	}

	public void setSaison(String saison) {
		this.saison = saison;
	}

	public int getNombre_match() {
		return nombre_match;
	}

	public void setNombre_match(int nombre_match) {
		this.nombre_match = nombre_match;
	}

	public int getEssai() {
		return essai;
	}

	public void setEssai(int essai) {
		this.essai = essai;
	}

	public int getPlaquage() {
		return plaquage;
	}

	public void setPlaquage(int plaquage) {
		this.plaquage = plaquage;
	}

	@Override
	public String toString() {
		return "Statistique_Rugby [id_statistique=" + id_statistique + ", saison=" + saison + ", nombre_match="
				+ nombre_match + ", essai=" + essai + ", plaquage=" + plaquage + "]";
	}
	
	
	
	
	
	

}
