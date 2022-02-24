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
import data.CourseSport;
import data.Kilometre_course;
import data.CourseSport;
import data.Sport;
import data.Trou_golf;
import requete.ListSport;




public class GraphCourseBar extends JFrame {

	private static final long serialVersionUID = 1L;
	private int user;

	//private ArrayList<Sport> sportList;

	public GraphCourseBar(String title,int user) {
		

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
		sportList=sportLists.arraySport("CourseSport",user,"kilometre");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		TimeTableXYDataset dataset2 = new TimeTableXYDataset();
		
		
		float kilometre;
		int nombre_course;
		
		if(!sportList.isEmpty())
		{
			for(int i = 0 ; i < sportList.size() ; i++)
			{
				CourseSport w = (CourseSport) sportList.get(i);

				for(int j = 0 ; j < w.getKilometre_course().size() ; j++)
				{
					Kilometre_course e = w.getKilometre_course().get(j);
					kilometre=e.getKilometre();
					nombre_course=e.getJour();
					dataset.addValue(kilometre, "Kilometre", "Course "+nombre_course);
					//dataset.addValue(coup_effectuer, "coup effectuer", nom_parcours);
					//dataset.add
					
					
				}
			}
		}
		return dataset;

	}

	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart("Course", "Jour", "Kilometre", dataset, 
				PlotOrientation.VERTICAL, true, true, false); // cat =parcours et value = nombre de coup
		
	

		return chart;

	}

	public static void main (String [] args) {
		GraphCourseBar demo = new GraphCourseBar("course",3);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
	}
	
}
