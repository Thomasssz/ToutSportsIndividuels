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

public class CourseSport extends Sport{
	private String type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Vitesse_course.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Vitesse_course> vitesse_course;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Kilometre_course.class)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Kilometre_course> kilometre_course;

	public CourseSport() {
	}
	
	public CourseSport(Date date, String type) {
		super(date);
		this.type = type;
		this.vitesse_course = new ArrayList<Vitesse_course>();
		this.kilometre_course = new ArrayList<Kilometre_course>();


	}
	
	public void addVitesse(Vitesse_course v) {
		vitesse_course.add(v);
	}
	
	public void addKilometre(Kilometre_course k) {
		kilometre_course.add(k);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Vitesse_course> getVitesse_course() {
		return vitesse_course;
	}

	public void setVitesse_course(List<Vitesse_course> vitesse_course) {
		this.vitesse_course = vitesse_course;
	}

	public List<Kilometre_course> getKilometre_course() {
		return kilometre_course;
	}

	public void setKilometre_course(List<Kilometre_course> kilometre_course) {
		this.kilometre_course = kilometre_course;
	}

	@Override
	public String toString() {
		return "CourseSport [type=" + type + ", vitesse_course=" + vitesse_course + ", kilometre_course="
				+ kilometre_course + "]";
	}
	
	
	

}
