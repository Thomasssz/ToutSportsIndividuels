package IHM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Amis;
import data.Utilisateur;
import requete.GestionAmis;

public class PanelComparaison {
	private int id_utilisateur;
	private int id_amis;
	private GestionAmis ga = new GestionAmis();
	private Utilisateur utilisateur_amis;
	public PanelComparaison(int id_utilisateur) {
	this.id_utilisateur = id_utilisateur;

	}
	
	public JPanel panelComparaison(String sport) {
		JPanel comparaisonParameter = new JPanel();
	   	comparaisonParameter.setLayout(new GridLayout(1,0));
	   	JLabel comparer = new JLabel("Comparer à");
	   	JComboBox comboBox = new JComboBox(jlistAmis());
	   	JButton comparerButton = new JButton("Comparer");
	   	
	   	comparaisonParameter.add(comparer);
	   	comparaisonParameter.add(comboBox);
	   	comparaisonParameter.add(comparerButton);
	   	
	   	comparerButton.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
				  utilisateur_amis = ga.findUser((String) comboBox.getSelectedItem());
				  id_amis = utilisateur_amis.getId_utilisteur();
					new Comparaison(id_utilisateur,id_amis,sport,(String) comboBox.getSelectedItem());
				// System.out.println( comboBox.getSelectedItem());
			  	}
		});
	   	return comparaisonParameter;
	}
	
	public String [] jlistAmis() {
		  String listElem[]= {}; 

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
}
