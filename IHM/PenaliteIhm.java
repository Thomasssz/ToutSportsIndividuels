package IHM;

import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;
import org.primefaces.util.GridLayoutUtils;

import graph.GraphGolfBar;
import graph.GraphGolfPoint;
import graph.GraphRugbyLine;
import graph.GraphRugbyPie;
import requete.InsertGolf;
import requete.InsertRugby;

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
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PenaliteIhm extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user; 

private JPanel container = new JPanel();
  
  private JTextField penalite_tenter = new JTextField();
  private JLabel labelPenalite_tenter = new JLabel("Penalité tenté : ");
  
  private JTextField distance = new JTextField();
  private JLabel labelDistance = new JLabel("Distance : ");
  
  private JTextField reussi = new JTextField();
  private JLabel labelReussi = new JLabel("Réussi : ");
  
  private JTextField echec = new JTextField();
  private JLabel labelEchec = new JLabel("Echec : ");
  
  private  GridLayout  grid = new GridLayout(5, 0);

  public PenaliteIhm(int user){
	  
	this.user = user;
	  
    this.setTitle("Animation");
    this.setSize(300, 300);
   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(grid);
    
  
    
    
    
    Font police = new Font("Arial", Font.BOLD, 14);
    
    penalite_tenter.setFont(police);
    penalite_tenter.setPreferredSize(new Dimension(150, 30));
    
    distance.setFont(police);
    penalite_tenter.setPreferredSize(new Dimension(150, 30));
    
    reussi.setFont(police);
    reussi.setPreferredSize(new Dimension(150, 30));
    
    echec.setFont(police);
    echec.setPreferredSize(new Dimension(150, 30));
  
    container.add(labelPenalite_tenter);
    container.add(penalite_tenter);
    
    container.add(labelDistance);
    container.add(distance);
    
    container.add(labelReussi);
    container.add(reussi);
    
    container.add(labelEchec);
    container.add(echec);
    
    
    
    
    JButton graphiqueButton = new JButton("graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if (penalite_tenter.getText().isEmpty() && distance.getText().isEmpty() && reussi.getText().isEmpty() && echec.getText().isEmpty() ) {
   				
   			}
   			else {
   				int iPenalite_tenter = Integer.parseInt(penalite_tenter.getText());
   		        int iDistance = Integer.parseInt(distance.getText());
   		        int iReussi = Integer.parseInt(reussi.getText());
   		        int iEchec = Integer.parseInt(echec.getText());
   		  
   				InsertRugby insert = new InsertRugby(iPenalite_tenter, iDistance, iReussi, iEchec,user);
   				insert.insertRugby_penalite(iPenalite_tenter, iDistance, iReussi, iEchec,user);
   				
   				GraphRugbyLine demo = new GraphRugbyLine("Penalité",user);
   				demo.pack();
   				RefineryUtilities.centerFrameOnScreen(demo);
   				demo.setVisible(true);
   				
   				
   			}
   			
   			
   			
   		}
   	});
   	container.add(graphiqueButton);
  /*  container.add(pannelSaison);
    container.add(pannelMatch );
    container.add(pannelEssai );
    container.add(pannelPlaquage );*/


    this.setContentPane(container);
    this.setVisible(true);          
  }
  
 /* public static void main (String [] args) {
	  
	  new PenaliteIhm();
  }*/
}