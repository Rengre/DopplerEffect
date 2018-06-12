package pl.edu.pw.fizyka.pojava.grajak;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

//Renata Grela - animation
//Alicja Jakubowska - cała reszta

public class RightPanelClass extends JPanel{ 
	
		ButtonsPanelClass b;
		CalculationsPanelClass c;
		
		JButton animation;
		JButton doCalculationsButton;
		
		double freq;
		static double l;
		static boolean running;

	public RightPanelClass(ButtonsPanelClass butt, CalculationsPanelClass cal) {
		b=butt;
		c=cal;
		running=false;
		
		this.setLayout(new GridLayout(2, 1));
		
		animation = new JButton("Animacja");
		doCalculationsButton = new JButton("Wykonaj obliczenia");
		
		//LISTENERS
		animation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!running) {
					//JOptionPane.showMessageDialog(null,
					//		 "Pamietaj o wykonywaniu obliczeń , aby animacja poprawnie działała!","",JOptionPane.WARNING_MESSAGE);
					running=true;
				}else running=false;				
			}
		});
		
		doCalculationsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				freq = b.sliderFrequency.getValue()*(340+b.sliderVrecipient.getValue())/(340+b.sliderVsource.getValue());
				l = 340/freq;
				c.labelCalFrequency.setText(String.valueOf(freq));
				c.labelCalWavelength.setText(String.valueOf(l));
			}
		});
		
	this.add(doCalculationsButton);
	this.add(animation);
	}
}
