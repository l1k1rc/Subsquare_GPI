package gui.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import engine.GridParameters;
import engine.Simulation;
import engine.TimeSimulator;

//import engine.Simulation;

public class MainFrame extends JFrame implements Runnable,MouseListener,KeyListener{

	private static final long serialVersionUID = 1L;
	private static int THREAD_MAP = GridParameters.speed;
	private Simulation simulation;
	private TimeSimulator timeSim;
	private Scene scene = new Scene();
	private PanelScore pScore = new PanelScore();
	private PanelAPI api = new PanelAPI();
	private static boolean stop = true;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu_game = new JMenu("Game");
	private JMenuItem item_save = new JMenuItem("Save");
	private JMenuItem item_load = new JMenuItem("Load a game");
	private JMenuItem item_manual = new JMenuItem("User's manual");
	private JMenuItem item_leave = new JMenuItem("Leave without save");
	
	/*********		construct		*********/
	public MainFrame() {
		super("Subsquare");
		setIconImage(new ImageIcon("subsquare_icon.png").getImage());		
		setFocusable(true);
		addKeyListener(this);
		simulation = new Simulation(GridParameters.getInstance());
		simulation.generatGrid();
		timeSim = TimeSimulator.getInstance();
		scene.setGrid(simulation.getGrid());
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
		setSize(1400,760);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		// TODO initialize your frame here
		
		scene.setBounds(205,5,1185,600);
		api.setBounds(200,610,1200,125);
		pScore.setBounds(0, 0, 200, 1150);

		this.menu_game.add(item_save);
		this.menu_game.add(item_load);
		this.menu_game.add(item_manual);
		this.menu_game.add(item_leave);
		
		//Action for leave without save
		item_leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		item_manual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new ManualFrame();
			}
		});
		
		this.menuBar.add(menu_game);
		this.setJMenuBar(menuBar);
		
		getContentPane().add(api);
		getContentPane().add(pScore);
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
		updateTime();
		scene.updateUI();
		scene.repaint();
	}
	
	public void updateTime() {
		timeSim.update();
		pScore.getDateField().setText(timeSim.getDate());
		pScore.getHourField().setText(timeSim.getTime());
	}

	@Override
	public void run() {
		while(true) {	
			// TODO simulation method new turn
			if(!stop) {
				simulation.simulationNextTurn();
				updateGUI();
				try {
					Thread.sleep(THREAD_MAP);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	public static void setThreadSpeed(int thread) {
		MainFrame.THREAD_MAP=thread;
	}
	
	public static void setStop(boolean stop) {
		MainFrame.stop=stop;
	}
}