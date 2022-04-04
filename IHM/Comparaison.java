package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Comparaison extends JFrame {
	private JPanel container, graphPerso, displayPerso, graphAmi, displayAmi;
	
	private JLabel labelPerso = new JLabel("Mon Graph");
	private JLabel labelAmi ;
	private JPanel persoParameter = new JPanel();
	private JPanel amiParameter = new JPanel();
	
	  private Color background = new Color(63, 149, 245);
	  private int width = 1380;
	  private int height = 800;
	  
	  private int id_utilisateur;
	  private int id_amis;
	  private String amis;
	  private String sport;

	  private JFrame frame;
	  
	  public Comparaison(int id_utilisateur,int id_amis,String sport,String amis) {
		  super();
			frame=this;
			
			this.id_utilisateur = id_utilisateur;
			this.id_amis = id_amis;
			this.sport = sport;
			this.amis = amis;
			frame.setTitle("Sport2-Comparaison");
			frame.setSize(width, height);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			
			//-------------- CONTENT PANE ------------------//
		    container = new JPanel();
		    container.setPreferredSize(new Dimension(width, height));
		    container.setBackground(background);
		    container.setLayout(new BorderLayout());
		    
		    //-------------- CONNECT PAGE ------------------//
		    displayComparaison();
		   
		    frame.setContentPane(container);
		    frame.setVisible(true);
			// System.out.println( amis);

	  }
	  
	  private void displayComparaison(){
		  displayPerso =  new JPanel();
		  displayPerso.setBackground(background);
		  displayPerso.setPreferredSize(new Dimension(690,700));
		  displayPerso.setLayout(new FlowLayout());
		  
		  graphPerso = new JPanel();
		  graphPerso.setBackground(background);
		  graphPerso.setPreferredSize(new Dimension(640,600));
		  
		  if (sport == "Vitesse_golfIhm") {
			  persoParameter = new Vitesse_golfIhm(id_utilisateur, displayPerso);
		  }
		  else if (sport == "CoupIhm") {
			  persoParameter = new CoupIhm(id_utilisateur, displayPerso);
		  }
		  else if (sport == "KilometreIhm") {
			  persoParameter = new KilometreIhm(id_utilisateur, displayPerso);
		  }
		  else if (sport == "Vitesse_courseIhm") {
			  persoParameter = new Vitesse_courseIhm(id_utilisateur, displayPerso);
		  }
		  else if (sport == "CotationIHM") {
			  persoParameter = new CotationIHM(id_utilisateur, displayPerso);
		  }
		  else if (sport == "PriseIHM") {
			  persoParameter = new PriseIHM(id_utilisateur, displayPerso);
		  }
		  else if (sport == "OxygeneIhm") {
			  persoParameter = new OxygeneIhm(id_utilisateur, displayPerso);
		  }
		  else if (sport == "ProfondeurIhm") {
			  persoParameter = new ProfondeurIhm(id_utilisateur, displayPerso);
		  }
		  else if (sport == "StatistiqueIhm") {
			  persoParameter = new StatistiqueIhm(id_utilisateur, displayPerso);
		  }
		  else if (sport == "PenaliteIhm") {
			  persoParameter = new PenaliteIhm(id_utilisateur, displayPerso);
		  }
		  
		 // persoParameter = new Vitesse_courseIhm(id_utilisateur, displayPerso);
		  
		  displayAmi =  new JPanel();
		  displayAmi.setBackground(background);
		  displayAmi.setPreferredSize(new Dimension(690,700));
		  displayAmi.setLayout(new FlowLayout());
		  
		  graphAmi = new JPanel();
		  graphAmi.setBackground(background);
		  graphAmi.setPreferredSize(new Dimension(640,600));
		  if (sport == "Vitesse_golfIhm") {
			  persoParameter = new Vitesse_golfIhm(id_amis, displayAmi);
		  }
		  else if (sport == "CoupIhm") {
			  persoParameter = new CoupIhm(id_amis, displayAmi);
		  }
		  else if (sport == "KilometreIhm") {
			  persoParameter = new KilometreIhm(id_amis, displayAmi);
		  }
		  else if (sport == "Vitesse_courseIhm") {
			  persoParameter = new Vitesse_courseIhm(id_amis, displayAmi);
		  }
		  else if (sport == "CotationIHM") {
			  persoParameter = new CotationIHM(id_amis, displayAmi);
		  }
		  else if (sport == "PriseIHM") {
			  persoParameter = new PriseIHM(id_amis, displayAmi);
		  }
		  else if (sport == "OxygeneIhm") {
			  persoParameter = new OxygeneIhm(id_amis, displayAmi);
		  }
		  else if (sport == "ProfondeurIhm") {
			  persoParameter = new ProfondeurIhm(id_amis, displayAmi);
		  }
		  else if (sport == "StatistiqueIhm") {
			  persoParameter = new StatistiqueIhm(id_amis, displayAmi);
		  }
		  else if (sport == "PenaliteIhm") {
			  persoParameter = new PenaliteIhm(id_amis, displayAmi);
		  }
		  
		   labelAmi = new JLabel("Le graph de "+amis);
		  	
		  displayPerso.add(labelPerso, BorderLayout.CENTER);
		  displayPerso.add(graphPerso,BorderLayout.CENTER);
		  
		  displayAmi.add(labelAmi, BorderLayout.CENTER);
		  displayAmi.add(graphAmi,BorderLayout.CENTER);
		  
		  container.add(displayPerso, BorderLayout.WEST);
		  container.add(displayAmi, BorderLayout.EAST);
	  }

	public static void main(String[] args) {
		new Comparaison(1,2,"Vitesse_golfIhm","yaya");

	}

}
