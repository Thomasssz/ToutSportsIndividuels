package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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

import data.Utilisateur;
import requete.GestionUtilisateur;



@SuppressWarnings("serial")
public class Connexion extends JFrame
{
	private Utilisateur utilisateur;
	private JPanel global;
	private JPanel icon ,connexion;
	private JPanel log1, log2, controls;
	private JLabel iconSportsL;
	
	private JButton connect, create;

	private JTextField login;
	private JPasswordField password;
	
	private Color background = new Color(63, 149, 245);
	private int width = 500;
	private int height = 400;


	/**
	 * Constructeur de la classe Fenetre.
	 *
	 * Ce constructeur gère la disposition des éléments de l'accueil
	 */
	public Connexion(){
		this.setTitle("Sport2-Connexion");
		this.setSize(new Dimension(width, height));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setIconImage(new ImageIcon(getClass().getResource("../images/ballon.jpg")).getImage());

		//-------------- CONTENT PANE ------------------//
		global = new JPanel();
	    global.setPreferredSize(new Dimension(width, height));
		global.setBackground(background);
		global.setLayout(new FlowLayout());
		

		//-------------- CONNECT PAGE ------------------//
		displayElements();
		
		this.setContentPane(global);
		
		this.setVisible(true);
		pack();
	}


	private void displayElements()
	{
		/*JPanel back = new JPanel();
		back.setSize(width, height);
		back.setBackground(Color.WHITE);
		back.setLayout(new FlowLayout());
		global.add(back);*/
		
		/*section = new JPanel();
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
		connexion.setPreferredSize(new Dimension(300,75));
		connexion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		connexion.setLayout(new GridLayout(2, 1));

		log1 = new JPanel();
		log1.setBackground(Color.WHITE);
		log1.setLayout(new BorderLayout());
		log1.add(new JLabel("Login : "),BorderLayout.WEST);
		login = new JTextField(17);
		log1.add(login,BorderLayout.EAST);

		log2 = new JPanel();
		log2.setBackground(Color.WHITE);
		log2.setLayout(new BorderLayout());
		log2.add(new JLabel("Password : "),BorderLayout.WEST);
		password = new JPasswordField(17);
		password.setBackground(Color.WHITE);
		//password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//password.setFont(new Font("Verdana", Font.PLAIN, 16));
		//password.setForeground(Color.WHITE);
		//password.setCaretColor(Color.WHITE);
		log2.add(password,BorderLayout.EAST);
		
		connexion.add(log1);
		connexion.add(log2);

		controls = new JPanel();
		controls.setBackground(background);
		controls.setPreferredSize(new Dimension(400,80));
		controls.setLayout(new FlowLayout(10, 62, 20));

		connect = new JButton("Se connecter");
		connect.setBackground(Color.WHITE);
		connect.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		
		create = new JButton("Créer un compte");
		create.setBackground(Color.WHITE);
		create.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		
		controls.add(connect);
		controls.add(create);

	
		//connexion.add(controls);
		
		BufferedImage myPicture;
		try {
			URL url = getClass().getResource("../images/sports.jpg");
			File file = new File(url.getPath());
			myPicture = ImageIO.read(file);
			iconSportsL = new JLabel(new ImageIcon(myPicture));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		icon = new JPanel();
		icon.setBackground(background);
		icon.setLayout(new FlowLayout());
		icon.add(iconSportsL);

		global.add(icon);
		global.add(connexion);
		global.add(controls);
		
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
		@Override
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

					pageMenu(id_utilisateur);
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

	public void pageMenu(int id_utilisateur)
	{
		//global.add(new Connexion(), BorderLayout.CENTER);
		//global.repaint();
		new ContainerPanels(id_utilisateur);
		this.setVisible(false);
	}
	
	public static void main (String [] args) {
		new Connexion();
	}
}
