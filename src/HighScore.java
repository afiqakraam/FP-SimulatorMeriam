import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighScore extends JFrame {
    Font titleFont = new Font("Monospaced", Font.PLAIN, 40);
    Font normalFont = new Font("Monospaced", Font.PLAIN, 20);
    JLabel highScore;
    JLabel dummyData;
    MainMenu mainMenu;

    public HighScore(MainMenu mainMenu){
        super("Highscore");
        this.mainMenu = mainMenu;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(600,400);
        setBackground(Color.black);

        JPanel hsPanel = new JPanel();
        hsPanel.setBackground(Color.BLACK);
        hsPanel.setLayout(new BorderLayout());
        highScore = new JLabel("Highscore");
        highScore.setFont(titleFont);
        highScore.setForeground(Color.WHITE);
        highScore.setHorizontalAlignment(JLabel.CENTER);
        hsPanel.add(highScore, BorderLayout.NORTH);

        dummyData = new JLabel();
        dummyData.setText("<html>1. Peter Parker   120<br>2. Doctor O   100<br>3. Tobey   70<br></html>");
        dummyData.setFont(normalFont);
        dummyData.setForeground(Color.WHITE);
        dummyData.setHorizontalAlignment(JLabel.CENTER);
        hsPanel.add(dummyData,BorderLayout.CENTER);
        add(hsPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    @Override
    public void dispose(){
        super.dispose();
        mainMenu.setVisible(true);
    }
    
}
