package pl.edu.pw.fizyka.pojava.grajak;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//Alicja Jakubowska

public class CalculationsPanelClass extends JPanel{ 
	JPanel pC; //calculationsPanel (informacje o danych z obliczeń)
	JPanel pS; //speedPanel(informacja o prędkści)
	JPanel pB; //buttonPanel
	
	JLabel labelDoCalculations;
	JLabel labelFrequency;
	JLabel labelWavelength;
	JLabel labelEmpty;
	JLabel labelSpeed;
	JLabel labelEmpty2;
	JLabel labelChart;
	JLabel labelCalFrequency;//calculated frequency
	JLabel labelCalWavelength;//calculated wave length
	
	JButton buttonChart;
	
	ButtonsPanelClass b;
	
	public CalculationsPanelClass() {
		this.setLayout(new BorderLayout());
		pC = new JPanel(new GridLayout(3,2));
		pB = new JPanel (new FlowLayout());
		pS = new JPanel(new FlowLayout());
		this.add(pC, BorderLayout.CENTER);
		this.add(pB, BorderLayout.EAST);
		this.add(pS, BorderLayout.SOUTH);
		
		//LABELS
		labelDoCalculations = new JLabel("Wyniki obliczeń");
		labelDoCalculations.setFont(new Font("default", Font.BOLD, 16));
		labelFrequency = new JLabel("Częstotliwość dzwięku słyszanego przez odbiorcę");
		labelWavelength = new JLabel("Długość fali");
		labelEmpty = new JLabel("");
		labelEmpty2 = new JLabel("");
		labelSpeed = new JLabel("Obliczenia zostały wykonane dla prędkości dzwięku w powietrzu V=340m/s");
		labelCalFrequency = new JLabel("                                                                  ");
		labelCalWavelength = new JLabel("                                                                 ");
		labelChart = new JLabel("Obraz fali dzwiekowej docierajacej do obserwatora");
		
		//BUTTON
		buttonChart = new JButton("Pokaż wykres");
		
		pC.add(labelDoCalculations);
		pC.add(labelEmpty2);
		pC.add(labelFrequency);
		pC.add(labelCalFrequency);
		pC.add(labelWavelength);
		pC.add(labelCalWavelength);;
		pS.add(labelSpeed);
		pB.add(labelChart);
		pB.add(buttonChart);
		
		//LISTENER
		buttonChart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				b.createFrame();	
			}
		});
		
	}
	

}

