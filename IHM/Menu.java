package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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


public class Menu extends JFrame {
  private JPanel container = new JPanel();
  
  private JRadioButton vitesse = new JRadioButton("Vitesse");
  private JRadioButton coup = new JRadioButton("Trou");
  private JRadioButton statistique = new JRadioButton("Statistique");
  private JRadioButton penalite = new JRadioButton("Penalite");
  private JRadioButton profondeur = new JRadioButton("Profondeur");
  private JRadioButton oxygene = new JRadioButton("Oxygene");
  private JRadioButton vitesse_course = new JRadioButton("Vitesse Moyenne");
  private JRadioButton kilometre = new JRadioButton("KIlometre ");
  private JRadioButton cotation = new JRadioButton("Cotation");
  private JRadioButton prise = new JRadioButton("Prise");




  
  private ButtonGroup bg = new ButtonGroup();
  private JLabel labelGolf = new JLabel("GOLF");
  private JLabel labelRugby = new JLabel("Rugby");
  private JLabel labelPlonger = new JLabel("Plonger");
  private JLabel labelCourse = new JLabel("Course");
  private JLabel labelEscalade = new JLabel("Escalade");

  
  private  GridLayout  grid = new GridLayout(0, 3);
  
  private int id_utilisateur;



  public Menu(int id_utilisateur){
	this.id_utilisateur = id_utilisateur;
    this.setTitle("Animation");
    this.setSize(300, 300);
  //  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(grid);
    JPanel bot = new JPanel();

    
    JButton simulation = new JButton("SIMULATION");
   	simulation.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent e) {
   			if ((vitesse.isSelected() == true) && (coup.isSelected() == false) && (statistique.isSelected() == false) && (penalite.isSelected() == false)) {
   				new Vitesse_golfIhm(id_utilisateur);
   			}
   			else if ((vitesse.isSelected() == false) && (coup.isSelected() == true) && (statistique.isSelected() == false) && (penalite.isSelected() == false) ) {

   				new CoupIhm(id_utilisateur);
   			}
   			else if ((vitesse.isSelected() == false) && (coup.isSelected() == false) && (statistique.isSelected() == true) && (penalite.isSelected() == false) ) {

   				new StatistiqueIhm(id_utilisateur);

   			}
   			else if ((vitesse.isSelected() == false) && (coup.isSelected() == false) && (statistique.isSelected() == false) && (penalite.isSelected() == true) ) {

   				new PenaliteIhm(id_utilisateur);
   			}
   			else if (profondeur.isSelected() == true){
   				new ProfondeurIhm(id_utilisateur);
   			}
   			else if (oxygene.isSelected() == true){
   				new OxygeneIhm(id_utilisateur);
   			}
   			else if (vitesse_course.isSelected() == true){
   				new Vitesse_courseIhm(id_utilisateur);
   			}
   			else if (kilometre.isSelected() == true){
   				new KilometreIhm(id_utilisateur);
   			}
   			else if (cotation.isSelected() == true){
   				
   			}
   			else if (prise.isSelected() == true){
   				
   			}
   			
   			
   			
   		}
   	});
  
    vitesse.setSelected(true);
    bg.add(vitesse);
    bg.add(coup);
    bg.add(statistique);
    bg.add(penalite);
    bg.add(profondeur);
    bg.add(oxygene);
    bg.add(prise);
    bg.add(cotation);
    bg.add(vitesse_course);
    bg.add(kilometre);


    
    container.add(labelGolf);
    container.add(vitesse);
    container.add(coup);
    container.add(labelRugby);
    container.add(statistique);
    container.add(penalite);
    container.add(labelPlonger);
    container.add(profondeur);
    container.add(oxygene);
    container.add(labelCourse);
    container.add(vitesse_course);
    container.add(kilometre);
    container.add(labelEscalade);
    container.add(cotation);
    container.add(prise);



    bot.add(simulation);
    
    System.out.println(coup.isSelected());
    
   
    
    

    container.add(bot);
    this.setContentPane(container);
    this.setVisible(true);            
  }       

  
    
  
 /* public static void main(String[] args) {
  
  new Menu(id_utilisateur);
  }*/
}