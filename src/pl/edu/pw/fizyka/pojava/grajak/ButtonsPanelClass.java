package pl.edu.pw.fizyka.pojava.grajak;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.Timer;

//Renata Grela - cała reszta
//Alicja Jakubowska - createFrame, drobne poprawki wizualne 

public class ButtonsPanelClass extends JPanel { 
	JPanel pV;
	JPanel pF;
	
	public static JSlider sliderVrecipient;
	public static JSlider sliderVsource;
	public static JSlider sliderFrequency;
	
	JLabel labelVrecipientInfo;
	JLabel labelVsourceInfo;
	JLabel labelVrecipientValue;
	JLabel labelVsourceValue;
	JLabel labelFrequencyValue;
	JLabel labelFrequencySoundValue;
	JLabel labelTypeOfFrequency;
	
	public static double pi=3.14;
	public static int valVsource, valVrecipient;
	
	public ButtonsPanelClass() {
		this.setLayout(new GridLayout(1, 2));
		
		pV = new JPanel();
		pF = new JPanel();
		this.add(pV);
		this.add(pF);
		
		//SLIDERS
		sliderVrecipient = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);
		sliderVsource = new JSlider(JSlider.HORIZONTAL, -50, 50, 0);
		sliderFrequency = new JSlider(JSlider.HORIZONTAL, 280, 1200, 300);
		
		//LABELS
		labelVrecipientInfo = new JLabel("Prędkość odbiorcy");
		labelVsourceInfo = new JLabel("Prędkość źródła");
		labelVsourceValue = new JLabel(String.format(sliderVsource.getValue() + " m/s"));
		labelVrecipientValue = new JLabel(String.format(sliderVrecipient.getValue() + " m/s"));
		labelFrequencyValue = new JLabel(String.format(sliderFrequency.getValue() + " Hz"));
		labelFrequencySoundValue = new JLabel("Częstotliwość dzwieku źródła");
		labelTypeOfFrequency = new JLabel("Rodzaj dzwieku");
		
		//ADDING SLIDER LISTENERS
		sliderVrecipient.addChangeListener(new ChangeSliderRecipient());
		sliderVsource.addChangeListener(new ChangeSliderSource());
		sliderFrequency.addChangeListener(new ChangeSliderFrequency());
		
		
		valVsource=sliderVsource.getValue();
		valVrecipient=sliderVrecipient.getValue();
		
		//COMBOBOX + LISTENER
		String[] typeSounds = new String[3];
		typeSounds[0] = "odgłos karetki";
		typeSounds[1] = "odgłos klaksonu";
		typeSounds[2] = "odgłos samolotu";
		final JComboBox<String> typeOfSound = new JComboBox<String>(typeSounds);
		
		typeOfSound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (typeOfSound.getSelectedIndex()) {
				case 0:
					PlayMusic soundAmbulance = new PlayMusic();
					if(sliderVsource.getValue()==sliderVrecipient.getValue()) {
					
					soundAmbulance.playMusic("Music\\\\constAmbulance.wav");
					}
					else if(sliderVsource.getValue()>0 && sliderVrecipient.getValue()<=0) {
						soundAmbulance.playMusic("Music\\\\upAmbulance.wav");
					
						
					}else {
					
						soundAmbulance.playMusic("Music\\\\downAmbulance.wav");
					}
					
					break;
				case 1:
					PlayMusic soundHorn = new PlayMusic();
					
					if(sliderVsource.getValue()==sliderVrecipient.getValue()) {
						soundHorn.playMusic("Music\\\\constHorn.wav");
						}
						else if(sliderVsource.getValue()>0 && sliderVrecipient.getValue()<=0) {
							
							soundHorn.playMusic("Music\\\\upHorn.wav");
							
						}else {
							soundHorn.playMusic("Music\\\\downHorn.wav");
						}
					break;
				case 2:
					PlayMusic soundPlane = new PlayMusic();
					
					if(sliderVsource.getValue()==sliderVrecipient.getValue()) {
						soundPlane.playMusic("Music\\\\constPlane.wav");
						}
						else if(sliderVsource.getValue()>0 && sliderVrecipient.getValue()<=0) {
							soundPlane.playMusic("Music\\\\upPlane.wav");
						}else {
							soundPlane.playMusic("Music\\\\downPlane.wav");
						}
					break;
				}
				
			}
		});
		pV.setLayout(new GridLayout(2, 3));
		pV.add(labelVsourceInfo);
		pV.add(sliderVsource);
		pV.add(labelVsourceValue);
		pV.add(labelVrecipientInfo);
		pV.add(sliderVrecipient);
		pV.add(labelVrecipientValue);
		pF.setLayout(new GridLayout(2, 3));
		pF.add(labelFrequencySoundValue);
		pF.add(sliderFrequency);
		pF.add(labelFrequencyValue);
		pF.add(labelTypeOfFrequency);
		pF.add(typeOfSound);
	}
		
	// SLIDER LISTENERS
		public class ChangeSliderSource implements ChangeListener {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				String valueSource = String.format(sliderVsource.getValue() + " m/s");
				labelVsourceValue.setText(valueSource);
			}
		}

		public class ChangeSliderRecipient implements ChangeListener {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				String valueRecipient = String.format(sliderVrecipient.getValue() + " m/s");
				labelVrecipientValue.setText(valueRecipient);
			}
		}
		public class ChangeSliderFrequency implements ChangeListener {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				String valueFrequency = String.format(sliderFrequency.getValue() + " Hz");
				labelFrequencyValue.setText(valueFrequency);
			}
		}
		
		//CHART
		public static void createFrame()
	    {
	        EventQueue.invokeLater(new Runnable()
	        {
	            @Override
	            public void run(){
	               XYSeries sin = new XYSeries("sin(wt)");
	               XYSeriesCollection dataSin = new XYSeriesCollection();
	               
	               for(double i = 0; i < 26; i +=0.05){
	   	    		double sinx = Math.sin(2*pi*sliderFrequency.getValue()*i-2*pi);
	   	    		sin.add(i, sinx);
	               }
	   	    		JFreeChart chart = ChartFactory.createXYLineChart 
	   		    			("Obraz fali dzwiękowej",  // Title 
	   		    					"Czas",           // X-Axis label 
	   		    					"Amplituda ",           // Y-Axis label 
	   		    					dataSin,          // Dataset 
	   		    					PlotOrientation.VERTICAL,        //Plot orientation 
	   		    					true,                //show legend 
	   		    					true,                // Show tooltips 
	   		    					false               //url show 
	   		    					); 
	   	    		dataSin.addSeries(sin);
	   	    		ChartFrame frame = new ChartFrame("Chart", chart);
	   	    		frame.setVisible(true);
	   	    		frame.setSize(500,400);
	          		
	            }
	        });
	    }
}
