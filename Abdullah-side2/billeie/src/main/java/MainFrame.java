package main.java;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JButton hjemButton;
    private JButton leggTilAnnonseButton;
    private JLabel Image;
    private JLabel Image2;
    private JLabel Image3;
    private JLabel Image4;
    private JLabel Image5;
    private JLabel Image6;
    private JLabel Image7;
    private JLabel Image8;
    private JLabel Image9;


    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("rentyourcar.no");
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        Image = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image2 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image3 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image4 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image5 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image6 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image7 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image8 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));
        Image9 = new JLabel(new ImageIcon("/Users/abdullahsalha/Desktop/billeie/Images/full.png"));

    }
}

