package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Aide extends JDialog{
		/**
	 * 
	 */
	private static final long serialVersionUID = 6827046515868517451L;
		private JTextArea aideT =new JTextArea();
		private JScrollPane jspAide;
		private JPanel aideP;
		private JLabel iconescalade;
		
		public Aide(JFrame frame) {
			super(frame, "Aide");

			
			aideP = new JPanel();
			//aideP.setSize(new Dimension(280,280));
			aideP.setLayout(new BorderLayout());
			
			aideT.setBackground(new Color(220,220,220));
			aideT.setFont(new Font("Arial", Font.BOLD, 15));
			aideT.setEditable(false);
			aideT.setLineWrap(true);
			aideT.setWrapStyleWord(true);
			
			aideP.add(aideT,BorderLayout.NORTH);
			
			jspAide=new JScrollPane(aideP);
			jspAide.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jspAide.setPreferredSize(new Dimension(300,300));

			this.add(jspAide);
			this.pack();
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
		public void aideAccueil() {
			aideT.setText("Voici l'accueil de notre application.\n\n"
					+ "Vous pouvez choisir des sports pour renseigner vos performances.\n\n"
					+ "Vous deconnecter.\n\n"
					+ "Ajouter des amis.\n\n"
					+ "Comparer sur notre reseau social vos performances par rapport a vos amis.");	
		}
		public void aideMenu() {
			aideT.setText("Voici le menu de notre application.\n\n"
					+ "Vous pouvez choisir des parametres selon le sports.\n\n"
					+ "Renseigner vos performances.\n\n"
					+ "Vous deconnecter.\n\n"
					+ "Comparer sur notre reseau social vos performances par rapport a vos amis.");	
		}
		public void escalade() { 
			try {
				iconescalade = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("../images/cotations.jpg"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
			aideP.add(iconescalade);
		}
}
