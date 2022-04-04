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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import graph.GraphEscaladeLine;
import requete.InsertEscalade;

public class CotationIHM extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 6438319607381687943L;
	private JPanel cotationP = new JPanel();

  private JTextField cotation = new JTextField(14);
  private JLabel labelCotation = new JLabel("Cotation : ");
  private JRadioButton jrd1= new JRadioButton ("1-4c");
  private JRadioButton jrd2= new JRadioButton ("5a-5c");
  private JRadioButton jrd3= new JRadioButton ("6a-6c");
  private JRadioButton jrd4= new JRadioButton ("7a-7c");
  private JRadioButton jrd5= new JRadioButton ("8a-8c");
  private JRadioButton jrd6= new JRadioButton ("9a-9b+");
  private ButtonGroup bg = new ButtonGroup();
  private  GridLayout  grid = new GridLayout(0, 1);
  
  private JPanel blockP = new JPanel();
  private JTextField block = new JTextField(17);
  private JLabel labelBlock = new JLabel("Block : ");
  
  private JPanel tentativesP = new JPanel();
  private JTextField tentatives = new JTextField(17);
  private JLabel labelTentatives = new JLabel("Tentatives : ");
  
  private JPanel buttonsP = new JPanel();
  private JButton graphiqueButton;
  
  private Color background = new Color(63, 149, 245);
  private int id_utilisateur;

  public CotationIHM(int id_utilisateur, JPanel simulationdisplay){
	super();
	this.id_utilisateur = id_utilisateur;
    this.setPreferredSize(new Dimension(300, 500));
    this.setBackground(background);
    this.setLayout(new FlowLayout());
    
    Font police = new Font("Arial", Font.BOLD, 11);
    
    cotationP.setLayout(grid);
    cotationP.setPreferredSize(new Dimension(300, 200));
    cotationP.setBackground(Color.white);
    cotationP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    blockP.setLayout(new BorderLayout());
    blockP.setPreferredSize(new Dimension(300, 40));
    blockP.setBackground(Color.white);
    blockP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    tentativesP.setLayout(new BorderLayout());
    tentativesP.setPreferredSize(new Dimension(300, 40));
    tentativesP.setBackground(Color.white);
    tentativesP.setBorder(BorderFactory.createLineBorder(background, 10));
    
    cotation.setFont(police);
    block.setFont(police);
    tentatives.setFont(police);

    
    bg.add(jrd1);
    bg.add(jrd2);
    bg.add(jrd3);
    bg.add(jrd4);
    bg.add(jrd5);
    bg.add(jrd6);

    cotationP.add(labelCotation,BorderLayout.WEST);
   // parcoursP.add(parcours,BorderLayout.EAST);
  
    cotationP.add(jrd1);
    cotationP.add(jrd2);
    cotationP.add(jrd3);
    cotationP.add(jrd4);
    cotationP.add(jrd5);
    cotationP.add(jrd6);

    blockP.add(labelBlock,BorderLayout.WEST);
    blockP.add(block,BorderLayout.EAST);
    
    tentativesP.add(labelTentatives,BorderLayout.WEST);
    tentativesP.add(tentatives,BorderLayout.EAST);
    
    GraphEscaladeLine simu = new GraphEscaladeLine(id_utilisateur);
	simulationdisplay.removeAll();
	simulationdisplay.add(simu);
	simulationdisplay.updateUI(); 
	
    graphiqueButton = new JButton("Graphique");
   	graphiqueButton.addActionListener(new ActionListener() {
   		@Override
		public void actionPerformed(ActionEvent e) {
   			if (cotation.getText().isEmpty() && block.getText().isEmpty() && tentatives.getText().isEmpty() ) {

   			}
   			else {
   				if (jrd1.isSelected()) {
   					int iblock = Integer.parseInt(block.getText());
   					int itentatives = Integer.parseInt(tentatives.getText());
   					InsertEscalade insert = new InsertEscalade("1-4c", iblock, itentatives, id_utilisateur);
   	   				insert.insertEscalade_cotation("1-4c", iblock, itentatives, id_utilisateur);
   				}
   				else if (jrd2.isSelected()) {
   					int iblock = Integer.parseInt(block.getText());
   					int itentatives = Integer.parseInt(tentatives.getText());
   					InsertEscalade insert = new InsertEscalade("5a-5c", iblock, itentatives, id_utilisateur);
   	   				insert.insertEscalade_cotation("5a-5c", iblock, itentatives, id_utilisateur);
   				}
   				else if (jrd3.isSelected()) {
   					int iblock = Integer.parseInt(block.getText());
   					int itentatives = Integer.parseInt(tentatives.getText());
   					InsertEscalade insert = new InsertEscalade("6a-6c", iblock, itentatives, id_utilisateur);
   	   				insert.insertEscalade_cotation("6a-6c", iblock, itentatives, id_utilisateur);
   				}
   				else if (jrd4.isSelected()) {
   					int iblock = Integer.parseInt(block.getText());
   					int itentatives = Integer.parseInt(tentatives.getText());
   					InsertEscalade insert = new InsertEscalade("7a-7c", iblock, itentatives, id_utilisateur);
   	   				insert.insertEscalade_cotation("7a-7c", iblock, itentatives, id_utilisateur);
   				}
   				else if (jrd5.isSelected()) {
   					int iblock = Integer.parseInt(block.getText());
   					int itentatives = Integer.parseInt(tentatives.getText());
   					InsertEscalade insert = new InsertEscalade("8a-8c", iblock, itentatives, id_utilisateur);
   	   				insert.insertEscalade_cotation("8a-8c", iblock, itentatives, id_utilisateur);
   				}
   				else if (jrd6.isSelected()) {
   					int iblock = Integer.parseInt(block.getText());
   					int itentatives = Integer.parseInt(tentatives.getText());
   					InsertEscalade insert = new InsertEscalade("9a-9b+", iblock, itentatives, id_utilisateur);
   	   				insert.insertEscalade_cotation("9a-9b+", iblock, itentatives, id_utilisateur);
   				}
   				
   				GraphEscaladeLine simu = new GraphEscaladeLine(id_utilisateur);
   				simulationdisplay.removeAll();
   				simulationdisplay.add(simu);
   				simulationdisplay.updateUI();   			
   			}
   		}
   	});
   	graphiqueButton.setBackground(Color.WHITE);
   graphiqueButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
    
    buttonsP.setPreferredSize(new Dimension(300,80));
    buttonsP.setLayout(new FlowLayout(10, 100, 10));
    buttonsP.setBackground(background);
   	buttonsP.add(graphiqueButton);
   	
   	this.add(cotationP);
   	this.add(blockP);
   	this.add(tentativesP );
   	this.add(buttonsP);
   	
	PanelComparaison comp = new PanelComparaison(id_utilisateur);
	   
   	this.add(comp.panelComparaison("CotationIHM"));
  }
}