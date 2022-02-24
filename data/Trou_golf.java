package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity

public class Trou_golf {
	@Id
	@GeneratedValue
	private int id_trou;
	
	private String nom_parcours;
	private int nombre_coup;
	private int nombre_coup_effectuer;
	
	public Trou_golf() {
	}
	
	

	public Trou_golf(String nom_parcours, int nombre_coup, int nombre_coup_effectuer) {
		this.nom_parcours = nom_parcours;
		this.nombre_coup = nombre_coup;
		this.nombre_coup_effectuer = nombre_coup_effectuer;
	}
	


	public int getId() {
		return id_trou;
	}

	public String getNom_parcours() {
		return nom_parcours;
	}

	public void setNom_parcours(String nom_parcours) {
		this.nom_parcours = nom_parcours;
	}

	public int getNombre_coup() {
		return nombre_coup;
	}

	public void setNombre_coup(int nombre_coup) {
		this.nombre_coup = nombre_coup;
	}



	public int getNombre_coup_effectuer() {
		return nombre_coup_effectuer;
	}



	public void setNombre_coup_effectuer(int nombre_coup_effectuer) {
		this.nombre_coup_effectuer = nombre_coup_effectuer;
	}



	@Override
	public String toString() {
		return "Trou_golf [id_trou=" + id_trou + ", nom_parcours=" + nom_parcours + ", nombre_coup=" + nombre_coup
				+ ", nombre_coup_effectuer=" + nombre_coup_effectuer + "]";
	}

	
	
	

}
