package forms;

import models.User;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tools.JsonFileHandler;

public class rentYourCarGUI extends JFrame {

    Color white = Color.decode("#FFFFFF");
    Color whitegray = Color.decode("#EFEFEF");
    Color red = Color.decode("#FF000A");
    private JPanel menuBar;
    private JPanel mainPanel;
    private JPanel cardLayoutPanel;
    private JPanel registerUserPanel;
    private JLabel createAccountLabel;
    private JPanel registerFormPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameInput;
    private JLabel lastNameLabel;
    private JTextField lastNameInput;
    private JLabel ageLabel;
    private JTextField ageInput;
    private JLabel addressLabel;
    private JTextField addressInput;
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberInput;
    private JLabel emailLabel;
    private JTextField emailInput;
    private JLabel passwordLabel;
    private JTextField passwordInput;
    private JPanel registerActionPanel;
    private JButton submitButton;
    private JPanel createAdPanel;
    private JTextField cartypeField;
    private JTextField carmodelField;
    private JTextField yearmodelField;
    private ComboBoxModel gearboxModel;
    private ComboBoxModel fuelModel;
    private JTextField mileageField;
    private JTextField priceperdayField;
    private JTextField regnrField;
    private JButton createAddButton;
    private JLabel pageText;
    private JButton blueButton;
    private JButton greenButton;
    private JButton clearAllButton;
    private JRadioButton automatRadioButton;
    private JRadioButton manuellRadioButton;
    private JRadioButton bensinRadioButton;
    private JLabel errorCreateAdField;
    private JRadioButton dieselRadioButton;
    private JRadioButton elbilRadioButton;

    public rentYourCarGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        greenButton.setText("Home"); //kan endre navnet på knappene, og kan potensielt brukes til å gjøre flere ting-
        blueButton.setText("Create Ad"); //- basert på hvilken side du er på
        errorCreateAdField.setText("");
        //regnrField

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User createdUser = new User(firstNameInput.getText(),
                        lastNameInput.getText(), Integer.parseInt(ageInput.getText()), addressInput.getText(),
                        Integer.parseInt(phoneNumberInput.getText()),
                        emailInput.getText(), passwordInput.getText());
                System.out.println(createdUser);

