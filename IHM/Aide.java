package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Aide extends JDialog{
		/**
	 * 
	 */
	private static final long serialVersionUID = 6827046515868517451L;
		private JTextArea aideT =new JTextArea();
		private JScrollPane jspAide;
		
		public Aide(JFrame frame) {
			super(frame, "Aide");
			this.setLayout(new GridLayout());
			
			aideT.setBackground(new Color(220,220,220));
			aideT.setFont(new Font("Arial", Font.BOLD, 15));
			aideT.setEditable(false);
			aideT.setLineWrap(true);
			aideT.setWrapStyleWord(true);
			
			jspAide=new JScrollPane(aideT);
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
}
