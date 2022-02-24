package graph;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeriesCollection;

import data.Oxygene_plonger;
import data.Penalite_Rugby;
import data.PlongerSport;
import data.RugbySport;
import data.Sport;
import requete.ListSport;

public class GraphPlongerAreaLine extends JFrame {

  private static final long serialVersionUID = 1L;
  private int user;
  public GraphPlongerAreaLine(String title,int user) {
    super(title);
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
    setContentPane(panel);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;

  }

  private DefaultCategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    ArrayList<Sport> sportList = new ArrayList<Sport>();
	ListSport sportLists = new ListSport(sportList);
	sportList=sportLists.arraySport("PlongerSport",user,"oxygene");
	
	float consommation;
	int profondeur;
	
	String sProfondeur;

	if(!sportList.isEmpty())
	{
		for(int i = 0 ; i < sportList.size() ; i++)
		{
			PlongerSport w = (PlongerSport) sportList.get(i);

			for(int j = 0 ; j < w.getOxyegene_plonger().size() ; j++)
			{
				Oxygene_plonger e = w.getOxyegene_plonger().get(j);
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