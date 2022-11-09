package forms;

import models.Car;
import tools.JsonFileHandler;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class booking extends JFrame {
    private JPanel booking;
    JsonFileHandler jfh = new JsonFileHandler();
    private javax.swing.JScrollPane JScrollPane;
    private JTextField regNum;
    private JTextField brand;
    private JTextField model;
    private JTextField year;
    private JTextField driveMileage;
    private JTextField price;
    private JTextField bookingStartDate;
    private JTextField bookingStartTime;
    private JTextField bookingEndDate;
    private JTextField bookingEndTime;
    private JButton bookButton;

    public booking() {
        setContentPane(booking);
        setTitle("rentyourcar.no");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JScrollPane.getVerticalScrollBar().setUnitIncrement(30);

        //setter noen av input-fieldene som ikke-redigerbare
        regNum.setEditable(false);
        brand.setEditable(false);
        model.setEditable(false);
        year.setEditable(false);
        driveMileage.setEditable(false);
        price.setEditable(false);

        File carJson = new File("src/main/java/json/bil.json");

        ArrayList<Car> carReadFromfile = jfh.readFromJSONfile(carJson);

        //bruke selectedIndex fra homePage.java inne som carReadFromfile.get(selectedIndex)
        regNum.setText(carReadFromfile.get(0).getRegNum());
        brand.setText(carReadFromfile.get(0).getBrand());
        model.setText(carReadFromfile.get(0).getModel());
        year.setText(String.valueOf(carReadFromfile.get(0).getYear()));
        driveMileage.setText(String.valueOf(carReadFromfile.get(0).getDriveMileage()));
        price.setText(String.valueOf(carReadFromfile.get(0).getPrice()));

    }

    public static void main(String[] args) {
        booking myFrame = new booking();
    }


}
