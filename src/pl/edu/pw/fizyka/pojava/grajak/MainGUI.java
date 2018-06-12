package pl.edu.pw.fizyka.pojava.grajak;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainGUI extends JFrame {

	public CalculationsPanelClass calculationsPanel;
	public AnimationPanelClass animationPanel;
	public static ButtonsPanelClass buttonsPanel;
	public static RightPanelClass rightPanel;
	
	public MainGUI() throws HeadlessException {
		this.setSize(1040, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		calculationsPanel = new CalculationsPanelClass();
		buttonsPanel = new ButtonsPanelClass();
		animationPanel = new AnimationPanelClass();
		rightPanel = new RightPanelClass(buttonsPanel, calculationsPanel);
		
		add(BorderLayout.NORTH, buttonsPanel);
		add(BorderLayout.EAST, rightPanel);
		add(BorderLayout.CENTER, animationPanel);
		add(BorderLayout.SOUTH, calculationsPanel);

	}

	public MainGUI(GraphicsConfiguration arg0) {
		super(arg0);
		this.setSize(1040, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public MainGUI(String arg0) throws HeadlessException {
		super(arg0);
		this.setSize(1040, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public MainGUI(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		this.setSize(1040, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		MainGUI frame = new MainGUI();
		frame.setTitle("Efekt Dopplera");
		frame.setVisible(true);
	}
}
