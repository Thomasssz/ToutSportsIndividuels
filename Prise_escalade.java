package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Prise_escalade {
	@Id
	@GeneratedValue
	private int id_prise;
	
	private int block;
	private int prisesMin;
	private int prises;
	
	public Prise_escalade() {
	}
	public Prise_escalade(int block, int prisesMin, int prises) {
		this.block = block;
		this.prisesMin = prisesMin;
		this.prises = prises;
	}
	public int getId_prise() {
		return id_prise;
	}
	public void setId_prise(int id_prise) {
		this.id_prise = id_prise;
	}
	public int getPrisesMin() {
		return prisesMin;
	}
	public void setPrisesMin(int prisesMin) {
		this.prisesMin = prisesMin;
	}
	public int getPrises() {
		return prises;
	}
	public void setPrises(int prises) {
		this.prises = prises;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	@Override
	public String toString() {
		return "Prise_escalade [id_prise=" + id_prise + ", block=" + block + ", prisesMin=" + prisesMin + ", prises=" + prises + "]";
	}
	


}
