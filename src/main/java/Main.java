import forms.rentYourCarGUI;

import javax.swing.*;

public class Main {
    public static rentYourCarGUI mainWindow;
    public static void main(String[] args) {
        mainWindow = new rentYourCarGUI("RentYourCar");
        mainWindow.setVisible(true);
    }
}
