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
import javax.swing.SwingUtilities;

import graph.GraphCourseBar;
import graph.GraphPlongerAreaLine;
import requete.InsertPlonger;

public class OxygeneIhm extends JPanel {
  /**
	 * 
	 */
  private static final long serialVersionUID = -7195616257247322368L;
  private JPanel consommation_oxygeneP = new JPanel();
  private JTextField consommation_oxygene = new JTextField(14);
  private JLabel labelConsommation = new JLabel("Consommation : ");
  
  private JPanel profondeurP = new JPanel();
  private JTextField profondeur = new JTextField(14);
  private JLabel labelProfondeur = new JLabel("Profondeur : ");
  
  private JPanel buttonsP = new JPanel();
  private JButton graphiqueButton;
  
  private Color background = new Color(63, 149, 245);
  private int id_utilisateur;

  public OxygeneIhm(int id_utilisateur, JPanel simulationdisplay){
	 super();
	 this.id_utilisateur = id_utilisateur;
	 this.setPreferredSize(new Dimension(300, 350));
	 this.setBackground(background);
	 this.setLayout(new FlowLayout());

    Font police = new Font("Arial", Font.BOLD, 14);
    
    consommation_oxygeneP.setLayout(new BorderLayout());
    consommation_oxygeneP.setPreferredSize(new Dimension(300, 60));
    consommation_oxygeneP.setBackground(Color.white);
    consommation_oxygeneP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    profondeurP.setLayout(new BorderLayout());
    profondeurP.setPreferredSize(new Dimension(300, 60));
    profondeurP.setBackground(Color.white);
    profondeurP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    consommation_oxygene.setFont(police);
    profondeur.setFont(police);

    consommation_oxygeneP.add(labelConsommation,BorderLayout.WEST);
    consommation_oxygeneP.add(consommation_oxygene,BorderLayout.EAST);

    profondeurP.add(labelProfondeur,BorderLayout.WEST);
    profondeurP.add(profondeur,BorderLayout.EAST);

    GraphPlongerAreaLine simu = new GraphPlongerAreaLine("Area Chart Example | BORAJI.COM",id_utilisateur);
	simulationdisplay.removeAll();
	simulationdisplay.add(simu);
	simulationdisplay.updateUI();
	
    graphiqueButton = new JButton("Graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		@Override
		public void actionPerformed(ActionEvent e) {
   			if (consommation_oxygene.getText().isEmpty() && profondeur.getText().isEmpty() ) {

   			}
   			else {
   		        float fConsommation = Float.valueOf(consommation_oxygene.getText());
   		        float fProfondeur = Float.valueOf(profondeur.getText());
   				InsertPlonger insert = new InsertPlonger(fConsommation, fProfondeur,id_utilisateur);
   				insert.insertPlonger_oxygene(fConsommation, fProfondeur,id_utilisateur);

   				SwingUtilities.invokeLater(() -> {
   			   
   				GraphPlongerAreaLine simu = new GraphPlongerAreaLine("Area Chart Example | BORAJI.COM",id_utilisateur);
				simulationdisplay.removeAll();
				simulationdisplay.add(simu);
				simulationdisplay.updateUI();
   			    });
   			}
   		}
   	});
   	graphiqueButton.setBackground(Color.WHITE);
    graphiqueButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
    
    buttonsP.setPreferredSize(new Dimension(300,80));
    buttonsP.setLayout(new FlowLayout(10, 100, 20));
    buttonsP.setBackground(background);
   	buttonsP.add(graphiqueButton);
   	
   	this.add(consommation_oxygeneP);
   	this.add(profondeurP);
   	this.add(buttonsP);
   	
	PanelComparaison comp = new PanelComparaison(id_utilisateur);
	   
   	this.add(comp.panelComparaison());
  }
}