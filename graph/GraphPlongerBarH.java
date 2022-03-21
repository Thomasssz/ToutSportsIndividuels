package graph;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import data.PlongerSport;
import data.Profondeur_plonger;
import data.Sport;
import requete.ListSport;

public class GraphPlongerBarH extends JPanel {

	private static final long serialVersionUID = 1L;
	private int user ;
	//private ArrayList<Sport> sportList;

	public GraphPlongerBarH(String title,int user) {
		super();
		this.user = user;
		CategoryDataset dataset = createDataGolf();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(640, 480));
		add(chartPanel);


	}


	private CategoryDataset createDataGolf() {

		ArrayList<Sport> sportList = new ArrayList<>();
		ListSport sportLists = new ListSport(sportList);

		sportList=sportLists.arraySport("PlongerSport",user,"profondeur");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();


		int profondeur;
		float temps;
		String sProfondeur;
		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				PlongerSport w = (PlongerSport) element;

				for (Profondeur_plonger e : w.getProfondeur_plonger()) {
					profondeur=e.getProfondeur();
					temps=e.getTemps();
					sProfondeur=  String.valueOf(profondeur);
					dataset.addValue(temps, "temps", sProfondeur+ " metres");
					//dataset.addValue(coup_effectuer, "coup effectuer", nom_parcours);
					//dataset.add


				}
			}
		}
		return dataset;

	}

	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart(" Plonger", "Profondeur", "temps", dataset,
				PlotOrientation.HORIZONTAL, true, true, false); // cat =parcours et value = nombre de coup



		return chart;

	}
}
