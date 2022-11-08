package tools;
import models.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class JsonFileHandler{

    public JsonFileHandler() {
        //creating an empty constructor to prevent error when deserializing and reading from json file.
    }

    ArrayList<Car> cars = new ArrayList<>();

    File carJson = new File("src/main/java/json/bil.json");

    ArrayList<Car> carReadFromfile = readFromJSONfile(carJson);

    //metode for å lese en JSON-fil og returnere innholdet som en ArrayList med bil-objekter
    public ArrayList<Car> readFromJSONfile(File fil) {
        ArrayList<Car> returnListe = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Car[] carArray = objectMapper.readValue(fil, Car[].class);

            returnListe.addAll(Arrays.asList(carArray));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //returnerer listen med bil-objekter lest fra JSON-fil
        return returnListe;
    }


}





