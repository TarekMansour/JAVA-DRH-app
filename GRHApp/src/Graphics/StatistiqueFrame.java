package Graphics;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.io.File;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Color;

public class StatistiqueFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatistiqueFrame frame = new StatistiqueFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel panel1;

	/**
	 * Create the frame.
	 */
	public StatistiqueFrame() {
		super ("Hello Statistiques");
		getContentPane().setBounds(new Rectangle(10, 0, 1230, 543));
		setBounds(new Rectangle(0, 106, 1252, 578));
		setFrameIcon(new ImageIcon(GestionPersonnel.class.getResource("/Ressources/student.png")));
		setForeground(Color.GRAY);
		setFont(new Font("Arial", Font.BOLD, 14));
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new MigLayout());
		panel1 = new JPanel(new MigLayout());
		
		/// Create a time series chart
		TimeSeries pop = new TimeSeries("Chiffre", Day.class);
		pop.add(new Day(10, 1, 2012), 10);
		pop.add(new Day(10, 2, 2013), 20);
		pop.add(new Day(10, 3, 2014), 25);
		pop.add(new Day(10, 4, 2015), 19);
		pop.add(new Day(10, 5, 2016), 40);
		
		pop.add(new Day(10, 6, 2016), 45);
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(pop);
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
		"Chiffre des stagiaires par ans",
		"Date",
		"Chiffre",
		dataset,
		true,
		true,
		false);
		try {
		ChartUtilities.saveChartAsJPEG(new File("E:/Travail/mini projet java swing/charts/chart2.jpg"), chart, 500, 300);
		} catch (IOException e) {
		System.err.println("Problem occurred creating chart.");
		}
		
		
		
		ChartPanel CP = new ChartPanel(chart);
		CP.setBackground(Color.WHITE);
		
		panel1.add(CP, "dock center");
		getContentPane().add(panel1, "dock center");
		setClosable(true);
	}

}
