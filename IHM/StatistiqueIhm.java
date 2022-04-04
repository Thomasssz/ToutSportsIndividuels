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
import graph.GraphRugbyPie;
import requete.InsertRugby;

public class StatistiqueIhm extends JPanel {
  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  private JPanel saisonP = new JPanel();
  private JTextField saison = new JTextField(13);
  private JLabel labelSaison = new JLabel("Saison : ");

  private JPanel matchP = new JPanel();
  private JTextField match = new JTextField(13);
  private JLabel labelMatch = new JLabel("Match joué : ");

  private JPanel essaiP = new JPanel();
  private JTextField essai = new JTextField(13);
  private JLabel labelEssai = new JLabel("Nombre essai : ");

  private JPanel plaquageP = new JPanel();
  private JTextField plaquage = new JTextField(13);
  private JLabel labelPlaquage = new JLabel("Plaquage : ");
  
  private JPanel buttonsP = new JPanel();
  private JButton graphiqueButton;
  
  private int id_utilisateur;
  private Color background = new Color(63, 149, 245);

  public StatistiqueIhm(int id_utilisateur, JPanel simulationdisplay){
	super();
	this.id_utilisateur = id_utilisateur;
	this.setPreferredSize(new Dimension(300, 500));
   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBackground(background);
    this.setLayout(new FlowLayout());

   /* JPanel pannelSaison = new JPanel();
    JPanel pannelMatch = new JPanel();
    JPanel pannelEssai = new JPanel();
    JPanel pannelPlaquage = new JPanel();

    JPanel bottom = new JPanel();*/

    saisonP.setLayout(new BorderLayout());
    saisonP.setPreferredSize(new Dimension(300, 60));
    saisonP.setBackground(Color.white);
    saisonP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    matchP.setLayout(new BorderLayout());
    matchP.setPreferredSize(new Dimension(300, 60));
    matchP.setBackground(Color.white);
    matchP.setBorder(BorderFactory.createLineBorder(background, 10));
    matchP.setLayout(new BorderLayout());
    
    essaiP.setPreferredSize(new Dimension(300, 60));
    essaiP.setBackground(Color.white);
    essaiP.setBorder(BorderFactory.createLineBorder(background, 10));
    essaiP.setLayout(new BorderLayout());
    
    plaquageP.setPreferredSize(new Dimension(300, 60));
    plaquageP.setBackground(Color.white);
    plaquageP.setBorder(BorderFactory.createLineBorder(background, 10));
    plaquageP.setLayout(new BorderLayout());
    
    Font police = new Font("Arial", Font.BOLD, 14);

    saison.setFont(police);
    match.setFont(police);
    essai.setFont(police);
    plaquage.setFont(police);

    saisonP.add(labelSaison,BorderLayout.WEST);
    saisonP.add(saison,BorderLayout.EAST);

    matchP.add(labelMatch,BorderLayout.WEST);
    matchP.add(match,BorderLayout.EAST);

    essaiP.add(labelEssai,BorderLayout.WEST);
    essaiP.add(essai,BorderLayout.EAST);

    plaquageP.add(labelPlaquage,BorderLayout.WEST);
    plaquageP.add(plaquage,BorderLayout.EAST);

    GraphRugbyPie simu = new GraphRugbyPie("Rugby",id_utilisateur);
	simulationdisplay.removeAll();
	simulationdisplay.add(simu);
	simulationdisplay.updateUI();
		
    graphiqueButton = new JButton("Graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		@Override
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

   				GraphRugbyPie simu = new GraphRugbyPie("Rugby",id_utilisateur);
	   			simulationdisplay.removeAll();
	   			simulationdisplay.add(simu);
	   			simulationdisplay.updateUI();
   			}
   		}
   	});
  	graphiqueButton.setBackground(Color.WHITE);
    graphiqueButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
    
   	buttonsP.setPreferredSize(new Dimension(300,60));
    buttonsP.setLayout(new FlowLayout(10, 100, 20));
    buttonsP.setBackground(background);
   	buttonsP.add(graphiqueButton);

   	this.add(saisonP);
   	this.add(matchP);
   	this.add(essaiP);
   	this.add(plaquageP);
   	this.add(buttonsP);
   	
	PanelComparaison comp = new PanelComparaison(id_utilisateur);
	   
   	this.add(comp.panelComparaison());
  }
}