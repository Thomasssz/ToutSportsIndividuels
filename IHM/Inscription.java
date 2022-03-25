package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd_init.DBConnection;
import data.Utilisateur;
import requete.GestionUtilisateur;

public class Inscription extends JFrame {
	private Utilisateur utilisateur;

  private JPanel container = new JPanel();
  private JPanel inscription = new JPanel();
  
  private JPanel nomP = new JPanel();
  private JTextField nom = new JTextField(17);
  private JLabel labelNom = new JLabel("Nom : ");
  
  private JPanel prenomP = new JPanel();
  private JTextField prenom = new JTextField(17);
  private JLabel labelPrenom = new JLabel("Prenom : ");
  
  private JPanel naissanceP = new JPanel();
  private JTextField naissance = new JTextField(17);
  private JLabel labelNaissance = new JLabel("Date de naissance : ");
  
  private JPanel loginP = new JPanel();
  private JTextField login = new JTextField(17);
  private JLabel labelLogin = new JLabel("Login : ");
  
  private JPasswordField password = new JPasswordField(17);
  private JPanel passwordP = new JPanel();
  private JLabel labelPassword = new JLabel("Password : ");
  
  private JPanel buttonsP = new JPanel();
  private JButton btnSubmit,retour;

  private Color background = new Color(63, 149, 245);
  private int width = 500;
  private int height = 400;


  public Inscription(){
	  
    this.setTitle("Sports2");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	this.setSize(new Dimension(width, height));
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setLayout(new FlowLayout());
    this.setIconImage(new ImageIcon(getClass().getResource("../images/ballon.jpg")).getImage());
	
    Font police = new Font("Arial", Font.BOLD, 14);
    
    container.setPreferredSize(new Dimension(width, height));
    container.setBackground(background);
   // container.setLayout(new GridLayout(6,1));
    container.setLayout(new FlowLayout(10, 50, 20));
    
    inscription.setLayout(new GridLayout(5,1));
    inscription.setPreferredSize(new Dimension(380, 180));
    
    nom.setFont(police);
    prenom.setFont(police);
    naissance.setFont(police);
    login.setFont(police);
    password.setFont(police);

    nomP.setLayout(new BorderLayout());
    nomP.add(labelNom,BorderLayout.WEST);
    nomP.add(nom,BorderLayout.EAST);
    
    prenomP.setLayout(new BorderLayout());
    prenomP.add(labelPrenom,BorderLayout.WEST);
    prenomP.add(prenom,BorderLayout.EAST);
    
    naissanceP.setLayout(new BorderLayout());
    naissanceP.add(labelNaissance,BorderLayout.WEST);
    naissanceP.add(naissance,BorderLayout.EAST);

    loginP.setLayout(new BorderLayout());
    loginP.add(labelLogin,BorderLayout.WEST);
    loginP.add(login,BorderLayout.EAST);

    passwordP.setLayout(new BorderLayout());
    passwordP.add(labelPassword,BorderLayout.WEST);
    passwordP.add(password,BorderLayout.EAST);

    buttonsP.setBackground(background);
    buttonsP.setPreferredSize(new Dimension(400,80));
    buttonsP.setLayout(new FlowLayout(10, 90, 30));
    
    btnSubmit = new JButton("Submit");
	//btnSubmit.setBounds(50, 10, 124, 21);
	btnSubmit.setBackground(Color.WHITE);
	btnSubmit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
	buttonsP.add(btnSubmit);

	retour = new JButton("Cancel");
	//retour.setBounds(184, 10, 85, 21);
	retour.setBackground(Color.WHITE);
	retour.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
	buttonsP.add(retour);

	btnSubmit.addActionListener(new AjoutUtilisateur());
	retour.addActionListener(new AjoutUtilisateur());
	
	inscription.add(nomP);
	inscription.add(prenomP);
	inscription.add(naissanceP);
	inscription.add(loginP);
	inscription.add(passwordP);
	
	container.add(inscription);
	container.add(buttonsP);
	
    this.setContentPane(container);
    this.setVisible(true);
  }

  public class AjoutUtilisateur implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e1) {
			String naissanceT=naissance.getText();
			String nomT=nom.getText();
			String prenomT=prenom.getText();
			String loginT=login.getText();
			String passwordT=password.getText();

				if(e1.getSource()== btnSubmit) {
					if ((naissance.getText().isEmpty()) || (nom.getText().isEmpty()) || (prenom.getText().isEmpty()) || (login.getText().isEmpty()) || (password.getText().isEmpty() )) {
						JOptionPane.showMessageDialog(null, "Veuillez saisir tous les champs");
					}
					else {
						GestionUtilisateur um = new GestionUtilisateur();
						utilisateur = um.findUser(login.getText(), password.getText());

						if(utilisateur != null)
							JOptionPane.showMessageDialog(null, "Utilisateur deja existant");
						else
						{
							Session session = DBConnection.getSession();
							@SuppressWarnings("unused")
							Transaction persistTransaction1 = session.beginTransaction();
							Utilisateur u1 = new Utilisateur(nomT,prenomT,naissanceT,loginT,passwordT);
							session.save(u1);
						}
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