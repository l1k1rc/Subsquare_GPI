package gui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import engine.GridParameters;
import grid.Box;
import grid.BoxFactory;
import grid.Grid;
import used.Point;

public class Scene extends JPanel {

	private static final long serialVersionUID = 1L;
	private Grid grid;
	private ImageIcon pics;
	private Graphics g2;
	private Box box;

	public Scene() {
		super();
		setPreferredSize(new Dimension(GridParameters.WIDTH*28,GridParameters.HEIGHT*28));
		setBorder(BorderFactory.createEtchedBorder());
		setBackground(Color.DARK_GRAY);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGlobalGrid(g);
	}

	public void paintGlobalGrid(Graphics g) {
		g2 = (Graphics2D) g;
		// the dimension of the grid
		for (int y = 0; y < grid.height; y++) {
			for (int x = 0; x < grid.width; x++) {
				box = grid.getBoxAt(y, x);
				if (box.getGroundType().isGrass()) {
					drawGround(new Point(x, y), g2, box);
				} else if (box.getGroundType().isWall()) {
					drawGround(new Point(x, y), g2, box);
				} else if (!box.getIsFree()) {
					drawObstacle(new Point(x, y), g2, box);
				}
			}
		}
	}

	// TODO paint all components of the map here with a specifics methods
	public void drawGround(Point p, Graphics g, Box box) {
		g.drawImage(box.getGroundType().getImage(), p.getAbscisse() * 28, p.getOrdonne() * 28, null);
	}

	public void drawObstacle(Point p, Graphics g, Box box) {
		pics = new ImageIcon(
				getClass().getResource("/images/terrain/" + GridParameters.getInstance().getGround() + ".png"));
		Image t = pics.getImage();
		g.drawImage(t, p.getAbscisse() * 28, p.getOrdonne() * 28, null);
		g.drawImage(box.getGroundType().getImage(), p.getAbscisse() * 28, p.getOrdonne() * 28, null);
	}
	
	public void zoomLess(Graphics g) {
		g2 = (Graphics2D) g;
		// the dimension of the grid
		for (int y = 0; y < grid.height-20; y++) {
			for (int x = 0; x < grid.width-20; x++) {
				box = grid.getBoxAt(y, x);
				if (box.getGroundType().isGrass()) {
					drawGround(new Point(x, y), g2, box);
				} else if (box.getGroundType().isWall()) {
					drawGround(new Point(x, y), g2, box);
				} else if (!box.getIsFree()) {
					drawObstacle(new Point(x, y), g2, box);
				}
			}
		}
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

}
