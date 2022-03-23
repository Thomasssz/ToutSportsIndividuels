package graph;

import java.awt.Color;
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

import data.Cotation_escalade;
import data.EscaladeSport;
import data.Sport;
import requete.ListSport;

public class GraphEscaladeLine extends JPanel {

	private static final long serialVersionUID = 1L;
	private int user;

	public GraphEscaladeLine(int user) {
		super();
		this.user = user;
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		 XYPlot plot =  chart.getXYPlot();
		 XYItemRenderer renderer = plot.getRenderer();
		 renderer.setSeriesPaint(0, Color.GRAY);
		 renderer.setSeriesPaint(1, Color.GREEN);
		 renderer.setSeriesPaint(2, Color.BLUE);
		 renderer.setSeriesPaint(3, Color.YELLOW);
		 renderer.setSeriesPaint(4, Color.ORANGE);
		 renderer.setSeriesPaint(5, Color.RED);
		 
		ChartPanel chartPanel = new ChartPanel(chart);


		chartPanel.setPreferredSize(new java.awt.Dimension(640, 480));
		add(chartPanel);
	}

	private XYDataset createDataset() {

		ArrayList<Sport> sportList = new ArrayList<>();
		ListSport sportLists = new ListSport(sportList);
		sportList=sportLists.arraySport("EscaladeSport",user,"cotation_escalade");

		XYSeries series1 = new XYSeries("1-4c");
		XYSeries series2 = new XYSeries("5a-5c");
		XYSeries series3 = new XYSeries("6a-6c");
		XYSeries series4 = new XYSeries("7a-7c");
		XYSeries series5 = new XYSeries("8a-8c");
		XYSeries series6 = new XYSeries("9a-9b+");
		
		String cotation;
		int block;
		int tentatives;
		
		if(!sportList.isEmpty())
		{
			for (Sport element : sportList) {
				EscaladeSport w = (EscaladeSport) element;

				for (Cotation_escalade e : w.getCotation_escalade()) {
					cotation = e.getCotation();
					block = e.getBlock();
					tentatives = e.getTentatives();
					switch(cotation)
					{
						case "1-4c":
							series1.add(block,tentatives);
							break;
						case "5a-5c":
							series2.add(block,tentatives);
							break;
						case "6a-6c":
							series3.add(block,tentatives);
							break;
						case "7a-7c":
							series4.add(block,tentatives);
							break;
						case "8a-8c":
							series5.add(block,tentatives);
							break;
						case "9a-9b+":
							series6.add(block,tentatives);
							break;

					}
				//	100 x Valeur partielle/Valeur totale

				}
			}
		}
		XYSeriesCollection dataset = new XYSeriesCollection();

		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		dataset.addSeries(series4);
		dataset.addSeries(series5);
		dataset.addSeries(series6);
	
		return dataset;
		
	}

	private JFreeChart createChart(XYDataset dataset) {
		return ChartFactory.createXYLineChart("Tentatives Block Cotation", "Block", "Tentatives", dataset, PlotOrientation.VERTICAL, true, true, false);

	}
}