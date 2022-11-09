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
    private JButton blueButton;
    private JButton greenButton;
    private JButton clearAllButton;
    private JRadioButton automatRadioButton;
    private JRadioButton manuellRadioButton;
    private JRadioButton bensinRadioButton;
    private JLabel errorCreateAdField;
    private JRadioButton dieselRadioButton;
    private JRadioButton elbilRadioButton;

    //start page
    private JPanel startPanel;
    private JButton loggInnButton;
    private JButton registerButton;
    private JButton backButton;

    //home page

    private JPanel homePanel;
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

    //My listings page
    private JPanel myListings;
    private JPanel deletePanel;
    //JsonFileHandler jfh = new JsonFileHandler();
    private JButton deleteButton;
    private JList list2;
    private javax.swing.JScrollPane JScrollPane2;
    private JLabel select2;
    private JLabel myListingsLabel;
    private JButton purpleButton;

    //booking panel
    private JPanel bookingPanel;
    private JScrollPane JScrollPane3;
    private JLabel regNumLabel;
    private int selectedIndex;
    private JTextField regNumField;
    private JLabel brandLabel;
    private JTextField brandField;
    private JLabel modelLabel;
    private JTextField modelField;
    private JLabel yearLabel;
    private JTextField yearField;
    private JLabel driveMileageLabel;
    private JTextField driveMileageField;
    private JLabel priceLabel;
    private JTextField priceField;
    private JLabel bookingStartDateLabel;
    private JTextField bookingStartDateField;
    private JLabel bookingStartTimeLabel;
    private JTextField bookingStartTimeField;
    private JLabel bookingEndDateLabel;
    private JTextField bookingEndDateField;
    private JLabel bookingEndTimeLabel;
    private JTextField bookingEndTimeField;
    private JButton bookButton2; //Field


    public rentYourCarGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(1000, 800);

        ChangeCard(startPanel);
        menuBar.setVisible(false);

        bookButton.setVisible(true);
        select.setVisible(false);
        deleteButton.setVisible(false);
        select2.setVisible(false);
        JScrollPane.getVerticalScrollBar().setUnitIncrement(30);
        JScrollPane2.getVerticalScrollBar().setUnitIncrement(30);

        DefaultListModel listModel = new DefaultListModel();

        list1.setModel(listModel);

        greenButton.setText("Home"); //kan endre navnet på knappene, og kan potensielt brukes til å gjøre flere ting-
        blueButton.setText("Create Ad"); //- basert på hvilken side du er på
        errorCreateAdField.setText("");
        //regnrField

        loggInnButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(homePanel);
                menuBar.setVisible(true);
            } });

        backButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(startPanel);
            } });

        registerButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(registerUserPanel);
                //menuBar.setVisible(true);
            } });


        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(bookingPanel);
            }
        });
        /*
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
        }); */

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
                ChangeCard(createAdPanel);
            }
        });
        greenButton.addActionListener(new ActionListener() { //home button
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(homePanel);
            }
        });

        purpleButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(myListings);
            }  });

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

    void ChangeCard(JPanel newCard) {
        cardLayoutPanel.removeAll();
        cardLayoutPanel.add(newCard);
        cardLayoutPanel.repaint();
        cardLayoutPanel.revalidate();
        //if (newCard.getName().equals("homePanel")) {
        //    menuBar.setVisible(false);
        //} else {
        //    menuBar.setVisible(true);
        //}
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
