package forms;

import models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tools.JsonFileHandler;

public class rentYourCarGUI extends JFrame {

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

    public rentYourCarGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        greenButton.setText("Home"); //kan endre navnet på knappene, og kan potensielt brukes til å gjøre flere ting-
        blueButton.setText("Create Ad"); //- basert på hvilken side du er på

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

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutPanel.removeAll();
                cardLayoutPanel.add(createAdPanel);
                cardLayoutPanel.repaint();
                cardLayoutPanel.revalidate();
            }
        });
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutPanel.removeAll();
                cardLayoutPanel.add(registerUserPanel);
                cardLayoutPanel.repaint();
                cardLayoutPanel.revalidate();
            }
        });

        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClearADFields(); } });

        //gearboxComboBox.getModel(gearboxModel);
        //fuelComboBox.getModel(fuelModel)



    }

    void ClearADFields() {
        regnrField.setText("");
        cartypeField.setText("");
        carmodelField.setText("");
        yearmodelField.setText("");
        mileageField.setText("");
        priceperdayField.setText("");
    }

}
