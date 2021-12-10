import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable, MouseListener, MouseMotionListener{
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 900;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private final int FPS = 60;
	private double averageFPS;
	
	private Cannon cannon = new Cannon();
	private SliderInput angleSlider = new SliderInput(50, 155, 157, 0, "Angle");
	private SliderInput sizeSlider = new SliderInput(50, 225, 0, 75, "Size");
	private SliderInput powerSlider = new SliderInput(50, 295, 150, 0, "Power");
	private Cloud cloud1 = new Cloud();
	private Cloud cloud2 = new Cloud();
	private Cloud cloud3 = new Cloud();
	public static ArrayList<Enemy> enemies;
	
	
	
    public GamePanel(double spawnTime, GameFrame.ScoreManager sManager){
    	
    	

    }
}
