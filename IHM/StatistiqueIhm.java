package IHM;

import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;


import graph.GraphRugbyPie;
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

public class StatistiqueIhm extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private JPanel container = new JPanel();
  
  private JTextField saison = new JTextField();
  private JLabel labelSaison = new JLabel("Saison : ");
  
  private JTextField match = new JTextField();
  private JLabel labelMatch = new JLabel("Match joué : ");
  
  private JTextField essai = new JTextField();
  private JLabel labelEssai = new JLabel("Nombre essai : ");
  
  private JTextField plaquage = new JTextField();
  private JLabel labelPlaquage = new JLabel("Plaquage : ");
  
  private  GridLayout  grid = new GridLayout(5, 0);
  private int id_utilisateur;

  public StatistiqueIhm(int id_utilisateur){
	  
	    
	this.id_utilisateur = id_utilisateur;
    this.setTitle("Animation");
    this.setSize(300, 300);
   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(grid);
    
   /* JPanel pannelSaison = new JPanel();
    JPanel pannelMatch = new JPanel();
    JPanel pannelEssai = new JPanel();
    JPanel pannelPlaquage = new JPanel();

    JPanel bottom = new JPanel();*/
    
    
    
    Font police = new Font("Arial", Font.BOLD, 14);
    
    saison.setFont(police);
    saison.setPreferredSize(new Dimension(150, 30));
    
    match.setFont(police);
    match.setPreferredSize(new Dimension(150, 30));
    
    essai.setFont(police);
    essai.setPreferredSize(new Dimension(150, 30));
    
    plaquage.setFont(police);
    plaquage.setPreferredSize(new Dimension(150, 30));
  
    container.add(labelSaison);
    container.add(saison);
    
    container.add(labelMatch);
    container.add(match);
    
    container.add(labelEssai);
    container.add(essai);
    
    container.add(labelPlaquage);
    container.add(plaquage);
    
    
    
    
    JButton graphiqueButton = new JButton("graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if (saison.getText().isEmpty() && match.getText().isEmpty() && essai.getText().isEmpty() && plaquage.getText().isEmpty() ) {
   				
   			}
   			else {
   				String sSaison = saison.getText();
   		        int iMatch = Integer.parseInt(match.getText());
   		        int iEssai = Integer.parseInt(essai.getText());
   		        int iPlaquage = Integer.parseInt(plaquage.getText());
   		  
   				InsertRugby insert = new InsertRugby(sSaison, iMatch, iEssai, iPlaquage,id_utilisateur);
   				insert.insertRugby_statistique(sSaison, iMatch, iEssai, iPlaquage,id_utilisateur);
   				
   				GraphRugbyPie demo = new GraphRugbyPie("Rugby",id_utilisateur);
   			//	System.out.println("graph"+id_utilisateur);

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
	  
	  new StatistiqueIhm();
  }*/
}