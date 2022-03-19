package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import graph.GraphGolfBar;
import requete.InsertGolf;

public class CoupIhm extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 4787154367605836672L;
private JPanel parcoursP = new JPanel();
  private JTextField parcours = new JTextField(14);
  private JLabel labelParcours = new JLabel("Parcours : ");
  
  private JPanel coup_effectuerP = new JPanel();
  private JTextField coup_effectuer = new JTextField(14);
  private JLabel labelCoupEffectuer = new JLabel("Coup effectué : ");
  
  private JPanel buttonsP = new JPanel();
  private JButton graphiqueButton;
  
  private Color background = new Color(63, 149, 245);
  private int id_utilisateur;

  public CoupIhm(int id_utilisateur, JPanel simulation, JFrame menu){
	super();
	this.id_utilisateur = id_utilisateur;
    this.setPreferredSize(new Dimension(300, 350));
    this.setBackground(background);
    this.setLayout(new FlowLayout());
    
    Font police = new Font("Arial", Font.BOLD, 11);
    
    parcoursP.setLayout(new BorderLayout());
    parcoursP.setPreferredSize(new Dimension(300, 60));
    parcoursP.setBackground(Color.white);
    parcoursP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    coup_effectuerP.setLayout(new BorderLayout());
    coup_effectuerP.setPreferredSize(new Dimension(300, 60));
    coup_effectuerP.setBackground(Color.white);
    coup_effectuerP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    parcours.setFont(police);
    coup_effectuer.setFont(police);

    parcoursP.add(labelParcours,BorderLayout.WEST);
    parcoursP.add(parcours,BorderLayout.EAST);

    coup_effectuerP.add(labelCoupEffectuer,BorderLayout.WEST);
    coup_effectuerP.add(coup_effectuer,BorderLayout.EAST);

    graphiqueButton = new JButton("Graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		@Override
		public void actionPerformed(ActionEvent e) {
   			if (parcours.getText().isEmpty() && coup_effectuer.getText().isEmpty() ) {

   			}
   			else {
   				String sParcours = parcours.getText();
   		        int iCoup_effectuer = Integer.parseInt(coup_effectuer.getText());
   				InsertGolf insert = new InsertGolf(sParcours, iCoup_effectuer,id_utilisateur);
   				insert.insertGolf_coup(sParcours, iCoup_effectuer,id_utilisateur);
   				GraphGolfBar demo = new GraphGolfBar("Golf",id_utilisateur);
   				simulation.removeAll();
   				simulation.add(demo);
   				simulation.updateUI();   			
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