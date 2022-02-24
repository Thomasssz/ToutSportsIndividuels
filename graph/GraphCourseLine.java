package graph;

import java.util.ArrayList;

import javax.swing.JFrame;

import java.awt.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import data.CourseSport;
import data.Penalite_Rugby;
import data.RugbySport;
import data.Sport;
import data.Statistique_Rugby;
import data.Vitesse_course;
import requete.ListSport;

public class GraphCourseLine extends JFrame {

	private static final long serialVersionUID = 1L;
	private int user;

	public GraphCourseLine(String title,int user) {
		super(title);
		this.user = user;
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		
        
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;


	}

	private XYDataset createDataset() {
		
		ArrayList<Sport> sportList = new ArrayList<Sport>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("CourseSport",user,"vitesse");
		
		XYSeries series1 = new XYSeries("Vitesse moyenne");
		XYSeries series2 = new XYSeries("Course");

		float vitesse_moyenne;
		int nombre_course;
		
		
		
		if(!sportList.isEmpty())
		{
			for(int i = 0 ; i < sportList.size() ; i++)
			{
				CourseSport w = (CourseSport) sportList.get(i);

				for(int j = 0 ; j < w.getVitesse_course().size() ; j++)
				{
					Vitesse_course e = w.getVitesse_course().get(j);
					
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

	/*public static void main(String[] args) {
		GraphRugbyLine demo = new GraphRugbyLine("Penalité",user);
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}*/

}