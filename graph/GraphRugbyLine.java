package graph;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import data.Penalite_Rugby;
import data.RugbySport;
import data.Sport;
import requete.ListSport;

public class GraphRugbyLine extends JPanel {

	private static final long serialVersionUID = 1L;
	private int user;

	public GraphRugbyLine(String title,int user) {
		super();
		this.user = user;
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		chart.getXYPlot().getRangeAxis().setRange(0, 100);
		chart.getXYPlot().getDomainAxis().setRange(0, 100);
		ChartPanel chartPanel = new ChartPanel(chart);


		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		add(chartPanel);
	}

	private XYDataset createDataset() {

		ArrayList<Sport> sportList = new ArrayList<>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("RugbySport",user,"penalite");

		XYSeries series1 = new XYSeries("Reussi");
		XYSeries series2 = new XYSeries("Echec");

		float penalite_tenter;
		int distance;
		float reussi;
		float echec;

		float pourcReussi;
		float pourcEchec;

		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				RugbySport w = (RugbySport) element;

				for (Penalite_Rugby e : w.getPenalite_rugby()) {
					penalite_tenter=e.getPenalite_tenter();
					distance=e.getDistance();
					reussi=e.getReussi();
					echec=e.getEchec();

					pourcReussi = 100 * ( reussi/penalite_tenter);
					pourcEchec = 100 * (echec / penalite_tenter);

					series1.add(distance,pourcReussi);
					series2.add(distance,pourcEchec);
				//	100 x Valeur partielle/Valeur totale

					System.out.println(pourcReussi);

				}
			}
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		return dataset;

	}

	private JFreeChart createChart(XYDataset dataset) {

		return ChartFactory.createXYLineChart("Penalité rugby", "Distance", "Pourcentage echec / reussite", dataset, PlotOrientation.VERTICAL, true, true, false);

	}
}