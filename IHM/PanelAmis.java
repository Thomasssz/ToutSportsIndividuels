package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.primefaces.component.button.Button;

import data.Amis;
import data.Sport;
import data.Utilisateur;
import graph.GraphCourseBar;
import graph.GraphCourseLine;
import graph.GraphGolfBar;
import graph.GraphGolfPoint;
import graph.GraphPlongerAreaLine;
import graph.GraphPlongerBarH;
import graph.GraphRugbyLine;
import graph.GraphRugbyPie;
import requete.GestionAmis;
import requete.GestionUtilisateur;


public class PanelAmis extends JPanel {
	private Utilisateur utilisateur;
	private Utilisateur amis,ajoutAmis;

	// private JFrame frame;
	 private JPanel container, listAmis, recherche,info,demandeAmis;
	 private JPanel panLigneDemande [] ;
	 private JButton ajout,suppr,rechercher,afficher;
	 private JButton [] btnAccepter,btnRefuser;

  
	private JLabel lblNewLabel,lblRechercheAmis,lblInfo,lblDemande,lblDemande2;
	private JLabel[] nomLoginDemande;
	private JTextField rechercheAmis;

  private Color background = new Color(63, 149, 245);
  private Color background2 = new Color(0, 255, 0);

  private int width = 1000;
  private int height = 800;
  
  private int id_utilisateur;

 

  private String listElem[]= {}; 
  private String listDemandeAmis[]= {}; 


  private JList list;
  private  GridLayout  grid = new GridLayout(2,0);
private int j=0;
  
