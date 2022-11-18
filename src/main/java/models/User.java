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

    public User(){
        //creating an empty constructor to prevent error when deserializing and reading from json file.
    }

    @Override
    public String toString() {
        return "User: " + firstName;
    }

    public User(int id, String firstName, String lastName, int age, String address, int phoneNumber,
                String eMail, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.password = password;

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

}
