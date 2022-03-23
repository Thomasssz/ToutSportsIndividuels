package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Cotation_escalade {
	@Id
	@GeneratedValue
	private int id_Cotation;

	private String cotation;
	private int block;
	private int tentatives;


	public Cotation_escalade() {
	}
	public Cotation_escalade(String cotation, int block, int tentatives) {
		this.cotation = cotation;
		this.block = block;
		this.tentatives = tentatives;
	}
	public int getId_Cotation() {
		return id_Cotation;
	}
	public void setId_Cotation(int id_Cotation) {
		this.id_Cotation = id_Cotation;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getTentatives() {
		return tentatives;
	}
	public void setTentatives(int tentatives) {
		this.tentatives = tentatives;
	}
	@Override
	public String toString() {
		return "Cotation_escalade [id_Cotation=" + id_Cotation + ", cotation=" + cotation + ", block=" + block + ", tentatives=" + tentatives + "]";
	}


}
