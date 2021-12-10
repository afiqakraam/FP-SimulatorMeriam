import java.awt.Graphics2D;
import java.awt.*;


public class Enemy {

	//x and y coordinates of enemies
	private double x;
	private double y;
	
	private double dx;
	
	//radius of the enemies
	private int radius;
	
	//speed of enemies
	private double speed;
	
	//Enemies Type based on level
	private int type;
	private int level;
	
	//number lives of enemies
	private int lives;
	
	//Timer enemies
	private int spawntime;
	
	//color of the enemies
	private Color color1;
	private Color color2;
	
	private boolean ready;
    private boolean hit;
    private long hitTimer;
    
    private boolean slow;
	
    public Enemy(int type,int level) {
    	
    	this.type = type;
    	this.level = level;
    	
    	if(type == 1) {
    		color1 = Color.RED;
    		if(level == 1) {
    			speed = 6;
    			radius = 20;
    			lives = 1;
    			spawntime = 5;
    		}
    		else if(level == 2) {
    			speed = 8;
    			radius = 15;
    			lives = 1;
    			spawntime = 4;
    		}
    		else if(level == 3) {
    			speed = 10;
    			radius = 10;
    			lives = 1;
    			spawntime = 3;
    		}
    	}
    	else if (type == 2) {
    		color1 = Color.BLUE;
    		if(level == 1 ) {
    			speed = 8;
    			radius = 15;
    			lives = 1;
    			spawntime = 2;
    		}
    		else if(level == 2 ) {
    			speed = 10;
    			radius = 10;
    			lives = 1;
    			spawntime = 2;
    		}
    		
    		else if(level == 3 ) {
    			speed = 12;
    			radius = 7;
    			lives = 1;
    			spawntime = 2;
    		}
    	}
    	
    	else if (type == 3) {
    		color1 = Color.GREEN;
    		if(level == 1 ) {
    			speed = 8;
    			radius = 15;
    			lives = 1;
    			spawntime = 2;
    		}
    		else if(level == 2 ) {
    			speed = 10;
    			radius = 10;
    			lives = 1;
    			spawntime = 2;
    		}
    		
    		else if(level == 3 ) {
    			speed = 12;
    			radius = 7;
    			lives = 1;
    			spawntime = 2;
    		}
    	}
    	color2 = Color.RED;
    	
    	x = Math.random()*GamePanel.WIDTH/2 + GamePanel.WIDTH/4;
    	y = (radius + 150);
    	
    	double angle = Math.random() * 140 + 20;
    	double radians = Math.toRadians(angle);
    	
    	dx = Math.cos(radians) * speed;
    	
    	ready = false;
    	hit = false;
    	hitTimer = 0;
    	slow = false;
    	
    }
    
    public double getX() {return x;}
    public double getY() {return y;}
    public double getDx() {return dx;}
//  public double getDy() {return dy;}
    public int getRadius() {return radius;}
    public double getSpeed() {return speed;}
    public int getType() {return type;}
    public int getLevel() {return level;}
    public int getLives() {return lives;}
    public boolean gotHit() {return hit;}
    public boolean isSlow() {return slow;}
    
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setDx(double dx) {this.dx = dx;}
//  public void setDy(double dy) {this.dy = dy;}
    public void setRadius(int radius) {this.radius = radius;}
    public void setSpeed(double speed) {this.speed = speed;}
    public void setLives(int lives) {this.lives = lives;}
    public void setHit(boolean b) {this.hit = b;}
    public void setSlow(boolean b) {slow = b;}
	
    public void update() {
    	if(ready == false) {
    		if(x > radius && x < GamePanel.WIDTH - radius 
    		  && y > (radius + 100) && y < GamePanel.HEIGHT - radius) {
    			
    			ready = true;
    		}
    	}
    	checkBoundaries();
    }
    
    public void draw(Graphics2D g) {
    	if(hit == false) {
    		g.setColor(color1);
    		g.fillOval((int) (x-radius),(int)(y-radius),(2*radius),(2*radius));
    		g.setStroke(new BasicStroke(3));
    		g.setColor(color1.darker());
    		g.drawOval((int) (x-radius),(int)(y-radius),(2*radius),(2*radius));
    		g.setStroke(new BasicStroke(1));
    	}
    	else {
    		g.setColor(color2);
            g.fillOval((int) (x - radius), (int) (y - radius), 2 * radius, 2 * radius);
            g.setStroke(new BasicStroke(3));
            g.setColor(color2.darker());
            g.drawOval((int) (x - radius), (int) (y - radius), 2 * radius, 2 * radius);
            g.setStroke(new BasicStroke(1));
    	}
    }
    
    private void checkBoundaries(){
    	//jika menyentuh ujung frame arahnya dibalik
    	if(x < radius && dx < 0) {
    		dx = -dx;
    	}
    	if(x > GamePanel.WIDTH - radius && dx > 0)
        {
            dx = -dx;
        }
    }
	
}



































