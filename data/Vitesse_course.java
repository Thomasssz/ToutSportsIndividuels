package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Vitesse_course {
	@Id
	@GeneratedValue
	private int id_vitesse;
	
	private float vitesse_moyenne;
	private int nombre_course;
	
	public Vitesse_course() {
	}

	public Vitesse_course(float vitesse_moyenne) {
		this.vitesse_moyenne = vitesse_moyenne;
	}

	public Vitesse_course(float vitesse_moyenne, int nombre_course) {
		this.vitesse_moyenne = vitesse_moyenne;
		this.nombre_course = nombre_course;
	}

	public int getId_vitesse() {
		return id_vitesse;
	}

	public void setId_vitesse(int id_vitesse) {
		this.id_vitesse = id_vitesse;
	}

	public float getVitesse_moyenne() {
		return vitesse_moyenne;
	}

	public void setVitesse_moyenne(float vitesse_moyenne) {
		this.vitesse_moyenne = vitesse_moyenne;
	}

	public int getNombre_course() {
		return nombre_course;
	}

	public void setNombre_course(int nombre_course) {
		this.nombre_course = nombre_course;
	}

	@Override
	public String toString() {
		return "Vitesse_course [id_vitesse=" + id_vitesse + ", vitesse_moyenne=" + vitesse_moyenne + ", nombre_course="
				+ nombre_course + "]";
	}
	
	
	
	
	
}
