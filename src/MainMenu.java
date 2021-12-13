import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class MainMenu extends JFrame {

    Font titleFont = new Font("Monospaced", Font.PLAIN, 40);
    Font normalFont = new Font("Monospaced", Font.PLAIN, 20);
    JTextField playerName;
    int gameLevel = 1;
    private About about;
    
    
    public MainMenu(){
        super("Simulator Meriam - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(400, 600);
        setResizable(false);
        setBackground(Color.black);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setBackground(Color.black);

        JLabel gameTitle = new JLabel("Simulator Meriam");
        gameTitle.setForeground(Color.white);
        gameTitle.setFont(titleFont);
        titlePanel.add(gameTitle);

        add(titlePanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        GridLayout buttonsLayout = new GridLayout(0,1);
        buttonsLayout.setVgap(5);
        buttonsPanel.setLayout(buttonsLayout);
        buttonsPanel.setBackground(Color.black);

        playerName = new JTextField("Guest");
        playerName.setBackground(Color.gray);
        playerName.setForeground(Color.white);
        playerName.setBorder(null);
        playerName.setHorizontalAlignment(JTextField.CENTER);
        playerName.setFont(normalFont);
        buttonsPanel.add(playerName);

        JButton highScoreButton = new JButton("High Score");
        highScoreButton.setFont(normalFont);
        highScoreButton.setHorizontalAlignment(JLabel.CENTER);
        highScoreButton.setBackground(Color.black);
        highScoreButton.setForeground(Color.white);
        buttonsPanel.add(highScoreButton);

        highScoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                new HighScore(MainMenu.this).setVisible(true);
			}
		});

        JButton aboutButton = new JButton("About Game");
        about = new About();
        aboutButton.setFont(normalFont);
        aboutButton.setHorizontalAlignment(JLabel.CENTER);
        aboutButton.setBackground(Color.black);
        aboutButton.setForeground(Color.white);
        buttonsPanel.add(aboutButton);

        aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about.setVisible(true);
			}
		});

    // -------------------- LEVEL -------------------- //
        JPanel levelPanel = new JPanel();
        FlowLayout levelLayout = new FlowLayout();
        levelLayout.setHgap(5);
        levelPanel.setLayout(levelLayout);
        levelPanel.setBackground(Color.black);

        // Level - easy
        JRadioButton easy = new JRadioButton("Easy", true);
        easy.setBackground(Color.green);
        easy.setFont(normalFont);

        // Level - medium
        JRadioButton medium = new JRadioButton("Medium", false);
        medium.setBackground(Color.orange);
        medium.setFont(normalFont);

        // Level - hard
        JRadioButton hard = new JRadioButton("Hard", false);
        hard.setBackground(Color.red);
        hard.setFont(normalFont);

        levelPanel.add(easy);
        levelPanel.add(medium);
        levelPanel.add(hard);

        // logical relationship
        ButtonGroup levelGroup = new ButtonGroup();
        levelGroup.add(easy);
        levelGroup.add(medium);
        levelGroup.add(hard);

        // level variables
        if(easy.isSelected()){
            gameLevel = 1;
            
        }
            
        else if (medium.isSelected()){
             gameLevel = 2;
        }
           
        else{
            gameLevel = 3;
        }
           


        buttonsPanel.add(levelPanel);

    // -------------------------------------------------- //

        JButton playButton = new JButton("Play!");
        playButton.setFont(normalFont);
        playButton.setHorizontalAlignment(JLabel.CENTER);
        playButton.setBackground(Color.black);
        playButton.setForeground(Color.white);
        playButton.addActionListener(new PlayGameListener(gameLevel));
        buttonsPanel.add(playButton);
        
        add(buttonsPanel, BorderLayout.CENTER);

        

        pack();
        setLocationRelativeTo(null);
    }

    private class PlayGameListener implements ActionListener{
        private int lv;

        public PlayGameListener(int lv){
            this.lv = lv;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            new GameFrame(MainMenu.this, playerName.getText(), lv).setVisible(true);
        }
    }
   
}
