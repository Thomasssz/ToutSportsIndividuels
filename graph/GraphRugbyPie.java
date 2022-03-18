package graph;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import data.GolfSport;
import data.RugbySport;
import data.Sport;
import data.Statistique_Rugby;
import data.Trou_golf;
import requete.ListSport;

public class GraphRugbyPie extends JFrame {

	private static final long serialVersionUID = 1L;
	String saison;
	int match;
	int essai;
	int plaquage;
	private int id_utilisateur;
	public GraphRugbyPie(String title,int id_utilisateur) {
		super(title);
		this.id_utilisateur = id_utilisateur;
		setContentPane(createDemoPanel());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;

	}

	private PieDataset createDataset() {

		ArrayList<Sport> sportList = new ArrayList<Sport>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("RugbySport",id_utilisateur,"statistique");
		System.out.println("graph+"+id_utilisateur);

		
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		

		
		if(!sportList.isEmpty())
		{
			for(int i = 0 ; i < sportList.size() ; i++)
			{
				RugbySport w = (RugbySport) sportList.get(i);

				for(int j = 0 ; j < w.getStatistique_rugby().size() ; j++)
				{
					Statistique_Rugby e = w.getStatistique_rugby().get(j);
					saison=e.getSaison();
					match=e.getNombre_match();
					essai=e.getEssai();
					plaquage=e.getPlaquage();
					
					dataset.setValue("match",match);
					dataset.setValue("essai",essai);
					dataset.setValue("plaquage",plaquage);


					
					
				}
			}
		}
	
		return dataset;
		
	/*	dataset.setValue("essai", new Double(55));
		dataset.setValue("Two", new Double(10.0));
		dataset.setValue("Three", new Double(27.5));
		dataset.setValue("Four", new Double(17.5));
		dataset.setValue("Five", new Double(11.0));
		dataset.setValue("Six", new Double(19.4));*/
		
		//return dataset;
	}

	private JFreeChart createChart(PieDataset dataset) {
		return ChartFactory.createPieChart("Saison "+saison, dataset, true, true, false);
	}

	public JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		GraphRugbyPie demo = new GraphRugbyPie("Rugby",3);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
}