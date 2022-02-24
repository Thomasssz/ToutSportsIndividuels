package IHM;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.ui.RefineryUtilities;

import graph.GraphCourseBar;
import graph.GraphCourseLine;
import graph.GraphGolfPoint;
import graph.GraphPlongerAreaLine;
import requete.InsertCourse;
import requete.InsertGolf;
import requete.InsertPlonger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class KilometreIhm extends JFrame {
  private JPanel container = new JPanel();
  private JTextField kilometre = new JTextField();
  private JLabel labelKilometre = new JLabel("Kilometre parcouru  : ");
 /* private JTextField profondeur = new JTextField();
  private JLabel labelProfondeur = new JLabel("profondeur : ");*/
  private int user;

  public KilometreIhm(int user){
	  this.user = user;
    this.setTitle("Animation");
    this.setSize(300, 300);
   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    Font police = new Font("Arial", Font.BOLD, 14);
    kilometre.setFont(police);
    kilometre.setPreferredSize(new Dimension(150, 30));
   /* profondeur.setFont(police);
    profondeur.setPreferredSize(new Dimension(150, 30));*/
  
    top.add(labelKilometre);
    top.add(kilometre);
    
   // bottom.add(labelProfondeur);
    //bottom.add(profondeur);
    
    
    JButton graphiqueButton = new JButton("graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if (kilometre.getText().isEmpty() /*&& profondeur.getText().isEmpty()*/ ) {
   				
   			}
   			else {
   		        float fKilometre = Float.valueOf(kilometre.getText());
   		       // float fProfondeur = Float.valueOf(profondeur.getText());
   				InsertCourse insert = new InsertCourse(fKilometre,user);
   				insert.insertCourse_kilometre(fKilometre, user);
   				
   				GraphCourseBar demo = new GraphCourseBar("Course",user);
   				demo.pack();
   				RefineryUtilities.centerFrameOnScreen(demo);
   				demo.setVisible(true);
   				
   				
   				
   			}
   			
   			
   			
   		}
   	});
   	bottom.add(graphiqueButton);
    container.add(top, BorderLayout.NORTH);
    container.add(bottom );

    this.setContentPane(container);
    this.setVisible(true);            
  }

}