                JsonFileHandler registerUserInformation = new JsonFileHandler();
                registerUserInformation.userToJson(createdUser);
                registerUserInformation.readUserFromJson();
            }



        });

        blueButton.addActionListener(new ActionListener() { //create ad button
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutPanel.removeAll();
                cardLayoutPanel.add(createAdPanel);
                cardLayoutPanel.repaint();
                cardLayoutPanel.revalidate();
            }
        });
        greenButton.addActionListener(new ActionListener() { //home button
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutPanel.removeAll();
                cardLayoutPanel.add(registerUserPanel);
                cardLayoutPanel.repaint();
                cardLayoutPanel.revalidate();
            }
        });

        clearAllButton.addActionListener(new ActionListener() { //Removes all info from fields
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearADFields(); } });

        //gearboxComboBox.getModel(gearboxModel);
        //fuelComboBox.getModel(fuelModel)

        automatRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
                GearBoxChange(1); //automatbox check, manuell uncheck
            } });
        manuellRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
                GearBoxChange(2); //manuell check, automatbox uncheck
            } });
        elbilRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
                FuelChange(1);
            } });
        dieselRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
                FuelChange(2);
            } });
        bensinRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
                FuelChange(3);
            } });
        createAddButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {
                CreateAd();
            } });
        regnrField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            regnrField.setBackground(white);
        } });
        cartypeField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            cartypeField.setBackground(white);
        } });
        carmodelField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            carmodelField.setBackground(white);
        } });
        yearmodelField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            yearmodelField.setBackground(white);
        } });
        mileageField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            mileageField.setBackground(white);
        } });
        priceperdayField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            priceperdayField.setBackground(white);
        } });
    }

    void ClearADFields() {
        regnrField.setText("");
        cartypeField.setText("");
        carmodelField.setText("");
        yearmodelField.setText("");
        mileageField.setText("");
        priceperdayField.setText("");
        GearBoxChange(0);
        FuelChange(0);
    }

    void GearBoxChange(int state) { //function to change radiobutton values under Gearbox
        automatRadioButton.setSelected(false);
        manuellRadioButton.setSelected(false);
        if (state == 1){automatRadioButton.setSelected(true);}
        if (state == 2){manuellRadioButton.setSelected(true);}
    }
    void FuelChange(int state) { //function to change radiobutton values under Gearbox
        elbilRadioButton.setSelected(false);
        dieselRadioButton.setSelected(false);
        bensinRadioButton.setSelected(false);
        if (state == 1){elbilRadioButton.setSelected(true);}
        if (state == 2){dieselRadioButton.setSelected(true);}
        if (state == 3){bensinRadioButton.setSelected(true);}
    }

    void CreateAd() { //Validates all areas and can check if it is able to be proccessed
        boolean fieldsNotEmpty = true; //bool for å sjekke om alle feltene har innhold
        errorCreateAdField.setText("");
        if (!elbilRadioButton.isSelected() && !dieselRadioButton.isSelected() && !bensinRadioButton.isSelected()) {
            errorCreateAdField.setText("Fueltype has not been set"); fieldsNotEmpty = false;
        }
        if (!automatRadioButton.isSelected() && !manuellRadioButton.isSelected()) {
            errorCreateAdField.setText("Gearbox has not been set"); fieldsNotEmpty = false;
        }
        if (priceperdayField.getText().isEmpty()) {
            errorCreateAdField.setText("Price field cannot be empty");
            priceperdayField.setBackground(red); fieldsNotEmpty = false;
        }
        if (mileageField.getText().isEmpty()) {
            errorCreateAdField.setText("Mileage field cannot be empty");
            mileageField.setBackground(red); fieldsNotEmpty = false;
        }
        if (yearmodelField.getText().isEmpty()) {
            errorCreateAdField.setText("Year model field cannot be empty");
            yearmodelField.setBackground(red); fieldsNotEmpty = false;
        }
        if (carmodelField.getText().isEmpty()) {
            errorCreateAdField.setText("Car model field cannot be empty");
            carmodelField.setBackground(red); fieldsNotEmpty = false;
        }
        if (cartypeField.getText().isEmpty()) {
            errorCreateAdField.setText("Car Type field cannot be empty");
            cartypeField.setBackground(red); fieldsNotEmpty = false;
        }
        if (regnrField.getText().isEmpty()) {
            errorCreateAdField.setText("Registration Number field cannot be empty");
            regnrField.setBackground(red); fieldsNotEmpty = false;
        }
        if (fieldsNotEmpty) {
            float price = 0;
            boolean price_is_not_zero = true;
            try {
                price = Float.parseFloat(priceperdayField.getText());
                if (price == 0) { price_is_not_zero = false; }
            } catch (NumberFormatException e) { }
            if (regnrField.getText().length() < 7) { //checks if number has 7 numbers + letters
                errorCreateAdField.setText("Registration Number is too short");
            } else
            if (regnrField.getText().length() > 7) { //checks if number has 7 numbers + letters
                errorCreateAdField.setText("Registration Number is too long");
            } else
            if (!mileageField.getText().matches("[0-9]+")) {
                errorCreateAdField.setText("Mileage can only contain numbers");
            } else
            if (!priceperdayField.getText().matches("[0-9]+")) {
                errorCreateAdField.setText("Price can only contain numbers");
            } else
            if (!price_is_not_zero) {
                errorCreateAdField.setText("Price cannot be 0");
            } else
            if (!regnrField.getText().matches("[a-zA-Z0-9]+")) { //checks if regnr only contains letters/numbers
                errorCreateAdField.setText("Registration Number can only contain Letters and Numbers");
            } else {
                /*Her kan skjemaet sendes
                * Kanskje lurt å sjekke om bruker eksisterer*/
            }

        }
    }

}
