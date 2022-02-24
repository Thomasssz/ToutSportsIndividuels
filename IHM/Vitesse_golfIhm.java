package IHM;

import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import graph.GraphGolfPoint;
import requete.InsertGolf;

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

public class Vitesse_golfIhm extends JFrame {
  private JPanel container = new JPanel();
  private JTextField vitesse = new JTextField();
  private JLabel labelVitesse = new JLabel("Vitesse : ");
  private JTextField distance = new JTextField();
  private JLabel labelDistance = new JLabel("Distance : ");
  private int id_utilisateur;

  public Vitesse_golfIhm(int id_utilisateur){
	this.id_utilisateur = id_utilisateur;
    this.setTitle("Animation");
    this.setSize(300, 300);
   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    Font police = new Font("Arial", Font.BOLD, 14);
    vitesse.setFont(police);
    vitesse.setPreferredSize(new Dimension(150, 30));
    distance.setFont(police);
    distance.setPreferredSize(new Dimension(150, 30));
  
    top.add(labelVitesse);
    top.add(vitesse);
    
    bottom.add(labelDistance);
    bottom.add(distance);
    
    
    JButton graphiqueButton = new JButton("graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if (vitesse.getText().isEmpty() && distance.getText().isEmpty() ) {
   				
   			}
   			else {
   		        float fvitesse = Float.valueOf(vitesse.getText());
   		        float fdistance = Float.valueOf(distance.getText());
   				InsertGolf insert = new InsertGolf(fvitesse, fdistance,id_utilisateur);
   				insert.insertGolf_vitesse(fvitesse, fdistance,id_utilisateur);
   				GraphGolfPoint scatterplotdemo4 = new GraphGolfPoint("Vitesse / Distance",id_utilisateur);
   				scatterplotdemo4.pack();
   				RefineryUtilities.centerFrameOnScreen(scatterplotdemo4);
   				scatterplotdemo4.setVisible(true);
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