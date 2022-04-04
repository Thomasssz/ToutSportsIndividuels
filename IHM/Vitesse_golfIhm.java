package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import data.Amis;
import graph.GraphGolfPoint;
import requete.GestionAmis;
import requete.InsertGolf;

public class Vitesse_golfIhm extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 8380586453862052273L;
	private JPanel vitesseP = new JPanel();
	private JTextField vitesse = new JTextField(14);
	private JLabel labelVitesse = new JLabel("Vitesse : ");
  
	private JPanel distanceP = new JPanel();
	private JTextField distance = new JTextField(14);
	private JLabel labelDistance = new JLabel("Distance : ");
  
	private JPanel buttonsP = new JPanel();
	private JButton graphiqueButton;
  
	
	private Color background = new Color(63, 149, 245);
	private int id_utilisateur;

	public Vitesse_golfIhm(int id_utilisateur, JPanel simulationdisplay){
		super();
		this.id_utilisateur = id_utilisateur;
	    this.setPreferredSize(new Dimension(300, 350));
	    this.setBackground(background);
	    this.setLayout(new FlowLayout());
	    
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    vitesseP.setLayout(new BorderLayout());
	    vitesseP.setPreferredSize(new Dimension(300, 60));
	    vitesseP.setBackground(Color.white);
	    vitesseP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    distanceP.setLayout(new BorderLayout());
	    distanceP.setPreferredSize(new Dimension(300, 60));
	    distanceP.setBackground(Color.white);
	    distanceP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    vitesse.setFont(police);
	    distance.setFont(police);
	
	    vitesseP.add(labelVitesse,BorderLayout.WEST);
	    vitesseP.add(vitesse,BorderLayout.EAST);
	
	    distanceP.add(labelDistance,BorderLayout.WEST);
	    distanceP.add(distance,BorderLayout.EAST);
	 
	    GraphGolfPoint simu = new GraphGolfPoint("Vitesse / Distance",id_utilisateur);
		simulationdisplay.removeAll();
		simulationdisplay.add(simu);
		simulationdisplay.updateUI();
	  
	    graphiqueButton = new JButton("Graphique");
	   	graphiqueButton.addActionListener(new ActionListener() {
	   		@Override
			public void actionPerformed(ActionEvent e) {
	   			if (vitesse.getText().isEmpty() && distance.getText().isEmpty() ) {
	
	   			}
	   			else {
	   		        float fvitesse = Float.valueOf(vitesse.getText());
	   		        float fdistance = Float.valueOf(distance.getText());
	   				InsertGolf insert = new InsertGolf(fvitesse, fdistance,id_utilisateur);
	   				insert.insertGolf_vitesse(fvitesse, fdistance,id_utilisateur);
	   				GraphGolfPoint simu = new GraphGolfPoint("Vitesse / Distance",id_utilisateur);
	   				simulationdisplay.removeAll();
	   				simulationdisplay.add(simu);
	   				simulationdisplay.updateUI();
	   			}
	   		}
	   	});   
	   	graphiqueButton.setBackground(Color.WHITE);
	    graphiqueButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
	    
	    buttonsP.setPreferredSize(new Dimension(300,80));
	    buttonsP.setLayout(new FlowLayout(10, 100, 20));
	    buttonsP.setBackground(background);
	   	buttonsP.add(graphiqueButton);
	   	
	   	this.add(vitesseP);
	   	this.add(distanceP);
	   	this.add(buttonsP);
	   	
	   	PanelComparaison comp = new PanelComparaison(id_utilisateur);
	   
	   	this.add(comp.panelComparaison());
	}
	
	
}