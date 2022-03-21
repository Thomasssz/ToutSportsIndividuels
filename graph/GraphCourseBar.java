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
import org.jfree.ui.RefineryUtilities;

import data.CourseSport;
import data.Kilometre_course;
import data.Sport;
import requete.ListSport;

public class GraphCourseBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private int user;

	//private ArrayList<Sport> sportList;

	public GraphCourseBar(String title,int user) {


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
		sportList=sportLists.arraySport("CourseSport",user,"kilometre");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		TimeTableXYDataset dataset2 = new TimeTableXYDataset();


		float kilometre;
		int nombre_course;

		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				CourseSport w = (CourseSport) element;

				for (Kilometre_course e : w.getKilometre_course()) {
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
}
