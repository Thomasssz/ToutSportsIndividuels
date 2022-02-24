package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.primefaces.component.button.Button;

import data.Utilisateur;
import net.sf.cglib.asm.Label;
import requete.GestionUtilisateur;



@SuppressWarnings("serial")
public class Connexion extends JFrame
{
	private Utilisateur utilisateur;
	private static JPanel global;
	private JPanel section, connexion;
	private JPanel log1, log2, controls;
	
	private JButton connect, create;
	
	private JTextField login;
	private JPasswordField password;
	
	private int width = 500;
	private int height = 500;
	
	
	/**
	 * Constructeur de la classe Fenetre.
	 * 
	 * Ce constructeur gère la disposition des éléments de l'accueil
	 */
	public Connexion(){
		this.setTitle("Test Sport2");
		this.setSize(width, height);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		//-------------- CONTENT PANE ------------------//
		global = new JPanel();
	    global.setPreferredSize(new Dimension(width, height));
		global.setBackground(Color.CYAN);
		global.setLayout(new BorderLayout());
		this.setContentPane(global);
		
		
		//-------------- CONNECT PAGE ------------------//		
		displayElements();
		
		this.setVisible(true);
		pack();
	}
	

	private void displayElements()
	{
		JPanel back = new JPanel();
		back.setSize(width, height);
		back.setBackground(Color.WHITE);
		back.setLayout(null);
		global.add(back);		
		
		section = new JPanel();
		section.setBounds(100, 50, width-200, height-200);
		section.setBackground(Color.WHITE);
		section.setLayout(new GridLayout(3, 1));
		back.add(section);
		
	/*	header = new JPanel();
		header.setBackground(Color.WHITE);
		header.setLayout(new BorderLayout());
		header.add(new JLabel(""), BorderLayout.NORTH);
		title = new JLabel("Sport");
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		header.add(title, BorderLayout.CENTER);
		section.add(header);*/
		
		connexion = new JPanel();
		connexion.setBackground(Color.WHITE);
		connexion.setLayout(new GridLayout(3, 1));		

		log1 = new JPanel();
		log1.setBackground(Color.WHITE);
		log1.add(new JLabel("login : "));
		login = new JTextField(17);
		log1.add(login);
		
		log2 = new JPanel();
		log2.setBackground(Color.WHITE);
		log2.add(new JLabel("Mot de passe : "));
		password = new JPasswordField(17);
		password.setBackground(Color.WHITE);
		//password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//password.setFont(new Font("Verdana", Font.PLAIN, 16));
		//password.setForeground(Color.WHITE);
		//password.setCaretColor(Color.WHITE);
		log2.add(password);
		
		controls = new JPanel();
		controls.setBackground(Color.WHITE);
		controls.setLayout(new FlowLayout());
		
		connect = new JButton("Se connecter");
		create = new JButton("Créer un compte");		
		controls.add(connect);
		controls.add(create);
		
		connexion.add(log1);
		connexion.add(log2);
		connexion.add(controls);
		section.add(connexion);
		
		connect.addActionListener(new ButtonListener());
		create.addActionListener(new ButtonListener());
	}
	
	/**
	 * Cette méthode permet de réinitialiser l'accueil
	 */
	
	
	
	

	
	
	/**
	 * Ecouteur associé aux boutons "cycle", "proteine" et "heritage" du panneau de commandes.
	 * 
	 * Chacun des boutons déclenche l'affichage du panel d'accès aux activités
	 */
	private class ButtonListener implements ActionListener
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) 
		{
			int id_utilisateur;
			if(e.getSource() == connect)
			{
				GestionUtilisateur um = new GestionUtilisateur();
				utilisateur = um.findUser(login.getText(), password.getText());
				
				id_utilisateur = um.findID(login.getText(), password.getText());
				if(utilisateur == null)
					JOptionPane.showMessageDialog(null, "Utilisateur inexistant");
				else
				{
					//global.removeAll();
					
					new Menu(id_utilisateur);
				}
				
			}
			else if(e.getSource() == create)
			{
				//global.removeAll();
			//	global.add(new Inscription(), BorderLayout.CENTER);
			//	global.repaint();
				pageInscription();
			}

			//global.revalidate();	
		}
	}
	
	public void pageInscription(){
		
		
		new Inscription();
		this.setVisible(false);
		
	}
	
	/*public void pageMenu()
	{
		//global.add(new Connexion(), BorderLayout.CENTER);
		//global.repaint();
		
		new Menu(id_utilisateur);
		this.setVisible(false);
		

		
	}*/
	
		
	
	
	public static void main (String [] args) {
		new Connexion();
	}
		
	
	

}
