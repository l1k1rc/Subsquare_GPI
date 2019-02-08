package gui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import gui.fontElements.Fonts;

public class PanelAPI extends JPanel {

	private static final long serialVersionUID = 1L;

    private GridBagConstraints gbc = new GridBagConstraints();

	
	public PanelAPI() {
		super();
		
		JButton[] tabButtonAPI= {new JButton(new ImageIcon("resid_icon.png")),new JButton(new ImageIcon("commercial_icon.png")),new JButton(new ImageIcon("gdp.png")),new JButton(new ImageIcon("hid.png")),new JButton(new ImageIcon("hehe.png")),
				new JButton(new ImageIcon("zoomin.png")), new JButton(new ImageIcon("zoomless.png")) };
		
		JPanel[] tabCells= { new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(),new JPanel(),
				new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()};
		
		setLayout(new GridBagLayout());
		//---------------------------Setting and placement of the cells from the GridBagLayout---------
		for(int index=0;index<tabCells.length;index++) {
			tabCells[index].setPreferredSize(new Dimension(160, 55));
		}
		gbc.gridx=0;
		gbc.gridy=0;
		
		for(int index=0;index<tabButtonAPI.length;index++) {
			add(tabButtonAPI[index],gbc);
			add(tabCells[index],gbc);
		
			gbc.gridx++;
			if(gbc.gridx%7==0) {
				gbc.gridy++;
				gbc.gridx=0;
			}
		}
		//------------------------Setting JButton with a special font and toolTipPex--------------------
		for(int index=0;index<tabButtonAPI.length;index++) {
			tabButtonAPI[index].setPreferredSize(new Dimension(100, 60));
			tabButtonAPI[index].setFont(Fonts.getF2());
			tabButtonAPI[index].setBackground(Color.DARK_GRAY);
		}
		tabButtonAPI[0].setToolTipText("TODO");

		
	}


}
