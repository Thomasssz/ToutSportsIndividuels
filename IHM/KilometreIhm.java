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

import graph.GraphCourseBar;
import graph.GraphGolfPoint;
import requete.InsertCourse;

public class KilometreIhm extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = -464910037926291144L;
	private JPanel kilometreP = new JPanel();
	private JTextField kilometre = new JTextField(10);
	private JLabel labelKilometre = new JLabel("Kilometre parcouru : ");	

	private JPanel buttonsP = new JPanel();
	private JButton graphiqueButton;
  
	private Color background = new Color(63, 149, 245);
	private int id_utilisateur;

	public KilometreIhm(int id_utilisateur, JPanel simulationdisplay){
		super();
		this.id_utilisateur = id_utilisateur;
		this.setPreferredSize(new Dimension(300, 350));
		this.setBackground(background);
		this.setLayout(new FlowLayout());
		
		Font police = new Font("Arial", Font.BOLD, 14);
		    
	    kilometreP.setLayout(new BorderLayout());
	    kilometreP.setPreferredSize(new Dimension(300, 60));
	    kilometreP.setBackground(Color.white);
	    kilometreP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    kilometre.setFont(police);
	   
	    kilometreP.add(labelKilometre,BorderLayout.WEST);
	    kilometreP.add(kilometre,BorderLayout.EAST);
	    
	    GraphCourseBar simu = new GraphCourseBar("Course",id_utilisateur);
		simulationdisplay.removeAll();
		simulationdisplay.add(simu);
		simulationdisplay.updateUI();
		
		graphiqueButton = new JButton("Graphique");
		graphiqueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (kilometre.getText().isEmpty() /*&& profondeur.getText().isEmpty()*/ ) {
		
				}
				else {
			        float fKilometre = Float.valueOf(kilometre.getText());
			       // float fProfondeur = Float.valueOf(profondeur.getText());
					InsertCourse insert = new InsertCourse(fKilometre,id_utilisateur);
					insert.insertCourse_kilometre(fKilometre, id_utilisateur);
		
					GraphCourseBar simu = new GraphCourseBar("Course",id_utilisateur);
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
		
		this.add(kilometreP );
		this.add(buttonsP);
	}
}