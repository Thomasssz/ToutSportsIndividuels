package graph;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

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
import data.Sport;
import data.Trou_golf;
import requete.ListSport;




public class GraphGolfBar extends JFrame {

	private static final long serialVersionUID = 1L;
	private int user;

	//private ArrayList<Sport> sportList;

	public GraphGolfBar(String title,int user) {
		

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
		sportList=sportLists.arraySport("GolfSport",user,"coup");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		TimeTableXYDataset dataset2 = new TimeTableXYDataset();
		
		
		String nom_parcours;
		int coup;
		int coup_effectuer;
		
		if(!sportList.isEmpty())
		{
			for(int i = 0 ; i < sportList.size() ; i++)
			{
				GolfSport w = (GolfSport) sportList.get(i);

				for(int j = 0 ; j < w.getTrou_golf().size() ; j++)
				{
					Trou_golf e = w.getTrou_golf().get(j);
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

	/*public static void main (String [] args) {
		GraphGolfBar demo = new GraphGolfBar("Golf");
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
	}*/
	
}
