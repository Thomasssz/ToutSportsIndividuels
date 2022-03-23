package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import graph.GraphCourseLine;
import graph.GraphRugbyPie;
import requete.InsertCourse;

public class Vitesse_courseIhm extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3143340476719077115L;
	private JPanel vitesse_moyenneP = new JPanel();
	private JTextField vitesse_moyenne = new JTextField(11);
	private JLabel labelVitesse = new JLabel("Vitesse moyenne : ");

	private JPanel buttonsP = new JPanel();
	private JButton graphiqueButton;

	private Color background = new Color(63, 149, 245);
	private int id_utilisateur;

	public Vitesse_courseIhm(int id_utilisateur, JPanel simulationdisplay){
		super();
		this.id_utilisateur = id_utilisateur;
		this.setPreferredSize(new Dimension(300, 350));
		this.setBackground(background);
		this.setLayout(new FlowLayout());
		
		Font police = new Font("Arial", Font.BOLD, 14);
		
		vitesse_moyenneP.setLayout(new BorderLayout());
		vitesse_moyenneP.setPreferredSize(new Dimension(300, 60));
		vitesse_moyenneP.setBackground(Color.white);
		vitesse_moyenneP.setBorder(BorderFactory.createLineBorder(background, 10));
			    
	    vitesse_moyenne.setFont(police);
	
	    vitesse_moyenneP.add(labelVitesse,BorderLayout.WEST);
	    vitesse_moyenneP.add(vitesse_moyenne,BorderLayout.EAST);

	    GraphCourseLine simu = new GraphCourseLine("Vitesse Moyenne",id_utilisateur);
		simulationdisplay.removeAll();
		simulationdisplay.add(simu);
		simulationdisplay.updateUI();
		
	    graphiqueButton = new JButton("Graphique");
	   	graphiqueButton.addActionListener(new ActionListener() {
	   		@Override
			public void actionPerformed(ActionEvent e) {
	   			if (vitesse_moyenne.getText().isEmpty() /*&& profondeur.getText().isEmpty()*/ ) {
	
	   			}
	   			else {
	   		        float fVitesse = Float.valueOf(vitesse_moyenne.getText());
	   		       // float fProfondeur = Float.valueOf(profondeur.getText());
	   				InsertCourse insert = new InsertCourse(fVitesse,id_utilisateur);
	   				insert.insertCourse_vitesse(fVitesse, id_utilisateur);
	
	   				GraphCourseLine simu = new GraphCourseLine("Vitesse Moyenne",id_utilisateur);
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
		
		this.add(vitesse_moyenneP );
		this.add(buttonsP);
	}
}
