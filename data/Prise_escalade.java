package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Prise_escalade {
	@Id
	@GeneratedValue
	private int id_kilometre;
	
	private float kilometre;
	private int jour;
	
	
	public Prise_escalade() {
	}
	
	
	
	
	//a definir
}
