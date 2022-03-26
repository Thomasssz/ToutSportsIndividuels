package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContainerPanels extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1238563082707942948L;

	private JPanel container;
	
	private Color background = new Color(63, 149, 245);
	private int width = 1000;
	private int height = 800;
  
	private int id_utilisateur;
	private JFrame frame;
	  
	public ContainerPanels(int id_utilisateur) {
		super();
		
		this.id_utilisateur = id_utilisateur;
		this.setTitle("Sport2-Menu");
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource("../images/ballon.jpg")).getImage());
		
		container = new JPanel();
		container.setPreferredSize(new Dimension(width, height));
		container.setBackground(background);
		container.setLayout(new FlowLayout());
		
		container.add(new Accueil(id_utilisateur, this));
		
		this.setContentPane(container);
		this.setVisible(true);
	}
	public void displayAccueil() {
		container.removeAll();
		container.add(new Accueil(id_utilisateur, this));
		container.updateUI();
		container.revalidate();
		container.repaint();		
	}
	public void displayMenu(String sport) {
		container.removeAll();
		container.add(new Menu(id_utilisateur, sport , this));
		container.updateUI();
		container.revalidate();
		container.repaint();
	}
	public void displayAmis() {
		container.removeAll();
		container.add(new PanelAmis(id_utilisateur));
		container.updateUI();
		container.revalidate();
		container.repaint();
	}

}
