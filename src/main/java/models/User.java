package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
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

    public User(String firstName, String lastName, int age, String address, int phoneNumber,
                String eMail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.password = password;

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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
