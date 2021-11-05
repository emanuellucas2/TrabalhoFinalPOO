import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Second;

public class Grafico extends JFrame {

	private JPanel janela;
	
	public Grafico(LinkedList<Data> l) {
	
		janela = new JPanel();
		janela.setSize(500, 300);
		
		final TimeSeries s1 = new TimeSeries("Series 1");
		for (int i = 0; i < l.size(); i++) {
		   s1.add(new Second(l.get(i).data),l.get(i).value);
		}
		
		final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        
        final JFreeChart chart = ChartFactory.createTimeSeriesChart("", "Data", "Valor", dataset,
                true, true, false);

        final XYPlot plot = chart.getXYPlot();
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("H:m:s"));
        final ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setAutoRangeMinimumSize(1.0);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(550, 350));
        
        janela.add(chartPanel);
        
        //janela.setVisible(true);
           
	}

	public JPanel getJanela() {
		return janela;
	}

	public void setJanela(JPanel janela) {
		this.janela = janela;
	}



}
