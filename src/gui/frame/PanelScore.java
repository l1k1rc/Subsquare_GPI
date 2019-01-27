package gui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelScore extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel timeButton= new JPanel();
	private JPanel scorePanel = new JPanel();
	
	private JButton stop=new JButton(new ImageIcon("pause.png"));
	private JButton go=new JButton(new ImageIcon("play.png"));
	
	public PanelScore() {
		super();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder());
		
		scorePanel.setLayout(new GridLayout(10, 1));
		timeButton.setLayout(new FlowLayout());
		
		go.setBackground(Color.DARK_GRAY);
		stop.setBackground(Color.DARK_GRAY);
		timeButton.add(go);
		timeButton.add(stop);
		
		add(timeButton, BorderLayout.NORTH);
	}

}
