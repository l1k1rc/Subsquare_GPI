package gui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import gui.fontElements.Fonts;

public class PanelScore extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel prosperityLabel = new JLabel("Prosperity Bar", JLabel.CENTER);
	
	private JPanel timeButton= new JPanel();
	private JPanel scorePanel = new JPanel();
	private JPanel prosperity = new JPanel();
	
	private JButton stop=new JButton(new ImageIcon("pause.png"));
	private JButton go=new JButton(new ImageIcon("play.png"));
	
	private JProgressBar prosperityBar = new JProgressBar();
	
	public PanelScore() {
		super();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder());
		
		prosperity.setLayout(new GridLayout(6, 1));
		scorePanel.setLayout(new GridLayout(10, 1));
		timeButton.setLayout(new FlowLayout());
		
		prosperityBar = new JProgressBar(SwingConstants.VERTICAL);
		prosperityBar.setBackground(Color.red);
		
		prosperityLabel.setFont(Fonts.getF3());
		
		go.setBackground(Color.DARK_GRAY);
		stop.setBackground(Color.DARK_GRAY);
		timeButton.add(go);
		timeButton.add(stop);
		prosperity.add(prosperityBar);
		prosperity.add(prosperityLabel);
		scorePanel.add(prosperity);
		
		add(timeButton, BorderLayout.NORTH);
		add(scorePanel, BorderLayout.CENTER);
	}
	
	public JProgressBar getProsperityBar() {
		return prosperityBar;
	}

}
