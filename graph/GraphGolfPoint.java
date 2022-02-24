package graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

import data.GolfSport;
import data.Sport;
import data.Trou_golf;
import data.Vitesse_golf;
import requete.ListSport;

public class GraphGolfPoint extends JFrame {
	
	   private static int id_utilisateur;
	    

	public GraphGolfPoint(String s,int id_utilisateur) {
		super(s);
		this.id_utilisateur = id_utilisateur;

		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(640, 480));
		add(jpanel);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;

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
		ArrayList<Sport> sportList = new ArrayList<Sport>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("GolfSport",id_utilisateur,"vitesse");
		
		float vitesse;
		float distance;
		
		if(!sportList.isEmpty())
		{
			for(int i = 0 ; i < sportList.size() ; i++)
			{
				GolfSport w = (GolfSport) sportList.get(i);

				for(int j = 0 ; j < w.getVitesse_golf().size() ; j++)
				{
					Vitesse_golf e = w.getVitesse_golf().get(j);
					
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
