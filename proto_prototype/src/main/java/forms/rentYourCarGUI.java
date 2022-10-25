package forms;

import javax.swing.*;

public class rentYourCarGUI extends JFrame {

    private JPanel mainPanel;

    public rentYourCarGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

}
