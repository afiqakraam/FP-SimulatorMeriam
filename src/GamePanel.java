import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GamePanel extends JPanel{
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 1000;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private final int FPS = 60;
	private double averageFPS;

	// public static ArrayList<Enemy> enemies;
	public static Enemy enemy1 = new Enemy(1, 3);
	public static Enemy enemy2 = new Enemy(2, 3);
	public static Enemy enemy4 = new Enemy(3, 3);
	public static Enemy enemy3 = new Enemy(1, 3);
	private Cannon cannon = new Cannon();
	
    public GamePanel(double spawnTime, GameFrame.ScoreManager sManager){
    	
    	super();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setFocusable(true);
		this.requestFocus();

		
    }

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
		enemy1.draw(g2d);
		enemy2.draw(g2d);
		enemy3.draw(g2d);
		enemy4.draw(g2d);
		cannon.draw(g2d);
	}

	public interface Drawable{
		public void draw(Graphics2D g);
	}

	
	
}
