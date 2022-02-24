package IHM;

import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import graph.GraphPlongerBarH;
import graph.GraphRugbyPie;
import requete.InsertPlonger;
import requete.InsertRugby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Font;

public class ProfondeurIhm extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user;

	private JPanel container = new JPanel();
  
  private JTextField profondeur = new JTextField();
  private JLabel labelProfondeur = new JLabel("Profondeur : ");
  
  private JTextField temps = new JTextField();
  private JLabel labelTemps = new JLabel("Temps rester : ");
  
 
  
  private  GridLayout  grid = new GridLayout(0, 2);

  public ProfondeurIhm(int user){
	  
	    
	  this.user = user;
    this.setTitle("Animation");
    this.setSize(300, 300);
  //  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(grid);
    
   /* JPanel pannelSaison = new JPanel();
    JPanel pannelMatch = new JPanel();
    JPanel pannelEssai = new JPanel();
    JPanel pannelPlaquage = new JPanel();

    JPanel bottom = new JPanel();*/
    
    
    
    Font police = new Font("Arial", Font.BOLD, 14);
    
    profondeur.setFont(police);
    profondeur.setPreferredSize(new Dimension(150, 30));
    
    temps.setFont(police);
    temps.setPreferredSize(new Dimension(150, 30));
    
   
  
    container.add(labelProfondeur);
    container.add(profondeur);
    
    container.add(labelTemps);
    container.add(temps);
    
    
    
    
    
    
    JButton graphiqueButton = new JButton("graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if (profondeur.getText().isEmpty() && temps.getText().isEmpty()  ) {
   				
   			}
   			else {
   				
   		        int iProfondeur = Integer.parseInt(profondeur.getText());
   		        float fTemps = Float.valueOf(temps.getText());
   		  
   				InsertPlonger insert = new InsertPlonger(iProfondeur, fTemps,user);
   				insert.insertPlonger_profondeur(iProfondeur, fTemps,user);
   				
   				GraphPlongerBarH demo = new GraphPlongerBarH("Plonger",user);
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
  
/*  public static void main (String [] args) {
	  
	  new ProfondeurIhm();
  }*/
}