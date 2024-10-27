import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FlashcardClueScreen extends JFrame {
    JPanel displayPanel;
    JLabel label;
    JButton flip;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    public FlashcardClueScreen(String text) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(450,250,800,600);
        Handling h = new Handling(this, "data.txt");
        setLayout(null);
        setResizable(false);


        displayPanel = new JPanel();
        displayPanel.setBounds(120,120,550,350);
        displayPanel.setBorder(border);
        displayPanel.setLayout(new BorderLayout());

        label = new JLabel();
        label.setText(text);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);

        flip = new JButton("Show answer");
        flip.setBounds(350, 500, 100, 50);
        flip.addActionListener(h);

        add(displayPanel);
        add(flip);
        displayPanel.add(label, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        FlashcardClueScreen t = new FlashcardClueScreen("Hello World");
        t.setVisible(true);
    }
}
