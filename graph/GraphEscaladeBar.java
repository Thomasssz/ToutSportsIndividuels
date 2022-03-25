package graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RefineryUtilities;

import data.CourseSport;
import data.EscaladeSport;
import data.Kilometre_course;
import data.Prise_escalade;
import data.Sport;
import requete.ListSport;

public class GraphEscaladeBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private int user;

	//private ArrayList<Sport> sportList;
	private Paint paintPrise = new GradientPaint(
            0.0f, 0.0f, new Color(51, 247, 10), 0.0f, 0.0f, new Color(0, 250, 21)
        );
	private Paint paintPriseMin = new GradientPaint(
            0.0f, 0.0f, new Color(240, 70, 58), 0.0f, 0.0f, new Color(240, 9, 0)
        );
	public GraphEscaladeBar(int user) {


		super();
		this.user = user;

		CategoryDataset dataset = createDataGolf();
		JFreeChart chart = createChart(dataset);
		 CategoryPlot plot =  chart.getCategoryPlot();
		 GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
		 KeyToGroupMap map = new KeyToGroupMap("toutesPrises");
		 map.mapKeyToGroup("prisesMin", "toutesPrises");
		 map.mapKeyToGroup("prises", "toutesPrises");
		 renderer.setSeriesToGroupMap(map);
		 
		 renderer.setItemMargin(0.0);
		 renderer.setSeriesPaint(0, paintPrise);
	     renderer.setSeriesPaint(1, paintPriseMin);
	     plot.setRenderer(renderer);
		 
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(640, 480));
		add(chartPanel);
	}

	private CategoryDataset createDataGolf() {

		ArrayList<Sport> sportList = new ArrayList<>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("EscaladeSport",user,"prise_escalade");
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		int block;
		int prisesMin;
		int prises;

		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				EscaladeSport w = (EscaladeSport) element;

				for (Prise_escalade e : w.getPrise_escalade()) {
					block = e.getBlock();
					prisesMin = e.getPrisesMin();
					prises = e.getPrises();
					
					String sblock = Integer.toString(block);
					dataset.addValue(prisesMin, "prisesMin", sblock);
					dataset.addValue(prises, "prises", sblock);
					
				}
			}
		}
		return dataset;
	}

	private JFreeChart createChart(CategoryDataset dataset) {
		
		return ChartFactory.createBarChart("Prises Block", "Block", "Prises", dataset,PlotOrientation.VERTICAL, true, true, false);
	}
}