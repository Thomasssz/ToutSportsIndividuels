package graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

import data.GolfSport;
import data.Sport;
import data.Vitesse_golf;
import requete.ListSport;

public class GraphGolfPoint extends JPanel {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 5141392002346251799L;
	private static int id_utilisateur;


	public GraphGolfPoint(String s,int id_utilisateur) {
		super();
		GraphGolfPoint.id_utilisateur = id_utilisateur;

		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(640, 480));
		add(jpanel);

	}
		public static JPanel createDemoPanel() {
		JFreeChart jfreechart = ChartFactory.createScatterPlot(
		"Vitesse / Distance", "Vitesse", "Distance", samplexydataset2(),
		PlotOrientation.VERTICAL, true, true, false);
		Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
		XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
		jfreechart.getXYPlot().getRangeAxis().setRange(0, 100);
		jfreechart.getXYPlot().getDomainAxis().setRange(0, 100);


		xyPlot.setDomainCrosshairVisible(true);
		xyPlot.setRangeCrosshairVisible(true);
		XYItemRenderer renderer = xyPlot.getRenderer();
		renderer.setSeriesShape(0, cross);
		renderer.setSeriesPaint(0, Color.red);
		return new ChartPanel(jfreechart);
	}
	private static  XYDataset samplexydataset2() {

		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		XYSeries series = new XYSeries("Vitesse / distance");
		ArrayList<Sport> sportList = new ArrayList<>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("GolfSport",id_utilisateur,"vitesse");

		float vitesse;
		float distance;

		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				GolfSport w = (GolfSport) element;

				for (Vitesse_golf e : w.getVitesse_golf()) {
					vitesse = e.getVitesse();
					distance = e.getDistance();
					System.out.println(sportList.size());
					series.add(distance,vitesse);
				}
			}
		}
		xySeriesCollection.addSeries(series);
		return xySeriesCollection;
	}
}