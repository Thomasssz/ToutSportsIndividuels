package graph;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import data.Oxygene_plonger;
import data.PlongerSport;
import data.Sport;
import requete.ListSport;

public class GraphPlongerAreaLine extends JPanel {

  private static final long serialVersionUID = 1L;
  private int user;
  public GraphPlongerAreaLine(String title,int user) {
    super();
    this.user=user;

    // Create dataset
    DefaultCategoryDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createAreaChart(
    		"Consommation Oxygene",             // chart title
            "Profondeur",               // domain axis label
            "Consommation",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            false);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    add(panel);

  }

  private DefaultCategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    ArrayList<Sport> sportList = new ArrayList<>();
	ListSport sportLists = new ListSport(sportList);
	sportList=sportLists.arraySport("PlongerSport",user,"oxygene");

	float consommation;
	int profondeur;

	String sProfondeur;

	if(!sportList.isEmpty())
	{
		for (Sport element : sportList) {
			PlongerSport w = (PlongerSport) element;

			for (Oxygene_plonger e : w.getOxyegene_plonger()) {
				consommation=e.getConsomation();
				profondeur=(int) e.getProfondeur();
				sProfondeur=  String.valueOf(profondeur);

				dataset.addValue(consommation,"consommation" ,sProfondeur+" metres" );



			}
		}
	}

	return dataset;
  }
}