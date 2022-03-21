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
import org.jfree.data.time.TimeTableXYDataset;

import data.GolfSport;
import data.Sport;
import data.Trou_golf;
import requete.ListSport;

public class GraphGolfBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private int user;

	//private ArrayList<Sport> sportList;

	public GraphGolfBar(String title,int user) {
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
		sportList=sportLists.arraySport("GolfSport",user,"coup");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		TimeTableXYDataset dataset2 = new TimeTableXYDataset();


		String nom_parcours;
		int coup;
		int coup_effectuer;

		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				GolfSport w = (GolfSport) element;

				for (Trou_golf e : w.getTrou_golf()) {
					nom_parcours=e.getNom_parcours();
					coup=e.getNombre_coup();
					coup_effectuer=e.getNombre_coup_effectuer();
					dataset.addValue(coup, "coup", nom_parcours);
					dataset.addValue(coup_effectuer, "coup effectuer", nom_parcours);
					//dataset.add


				}
			}
		}
		return dataset;

	}

	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart(" Golf", "Parcours", "Nombre de Coup", dataset,
				PlotOrientation.VERTICAL, true, true, false); // cat =parcours et value = nombre de coup



		return chart;

	}
}
