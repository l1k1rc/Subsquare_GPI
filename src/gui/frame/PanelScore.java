package gui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import engine.GridParameters;
import gui.fontElements.Fonts;

public class PanelScore extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel prosperityLabel = new JLabel("Prosperity Bar", JLabel.CENTER);
	private JLabel date = new JLabel("",JLabel.CENTER);
	private JLabel hour = new JLabel("",JLabel.CENTER);
	
	private JPanel timeButton= new JPanel();
	private JPanel scorePanel = new JPanel();
	private JPanel prosperity = new JPanel();
	
	private JButton stop=new JButton(new ImageIcon("pause.png"));
	private JButton go=new JButton(new ImageIcon("play.png"));
	private JButton fast = new JButton(new ImageIcon("fast.png"));
	
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
		fast.setBackground(Color.DARK_GRAY);
		timeButton.add(go);
		timeButton.add(stop);
		timeButton.add(fast);
		prosperity.add(date);
		prosperity.add(hour);
		prosperity.add(prosperityBar);
		prosperity.add(prosperityLabel);
		scorePanel.add(prosperity);
		
		fast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(GridParameters.speed>50) {
					GridParameters.setSpeed(GridParameters.speed-50);
					MainFrame.setThreadSpeed(GridParameters.speed);
				}
			}
		});
		
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.setStop(false);
			}
		});
		
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.setStop(true);
			}
		});
		
		add(timeButton, BorderLayout.NORTH);
		add(scorePanel, BorderLayout.CENTER);
	}
	
	public JProgressBar getProsperityBar() {
		return prosperityBar;
	}
	
	public JLabel getDateField() {
		return date;
	}
	
	public JLabel getHourField() {
		return hour;
	}
}
