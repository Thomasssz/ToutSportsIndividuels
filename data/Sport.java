package data;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Sport {
	
		@TableGenerator(name = "workoutGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "WORKOUT_ID", allocationSize = 1)
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE, generator="workoutGen")
		private int id_Sport;
		private Date date;
		private int temps;
		
		@ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
		private Utilisateur utilisateur;
		
		

		public Sport() {
		}
		

		public Sport(Date date) {
			this.date = date;
		}


		public Sport(Date date, int temps) {
			this.date = date;
			this.temps = temps;
		}

		public int getId_Sport() {
			return id_Sport;
		}

		public void setId_Sport(int id_Sport) {
			this.id_Sport = id_Sport;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getTemps() {
			return temps;
		}

		public void setTemps(int temps) {
			this.temps = temps;
		}

		public Utilisateur getUtilisateur() {
			return utilisateur;
		}

		public void setUtilisateur(Utilisateur utilisateur) {
			this.utilisateur = utilisateur;
		}

		@Override
		public String toString() {
			return "Sport [id_Sport=" + id_Sport + ", date=" + date + ", temps=" + temps + ", utilisateur="
					+ utilisateur + "]";
		}
		
		
}
