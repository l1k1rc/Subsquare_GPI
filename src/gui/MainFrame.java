package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import engine.Simulation;

public class MainFrame extends JFrame implements Runnable,MouseListener,KeyListener{

	private static final long serialVersionUID = 1L;
	private static final int THREAD_MAP = 800;
	private Simulation simulation;
	private Scene scene = new Scene();
	private boolean stop = true;

	/*********		construct		*********/
	public MainFrame() {
		super("Subsquare");
		setFocusable(true);
		addKeyListener(this);
		simulation = new Simulation();
		init();
		launchGUI();
	}
	
	private void launchGUI(){
		stop = false;		
		Thread chronoThread = new Thread(this);
		chronoThread.start();
	}
	
	public void init() {
		setResizable(false);
		getContentPane().setBackground(Color.darkGray);
		setSize(1150,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		// TODO initialize your frame here
		
		scene.setBounds(165,5,980,570);
		getContentPane().add(scene);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		// When Key pressed write the code
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//When Key released write the code
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//When Key tayped write the code
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//When mouse clocked write the code
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//When mouse entered write the code		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//When mouse exites write the code
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//When mouse pressed write the code
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//When mouse relesed write the code
	}
	
	public void updateGUI() {
		// TODO repaint method of the scene
		// TODO check new statistics ..
		scene.updateUI();
		scene.repaint();
	}

	@Override
	public void run() {
		while(!stop) {	
			// TODO simulation method new turn
			simulation.simulationNextTurn();
			updateGUI();
			try {
				Thread.sleep(THREAD_MAP);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}