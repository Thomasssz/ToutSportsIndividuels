package data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity

public class EscaladeSport extends Sport{

	private String type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Cotation_escalade.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Cotation_escalade> cotation_escalade;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Prise_escalade.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Prise_escalade> prise_escalade;

	public EscaladeSport() {
	}

	public EscaladeSport(Date date,String type ) {
		super(date);
		this.type = type;
		this.cotation_escalade = new ArrayList<>();
		this.prise_escalade = new ArrayList<>();
	}
	public void addCotation_escalade(Cotation_escalade c) {
		cotation_escalade.add(c);
	}

	public void addPrise_escalade(Prise_escalade p) {
		prise_escalade.add(p);
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Cotation_escalade> getCotation_escalade() {
		return cotation_escalade;
	}

	public void setCotation_escalade(List<Cotation_escalade> cotation_escalade) {
		this.cotation_escalade = cotation_escalade;
	}

	public List<Prise_escalade> getPrise_escalade() {
		return prise_escalade;
	}

	public void setPrise_escalade(List<Prise_escalade> prise_escalade) {
		this.prise_escalade = prise_escalade;
	}

	@Override
	public String toString() {
		return "EscaladeSport [type=" + type + ", cotation_escalade=" + cotation_escalade + ", prise_escalade="
				+ prise_escalade + "]";
	}






}
