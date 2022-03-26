package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.primefaces.component.graphicimage.GraphicImageRenderer;

public class Accueil extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -801736552171033117L;
	private JPanel container, sports, header, btnReseauSocialP, deconnexion, aide, golf, plongee, rugby , course, escalade, menu;
	
	private URL golfIcon, plongeeIcon, rugbyIcon, courseIcon, escaladeIcon;
	private JButton golfBtn = new JButton("    GOLF   ");
	private JButton plongeeBtn = new JButton(" PLONGEE ");
	private JButton rugbyBtn = new JButton("   RUGBY   ");
	private JButton courseBtn = new JButton("  COURSE  ");
	private JButton escaladeBtn = new JButton("ESCALADE");
	
	  private Color background = new Color(63, 149, 245);
	  private int width = 1000;
	  private int height = 800;
	  
	  private int id_utilisateur;
	  private JFrame frame;

	  
	public Accueil (int id_utilisateur, JPanel menu, JFrame frame) {

		this.id_utilisateur = id_utilisateur;
		this.menu = menu;
		this.frame = frame;
		
		this.setSize(width, height);

		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(background);
		this.setLayout(new  FlowLayout(FlowLayout.CENTER));
	    
	    header = new JPanel();
	    header.setBackground(background);
	    header.setSize(new Dimension(1000,100));
	    header.setLayout(new GridLayout(1,3));
		
	    displayReseauSocial();
	    displayDeconnexion();
	    displayAide();
	    this.add(header);
	    
	    displaySports();
	}
	private void displayReseauSocial() {
		btnReseauSocialP = new JPanel();
		btnReseauSocialP.setBackground(background);
		btnReseauSocialP.setSize(new Dimension(100,60));
		btnReseauSocialP.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
		
		JButton btnReseauSocial = new JButton("Reseau Social");
		btnReseauSocial.setBackground(Color.WHITE);
		btnReseauSocial.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		
		btnReseauSocialP.add(btnReseauSocial);
		header.add(btnReseauSocialP);
		
		btnReseauSocial.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		  menu.removeAll();
		  menu.add(new PanelAmis(id_utilisateur));
		  menu.updateUI();
		  menu.revalidate();
		  menu.repaint();
	  	}
	  
	  });
	}
	private void displayDeconnexion() {
		deconnexion = new JPanel();
		deconnexion.setBackground(background);
		deconnexion.setSize(new Dimension(100,60));
		deconnexion.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBackground(Color.WHITE);
		btnDeconnexion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		
		deconnexion.add(btnDeconnexion);
		header.add(deconnexion);
		
		btnDeconnexion.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
				  	frame.dispose();
					new Connexion();
			  	}
		});
	}
	private void displayAide() {
		aide = new JPanel();
		aide.setBackground(background);
		aide.setSize(new Dimension(100,60));
		aide.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
		
		JButton btnAide = new JButton("Aide");
		btnAide.setBackground(Color.WHITE);
		btnAide.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		
		aide.add(btnAide);
		header.add(aide);
		
		btnAide.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
					//new Aide();
			  	}
		});
	}
	public void displaySports() {
		sports = new JPanel();
		sports.setBackground(background);
		sports.setSize(new Dimension(800,700));
		sports.setLayout(new GridLayout(3,2, 0, 20));
		
		golfIcon = displayImage("golf");
		plongeeIcon = displayImage("plongee");
		rugbyIcon = displayImage("rugby");
		courseIcon = displayImage("course");
		escaladeIcon = displayImage("escalade");
		
		golf = new PaintedPanel(golfIcon, golfBtn);
		plongee = new PaintedPanel(plongeeIcon, plongeeBtn);
		rugby = new PaintedPanel(rugbyIcon, rugbyBtn);
		course = new PaintedPanel(courseIcon, courseBtn);
		escalade = new PaintedPanel(escaladeIcon, escaladeBtn);
		
		sports.add(golf);
		sports.add(plongee);
		sports.add(rugby);
		sports.add(course);
		sports.add(escalade);
		
		this.add(sports);
	}
	public URL displayImage(String sport) {
		return getClass().getResource("../images/" + sport + ".jpg");
	}
}