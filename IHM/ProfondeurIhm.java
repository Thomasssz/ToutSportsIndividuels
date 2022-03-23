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

import graph.GraphPlongerBarH;
import graph.GraphRugbyLine;
import requete.InsertPlonger;

public class ProfondeurIhm extends JPanel {
  /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel profondeurP = new JPanel();
	private JTextField profondeur = new JTextField(14);
	private JLabel labelProfondeur = new JLabel("Profondeur : ");

	private JPanel tempsP = new JPanel();
	private JTextField temps = new JTextField(14);
	private JLabel labelTemps = new JLabel("Temps reste : ");

	private JPanel buttonsP = new JPanel();
	private JButton graphiqueButton;

	private Color background = new Color(63, 149, 245);
	private int id_utilisateur;
	
	public ProfondeurIhm(int id_utilisateur, JPanel simulationdisplay){
		super();
		this.id_utilisateur = id_utilisateur;
		this.setPreferredSize(new Dimension(300, 350));
		this.setBackground(background);
		this.setLayout(new FlowLayout());
	
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    profondeurP.setLayout(new BorderLayout());
	    profondeurP.setPreferredSize(new Dimension(300, 60));
	    profondeurP.setBackground(Color.white);
	    profondeurP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    tempsP.setLayout(new BorderLayout());
	    tempsP.setPreferredSize(new Dimension(300, 60));
	    tempsP.setBackground(Color.white);
	    tempsP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    profondeur.setFont(police);
	    temps.setFont(police);
	
	    profondeurP.add(labelProfondeur,BorderLayout.WEST);
	    profondeurP.add(profondeur,BorderLayout.EAST);
	
	    tempsP.add(labelTemps,BorderLayout.WEST);
	    tempsP.add(temps,BorderLayout.EAST);
	
	    GraphPlongerBarH simu = new GraphPlongerBarH("Plongee",id_utilisateur);
		simulationdisplay.removeAll();
		simulationdisplay.add(simu);
		simulationdisplay.updateUI();

	    graphiqueButton = new JButton("Graphique");
	   	graphiqueButton.addActionListener(new ActionListener() {
	   		@Override
			public void actionPerformed(ActionEvent e) {
	   			if (profondeur.getText().isEmpty() && temps.getText().isEmpty()  ) {
	
	   			}
	   			else {
	
	   		        int iProfondeur = Integer.parseInt(profondeur.getText());
	   		        float fTemps = Float.valueOf(temps.getText());
	
	   				InsertPlonger insert = new InsertPlonger(iProfondeur, fTemps,id_utilisateur);
	   				insert.insertPlonger_profondeur(iProfondeur, fTemps,id_utilisateur);
	
	   				
	   				GraphPlongerBarH simu = new GraphPlongerBarH("Plongee",id_utilisateur);
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
	   	
	   	this.add(profondeurP);
	   	this.add(tempsP);
	   	this.add(buttonsP);
	}
}