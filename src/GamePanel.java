import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.awt.Graphics2D;

public class GamePanel extends JPanel{
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 1000;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private final int FPS = 60;
	private double averageFPS;
	
	public static Enemy enemies = new Enemy(1, 1);
	
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
		enemies.draw(g2d);
	}

	public interface Drawable{
		public void draw(Graphics2D g);
	}

	
	
}