  public PanelAmis(int id_utilisateur){
	super();
	//frame=this;
	this.id_utilisateur = id_utilisateur;

	/*frame.setTitle("Sport2-Menu");
	frame.setSize(width, height);
	frame.setMaximumSize(new Dimension(width,height));
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);*/
 
	//-------------- CONTENT PANE ------------------//
    container = new JPanel();
    container.setPreferredSize(new Dimension(width, height));
    container.setBackground(background);
    container.setLayout(null);
   
    
    listAmis=new JPanel();
	listAmis.setLayout(new BorderLayout( ));
	listAmis.setBounds((int) (width*0.05), 75, (int) (width*0.40), 405);
	listAmis.setBorder(new LineBorder(new Color(0, 0, 0), 3));
	listAmis.setBackground(new Color(255, 255, 255));
	
	 
	     
    
	   list = new JList(jlistAmis());
	   list.setOpaque(false);
	   list.setBackground(new Color(255, 255, 255));
	   list.setForeground(Color.BLACK);
	   list.setFont(new Font("Times New Roman", Font.PLAIN, 14));   
	       
	  JScrollPane pane = new JScrollPane(list);
	  pane.setOpaque(false);
	  pane.getViewport().setOpaque(false);
	  listAmis.add(pane, BorderLayout.CENTER);
	  
	  JPanel panTitreAmis = new JPanel();
		lblNewLabel = new JLabel("Liste d'amis");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(60, 22, 279, 21);
		panTitreAmis.add(lblNewLabel);
		listAmis.add(panTitreAmis,BorderLayout.NORTH);
		
		JPanel zoneBtnAfficher = new JPanel();
		  zoneBtnAfficher.setLayout(new GridLayout(0,1));

		  afficher = new JButton("Afficher");
		  zoneBtnAfficher.add(afficher);
		  listAmis.add(zoneBtnAfficher,BorderLayout.SOUTH);
   
	  container.add(listAmis);
	  
	  
	  //panel recherche d'amis
	  recherche = new JPanel();
	  recherche.setLayout(new BorderLayout());
	  recherche.setBorder(new LineBorder(new Color(0, 0, 0), 3));
	  recherche.setBackground(new Color(255, 255, 255));
	  recherche.setBounds((int) (width*0.55), 75, (int) (width*0.40), 100);
	  
	  lblRechercheAmis = new JLabel("Rechercher un amis");
	  rechercheAmis = new JTextField();
	  
	  JPanel btnRechercher = new JPanel();
	  btnRechercher.setLayout(new GridLayout(0,1));

	  rechercher = new JButton("Rechercher");
	  btnRechercher.add(rechercher);
	
	  JPanel zoneRecherche = new JPanel();
	  zoneRecherche.setLayout(new GridLayout(0,2));
	  zoneRecherche.add(lblRechercheAmis);
	  zoneRecherche.add(rechercheAmis);
	 // recherche.add(lblRechercheAmis);
	  recherche.add(zoneRecherche);
	  recherche.add(btnRechercher,BorderLayout.SOUTH);
	  
	  container.add(recherche);
		
	//info panel
	  info = new JPanel();
	  info.setLayout( new BorderLayout());
	  info.setBorder(new LineBorder(new Color(0, 0, 0), 3));
	  info.setBackground(new Color(255, 255, 255));
	  info.setBounds((int) (width*0.55), 180, (int) (width*0.40), 300);
	  
	  lblInfo = new JLabel("");
	  
	  
	  info.add(lblInfo);
	  container.add(info);

	  
	  demandeAmis = new JPanel();
		demandeAmis.setLayout(new BorderLayout( ));
		demandeAmis.setBounds((int) (width*0.05), 490, (int) (width*0.40), 200);
		demandeAmis.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		demandeAmis.setBackground(new Color(255, 255, 255));
		
		JPanel panDemande = new JPanel();
		lblDemande = new JLabel("Demande d'amis");
		panDemande.add(lblDemande);
		demandeAmis.add(panDemande,BorderLayout.NORTH);
		
		JPanel panLoginDemande = new JPanel();
		panLoginDemande.setLayout(new GridLayout(0,1));
		panLoginDemande.setBackground(new Color(255, 255, 255));
		
		
		GestionAmis ga = new GestionAmis();
	 	ArrayList<Amis> amisList = new ArrayList<>();
	    amisList = ga.arrayDemandeAmis(id_utilisateur);
		listDemandeAmis=new String[amisList.size()];
		btnAccepter = new JButton[amisList.size()];
		btnRefuser = new JButton[amisList.size()];
		nomLoginDemande = new JLabel[amisList.size()];
		panLigneDemande = new JPanel[amisList.size()];
		
		for(int i=0 ; i<amisList.size() ; i++) {
			if (amisList.get(i).getAccepter() == 0) {
			panLigneDemande[i] = new JPanel();
			panLigneDemande[i].setLayout(new GridLayout(0,3));
			panLigneDemande[i].setName(""+i);
			
			nomLoginDemande[i] = new JLabel(amisList.get(i).getUtilisateur().getLogin());
			panLigneDemande[i].add(nomLoginDemande[i]);
			btnAccepter[i] = new JButton("Accepter");
			btnRefuser[i] = new JButton("Refuser");
			btnAccepter[i].setName(nomLoginDemande[i].getText());
			panLigneDemande[i].setName(nomLoginDemande[i].getText());
			btnRefuser[i].setName(nomLoginDemande[i].getText());
			panLigneDemande[i].add(btnAccepter[i]);
			panLigneDemande[i].add(btnRefuser[i]);

			panLoginDemande.add(panLigneDemande[i]);
			
			btnAccepter[i].addActionListener(new ActionListener() {
				  @Override
				  public void actionPerformed(ActionEvent e) {
					  Object source = e.getSource();

					  GestionAmis ga = new GestionAmis();
						GestionUtilisateur gm = new GestionUtilisateur();
					 	ArrayList<Amis> amisDemandeList = new ArrayList<>();
					 	ArrayList<Amis> amisList = new ArrayList<>();

						  
					     if (source instanceof JButton) {
					        JButton button = (JButton) source;
					        String login = button.getName();
					        String panelLogin; 

					      //  System.out.println(login);		
					        
					        amisDemandeList = ga.arrayDemandeAmis(id_utilisateur);
						    amis = ga.findUser(login);
							utilisateur = gm.findID(id_utilisateur);

							ga.addAmis(amis, utilisateur);//ajout de l'amis apres avoir accepter
							amisList = ga.arrayAmis(id_utilisateur);
							
							
						  
								  JPanel panTitreAmis = new JPanel();
									lblNewLabel = new JLabel("Liste d'amis");
									lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
									lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
									lblNewLabel.setForeground(Color.BLACK);
									lblNewLabel.setBounds(60, 22, 279, 21);
									
								  list = new JList(jlistAmis());
								   list.setOpaque(false);
								   list.setBackground(new Color(255, 255, 255));
								   list.setForeground(Color.BLACK);
								   list.setFont(new Font("Times New Roman", Font.PLAIN, 14));   
								  JScrollPane pane = new JScrollPane(list);
								  pane.setOpaque(false);
								  pane.getViewport().setOpaque(false);
								  JPanel zoneBtnAfficher = new JPanel();
								  zoneBtnAfficher.setLayout(new GridLayout(0,1));
								  afficher = new JButton("Afficher");
								  zoneBtnAfficher.add(afficher);
								  listAmis.removeAll();
								  listAmis.add(pane, BorderLayout.CENTER);
								  listAmis.add(zoneBtnAfficher,BorderLayout.SOUTH);

								  panTitreAmis.add(lblNewLabel);
								  afficher.addActionListener(new Fonction());

									listAmis.add(panTitreAmis,BorderLayout.NORTH);
									listAmis.updateUI();
									listAmis.revalidate();
									listAmis.repaint();
									
									for (int i = 0; i<amisDemandeList.size(); i++) {
										panelLogin = panLigneDemande[i].getName();

										if (panLigneDemande[i].getName() == login) {
											panLigneDemande[i].removeAll();
											panLigneDemande[i].updateUI();
											panLigneDemande[i].revalidate();
											panLigneDemande[i].repaint();
										}
									}
									 
									
					     }
				  }
					  
			});
			btnRefuser[i].addActionListener(new ActionListener() {
				  @Override
				  public void actionPerformed(ActionEvent e) {
					  System.out.println("Refuser");
					  Object source = e.getSource();

					  GestionAmis ga = new GestionAmis();
						GestionUtilisateur gm = new GestionUtilisateur();
					 	ArrayList<Amis> amisDemandeList = new ArrayList<>();
					 	//ArrayList<Amis> amisList = new ArrayList<>();

						  
					     if (source instanceof JButton) {
					        JButton button = (JButton) source;
					        String login = button.getName();
					        String panelLogin; 

					      //  System.out.println(login);		
					        
					        amisDemandeList = ga.arrayDemandeAmis(id_utilisateur);
						    amis = ga.findUser(login);
							utilisateur = gm.findID(id_utilisateur);

							//ga.addAmis(amis, utilisateur);//ajout de l'amis apres avoir accepter
							//ga.deleteAmis(amis, utilisateur);//ajout de l'amis apres avoir accepter
							ga.deleteAmis(utilisateur,amis );//ajout de l'amis apres avoir accepter
							
							for (int i = 0; i<amisDemandeList.size(); i++) {
								panelLogin = panLigneDemande[i].getName();
								//System.out.println(panelLogin+ "   "+ login);
								System.out.println(panelLogin);

								//amisDemandeList.remove(amisDemandeList.get(i));

								if (panLigneDemande[i].getName() == login) {
									panLigneDemande[i].removeAll();
									panLigneDemande[i].updateUI();
									panLigneDemande[i].revalidate();
									panLigneDemande[i].repaint();
								}
								//System.out.println("apres supppr  "   +amisDemandeList);


							}
						}
				  	}
					  
				  });
			
			}
			
		}
		
		
		demandeAmis.add(panLoginDemande);
		
	  
	container.add(demandeAmis);

	  rechercher.addActionListener(new Fonction());
	  afficher.addActionListener(new Fonction());
	  this.add(container);
    //frame.setContentPane(container);
   // frame.setVisible(true);
  }

