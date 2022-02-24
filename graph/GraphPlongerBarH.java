package graph;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import bd_init.DBConnection;
import data.GolfSport;
import data.PlongerSport;
import data.Profondeur_plonger;
import data.Sport;
import data.Trou_golf;
import requete.ListSport;




public class GraphPlongerBarH extends JFrame {

	private static final long serialVersionUID = 1L;
	private int user ;
	//private ArrayList<Sport> sportList;

	public GraphPlongerBarH(String title,int user) {

		super(title);
		this.user = user;
		CategoryDataset dataset = createDataGolf();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;


	}
	

	private CategoryDataset createDataGolf() {

		ArrayList<Sport> sportList = new ArrayList<Sport>();
		ListSport sportLists = new ListSport(sportList);
		
		sportList=sportLists.arraySport("PlongerSport",user,"profondeur");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		
		int profondeur;
		float temps;
		String sProfondeur;
		if(!sportList.isEmpty())
		{
			for(int i = 0 ; i < sportList.size() ; i++)
			{
				PlongerSport w = (PlongerSport) sportList.get(i);

				for(int j = 0 ; j < w.getProfondeur_plonger().size() ; j++)
				{
					Profondeur_plonger e = w.getProfondeur_plonger().get(j);
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

	/*public static void main (String [] args) {
		GraphPlongerBarH demo = new GraphPlongerBarH("Plonger");
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
	}*/
	
}
