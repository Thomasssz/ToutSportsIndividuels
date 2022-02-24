package data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity

public class Vitesse_golf {

	@Id
	@GeneratedValue
	private int id_vitesse;
	
	private float distance;
	private float vitesse;
	
	
	
	public Vitesse_golf() {
	}

	public Vitesse_golf(float distance, float vitesse) {
		this.distance = distance;
		this.vitesse = vitesse;
	}

	public int getId_vitesse() {
		return id_vitesse;
	}

	public void setId_vitesse(int id_vitesse) {
		this.id_vitesse = id_vitesse;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	@Override
	public String toString() {
		return "Vitesse_Golf [id_vitesse=" + id_vitesse + ", distance=" + distance + ", vitesse=" + vitesse + "]";
	} 
	
	
	
	
}
