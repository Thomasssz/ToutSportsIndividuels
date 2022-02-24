package IHM;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.ui.RefineryUtilities;

import graph.GraphGolfPoint;
import graph.GraphPlongerAreaLine;
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

public class OxygeneIhm extends JFrame {
  private JPanel container = new JPanel();
  private JTextField consommation_oxygene = new JTextField();
  private JLabel labelConsommation = new JLabel("Consommation : ");
  private JTextField profondeur = new JTextField();
  private JLabel labelProfondeur = new JLabel("profondeur : ");
  private int user;

  public OxygeneIhm(int user){
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
    consommation_oxygene.setFont(police);
    consommation_oxygene.setPreferredSize(new Dimension(150, 30));
    profondeur.setFont(police);
    profondeur.setPreferredSize(new Dimension(150, 30));
  
    top.add(labelConsommation);
    top.add(consommation_oxygene);
    
    bottom.add(labelProfondeur);
    bottom.add(profondeur);
    
    
    JButton graphiqueButton = new JButton("graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if (consommation_oxygene.getText().isEmpty() && profondeur.getText().isEmpty() ) {
   				
   			}
   			else {
   		        float fConsommation = Float.valueOf(consommation_oxygene.getText());
   		        float fProfondeur = Float.valueOf(profondeur.getText());
   				InsertPlonger insert = new InsertPlonger(fConsommation, fProfondeur,user);
   				insert.insertPlonger_oxygene(fConsommation, fProfondeur,user);
   				
   				SwingUtilities.invokeLater(() -> {
   			      GraphPlongerAreaLine example = new GraphPlongerAreaLine("Area Chart Example | BORAJI.COM",user);
   			      example.setSize(800, 400);
   			      example.setLocationRelativeTo(null);
   			      example.setVisible(true);
   			    });
   			  
   				
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