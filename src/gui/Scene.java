package gui;

import java.awt.Graphics;

import javax.swing.*;

public class Scene extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public Scene() {
		super();
		setBorder(BorderFactory.createEtchedBorder());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		paintGlobalGrid(g);
	}

	public void paintGlobalGrid(Graphics g) {
		//TODO paint the map		
	}
	
	//TODO paint all components of the map here with a specifics methods
}
