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
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;



public class myListings extends JFrame {
    private JPanel myListings;
    JsonFileHandler jfh = new JsonFileHandler();
    private JPanel navigationPanel;
    private JLabel myListingsLabel;
    private JButton deleteButton;
    private JList list1;
    private JButton homeButton;
    private JButton signOutButton;
    private javax.swing.JScrollPane JScrollPane;
    private JLabel select;
    private int selectedIndex;


    public myListings() {
        setContentPane(myListings);
        setTitle("rentyourcar.no");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        select.setVisible(false);
        deleteButton.setVisible(false);

        myListingsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));

        JScrollPane.getVerticalScrollBar().setUnitIncrement(30);

        File carJson = new File("src/main/java/json/bil.json");

        ArrayList<Car> carReadFromfile = jfh.readFromJSONfile(carJson);


        DefaultListModel listModel = new DefaultListModel();

        list1.setModel(listModel);

        for (Car x : carReadFromfile) {
            listModel.addElement(x.getBrand() + " " + x.getModel() + " " + x.getYear());
        }

        for (Car x : carReadFromfile) {
            System.out.println(x.getBrand() + " " + x.getModel() + " " + x.getYear());
        }


        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selected = list1.getSelectedValue().toString();
                select.setVisible(true);
                select.setText("Selected item is " + selected);

                //hente selected sin index
                selectedIndex = list1.getSelectedIndex();

                if(select.isVisible()){
                    select.setText("Selected item is " + selected);
                    deleteButton.setVisible(true);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //delete the element and remake a new file
                carReadFromfile.remove(selectedIndex);
                System.out.println();
                for (Car x : carReadFromfile) {
                    System.out.println(x.getBrand() + " " + x.getModel() + " " + x.getYear());
                }

                File carJson1 = new File("src/main/java/json/bil.json");

                carJson1.delete();


                try {
                    FileWriter carJson2 = new FileWriter("src/main/java/json/bil.json");
                    carJson2.write(carReadFromfile.toString());
                    System.out.println("File: " + carJson2);
                    carJson2.close();
                }

                catch(Exception m) {
                    m.printStackTrace();
                }


            }
        });
    }

    public static void main(String[] args) {
        myListings myFrame = new myListings();
    }
}
