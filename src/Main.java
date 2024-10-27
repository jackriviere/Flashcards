import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    JFrame homeScreen;
    public static void main(String[] args) {
        FlashcardDatabase database  = new FlashcardDatabase("data.txt");

        JFrame homeScreen = new JFrame();
        homeScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        homeScreen.setLayout(null);
        homeScreen.setBounds(450,250,800,600);

        JLabel study = new JLabel("Study");
        study.setBounds(300,150,100,25);
        study.setFont(new Font("PT Sans", Font.PLAIN, 24));

        JButton goButton = new JButton("Go");
        goButton.setBounds(300, 200, 200, 50);
        goButton.setFocusable(false);
        goButton.setFont(new Font("PT Sans", Font.BOLD, 40));


        JComboBox classOptions = new JComboBox(database.getClasses());
        classOptions.setBounds(375,125,150,75);

        homeScreen.add(study);
        homeScreen.add(goButton);
        homeScreen.add(classOptions);
        homeScreen.setVisible(true);

        JFrame questionFrame = new JFrame();
        questionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        questionFrame.setLayout(null);
        questionFrame.setBounds(450,250,800,600);
        questionFrame.setVisible(false);

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                questionFrame.setVisible(true);
            }
        });
    }
}
