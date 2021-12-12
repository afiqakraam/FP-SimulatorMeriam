import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GameFrame extends JFrame {
    
    // Nilai awal
    private static final int STARTING_LIFE = 100;
    private static final int STARTING_SCORE = 0;

    // Main Menu
    private MainMenu mainMenu;

    // Game Panel -> isi dari gamenya
    private GamePanel gamePanel;

    // Label Nilai
    private JLabel lifeDisplay;
    private JLabel scoreDisplay;

    private ScoreManager scoreManager;
    private String highScore;


    public GameFrame(MainMenu mainMenu, String playerName, int lv){
        super("Simulator Meriam : " + playerName);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // setSize(800, 600);
        setResizable(false);
        setBackground(Color.black);

        // Main Menu
        this.mainMenu = mainMenu;
	// High Score
        highScore = this.getHighScore();
        // Score Manager
        scoreManager = new ScoreManager(STARTING_LIFE, STARTING_SCORE);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(Color.darkGray);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.red);
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                GameFrame.this.setVisible(false);
                GameFrame.this.dispose();
            }
        }); 
        headerPanel.add(exitButton, BorderLayout.EAST);

        // Score Panel
        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.darkGray);

        GridLayout scorePanelLayout = new GridLayout(0,4);
        scorePanelLayout.setHgap(10);
        scorePanel.setLayout(scorePanelLayout);

        // Life Score
        JLabel lifeLabel = new JLabel(playerName + " life:");
        lifeLabel.setForeground(Color.WHITE);
		lifeLabel.setHorizontalAlignment(JLabel.RIGHT);
		scorePanel.add(lifeLabel);

        lifeDisplay = new JLabel("100");
		lifeDisplay.setForeground(Color.GREEN);
		lifeDisplay.setHorizontalAlignment(JLabel.LEFT);
		scorePanel.add(lifeDisplay);

        // The Player Score
		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(JLabel.RIGHT);
		scorePanel.add(scoreLabel);
		
		scoreDisplay = new JLabel("0");
		scoreDisplay.setForeground(Color.CYAN);
		scoreDisplay.setHorizontalAlignment(JLabel.LEFT);
		scorePanel.add(scoreDisplay);
		
		headerPanel.add(scorePanel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        
        gamePanel = new GamePanel(lv, scoreManager);
        add(gamePanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
    private String getHighScore() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void dispose(){
        super.dispose();
        mainMenu.setVisible(true);
    }

    public class ScoreManager {
        private double health;
        private double score;
    
        public ScoreManager(int initialHealth, int initialScore){
            health = initialHealth;
            score = initialScore;
        }
    
        public void doDamage(int damage){
            health -= damage; // -> damage diatur di game panel *disesuaikan dengan lv*
            updateDisplay();
        }


        private void updateDisplay(){
            if (health < 0)
                health = 0;
            
            lifeDisplay.setText(Long.toString(Math.round(health)));
            scoreDisplay.setText(Long.toString(Math.round(score)));

            if (health < 20)
                lifeDisplay.setForeground(Color.red);
            else if (health < 50)
                lifeDisplay.setForeground(Color.orange);
            else
                lifeDisplay.setForeground(Color.green);

            if (health <= 0) {
                // The player has died
                
                // Notify player that game is over
                JOptionPane.showMessageDialog(null, 
                        "The game is over. \n"
                        + "You managed to collect " + Math.round(score) + " points.",
                        "Game Over", JOptionPane.INFORMATION_MESSAGE);
                
                // Destroy the game window and return to the main menu!
                GameFrame.this.dispose();
            }
        }
	public String getHighScore() { 
            FileReader readFile = null;
            BufferedReader reader = null;
            try {
                readFile = new FileReader("highscore.txt");
                reader = new BufferedReader(readFile);
                return reader.readLine(); 
            }
            catch (Exception e) {
                return "Nobody:0"; 
            }
            finally {
                try {
                    if (reader != null)
                    reader. close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                } 
            } 
        }
    }
}
