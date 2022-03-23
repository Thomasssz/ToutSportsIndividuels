package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*; 
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import graph.GraphGolfBar;
import graph.GraphGolfPoint;
import requete.InsertGolf;

public class CoupIhm extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 4787154367605836672L;
private JPanel parcoursP = new JPanel();
  private JTextField parcours = new JTextField(14);
  private JLabel labelParcours = new JLabel("Parcours : ");
  private JRadioButton jrd1= new JRadioButton ("green");
  private JRadioButton jrd2= new JRadioButton ("lac");
  private JRadioButton jrd3= new JRadioButton ("practice");
  private JRadioButton jrd4= new JRadioButton ("winter");
  private JRadioButton jrd5= new JRadioButton ("medium");
  private JRadioButton jrd6= new JRadioButton ("hard");
  private ButtonGroup bg = new ButtonGroup();
  private  GridLayout  grid = new GridLayout(0, 1);
  
  private JPanel coup_effectuerP = new JPanel();
  private JTextField coup_effectuer = new JTextField(14);
  private JLabel labelCoupEffectuer = new JLabel("Coup effectué : ");
  
  private JPanel buttonsP = new JPanel();
  private JButton graphiqueButton;
  
  private Color background = new Color(63, 149, 245);
  private int id_utilisateur;

  public CoupIhm(int id_utilisateur, JPanel simulationdisplay){
	super();
	this.id_utilisateur = id_utilisateur;
    this.setPreferredSize(new Dimension(300, 350));
    this.setBackground(background);
    this.setLayout(new FlowLayout());
    
    Font police = new Font("Arial", Font.BOLD, 11);
    
    parcoursP.setLayout(grid);
    parcoursP.setPreferredSize(new Dimension(300, 200));
    parcoursP.setBackground(Color.white);
    parcoursP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    coup_effectuerP.setLayout(new BorderLayout());
    coup_effectuerP.setPreferredSize(new Dimension(300, 60));
    coup_effectuerP.setBackground(Color.white);
    coup_effectuerP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    parcours.setFont(police);
    coup_effectuer.setFont(police);

    
    bg.add(jrd1);
    bg.add(jrd2);
    bg.add(jrd3);
    bg.add(jrd4);
    bg.add(jrd5);
    bg.add(jrd6);

    parcoursP.add(labelParcours,BorderLayout.WEST);
   // parcoursP.add(parcours,BorderLayout.EAST);
  

    parcoursP.add(jrd1);
    
    parcoursP.add(jrd2);
    
    parcoursP.add(jrd3);
    
    parcoursP.add(jrd4);
   
    parcoursP.add(jrd5);

    parcoursP.add(jrd6);
    

    coup_effectuerP.add(labelCoupEffectuer,BorderLayout.WEST);
    coup_effectuerP.add(coup_effectuer,BorderLayout.EAST);
    
    GraphGolfBar simu = new GraphGolfBar("Golf",id_utilisateur);
	simulationdisplay.removeAll();
	simulationdisplay.add(simu);
	simulationdisplay.updateUI(); 
	
    graphiqueButton = new JButton("Graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		@Override
		public void actionPerformed(ActionEvent e) {
   			if (parcours.getText().isEmpty() && coup_effectuer.getText().isEmpty() ) {

   			}
   			else {
   				if (jrd1.isSelected()) {
   					int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   	   				InsertGolf insert = new InsertGolf("green", iCoup_effectuer,id_utilisateur);
   	   				insert.insertGolf_coup("green", iCoup_effectuer,id_utilisateur);
   				}
   				else if (jrd2.isSelected()) {
   					int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   	   				InsertGolf insert = new InsertGolf("lac", iCoup_effectuer,id_utilisateur);
   	   				insert.insertGolf_coup("lac", iCoup_effectuer,id_utilisateur);
   				}
   				else if (jrd3.isSelected()) {
   					int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   	   				InsertGolf insert = new InsertGolf("practice", iCoup_effectuer,id_utilisateur);
   	   				insert.insertGolf_coup("practice", iCoup_effectuer,id_utilisateur);
   				}
   				else if (jrd4.isSelected()) {
   					int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   	   				InsertGolf insert = new InsertGolf("winter", iCoup_effectuer,id_utilisateur);
   	   				insert.insertGolf_coup("winter", iCoup_effectuer,id_utilisateur);
   				}
   				else if (jrd5.isSelected()) {
   					int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   	   				InsertGolf insert = new InsertGolf("medium", iCoup_effectuer,id_utilisateur);
   	   				insert.insertGolf_coup("medium", iCoup_effectuer,id_utilisateur);
   				}
   				else if (jrd6.isSelected()) {
   					int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   	   				InsertGolf insert = new InsertGolf("hard", iCoup_effectuer,id_utilisateur);
   	   				insert.insertGolf_coup("hard", iCoup_effectuer,id_utilisateur);
   				}
   				
   				GraphGolfBar simu = new GraphGolfBar("Golf",id_utilisateur);
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
   	
   	this.add(parcoursP);
   	this.add(coup_effectuerP );
   	this.add(buttonsP);
  }
}