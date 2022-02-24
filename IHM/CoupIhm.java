package IHM;

import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import graph.GraphGolfBar;
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
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CoupIhm extends JFrame {
  private JPanel container = new JPanel();
  private JTextField parcours = new JTextField();
  private JLabel labelParcours = new JLabel("Parcours : ");
  private JTextField coup_effectuer = new JTextField();
  private JLabel labelCoupEffectuer = new JLabel("coup effectué : ");
  private int user;

  public CoupIhm(int user){
	  this.user = user;
    this.setTitle("Animation");
    this.setSize(300, 300);
 //   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();
    Font police = new Font("Arial", Font.BOLD, 14);
    parcours.setFont(police);
    parcours.setPreferredSize(new Dimension(150, 30));
    coup_effectuer.setFont(police);
    coup_effectuer.setPreferredSize(new Dimension(150, 30));
  
    top.add(labelParcours);
    top.add(parcours);
    
    bottom.add(labelCoupEffectuer);
    bottom.add(coup_effectuer);
    
    
    JButton graphiqueButton = new JButton("graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if (parcours.getText().isEmpty() && coup_effectuer.getText().isEmpty() ) {
   				
   			}
   			else {
   				String sParcours = parcours.getText();
   		        int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   				InsertGolf insert = new InsertGolf(sParcours, iCoup_effectuer,user);
   				insert.insertGolf_coup(sParcours, iCoup_effectuer,user);
   				GraphGolfBar demo = new GraphGolfBar("Golf",user);
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