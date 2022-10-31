package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import forms.rentYourCarGUI;
import java.io.File;


public class JsonFileHandler{

    public void userToJson(User x){
        try{
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writeValue(new File("src/main/java/jsonDatabase/userRegister.json"), x);

        } catch (final Exception e){
            e.printStackTrace();
        }


    }

    public void readUserFromJson(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File userRegister = new File("src/main/java/jsonDatabase/userRegister.json");

            User currentUser = objectMapper.readValue(userRegister, User.class);
            System.out.println(currentUser.getLastName());

        } catch (final Exception e){
            e.printStackTrace();
        }

    }
}
