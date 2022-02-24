package IHM;

import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.ui.RefineryUtilities;

import bd_init.DBConnection;
import data.Utilisateur;
import graph.GraphGolfPoint;
import requete.InsertGolf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;


import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Inscription extends JFrame {
  private JPanel container = new JPanel();
  private JTextField nom = new JTextField();
  private JLabel labelNom = new JLabel("Nom : ");
  private JTextField prenom = new JTextField();
  private JLabel labelPrenom = new JLabel("Prenom : ");
  private JTextField naissance = new JTextField();
  private JLabel labelNaissance = new JLabel("date de naissance : ");
  private JTextField login = new JTextField();
  private JLabel labelLogin = new JLabel("login : ");
  private JPasswordField password = new JPasswordField();

  private JLabel labelPassword = new JLabel("password : ");
  private  GridLayout  grid = new GridLayout(6, 0);
  
  private JButton btnSubmit,retour;




  public Inscription(){
	  
	    this.setTitle("Animation");
	    this.setSize(300, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setBackground(Color.white);
	    container.setLayout(grid);
    
    container.setBackground(Color.white);
    
   
    Font police = new Font("Arial", Font.BOLD, 14);
    
    nom.setFont(police);
    nom.setPreferredSize(new Dimension(150, 30));
    
    prenom.setFont(police);
    prenom.setPreferredSize(new Dimension(150, 30));
    
    naissance.setFont(police);
    naissance.setPreferredSize(new Dimension(150, 30));
    
    login.setFont(police);
    login.setPreferredSize(new Dimension(150, 30));
    
    password.setFont(police);
    password.setPreferredSize(new Dimension(150, 30));
    
    
  
    container.add(labelNom);
    container.add(nom);
    
    container.add(labelPrenom);
    container.add(prenom);
    
    container.add(labelNaissance);
    container.add(naissance);
    
    container.add(labelLogin);
    container.add(login);
    
    container.add(labelPassword);
    container.add(password);
    
    
    btnSubmit = new JButton("Submit");
	btnSubmit.setBounds(50, 10, 124, 21);
	container.add(btnSubmit);
	
	retour = new JButton("Cancel");
	retour.setBounds(184, 10, 85, 21);
	container.add(retour);
	
	btnSubmit.addActionListener(new AjoutUtilisateur());
	retour.addActionListener(new AjoutUtilisateur());

    this.setContentPane(container);
    this.setVisible(true);            
  }
  
  public class AjoutUtilisateur implements ActionListener {
		
		public void actionPerformed(ActionEvent e1) {
			String naissanceT=naissance.getText();
			String nomT=nom.getText();
			String prenomT=prenom.getText();
			String loginT=login.getText();
			String passwordT=password.getText();
		
			
			
			
			
				if(e1.getSource()== btnSubmit) {
					if (naissance.getText().isEmpty() && nom.getText().isEmpty() && prenom.getText().isEmpty() && login.getText().isEmpty() && password.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir tous les champs");
					}
					else {
						Session session = DBConnection.getSession();
						@SuppressWarnings("unused")
						Transaction persistTransaction1 = session.beginTransaction();
						Utilisateur u1 = new Utilisateur(nomT,prenomT,naissanceT,loginT,passwordT);
						session.save(u1);
					
					}
				}
			
				if(e1.getSource() == retour) {
					retour();					
				}
				
			}
		}
				
	
	
	public void retour()
	{
		//global.add(new Connexion(), BorderLayout.CENTER);
		//global.repaint();
		
		new Connexion();
		this.setVisible(false);
		

		
	}
	
		
		
}