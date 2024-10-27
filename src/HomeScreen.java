import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;

public class HomeScreen extends JFrame {
    JButton goButton;
    JComboBox classOptions;
    public HomeScreen() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(450,250,800,600);
        Handling h = new Handling(this, "data.txt");
        setResizable(false);


        JLabel study = new JLabel("Study");
        study.setBounds(300,150,100,25);
        study.setFont(new Font("PT Sans", Font.PLAIN, 24));




        goButton = new JButton("Go");
        goButton.setBounds(300, 200, 200, 50);
        goButton.setFocusable(false);
        goButton.setFont(new Font("PT Sans", Font.BOLD, 40));
        goButton.addActionListener(h);

        classOptions = new JComboBox();

        this.add(goButton);
        this.add(study);
    }
    
    public void addClasses(String[] classes) {
        classOptions = new JComboBox(classes);
        classOptions.setBounds(380, 140, 150, 50);
        add(classOptions);
    }



    public static void main(String[] args) {
        new HomeScreen();
    }

}
