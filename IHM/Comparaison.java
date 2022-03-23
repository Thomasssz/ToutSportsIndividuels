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
	private JLabel labelAmi = new JLabel("Le graph de mon ami");
	private JPanel persoParameter = new JPanel();
	private JPanel amiParameter = new JPanel();
	
	  private Color background = new Color(63, 149, 245);
	  private int width = 1000;
	  private int height = 800;
	  
	  private int id_utilisateur;
	  private int id_ami;

	  private JFrame frame;
	  
	  public Comparaison(int id_utilisateur) {
		  super();
			frame=this;
			
			this.id_utilisateur = id_utilisateur;
			this.id_ami = id_ami;
			frame.setTitle("Sport2-Comparaison");
			frame.setSize(width, height);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		 
	  }
	  
	  private void displayComparaison(){
		  displayPerso =  new JPanel();
		  displayPerso.setBackground(background);
		  displayPerso.setPreferredSize(new Dimension(480,700));
		  displayPerso.setLayout(new FlowLayout());
		  
		  graphPerso = new JPanel();
		  graphPerso.setBackground(background);
		  graphPerso.setPreferredSize(new Dimension(430,600));
		  persoParameter = new Vitesse_courseIhm(id_utilisateur, displayPerso);
		  
		  displayAmi =  new JPanel();
		  displayAmi.setBackground(background);
		  displayAmi.setPreferredSize(new Dimension(480,700));
		  displayAmi.setLayout(new FlowLayout());
		  
		  graphAmi = new JPanel();
		  graphAmi.setBackground(background);
		  graphAmi.setPreferredSize(new Dimension(430,600));
		  amiParameter = new Vitesse_courseIhm(id_ami, displayAmi);
		  	
		  displayPerso.add(labelPerso, BorderLayout.CENTER);
		  displayPerso.add(graphPerso,BorderLayout.CENTER);
		  
		  displayAmi.add(labelAmi, BorderLayout.CENTER);
		  displayAmi.add(graphAmi,BorderLayout.CENTER);
		  
		  container.add(displayPerso, BorderLayout.WEST);
		  container.add(displayAmi, BorderLayout.EAST);
	  }

	public static void main(String[] args) {
		new Comparaison(1);

	}

}
