package models;

public class User {
    int id;
    String firstName;
    String lastName;
    int age;
    String address;
    int phoneNumber;
    String eMail;
    String password;
    int balance;
    String cardNumber;
    int expireMonth;
    int expireYear;
    int cvvNumber;

    public User(){
        //creating an empty constructor to prevent error when deserializing and reading from json file.
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public User(int id, String firstName, String lastName, int age, String address, int phoneNumber,
                String eMail, String password, int balance, String cardNumber, int expireMonth, int expireYear, int cvvNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.password = password;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.cvvNumber = cvvNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(int expireMonth) {
        this.expireMonth = expireMonth;
    }

    public int getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(int expireYear) {
        this.expireYear = expireYear;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
}
