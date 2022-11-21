package forms;

import models.User;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.Car;
import tools.DateTimeHandler;
import tools.JsonFileHandler;
import java.io.File;
import java.util.ArrayList;

public class rentYourCarGUI extends JFrame {

    Color white = Color.decode("#FFFFFF");
    Color whitegray = Color.decode("#EFEFEF");
    Color red = Color.decode("#FF000A");
    User currentUser = new User();
    int userIndex = 0;
    Car currentlyBooking = new Car();
    int currentlyBookingIndex = 0;
    DateTimeHandler dateTimeHandler = new DateTimeHandler();
    ArrayList<Car> carList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
            //ArrayList<Booking> bookList = new ArrayList<>();
    DefaultListModel<Car> listModel = new DefaultListModel();
    DefaultListModel<Car> listModel2 = new DefaultListModel();
    DefaultListModel<User> listModel3 = new DefaultListModel<>();
    DefaultListModel<Car> listModel4 = new DefaultListModel();
    int MyListingLastSelect = 0;
    private JPanel menuBar;
    private JOptionPane enWarning;
    private JPanel mainPanel;
    private JPanel cardLayoutPanel;
    private JPanel registerUserPanel;
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField ageInput;
    private JTextField addressInput;
    private JTextField phoneNumberInput;
    private JTextField emailInput;
    private JTextField passwordInput;
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


    //Sign-in panel
    private JButton signOutButton;
    private JPanel signInUserPanel;
    private JList<User> list3;
    private JButton signInButton;

    //home page
    private JPanel homePanel;
    JsonFileHandler jfh = new JsonFileHandler();
    private JLabel homePageLabel;
    private javax.swing.JScrollPane JScrollPane;
    private JList<Car> list1;
    private JButton bookSelectedCarButton;
    private JLabel select;

    //My listings page
    private JPanel myListings;
    private JPanel deletePanel;
    private JButton deleteButton;
    private JList<Car> list2;
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
    private JButton bookButton; //Field
    private JLabel errorBookingPage;
    private JList<Car> list4;
    private JLabel welcomeUserLabel;
    private JLabel todaydateLabel;
    private JLabel errorSignIn;
    private JButton backButton;
    private JPanel paymentPanel;
    private JLabel errorPayment;
    private JPanel orderConfirmationPanel;
    private JButton backToMyListingsButton;
    private JButton payOrderButton;
    private JTextField cardNumberField;
    private JTextField expireMonthField;
    private JTextField expireYearField;
    private JTextField cvvField;
    private JCheckBox savePaymentInformationForCheckBox;
    private JTextArea yourbookingArea;
    private JButton addToBalanceButton;
    private JLabel balanceLabel;


    public rentYourCarGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(1000, 800);

        ChangeCard(startPanel);
        menuBar.setVisible(true);

        bookSelectedCarButton.setVisible(false);
        select.setVisible(false);
        deleteButton.setVisible(false);
        select2.setVisible(false);
        errorSignIn.setVisible(false);
        errorPayment.setVisible(false);
        addToBalanceButton.setVisible(false);
        balanceLabel.setVisible(false);
        JScrollPane.getVerticalScrollBar().setUnitIncrement(30);
        JScrollPane2.getVerticalScrollBar().setUnitIncrement(30);
        JScrollPane3.getVerticalScrollBar().setUnitIncrement(30);

        welcomeUserLabel.setText("");
        todaydateLabel.setText("");


        list1.setModel(listModel);
        list2.setModel(listModel2);
        list3.setModel(listModel3);
        list4.setModel(listModel4);


        listingsButton.setText("My listings");
        homeButton.setText("Home");
        adButton.setText("Create Ad");
        signOutButton.setText("Sign out");
        errorSignIn.setText("");
        errorCreateAdField.setText("");
        errorBookingPage.setText("");

        File carJson = new File("src/main/java/jsonDatabase/car.json");

        carList = jfh.readCarFromJSONfile();
        //bookList = jfh.readBookingFromJSONfile();

        GetHomePageListings();

        File userJson = new File("src/main/java/jsonDatabase/user.json");

