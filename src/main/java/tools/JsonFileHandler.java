package tools;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.Car;
import models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class JsonFileHandler {
    public JsonFileHandler() {
        //creating an empty constructor to prevent error when deserializing and reading from json file.
    }

    ArrayList<Car> cars = new ArrayList<>();

    File carJson = new File("src/main/java/jsonDatabase/car.json");

    ArrayList<Car> carList = readCarFromJSONfile();

    ArrayList<User> user = new ArrayList<>();

    File userJson = new File("src/main/java/jsonDatabase/user.json");

    ArrayList<User> userList = readUserFromJSONfile();


    //metode for å lese en JSON-fil og returnere innholdet som en ArrayList med bil-objekter
    public ArrayList<Car> readCarFromJSONfile() {
        ArrayList<Car> returnCarListe = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Car[] carArray = objectMapper.readValue(carJson, Car[].class);

            returnCarListe.addAll(Arrays.asList(carArray));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //returnerer listen med bil-objekter lest fra JSON-fil
        return returnCarListe;
    }

    //metode for å lese en JSON-fil og returnere innholdet som en ArrayList med user-objekter
    public ArrayList<User> readUserFromJSONfile() {

        ArrayList<User> returnUserListe = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            User[] userArray = objectMapper.readValue(userJson, User[].class);

            returnUserListe.addAll(Arrays.asList(userArray));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //returnerer listen med user-objekter lest fra JSON-fil
        return returnUserListe;
    }
    public void WriteCarToJSONfile(ArrayList<Car> cars) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(carJson, cars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void WriteUserToJSONfile(ArrayList<User> users) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(userJson, users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
