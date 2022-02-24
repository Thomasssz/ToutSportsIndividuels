package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Cotation_escalade {
	@Id
	@GeneratedValue
	private int id_Cotation;
	
	private float kilometre;
	private int jour;
	
	
	public Cotation_escalade() {
	}
	
	
	
	//a definir 
}