  public String [] jlistAmis() {
	  GestionAmis ga = new GestionAmis();
	    
		
	 	ArrayList<Amis> amisList = new ArrayList<>();

	     amisList = ga.arrayAmis(id_utilisateur);
	    // System.out.println(amisList);
	     
	 
	     
			listElem=new String[amisList.size()];
			for(int i=0 ; i<amisList.size() ; i++) {
				if (amisList.get(i).getAccepter() == 1) {
					if(amisList.get(i).getAmis().getId_utilisteur() == id_utilisateur) {
						listElem[i] = amisList.get(i).getUtilisateur().getLogin();
					}
					else {
						listElem[i]=amisList.get(i).getAmis().getLogin();
					}
				}
			}
			return listElem;
  }
  
 
  

 /* public static void main(String[] args) {

	  new PanelAmis(1);

	  

  }	*/
  
  public class Fonction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e1) {
			GestionAmis ga = new GestionAmis();
			GestionUtilisateur gm = new GestionUtilisateur();
			String nomAmis=rechercheAmis.getText();
			//Amis dejaAmis = new Amis();
			if(e1.getSource() == rechercher) {

				if ((nomAmis.isEmpty())) {
					JOptionPane.showMessageDialog(null, "Veuillez saisir un login utilisateur");
				}
				else {
					amis = ga.findUser(nomAmis);

					if(amis == null)
						JOptionPane.showMessageDialog(null, "Utilisateur n'existe pas");
					else {
						lblInfo.setVerticalAlignment(SwingConstants.NORTH);
						lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
						lblInfo.setFont(new Font("Verdana", Font.BOLD,20));
						lblInfo.setText("<html><body><p>Nom: "+amis.getNom()+ "</p>"+
						    	 "<p>Prénom:"+ amis.getPrenom()+"</p>"+
						    	 			"<p> Login: "+amis.getLogin()+"</p>"+
						    	 			"<p> Date de naissance : "+amis.getDate_naissance()+" </p>"+
											"</body></html>");
						JPanel butonInfo = new JPanel();
						butonInfo.setLayout(new GridLayout(1, 0));
						ajout = new JButton("Ajouter à mes amis");
						//suppr = new JButton("Supprimer");
 
						  info.removeAll();
							butonInfo.add(ajout);

						info.add(butonInfo,BorderLayout.SOUTH);
						info.add(lblInfo);

						info.updateUI();
						info.revalidate();
						info.repaint();

						 ajout.addActionListener(new ActionListener() {
							  @Override
							  public void actionPerformed(ActionEvent e) {
								  int id_amis;
								  id_amis = amis.getId_utilisteur();
								  ajoutAmis = ga.findIdAmis(id_amis,id_utilisateur);
								  utilisateur = gm.findID(id_utilisateur);
								  //dejaAmis = 
								  int cas1;
								  int cas2;
								  

								  if (ajoutAmis == null ) {
									  if (amis.getId_utilisteur() == utilisateur.getId_utilisteur()) {
											JOptionPane.showMessageDialog(null, "Vous ne pouvez pas vous ajouter vous meme a votre liste d'amis");

									  }
									 /* else if (ga._) {
											JOptionPane.showMessageDialog(null, "Utilisateur est deja dans votre liste d'amis22");

									  }*/
									  else {
										  cas1 =  ga.dejaAmis(amis,utilisateur);
											 //System.out.println("test deja amis"+cas1);
											 
											  cas2 =  ga.dejaAmis(utilisateur,amis);
												 //System.out.println("test deja amis deuxieme"+cas2);
											  if(cas1 == 1 || cas2 == 1) {
													JOptionPane.showMessageDialog(null, "Utilisateur est deja dans votre liste d'amis");

											  }
											  else {


										  int a = ga.requeteAmis(amis, utilisateur);
										 // System.out.println(a);
											JOptionPane.showMessageDialog(null, "Requete d'amis envoyé");
											
											  }

										  
									
									  }
									  
								  }
								  else {
										JOptionPane.showMessageDialog(null, "Utilisateur est deja dans votre liste d'amis");

								  }
								  
							  }
						  });
						 
						

					}
				}
				
			}
			else if (e1.getSource() == afficher) {
				String loginAmis;
				if(!list.isSelectionEmpty()) {
				    loginAmis = (String) list.getSelectedValue();
					//System.out.println(loginAmis);
					amis = ga.findUser(loginAmis);
					
					lblInfo.setVerticalAlignment(SwingConstants.NORTH);
					lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
					lblInfo.setFont(new Font("Verdana", Font.BOLD,20));
					lblInfo.setText("<html><body><p>Nom: "+amis.getNom()+ "</p>"+
					    	 "<p>Prénom:"+ amis.getPrenom()+"</p>"+
					    	 			"<p> Login: "+amis.getLogin()+"</p>"+
					    	 			"<p> Date de naissance : "+amis.getDate_naissance()+" </p>"+
										"</body></html>");
					
					JPanel butonInfo = new JPanel();
					butonInfo.setLayout(new GridLayout(1, 0));
					suppr = new JButton("Supprimer de mes amis");
					  
					info.removeAll();
					butonInfo.add(suppr);
					info.add(butonInfo,BorderLayout.SOUTH);
					info.add(lblInfo);

				info.updateUI();
				info.revalidate();
				info.repaint();
				
				
					suppr.addActionListener(new ActionListener() {
						  @Override
						  public void actionPerformed(ActionEvent e) {
							  utilisateur = gm.findID(id_utilisateur);

							  ga.deleteAmis(amis, utilisateur);
							  ga.deleteAmis(utilisateur,amis );

							//System.out.println("amis "+amis);

							  JPanel panTitreAmis = new JPanel();
								lblNewLabel = new JLabel("Liste d'amis");
								lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
								lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel.setForeground(Color.BLACK);
								lblNewLabel.setBounds(60, 22, 279, 21);
								
							  list = new JList(jlistAmis());
							   list.setOpaque(false);
							   list.setBackground(new Color(255, 255, 255));
							   list.setForeground(Color.BLACK);
							   list.setFont(new Font("Times New Roman", Font.PLAIN, 14));   
							  JScrollPane pane = new JScrollPane(list);
							  pane.setOpaque(false);
							  pane.getViewport().setOpaque(false);
							  JPanel zoneBtnAfficher = new JPanel();

							  zoneBtnAfficher.setLayout(new GridLayout(0,1));
							  afficher = new JButton("Afficher");
							  zoneBtnAfficher.add(afficher);
							  listAmis.removeAll();
							  listAmis.add(pane, BorderLayout.CENTER);
							  listAmis.add(zoneBtnAfficher,BorderLayout.SOUTH);
							  panTitreAmis.add(lblNewLabel);
							  afficher.addActionListener(new Fonction());
								listAmis.add(panTitreAmis,BorderLayout.NORTH);
								listAmis.updateUI();
								listAmis.revalidate();
								listAmis.repaint();
						  }
					 });

					list.clearSelection(); 
		   		}
			}

			container.repaint();
		}
  }
  
}

