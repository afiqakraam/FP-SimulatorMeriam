import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class About extends JFrame{
    private JButton backButton;
	private JPanel about;
    private MainMenu mainMenu;
    
    public About(MainMenu mainMenu){ 
        super("About");
        this.mainMenu = mainMenu;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        backButton = new JButton("Close");
        backButton.setHorizontalAlignment(JLabel.CENTER);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        about = new JPanel(new GridBagLayout());
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        getContentPane().setBackground(Color.BLACK);
        about.setBackground(Color.BLACK);
        setResizable(true);
        setLayout(new GridBagLayout());

        JLabel description = new JLabel("<html><h2>Built by</h2>"+
        "    <ol>"+
        "        <li>Afiq Akram - 5025201270</li>"+
        "        <li>Muhammad Raihan Athallah - 5025201206</li>"+
        "        <li>Helmi Taqiyudin - 5025201152</li>"+
        "        <li>Nathanael Roviery - 5025201258</li>"+
        "    </ol>"+
        "    <h2>Description</h2>"+
        "    <p style=\"text-indent: 30px;\">Simulator Meriam merupakan game sederhana yang dirancang menggunakan Java Swing Framework." +
        "    Anda dapat menembakkan bola meriam dari bermacam-macam level yang tersedia dan mendapatkan skor tertinggi. Anda dapat "+
        "    mengontrol meriam menggunakan mouse yang membantu akurasi Anda dalam menembak.</p>");
            
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.CENTER;
        c.ipady = 90;
        c.ipadx = 220;
        about.add(description, c);

        c.ipady = 0;
        c.ipadx = 0;
        c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0,0,0,0);
		this.backButton.setEnabled(true);
        about.add(backButton, c);
		
		add(about);
		pack();
        setSize(400, 500);
		setVisible(true);
        setLocationRelativeTo(null);
        description.setForeground(Color.WHITE);
    }

    @Override
    public void dispose(){
        super.dispose();
        mainMenu.setVisible(true);
    }

}
