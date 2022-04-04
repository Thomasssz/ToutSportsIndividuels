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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import graph.GraphEscaladeBar;
import requete.InsertEscalade;

public class PriseIHM extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 8380586453862052273L;
	private JPanel blockP = new JPanel();
	private JTextField block = new JTextField(16);
	private JLabel labelBlock = new JLabel("Block : ");
	  
	  
	private JPanel prisesMinP = new JPanel();
	private JTextField prisesMin = new JTextField(10);
	private JLabel labelPrisesMin = new JLabel("Minimum prises : ");
  
	private JPanel prisesP = new JPanel();
	private JTextField prises = new JTextField(16);
	private JLabel labelPrises = new JLabel("Prises : ");
  
	private JPanel buttonsP = new JPanel();
	private JButton graphiqueButton;
	
	private Color background = new Color(63, 149, 245);
	private int id_utilisateur;

	public PriseIHM(int id_utilisateur, JPanel simulationdisplay){
		super();
		this.id_utilisateur = id_utilisateur;
	    this.setPreferredSize(new Dimension(300, 500));
	    this.setBackground(background);
	    this.setLayout(new FlowLayout());
	    
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    blockP.setLayout(new BorderLayout());
	    blockP.setPreferredSize(new Dimension(300, 60));
	    blockP.setBackground(Color.white);
	    blockP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    prisesMinP.setLayout(new BorderLayout());
	    prisesMinP.setPreferredSize(new Dimension(300, 60));
	    prisesMinP.setBackground(Color.white);
	    prisesMinP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    prisesP.setLayout(new BorderLayout());
	    prisesP.setPreferredSize(new Dimension(300, 60));
	    prisesP.setBackground(Color.white);
	    prisesP.setBorder(BorderFactory.createLineBorder(background, 10));
	    
	    block.setFont(police);
	    prisesMin.setFont(police);
	    prises.setFont(police);
	
	    blockP.add(labelBlock,BorderLayout.WEST);
	    blockP.add(block,BorderLayout.EAST);
	    
	    prisesMinP.add(labelPrisesMin,BorderLayout.WEST);
	    prisesMinP.add(prisesMin,BorderLayout.EAST);
	
	    prisesP.add(labelPrises,BorderLayout.WEST);
	    prisesP.add(prises,BorderLayout.EAST);
	 
	    GraphEscaladeBar simu = new GraphEscaladeBar(id_utilisateur);
		simulationdisplay.removeAll();
		simulationdisplay.add(simu);
		simulationdisplay.updateUI();
	  
	    graphiqueButton = new JButton("Graphique");
	   	graphiqueButton.addActionListener(new ActionListener() {
	   		@Override
			public void actionPerformed(ActionEvent e) {
	   			if (block.getText().isEmpty() && prisesMin.getText().isEmpty() && prises.getText().isEmpty() ) {
	
	   			}
	   			else {
	   				int iblock = Integer.valueOf(block.getText());
	   		        int iprisesMin = Integer.valueOf(prisesMin.getText());
	   		        int iprises = Integer.valueOf(prises.getText());
	   				InsertEscalade insert = new InsertEscalade(iblock, iprisesMin, iprises, id_utilisateur);
	   				insert.insertEscalade_prise(iblock, iprisesMin, iprises,id_utilisateur);
	   				GraphEscaladeBar simu = new GraphEscaladeBar(id_utilisateur);
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
	   	
	   	this.add(blockP);
	   	this.add(prisesMinP);
	   	this.add(prisesP);
	   	this.add(buttonsP);
	   	
		PanelComparaison comp = new PanelComparaison(id_utilisateur);
		   
	   	this.add(comp.panelComparaison("PriseIHM"));
	}
	
}
