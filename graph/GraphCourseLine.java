package graph;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import data.CourseSport;
import data.Sport;
import data.Vitesse_course;
import requete.ListSport;

public class GraphCourseLine extends JPanel {

	private static final long serialVersionUID = 1L;
	private int user;

	public GraphCourseLine(String title,int user) {
		super();
		this.user = user;
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);

		ChartPanel chartPanel = new ChartPanel(chart);


		chartPanel.setPreferredSize(new java.awt.Dimension(640, 480));
		add(chartPanel);
	}

	private XYDataset createDataset() {

		ArrayList<Sport> sportList = new ArrayList<>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("CourseSport",user,"vitesse");

		XYSeries series1 = new XYSeries("Vitesse moyenne");
		XYSeries series2 = new XYSeries("Course");

		float vitesse_moyenne;
		int nombre_course;



		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				CourseSport w = (CourseSport) element;

				for (Vitesse_course e : w.getVitesse_course()) {
					vitesse_moyenne=e.getVitesse_moyenne();
					nombre_course=e.getNombre_course();

					series1.add(nombre_course,vitesse_moyenne);
				//	100 x Valeur partielle/Valeur totale

				}
			}
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		return dataset;
		
	}

	private JFreeChart createChart(XYDataset dataset) {

		return ChartFactory.createXYLineChart("Vitesse Moyenne Course", "Nombre de course", "Vitesse moyenne", dataset, PlotOrientation.VERTICAL, true, true, false);

	}
}