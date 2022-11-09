package forms;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.Car;
import tools.JsonFileHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class homePage extends JFrame {
    private JPanel homePage;
    JsonFileHandler jfh = new JsonFileHandler();
    private JPanel navigationPanel;
    private JLabel logoLabel;
    private JButton myListingsButton;
    private JButton signOutButton;
    private JLabel homePageLabel;
    private javax.swing.JScrollPane JScrollPane;
    private JList list1;
    private JButton bookButton;
    private JLabel select;


    public homePage() {
        setContentPane(homePage);
        setTitle("rentyourcar.no");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        bookButton.setVisible(false);
        select.setVisible(false);

        homePageLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));

        JScrollPane.getVerticalScrollBar().setUnitIncrement(30);

        File carJson = new File("src/main/java/json/bil.json");

        ArrayList<Car> carReadFromfile = jfh.readFromJSONfile(carJson);


        DefaultListModel listModel = new DefaultListModel();

        list1.setModel(listModel);

        for (Car x : carReadFromfile) {
            listModel.addElement(x.getBrand() + " " + x.getModel() + " " + x.getYear());
        }


        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selected = list1.getSelectedValue().toString();
                select.setVisible(true);
                select.setText("Selected item is " + selected);

                //hente selcted sin index
                int selectedIndex = list1.getSelectedIndex();
                System.out.println(selectedIndex);


                //fjerne book knappen hvis bilen er booket eller bare gi en melding om at bilen er booket
                Boolean status = carReadFromfile.get(selectedIndex).getAvailable();

                if(!status){
                    if(select.isVisible()){
                        bookButton.setVisible(false);
                        select.setText("Selected item is " + selected + " and is booked!" + " Please book another car :)");
                    }
                }

                if(status){
                    if(select.isVisible()){
                        bookButton.setVisible(true);
                    }
                }

                //hente alt av info fra array med indexen vi har
                System.out.println(carReadFromfile.get(selectedIndex).getBrand());

                //Endre siden når man trykker på book knappen
            }
        });

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Send meg til booking side");
            }
        });
    }

    public static void main(String[] args) {
        homePage myFrame = new homePage();
    }


}