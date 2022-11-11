package forms;

import models.User;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tools.JsonFileHandler;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.Car;
import tools.JsonFileHandler2;
import java.io.File;
import java.util.ArrayList;

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
    private JButton adButton;
    private JButton homeButton;
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
    JsonFileHandler2 jfh = new JsonFileHandler2();
    private JLabel homePageLabel;
    private javax.swing.JScrollPane JScrollPane;
    private JList list1;
    private JButton bookButton;
    private JLabel select;

    //My listings page
    private JPanel myListings;
    private JPanel deletePanel;
    private JButton deleteButton;
    private JList list2;
    private javax.swing.JScrollPane JScrollPane2;
    private JLabel select2;
    private JLabel myListingsLabel;
    private JButton listingsButton;

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
    private JButton signOutButton;
    private JLabel errorRegisterUser;


    public rentYourCarGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(1000, 800);

        ChangeCard(startPanel);
        menuBar.setVisible(true);

        bookButton.setVisible(false);
        select.setVisible(false);
        deleteButton.setVisible(false);
        select2.setVisible(false);
        JScrollPane.getVerticalScrollBar().setUnitIncrement(30);
        JScrollPane2.getVerticalScrollBar().setUnitIncrement(30);


        listingsButton.setText("My listings");
        homeButton.setText("Home");
        adButton.setText("Create Ad");
        signOutButton.setText("Sign out");
        errorCreateAdField.setText("");
        errorRegisterUser.setText("");

        File carJson = new File("src/main/java/jsonDatabase/bil.json");

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

                //hente selected element sitt index
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

        loggInnButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(homePanel);
            } });

        backButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(startPanel);
            } });

        registerButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(registerUserPanel);
            } });


        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(bookingPanel);
                getBookingInfo(carReadFromfile);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterNewUser();
            }


        });

        adButton.addActionListener(new ActionListener() { //create ad button
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(createAdPanel);
            }
        });
        homeButton.addActionListener(new ActionListener() { //home button
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(homePanel);
            }
        });

        listingsButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(myListings);
                //sjekke om bruker id som ligger på car.json er lik bruker id på user.json

                //hente alle biler som man kan brukeren har leid eller leier


                DefaultListModel listModel2 = new DefaultListModel();

                list2.setModel(listModel2);

                for (Car x : carReadFromfile) {
                    listModel2.addElement(x.getBrand() + " " + x.getModel() + " " + x.getYear());
                }


                list2.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        String selected2 = list2.getSelectedValue().toString();
                        select2.setVisible(true);
                        select2.setText("Selected item is " + selected2);

                        //hente selected sin index
                        selectedIndex = list2.getSelectedIndex();

                        if(select2.isVisible()){
                            select2.setText("Selected item is " + selected2);
                            deleteButton.setVisible(true);
                        }
                    }
                });

            }
        });

        signOutButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(startPanel);
            }
        });

        clearAllButton.addActionListener(new ActionListener() { //Removes all info from fields
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearADFields(); }
        });

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

        firstNameInput.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            firstNameInput.setBackground(white);
        } });
        lastNameInput.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            lastNameInput.setBackground(white);
        } });
        ageInput.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            ageInput.setBackground(white);
        } });
        addressInput.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            addressInput.setBackground(white);
        } });
        phoneNumberInput.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            phoneNumberInput.setBackground(white);
        } });
        emailInput.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            emailInput.setBackground(white);
        } });
        passwordInput.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            passwordInput.setBackground(white);
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

    public void getBookingInfo(ArrayList<Car> carReadFromfile){
        //setter noen av input-fieldene som ikke-redigerbare
        regNumField.setEditable(false);
        brandField.setEditable(false);
        modelField.setEditable(false);
        yearField.setEditable(false);
        driveMileageField.setEditable(false);
        priceField.setEditable(false);


        int carIndex = list1.getSelectedIndex();
        //bruke selectedIndex fra homePage.java inne som carReadFromfile.get(selectedIndex)
        regNumField.setText(carReadFromfile.get(carIndex).getRegNum());
        brandField.setText(carReadFromfile.get(carIndex).getBrand());
        modelField.setText(carReadFromfile.get(carIndex).getModel());
        yearField.setText(String.valueOf(carReadFromfile.get(carIndex).getYear()));
        driveMileageField.setText(String.valueOf(carReadFromfile.get(carIndex).getDriveMileage()));
        priceField.setText(String.valueOf(carReadFromfile.get(carIndex).getPrice()));
    }

    void ChangeCard(JPanel newCard) {
        cardLayoutPanel.removeAll();
        cardLayoutPanel.add(newCard);
        cardLayoutPanel.repaint();
        cardLayoutPanel.revalidate();

        if (newCard == homePanel) {
            menuBar.setVisible(true);
            listingsButton.setVisible(true);
            signOutButton.setVisible(true);
            homeButton.setVisible(false);
            adButton.setVisible(false);
        }

        if(newCard == myListings){
            homeButton.setVisible(true);
            adButton.setVisible(true);
            listingsButton.setVisible(false);
        }

        if(newCard == createAdPanel){
            listingsButton.setVisible(true);
            adButton.setVisible(false);
            homeButton.setVisible(true);
            signOutButton.setVisible(true);
        }

        if(newCard == bookingPanel){
            homeButton.setVisible(true);
            listingsButton.setVisible(true);
            adButton.setVisible(false);
            signOutButton.setVisible(true);
        }

        if(newCard == registerUserPanel){
            menuBar.setVisible(true);
            homeButton.setVisible(false);
            listingsButton.setVisible(false);
            adButton.setVisible(false);
            signOutButton.setVisible(false);
        }

        if(newCard == startPanel){
            menuBar.setVisible(true);
            homeButton.setVisible(false);
            listingsButton.setVisible(false);
            adButton.setVisible(false);
            signOutButton.setVisible(false);
        }
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

    void RegisterNewUser() { //Validates all areas and can check if user can be created
        System.out.println("Bruker void");
        boolean fieldsNotEmpty = true; //bool for å sjekke om alle feltene har innhold
        errorRegisterUser.setText("");
        System.out.println("Bruker void1");
        System.out.println("Bruker void2");
        if (passwordInput.getText().isEmpty()) {
            errorRegisterUser.setText("Password is empty");
            passwordInput.setBackground(red);
            fieldsNotEmpty = false;
        }
        if (emailInput.getText().isEmpty()) {
            errorRegisterUser.setText("Email is empty");
            emailInput.setBackground(red);
            fieldsNotEmpty = false;
        }
        if (phoneNumberInput.getText().isEmpty()) {
            errorRegisterUser.setText("Phonenumber is empty");
            phoneNumberInput.setBackground(red);
            fieldsNotEmpty = false;
        }
        if (addressInput.getText().isEmpty()) {
            errorRegisterUser.setText("Adress is empty");
            addressInput.setBackground(red);
            fieldsNotEmpty = false;
        }
        if (ageInput.getText().isEmpty()) {
            errorRegisterUser.setText("Age is not set");
            ageInput.setBackground(red);
            fieldsNotEmpty = false;
        }
        if (lastNameInput.getText().isEmpty()) {
            errorRegisterUser.setText("Last Name is empty");
            lastNameInput.setBackground(red);
            fieldsNotEmpty = false;
        }
        if (firstNameInput.getText().isEmpty()) {
            errorRegisterUser.setText("Name is empty");
            firstNameInput.setBackground(red);
            fieldsNotEmpty = false;
        }
        if (fieldsNotEmpty) {
            int age = 0;
            try {
                age = Integer.parseInt(ageInput.getText());
            } catch (NumberFormatException e) { }
            if (firstNameInput.getText().length() < 2) { //checks if number has 7 numbers + letters
                errorRegisterUser.setText("Name is too short");
            } else if (lastNameInput.getText().length() < 2) { //checks if number has 7 numbers + letters
                errorRegisterUser.setText("Last Name is too short");
            } else if (passwordInput.getText().length() < 4) { //checks if number has 7 numbers + letters
                errorRegisterUser.setText("Password is too short");
            } else if (!ageInput.getText().matches("[0-9]+")) {
                errorRegisterUser.setText("Age can only contain numbers");
            } else if (age < 18) {
                errorRegisterUser.setText("Age is too low");
            } else if (!addressInput.getText().matches("[a-zA-Z0-9]+")) { //checks if regnr only contains letters/numbers
                errorRegisterUser.setText("Registration Number can only contain Letters and Numbers");
            } else if (!phoneNumberInput.getText().matches("[0-9]+")) {
                errorRegisterUser.setText("Phonenumber can only contain numbers");
            } else if (phoneNumberInput.getText().length() < 8) {
                errorRegisterUser.setText("Phonenumber is too short");
            } else if (phoneNumberInput.getText().length() > 8) {
                errorRegisterUser.setText("Phonenumber is too long");
            } else if (phoneNumberInput.getText().length() > 8) {
                errorRegisterUser.setText("Phonenumber is too long");
            } else if (!emailInput.getText().contains("@") || !emailInput.getText().contains(".")) {
                errorRegisterUser.setText("Email is invalid");
            } else {
                /*Her kan skjemaet sendes */
            }

        }
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