        userList = jfh.readUserFromJSONfile();

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getSelectedCar();
            }
        });
        list4.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Car carInfo = list4.getSelectedValue();
                    System.out.println(carInfo);
                    System.out.println(list4.getSelectedValue());
                    select2.setVisible(true);
                    select2.setText(carInfo.GetBookingInfo());
                    if (!select2.getText().isEmpty()) {
                        deleteButton.setVisible(true);
                    }
                    MyListingLastSelect = 2;
                    list2.clearSelection();

                } catch (IndexOutOfBoundsException n) {
                    System.out.println("List has no value selected");
                } catch (NullPointerException n) {
                    System.out.println("No car selected");
                }
            }
        });

        loggInnButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(signInUserPanel);
                getAllusers(userList);
                System.out.println(userList);
            } });


        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list3.getSelectedValue() != null) {
                    currentUser = list3.getSelectedValue();
                    userIndex = list3.getSelectedIndex();
                    errorSignIn.setVisible(false);
                    errorSignIn.setText("");
                    addToBalanceButton.setVisible(true);
                    balanceLabel.setVisible(true);
                    ChangeCard(homePanel);
                    System.out.println(currentUser.toString());
                    welcomeUserLabel.setText("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName());
                    todaydateLabel.setText(dateTimeHandler.GetTodaysDate());
                } else {
                    errorSignIn.setVisible(true);
                    errorSignIn.setText("Please choose a user");
                }
            }
        });

        addToBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateBalance(1000);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(startPanel);
                ClearSelections();
            }
        });
        backToMyListingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(myListings);
                ClearSelections();
            }
        });

        payOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PayOrder();
            }
        });

        //legge en annen logg inn knapp som tar oss videre til hjemmesiden

        bookSelectedCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCard(bookingPanel);
                getBookingInfo(carList);
            }
        });
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookListing();
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
                GetHomePageListings();
                ClearSelections();
            }
        });

        listingsButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(myListings);
                GetMyListingsPageListings();
                ClearSelections();
            }
        });

        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getMySelectedCar();
                MyListingLastSelect = 1;
                list4.clearSelection();
            }
        });

        signOutButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                ChangeCard(startPanel);
                welcomeUserLabel.setText("");
                todaydateLabel.setText("");
                ClearSelections();
            }
        });

        clearAllButton.addActionListener(new ActionListener() { //Removes all info from fields
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearADFields(); }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MyListingLastSelect == 0) {

                } else if (MyListingLastSelect == 1){
                    int deleteAnswer = enWarning.showConfirmDialog(
                            mainPanel,
                            "Would you like to delete the car?",
                            "Delete car?",
                            JOptionPane.WARNING_MESSAGE,
                            JOptionPane.YES_NO_OPTION);
                    if (deleteAnswer == 0) {
                        Car car = list2.getSelectedValue();
                        int indexCarToDelete = carList.indexOf(car);
                        carList.remove(car);
                        GetMyListingsPageListings();
                        GetHomePageListings();
                        jfh.WriteCarToJSONfile(carList);
                    } else if (deleteAnswer == 2) {
                    }
                } else if (MyListingLastSelect == 2){
                    int deleteAnswer = enWarning.showConfirmDialog(
                            mainPanel,
                            "Would you like to delete this booking?",
                            "Delete booking?",
                            JOptionPane.WARNING_MESSAGE,
                            JOptionPane.YES_NO_OPTION);
                    if (deleteAnswer == 0) {
                        Car changeCar = list4.getSelectedValue();
                        int changeCarIndex = carList.indexOf(changeCar);
                        changeCar.setTenantId(0);
                        changeCar.setBookingStartDate(null);
                        changeCar.setBookingStartTime(null);
                        changeCar.setBookingEndDate(null);
                        changeCar.setBookingEndTime(null);
                        changeCar.setAvailable(true);
                        carList.set(changeCarIndex, changeCar);
                        jfh.WriteCarToJSONfile(carList);
                        GetMyListingsPageListings();
                        GetHomePageListings();
                    } else if (deleteAnswer == 2) {
                    }
                }
            }
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
                ClearSelections();
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
        bookingStartDateField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            bookingStartDateField.setBackground(white);
        } });
        bookingStartTimeField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            bookingStartTimeField.setBackground(white);
        } });
        bookingEndDateField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            bookingEndDateField.setBackground(white);
        } });
        bookingEndTimeField.addCaretListener(new CaretListener() { @Override public void caretUpdate(CaretEvent e) {
            bookingEndTimeField.setBackground(white);
        } });
    }

    void ClearSelections() {
        bookSelectedCarButton.setVisible(false);
        select.setText("");
        select2.setText("");
        deleteButton.setVisible(false);
        errorSignIn.setText("");
        errorBookingPage.setText("");
        errorCreateAdField.setText("");
        errorPayment.setText("");
        list1.clearSelection();
        list2.clearSelection();
        list3.clearSelection();
        list4.clearSelection();
    }

    public void getBookingInfo(ArrayList<Car> carList){
        //setter noen av input-fieldene som ikke-redigerbare
        regNumField.setEditable(false);
        brandField.setEditable(false);
        modelField.setEditable(false);
        yearField.setEditable(false);
        driveMileageField.setEditable(false);
        priceField.setEditable(false);


        int carIndex = list1.getSelectedIndex();
        //bruke selectedIndex fra homePage.java inne som carList.get(selectedIndex)
        regNumField.setText(carList.get(carIndex).getRegNum());
        brandField.setText(carList.get(carIndex).getBrand());
        modelField.setText(carList.get(carIndex).getModel());
        yearField.setText(String.valueOf(carList.get(carIndex).getYear()));
        driveMileageField.setText(String.valueOf(carList.get(carIndex).getDriveMileage()));
        priceField.setText(String.valueOf(carList.get(carIndex).getPrice()));
    }

    public void GetHomePageListings(){
        //refresh Car-list in homepage
        try {
            select.setText("");
            list1.clearSelection();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        listModel.clear();
        for (Car x : carList) {
            listModel.addElement(x);
        }
        list1.updateUI();
    }

    public void getSelectedCar(){
        try {
            Car car = list1.getSelectedValue();
            currentlyBookingIndex = list1.getSelectedIndex();
            select.setVisible(true);

            //hente selected element sitt index
            int selectedIndex = list1.getSelectedIndex();
            //fjerne book knappen hvis bilen er booket eller bare gi en melding om at bilen er booket
            Car selectedCar = carList.get(selectedIndex);
            boolean status = selectedCar.getAvailable();
            if(!status){ //not avaliable
                if(select.isVisible()){
                    bookSelectedCarButton.setVisible(false);
                    if (selectedCar.getTenantId() == currentUser.getId()) {
                        select.setText("You are already booking this car");
                    } else {
                        select.setText("Selected car " + car.toString() + " is booked");
                    }
                }
            } else { //is avaliable
                if (carList.get(selectedIndex).getOwnerId() == currentUser.getId()){
                    bookSelectedCarButton.setVisible(false);
                    select.setText("The car " + car.toString() + " is your listing");
                } else {
                    select.setText("Selected item is " + car.toString());
                    if(select.isVisible()){
                        bookSelectedCarButton.setVisible(true);
                    }
                }
            }
        } catch (IndexOutOfBoundsException n) {
            System.out.println("List does not have a selected value");
        }
    }

    public void getAllusers(ArrayList<User> userList) {
        //HENTE ALLE BRUKERE
        //vi tester om det funker med biljson
        list3.clearSelection();
        listModel3.clear();
        for (User x : userList) {
            listModel3.addElement(x);
        }
        System.out.println(listModel3.size());
        list3.updateUI();
    }

    public void GetMyListingsPageListings(){
        list2.clearSelection();
        list4.clearSelection();
        listModel2.clear();
        listModel4.clear();

        for (Car x : carList) {
            if (x.getOwnerId() == currentUser.getId()) {
                listModel2.addElement(x);}
            if (x.getTenantId() == currentUser.getId()) {
                listModel4.addElement(x);}
        }
        list2.updateUI();
        list4.updateUI();
    }

    public void getMySelectedCar(){
        try {
            String selected2 = list2.getSelectedValue().toString();
            select2.setVisible(true);
            select2.setText("Selected item is " + selected2);

            //hente selected sin index
            selectedIndex = list2.getSelectedIndex();

            if(select2.isVisible()){
                select2.setText("Selected item is " + selected2);
                deleteButton.setVisible(true);
            }
        } catch (NullPointerException n) {
            select2.setText("");
        }
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
            UpdateBalance(0);
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
            addToBalanceButton.setVisible(false);
            balanceLabel.setVisible(false);
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

    void ClearBookFields() {
        regnrField.setText("");
        brandField.setText("");
        modelField.setText("");
        yearField.setText("");
        driveMileageField.setText("");
        priceField.setText("");
        bookingStartDateField.setText("");
        bookingStartTimeField.setText("");
        bookingEndDateField.setText("");
        bookingEndTimeField.setText("");
    }

    void GearBoxChange(int state) { //function to change radiobutton values under Gearbox
        automatRadioButton.setSelected(false);
        manuellRadioButton.setSelected(false);
        int selec = 0;
        if (automatRadioButton.isSelected()) {
            selec = 1;
        } else if (manuellRadioButton.isSelected()) {
            selec = 2;
        }

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

    void BookListing() {
        boolean fieldsNotEmpty = true; //bool for å sjekke om alle feltene har innhold
        errorBookingPage.setText("");
        if (bookingStartDateField.getText().isEmpty()) {
            errorCreateAdField.setText("Booking Date cannot be empty");
            bookingStartDateField.setBackground(red); fieldsNotEmpty = false;
        }
        if (bookingStartTimeField.getText().isEmpty()) {
            errorBookingPage.setText("Booking Date cannot be empty");
            bookingStartTimeField.setBackground(red); fieldsNotEmpty = false;
        }
        if (bookingEndDateField.getText().isEmpty()) {
            errorBookingPage.setText("Booking Date cannot be empty");
            bookingEndDateField.setBackground(red); fieldsNotEmpty = false;
        }
        if (bookingEndTimeField.getText().isEmpty()) {
            errorBookingPage.setText("Booking Date cannot be empty");
            bookingEndTimeField.setBackground(red); fieldsNotEmpty = false;
        }
        if (regNumField.getText().isEmpty() || brandField.getText().isEmpty() || modelField.getText().isEmpty() || yearField.getText().isEmpty()) {
            errorBookingPage.setText("Something went wrong, please try again later");
        } else
        if (fieldsNotEmpty) { //Dato kan senest være x måneder i framtiden
            try {
                if (bookingStartDateField.getText().contains(".")) {
                    String[] SDF = bookingStartDateField.getText().split(".");
                    bookingStartDateField.setText(SDF[0] + "-" + SDF[1] + "-" + SDF[2]); }
                if (bookingEndDateField.getText().contains(".")) {
                    String[] SDF = bookingEndDateField.getText().split(".");
                    bookingEndDateField.setText(SDF[0] + "-" + SDF[1] + "-" + SDF[2]); }
                String todaysDate = dateTimeHandler.GetTodaysDate();
                String[] td1 = todaysDate.split("-"); //0 - dd, 1 - mm, 2 - yyyy
                String startDate = bookingStartDateField.getText();
                String[] sd1 = startDate.split("-"); //0 - dd, 1 - mm, 2 - yyyy
                String endDate = bookingEndDateField.getText();
                String[] ed1 = endDate.split("-"); //0 - dd, 1 - mm, 2 - yyyy
                String startTime = bookingStartTimeField.getText();
                String[] st1 = startTime.split(":"); //0 - hh, 1 - mm
                int startTimeCorrect = dateTimeHandler.CheckTimeFormat(st1);
                String endTime = bookingEndTimeField.getText();
                String[] et1 = endTime.split(":"); //0 - hh, 1 - mm
                int endTimeCorrect = dateTimeHandler.CheckTimeFormat(et1);
                if (startTimeCorrect == 2 && endTimeCorrect == 2) {
                    //Start date
                    if (dateTimeHandler.DateComparison(sd1,td1) == 1) {
                        errorBookingPage.setText("StartDate year is in the past");
                    } else if (dateTimeHandler.DateComparison(sd1,td1) == 2) {
                        errorBookingPage.setText("StartDate month is in the past");
                    } else if (dateTimeHandler.DateComparison(sd1,td1) == 3) {
                        errorBookingPage.setText("Cars can be booked at least one day after the application date");
                    } else { //End date
                        if (dateTimeHandler.DateComparison(ed1,td1) == 1) {
                            errorBookingPage.setText("EndDate year is in the past");
                        } else if (dateTimeHandler.DateComparison(ed1,td1) == 2) {
                            errorBookingPage.setText("EndDate month is in the past");
                        } else if (dateTimeHandler.DateComparison(ed1,td1) == 3) {
                            errorBookingPage.setText("EndDate must be at least one day after start date");
                        } else { //Is EndDate after StartDate
                            if (dateTimeHandler.DateComparison(ed1,sd1) == 1) {
                                errorBookingPage.setText("EndDate year is lower than StartDate year");
                            } else if (dateTimeHandler.DateComparison(ed1,sd1) == 2) {
                                errorBookingPage.setText("EndDate month is lower than StartDate month");
                            } else if (dateTimeHandler.DateComparison(ed1,sd1) == 3) {
                                errorBookingPage.setText("EndDate cannot be before StartDate");
                            } else {
                                Car newBooking = new Car();
                                String Regnr = regNumField.getText();
                                newBooking = carList.get(currentlyBookingIndex);
                                System.out.println(newBooking.getBookingStartDate());
                                newBooking.setTenantId(currentUser.getId()); //i JSON, sjekker hvilken bruker som er logget inn og setter verdien til bruker id
                                newBooking.setBookingStartDate(bookingStartDateField.getText());
                                newBooking.setBookingStartTime(bookingStartTimeField.getText());
                                newBooking.setBookingEndDate(bookingEndDateField.getText());
                                newBooking.setBookingEndTime(bookingEndTimeField.getText());
                                currentlyBooking = newBooking;
                                System.out.println("Car availability " + newBooking.getAvailable());

                                if (newBooking.getAvailable() == true) {
                                    try {
                                        if (currentUser.getCardNumber().length() == 16) {
                                            cardNumberField.setText(currentUser.getCardNumber());
                                            expireMonthField.setText(String.valueOf(currentUser.getExpireMonth()));
                                            expireYearField.setText(String.valueOf(currentUser.getExpireYear()));
                                            cvvField.setText(String.valueOf(currentUser.getCvvNumber()));
                                        }
                                    } catch (NullPointerException n) {
                                        System.out.println("No card saved");
                                    }
                                    newBooking.setAvailable(false);
                                    if (currentUser.getCardNumber().length() == 16) {
                                        savePaymentInformationForCheckBox.setVisible(false);
                                    } else {
                                        savePaymentInformationForCheckBox.setVisible(true);
                                    }
                                    ClearBookFields();
                                    ChangeCard(paymentPanel);
                                } else {
                                    errorBookingPage.setText("Booking failed, please try again later");
                                }
                            }
                        }
                    }
                } else {
                    errorBookingPage.setText("Start or Endtime is invalid");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                errorBookingPage.setText("Date or Time Format is wrong (DD-MM-YYYY, HH:MM)");
            }
        }
    }

    int CreateAd() { //Validates all areas and can check if it is able to be proccessed
        int errorVariabel = 0;
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
                Car newAd = new Car();
                newAd.setOwnerId(currentUser.getId());
                newAd.setRegNum(regnrField.getText());
                newAd.setBrand(cartypeField.getText());
                newAd.setModel(carmodelField.getText());
                newAd.setYear(Integer.parseInt(yearmodelField.getText()));
                String gearbox = "";
                String fuel = "";
                if (automatRadioButton.isSelected()) {
                    gearbox = "Automatic";
                } else if (manuellRadioButton.isSelected()) {
                    gearbox = "Manual";
                }
                if (elbilRadioButton.isSelected()) {
                    fuel = "Electric";
                } else if (dieselRadioButton.isSelected()) {
                    fuel = "Diesel";
                } else if (bensinRadioButton.isSelected()) {
                    fuel = "Petrol";
                }
                newAd.setGearbox(gearbox);
                newAd.setFuel(fuel);
                newAd.setDriveMileage(Integer.parseInt(mileageField.getText()));
                newAd.setPrice(Integer.parseInt(priceperdayField.getText()));
                newAd.setAvailable(true);
                int fault = 0; //0 is all clear
                for (Car x : carList) {
                    if (x.getRegNum().equals(newAd.getRegNum())) {
                        fault = 1;
                    }
                }
                if (gearbox.equals("Manual") && fuel.equals("Electric")) {
                    fault = 2;
                }

                if (fault == 0) {
                    carList.add(newAd);
                    jfh.WriteCarToJSONfile(carList);
                    ClearADFields();
                    ChangeCard(myListings);
                    GetMyListingsPageListings();
                    GetHomePageListings();
                } else if (fault == 1) {
                    errorCreateAdField.setText("Warning: Registration Number already exists!");
                } else if (fault == 2) {
                    errorCreateAdField.setText("Electric vehicles does not support manual gearbox");
                }
            }

        }
        return errorVariabel;
    }

    int PayOrder() {
        boolean fieldsNotEmpty = true; //bool for å sjekke om alle feltene har innhold
        errorPayment.setText("");
        errorPayment.setVisible(false);
        if (cvvField.getText().isEmpty()) {
            errorPayment.setText("CVV cannot be empty");
            errorPayment.setVisible(true); fieldsNotEmpty = false;
        }
        if (expireYearField.getText().isEmpty()) {
            errorPayment.setText("Expire Year cannot be empty");
            errorPayment.setVisible(true); fieldsNotEmpty = false;
        }
        if (expireMonthField.getText().isEmpty()) {
            errorPayment.setText("Expire Month cannot be empty");
            errorPayment.setVisible(true); fieldsNotEmpty = false;
        }
        if (cardNumberField.getText().isEmpty()) {
            errorPayment.setText("Cardnumber cannot be empty");
            errorPayment.setVisible(true); fieldsNotEmpty = false;
        }
        if (fieldsNotEmpty) {
            String todaysdate = dateTimeHandler.GetTodaysDate();
            String[] dates = todaysdate.split("-");
            System.out.println(dates[2].substring(dates[2].length()-2));
            if (cardNumberField.getText().length() != 16) {
                errorPayment.setText("Cardnumber needs to contain 16 digits");
                errorPayment.setVisible(true);
            }
            else if (!cardNumberField.getText().matches("[0-9]+")) {
                errorPayment.setText("Cardnumber can only contain numbers");
                errorPayment.setVisible(true);
            }
            else if(cardNumberField.getText().startsWith("0")) {
                errorPayment.setText("Cardnumber is invalid and cannot start with 0");
                errorPayment.setVisible(true);
            }
            else if (expireMonthField.getText().length() != 2) {
                errorPayment.setText("Expire month can only contain 2 digits");
                errorPayment.setVisible(true);
            }
            else if (!expireMonthField.getText().matches("[0-9]+")) {
                errorPayment.setText("Expire month can only contain numbers");
                errorPayment.setVisible(true);
            }
            else if (expireYearField.getText().length() != 2) {
                errorPayment.setText("Expire year can only contain 2 digits");
                errorPayment.setVisible(true);
            }
            else if (!expireYearField.getText().matches("[0-9]+")) {
                errorPayment.setText("Expire year can only contain numbers");
                errorPayment.setVisible(true);
            }
            else if (dates[2].substring(dates[2].length()-2).equals(expireYearField.getText())) {
                if (Integer.parseInt(dates[1]) >= Integer.parseInt(expireMonthField.getText())) {
                    errorPayment.setText("Card has expired");
                    errorPayment.setVisible(true);
                }
            }
            else if (cvvField.getText().length() != 3) {
                errorPayment.setText("CVV can only contain 3 digits");
                errorPayment.setVisible(true);
            }
            else if (!cvvField.getText().matches("[0-9]+")) {
                errorPayment.setText("CVV can only contain numbers");
                errorPayment.setVisible(true);
            } else {//ALL INFO CORRECT
                if (currentUser.getBalance() >= currentlyBooking.getPrice()) {
                    UpdateBalance(-currentlyBooking.getPrice());
                    if (savePaymentInformationForCheckBox.isSelected()) {
                        currentUser.setCardNumber(cardNumberField.getText());
                        currentUser.setExpireMonth(Integer.parseInt(expireMonthField.getText()));
                        currentUser.setExpireYear(Integer.parseInt(expireYearField.getText()));
                        currentUser.setCvvNumber(Integer.parseInt(cvvField.getText()));
                    }
                    userList.set(userIndex, currentUser);
                    jfh.WriteUserToJSONfile(userList);
                    jfh.WriteCarToJSONfile(carList);
                    yourbookingArea.setText("You have booked " + currentlyBooking.getBrand() +
                            " " + currentlyBooking.getModel() + " " + currentlyBooking.getYear() +
                            "\nWith Registration Number " + currentlyBooking.getRegNum() + "\nYour booking starts: "
                            + currentlyBooking.getBookingStartDate() + " T:" + currentlyBooking.getBookingStartTime() +
                            "\nBooking ends: " + currentlyBooking.getBookingEndDate() + " T:" +
                            currentlyBooking.getBookingEndTime() + "\nYour wallet have been charged with " + currentlyBooking.getPrice() + " kr" + "\n Your Balance is now " + currentUser.getBalance() + " kr.");
                    ChangeCard(orderConfirmationPanel);
                    ClearSelections();
                    GetMyListingsPageListings();
                } else {
                    errorPayment.setText("Payment declined, you're broke");
                }
            }
        }
        return 0;
    }

    void UpdateBalance(int amount) {
        currentUser.setBalance(currentUser.getBalance() + amount);
        userList.set(userIndex, currentUser);
        jfh.WriteUserToJSONfile(userList);
        balanceLabel.setText("Current Balance: " + currentUser.getBalance() + " kr");
    }

}
