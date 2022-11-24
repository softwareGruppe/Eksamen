import org.junit.jupiter.api.Test;
import tools.Functions;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAdTest {
    //public rentYourCarGUI rentYourCarGUI = Main.mainWindow;

    @Test
    public void Create_Ad_Tests() { /*13 tester + 1 "suksess"*/ };

    @Test
    public void Create_Ad_Succeeds_And_Does_Not_Return_Error_Message() { assertEquals(Functions.CreateAdFieldCheck("AB12345", "BMW", "Bazzar", "2029", "109", "90", "Automatic", "Diesel"), ""); }

    @Test
    public void Create_Ad_RegNr_Is_Empty() { assertEquals(Functions.CreateAdFieldCheck("", "T", "T", "T", "T", "T", "T", "T"), "Registration Number field cannot be empty"); }

    @Test
    public void Create_Ad_RegisteryNumber_Too_Short() { assertEquals(Functions.CreateAdFieldCheck("AB12", "T", "T", "T", "T", "T", "T", "T"), "Price can only contain numbers"); }

    @Test
    public void Create_Ad_CarType_Is_Empty(){ assertEquals(Functions.CreateAdFieldCheck("AB12345", "", "Loses", "232", "103", "2322", "Automatic", "Dissel"), "Car Type field cannot be empty");};

    @Test
    public void Create_Ad_CarModel_Is_Empty(){ assertEquals(Functions.CreateAdFieldCheck("AB12345", "BmW", "", "232", "103", "2322", "Automatic", "Dissel"), "Car model field cannot be empty");};

    @Test
    public void Create_Ad_YearModel_Is_Empty(){ assertEquals(Functions.CreateAdFieldCheck("AB12345", "BmW", "Baxx", "", "103", "2322", "Automatic", "Dissel"), "Year model field cannot be empty");};

    @Test
    public void Create_Ad_mileage_Is_Empty(){ assertEquals(Functions.CreateAdFieldCheck("AB12345", "BmW", "Baxx", "2003", "", "2322", "Automatic", "Dissel"), "Mileage field cannot be empty");};

    @Test
    public void Create_Ad_pricePerDay_Is_Empty(){ assertEquals(Functions.CreateAdFieldCheck("AB12345", "BmW", "Baxx", "2003", "2012002", "", "Automatic", "Dissel"), "Price field cannot be empty");};

    @Test
    public void Create_Ad_regNr_Is_Too_Short(){ assertEquals(Functions.CreateAdFieldCheck("AB1234", "BmW", "Baxx", "2003", "2012002", "230203", "Automatic", "Dissel"), "Registration Number is too short");};

    @Test
    public void Create_Ad_regNr_Is_Too_Long(){ assertEquals(Functions.CreateAdFieldCheck("AB12342323", "BmW", "Baxx", "2003", "2012002", "230203", "Automatic", "Dissel"), "Registration Number is too long");};

    @Test
    public void Create_Ad_regNr_Contain_All(){ assertEquals(Functions.CreateAdFieldCheck("AB@$23&", "BmW", "Baxx", "2003", "2012002", "230203", "Automatic", "Dissel"), "Registration Number can only contain Letters and Numbers");};

    @Test
    public void Create_Ad_Mileage_Contain_Letters_And_Numbers(){ assertEquals(Functions.CreateAdFieldCheck("AB12432", "BmW", "Baxx", "2003", "234Ab$", "230203", "Automatic", "Dissel"), "Mileage can only contain numbers");};

    @Test
    public void Create_Ad_PricePerDay_Contain_Letters_And_Numbers(){ assertEquals(Functions.CreateAdFieldCheck("AB12432", "BmW", "Baxx", "2003", "234234", "23B20@3", "Automatic", "Dissel"), "Price can only contain numbers");};

    @Test
    public void Create_Ad_price_Is_Zero(){ assertEquals(Functions.CreateAdFieldCheck("AB12432", "BmW", "Baxx", "2003", "234234", "0", "Automatic", "Dissel"), "Price cannot be 0");};

}
