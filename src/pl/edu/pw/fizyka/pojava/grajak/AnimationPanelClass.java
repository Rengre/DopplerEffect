package pl.edu.pw.fizyka.pojava.grajak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.RenderingHints;

//Renata Grela

public class AnimationPanelClass extends JPanel implements ActionListener{  //Renata Grela
	int xObserver=450;
	static int xSource=120;
	int xprev , xnext;
	int xprevR , xnextR;
	static double [] r= new double[30];
	static int  VxObserver, VxSource;
	public Ellipse2D.Float ellipse = new Ellipse2D.Float();
	public double esize;
	public double maxSize = 0;
	public boolean initialize = true;
	Timer timer;
	double freq;
	double lambda;
	
	
	Image bike= new ImageIcon("rower1.png").getImage(); // obrazek udostepniony przez strone http://nonciclopedia.wikia.com/wiki/File:Bicicletta.gif
	Image bikeRight= new ImageIcon("rower.gif").getImage();
	Image bikeLeft= new ImageIcon("rowerL.gif").getImage();// obrazek udostepniony przez strone http://nonciclopedia.wikia.com/wiki/File:Bicicletta.gif
	Image ambulanceRight= new ImageIcon("karetka.png").getImage(); //obrazek udostepniony przez strone https://pl.seaicons.com/karetka-ikona-opieki-zdrowotnej/
	Image ambulanceLeft= new ImageIcon("karetka2.png").getImage(); //obrazek udostepniony przez strone https://pl.seaicons.com/karetka-ikona-opieki-zdrowotnej/
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i=0; i<50;i++) {
		
		if(RightPanelClass.running) {
			if(MainGUI.buttonsPanel.sliderVrecipient.getValue()==0 || !RightPanelClass.running)   g.drawImage(bike, xObserver, 150, null);
			if(xnextR>=xprevR && MainGUI.buttonsPanel.sliderVrecipient.getValue()!=0) g.drawImage(bikeRight, xObserver, 150, null);
			if(xprevR>xnextR && MainGUI.buttonsPanel.sliderVrecipient.getValue()!=0)  g.drawImage(bikeLeft, xObserver, 150, null);
			if(xnext>=xprev) g.drawImage(ambulanceRight, xSource, 150, null);
			if(xprev>xnext)  g.drawImage(ambulanceLeft, xSource, 150, null);
			
			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			        RenderingHints.VALUE_ANTIALIAS_ON);

			rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2.setRenderingHints(rh);
			double size;
			size=10000;
			if (initialize) {
				reset(size, size);
				initialize = false;
		 	}
			this.step(size, size);
			render(size, size, g2);
		}
	  }
	}
	
	public AnimationPanelClass() {
		super();
		this.setBackground(Color.white);
		
		Timer t= new Timer(100,this);
		t.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(RightPanelClass.running) {
			freq = MainGUI.buttonsPanel.sliderFrequency.getValue()*(340+MainGUI.buttonsPanel.sliderVrecipient.getValue())/(340+MainGUI.buttonsPanel.sliderVsource.getValue());
			lambda = 340/freq;
			xprev=xSource;
			xprevR=xObserver;
			
			VxSource=MainGUI.buttonsPanel.sliderVsource.getValue();
			VxObserver=MainGUI.buttonsPanel.sliderVrecipient.getValue();
			
			if(xSource>900) xSource=-80;
			if(xSource<-80) xSource=900;
			if(xObserver>900) xObserver=-80;
			if(xObserver<-80) xObserver=900;
            
			xObserver+=VxObserver;
			xSource+=VxSource;
			
			xnext=xSource;
			xnextR=xObserver;
		}
		repaint();
		
	}
	
	  
	 public void setXY(double size, double w, double h) {
		    esize = size;
		    if(xSource>0) ellipse.setFrame(xSource+60, 150, size, size);
		    else  ellipse.setFrame(xSource-50, 150, size, size);
		  }

		  public void reset(double w, double h) {
		    maxSize = w /5;
		    setXY(maxSize , w, h);
		  }

		  public void step(double w, double h) {
			  
		    esize+=lambda*10+2;
		    if (esize > maxSize) {
		      setXY(1, w, h);
		    } else {
		    	
		      ellipse.setFrame(ellipse.getX(), ellipse.getY(), esize, esize);
		    }
		  }

		  public void render(double w, double h, Graphics2D g2) {
		    g2.setColor(Color.BLUE);
		    g2.draw(ellipse);
		  }
    
			
	}


