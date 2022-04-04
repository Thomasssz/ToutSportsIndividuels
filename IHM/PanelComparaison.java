package IHM;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Amis;
import requete.GestionAmis;

public class PanelComparaison {
	private int id_utilisateur;
	public PanelComparaison(int id_utilisateur) {
	this.id_utilisateur = id_utilisateur;

	}
	
	public JPanel panelComparaison() {
		JPanel comparaisonParameter = new JPanel();
	   	comparaisonParameter.setLayout(new GridLayout(1,0));
	   	JLabel comparer = new JLabel("Comparer à");
	   	JComboBox comboBox = new JComboBox(jlistAmis());
	   	JButton comparerButton = new JButton("Comparer");
	   	
	   	comparaisonParameter.add(comparer);
	   	comparaisonParameter.add(comboBox);
	   	comparaisonParameter.add(comparerButton);
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
