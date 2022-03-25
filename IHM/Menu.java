package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Menu extends JFrame {
  private JPanel container, profils, choixSport, listeSport, btnSimulationP, simulationSport, simulationdisplay,
  btnReseauSocialP, btnComparerP;

  private JRadioButton vitesse = new JRadioButton("Vitesse");
  private JRadioButton coup = new JRadioButton("Trou");
  private JRadioButton statistique = new JRadioButton("Statistique");
  private JRadioButton penalite = new JRadioButton("Penalite");
  private JRadioButton profondeur = new JRadioButton("Profondeur");
  private JRadioButton oxygene = new JRadioButton("Oxygene");
  private JRadioButton vitesse_course = new JRadioButton("Vitesse Moyenne");
  private JRadioButton kilometre = new JRadioButton("Kilometre ");
  private JRadioButton cotation = new JRadioButton("Cotation");
  private JRadioButton prise = new JRadioButton("Prise");

  private ButtonGroup bg = new ButtonGroup();
  
  private JLabel labelGolf = new JLabel("Golf");
  private JLabel labelRugby = new JLabel("Rugby");
  private JLabel labelPlonger = new JLabel("Plongee");
  private JLabel labelCourse = new JLabel("Course");
  private JLabel labelEscalade = new JLabel("Escalade");

  private Color background = new Color(63, 149, 245);
  private int width = 1000;
  private int height = 800;
  
  private int id_utilisateur;

  private JFrame frame;
  private JPanel sportParameterC = new JPanel();
  private JPanel sportParameter = new JPanel();
  
  public Menu(int id_utilisateur){
	super();
	frame=this;
	
	this.id_utilisateur = id_utilisateur;
	frame.setTitle("Sport2-Menu");
	frame.setSize(width, height);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
 
	//-------------- CONTENT PANE ------------------//
    container = new JPanel();
    container.setPreferredSize(new Dimension(width, height));
    container.setBackground(background);
    container.setLayout(new BorderLayout());
	

	//-------------- CONNECT PAGE ------------------//
    displayReseauSocial();
    displaySimulation();
    displayChoixSport();
    
    frame.setContentPane(container);
    frame.setVisible(true);
  }
  private void displayReseauSocial() {
		btnReseauSocialP = new JPanel();
		btnReseauSocialP.setBackground(background);
		btnReseauSocialP.setPreferredSize(new Dimension(300,60));
		btnReseauSocialP.setLayout(new FlowLayout(10, 100, 20));
		
		JButton btnReseauSocial = new JButton("Reseau Social");
		btnReseauSocial.setBackground(Color.WHITE);
		btnReseauSocial.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		
		btnReseauSocialP.add(btnReseauSocial);
		container.add(btnReseauSocialP, BorderLayout.SOUTH);
		
		btnReseauSocial.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		  container.removeAll();
		  container.add(new PanelAmis(id_utilisateur));
		  container.updateUI();
		  container.revalidate();
		  container.repaint();
	  	}
	  
	  });
  }
  
  private void displayChoixSport(){
	  choixSport = new JPanel();
	  choixSport.setBackground(background);
	  choixSport.setPreferredSize(new Dimension(300,350));
	  choixSport.setLayout(new FlowLayout());
	  
	  listeSport = new JPanel();
	  listeSport.setBackground(Color.WHITE);
	  listeSport.setPreferredSize(new Dimension(300,250));
	  listeSport.setBorder(BorderFactory.createLineBorder(background, 10));
	  listeSport.setLayout(new GridLayout(0, 3));
	 
	  btnSimulationP = new JPanel();
	  btnSimulationP.setBackground(background);
	  btnSimulationP.setPreferredSize(new Dimension(300,60));
	  btnSimulationP.setLayout(new FlowLayout(10, 100, 20));
	  
	  JButton btnSimulation = new JButton("SIMULATION");
	  btnSimulation.setBackground(Color.WHITE);
	  btnSimulation.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
   
	  vitesse.setBackground(Color.WHITE);
	  coup.setBackground(Color.WHITE);
	  statistique.setBackground(Color.WHITE);
	  penalite.setBackground(Color.WHITE);
	  profondeur.setBackground(Color.WHITE);
	  oxygene.setBackground(Color.WHITE);	
	  vitesse_course.setBackground(Color.WHITE);
	  kilometre.setBackground(Color.WHITE);
	  cotation.setBackground(Color.WHITE);
	  prise.setBackground(Color.WHITE);

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

	  listeSport.add(labelGolf);
	  listeSport.add(vitesse);
	  listeSport.add(coup);
	  listeSport.add(labelRugby);
	  listeSport.add(statistique);
	  listeSport.add(penalite);
	  listeSport.add(labelPlonger);
	  listeSport.add(profondeur);
	  listeSport.add(oxygene);
	  listeSport.add(labelCourse);
	  listeSport.add(vitesse_course);
	  listeSport.add(kilometre);
	  listeSport.add(labelEscalade);
	  listeSport.add(cotation);
	  listeSport.add(prise);
	
	  choixSport.add(listeSport);

	  btnSimulationP.add(btnSimulation);
	  choixSport.add(btnSimulationP);
	  
	  sportParameter.setBackground(background);
	  sportParameterC.setBackground(background);
	  sportParameterC.add(sportParameter);
	  choixSport.add(sportParameterC);
	  
	  btnSimulation.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		if (vitesse.isSelected()) {
			sportParameterC.remove(sportParameter);
			sportParameter = new Vitesse_golfIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
		}
		else if (coup.isSelected()) {
			sportParameterC.remove(sportParameter);
			sportParameter = new CoupIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
		}
		else if (statistique.isSelected()) {
			sportParameterC.remove(sportParameter);
			sportParameter = new StatistiqueIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
			
		}
		else if (penalite.isSelected()) {
			sportParameterC.remove(sportParameter);
			sportParameter = new PenaliteIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
			
		}
		else if (profondeur.isSelected()){
			sportParameterC.remove(sportParameter);
			sportParameter = new ProfondeurIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
		}
		else if (oxygene.isSelected()){
			sportParameterC.remove(sportParameter);
			sportParameter = new OxygeneIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);

		}
		else if (vitesse_course.isSelected()){
			sportParameterC.remove(sportParameter);
			sportParameter = new Vitesse_courseIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
		}
		else if (kilometre.isSelected()){
			sportParameterC.remove(sportParameter);
			sportParameter = new KilometreIhm(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
		}
		else if (cotation.isSelected()){
			sportParameterC.remove(sportParameter);
			sportParameter = new CotationIHM(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
		}
		else if (prise.isSelected()){
			sportParameterC.remove(sportParameter);
			sportParameter = new PriseIHM(id_utilisateur, simulationdisplay);
			sportParameterC.add(sportParameter);
		}
		}
	  });
	  
	  vitesse.setSelected(true);
	
	  container.add(choixSport, BorderLayout.WEST);
  }
  
  private void displaySimulation(){
	  simulationSport =  new JPanel();
	  simulationSport.setBackground(background);
	  simulationSport.setPreferredSize(new Dimension(700,700));
	  //simulationSport.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	  simulationSport.setLayout(new FlowLayout());
	  
	  simulationdisplay = new JPanel();
	  simulationdisplay.setBackground(background);
	  simulationdisplay.setPreferredSize(new Dimension(700,600));
	  
	  simulationSport.add(simulationdisplay); 
		
	  container.add(simulationSport, BorderLayout.CENTER);
  }
 
/*
  public static void main(String[] args) {

  new Menu(14044044);
  }*/
}