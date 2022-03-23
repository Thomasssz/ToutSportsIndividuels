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

import graph.GraphPlongerAreaLine;
import graph.GraphRugbyLine;
import requete.InsertRugby;

public class PenaliteIhm extends JPanel {
  /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel penalite_tenterP = new JPanel();
	private JTextField penalite_tenter = new JTextField(13);
	private JLabel labelPenalite_tenter = new JLabel("Penalité tentée : ");

	private JPanel distanceP = new JPanel();
	private JTextField distance = new JTextField(13);
	private JLabel labelDistance = new JLabel("Distance : ");

	private JPanel reussiP = new JPanel();
	private JTextField reussi = new JTextField(13);
	private JLabel labelReussi = new JLabel("Réussi : ");

	private JPanel echecP = new JPanel();
	private JTextField echec = new JTextField(13);
	private JLabel labelEchec = new JLabel("Echec : ");

	private JPanel buttonsP = new JPanel();
	private JButton graphiqueButton;
	  
	private Color background = new Color(63, 149, 245);
	private int id_utilisateur;
	
	public PenaliteIhm(int id_utilisateur, JPanel simulationdisplay){
		super();
		this.id_utilisateur = id_utilisateur;
	    this.setPreferredSize(new Dimension(300, 350));
	    this.setBackground(background);
	    this.setLayout(new FlowLayout());
		
	    penalite_tenterP.setLayout(new BorderLayout());
	    penalite_tenterP.setPreferredSize(new Dimension(300, 60));
	    penalite_tenterP.setBackground(Color.white);
	    penalite_tenterP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    distanceP.setLayout(new BorderLayout());
	    distanceP.setPreferredSize(new Dimension(300, 60));
	    distanceP.setBackground(Color.white);
	    distanceP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    reussiP.setLayout(new BorderLayout());
	    reussiP.setPreferredSize(new Dimension(300, 60));
	    reussiP.setBackground(Color.white);
	    reussiP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    echecP.setLayout(new BorderLayout());
	    echecP.setPreferredSize(new Dimension(300, 60));
	    echecP.setBackground(Color.white);
	    echecP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    Font police = new Font("Arial", Font.BOLD, 14);
	
	    penalite_tenter.setFont(police);
	    distance.setFont(police);
	    reussi.setFont(police);
	    echec.setFont(police);
	    
	    penalite_tenterP.add(labelPenalite_tenter,BorderLayout.WEST);
	    penalite_tenterP.add(penalite_tenter,BorderLayout.EAST);
	
	    distanceP.add(labelDistance,BorderLayout.WEST);
	    distanceP.add(distance,BorderLayout.EAST);
	
	    reussiP.add(labelReussi,BorderLayout.WEST);
	    reussiP.add(reussi,BorderLayout.EAST);
	
	    echecP.add(labelEchec,BorderLayout.WEST);
	    echecP.add(echec,BorderLayout.EAST);
	
	    GraphRugbyLine simu = new GraphRugbyLine("Penalité",id_utilisateur);
		simulationdisplay.removeAll();
		simulationdisplay.add(simu);
		simulationdisplay.updateUI();
		
	    graphiqueButton = new JButton("Graphique");
	   	graphiqueButton.addActionListener(new ActionListener() {
	   		@Override
			public void actionPerformed(ActionEvent e) {
	   			if (penalite_tenter.getText().isEmpty() && distance.getText().isEmpty() && reussi.getText().isEmpty() && echec.getText().isEmpty() ) {
	
	   			}
	   			else {
	   				int iPenalite_tenter = Integer.parseInt(penalite_tenter.getText());
	   		        int iDistance = Integer.parseInt(distance.getText());
	   		        int iReussi = Integer.parseInt(reussi.getText());
	   		        int iEchec = Integer.parseInt(echec.getText());
	
	   				InsertRugby insert = new InsertRugby(iPenalite_tenter, iDistance, iReussi, iEchec,id_utilisateur);
	   				insert.insertRugby_penalite(iPenalite_tenter, iDistance, iReussi, iEchec,id_utilisateur);
	
	   				GraphRugbyLine simu = new GraphRugbyLine("Penalité",id_utilisateur);
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
	   	
	   	this.add(penalite_tenterP);
	   	this.add(distanceP);
	   	this.add(reussiP);
	   	this.add(echecP);
	   	this.add(buttonsP);
	}
}