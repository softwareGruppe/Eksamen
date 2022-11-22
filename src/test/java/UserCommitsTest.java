import models.Car;
import org.junit.jupiter.api.Test;
import tools.Functions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCommitsTest {
    @Test
    public void Sign_Out_User() { assertTrue(Functions.LogOutUser()); }
    @Test
    public void Sign_In_User() { assertTrue(Functions.LogInnUser("Sensor", 6)); }
    @Test
    public void Get_Listings_From_User() {
        assertNotNull(Functions.GetListings(6));
        ArrayList<Car> carList = Functions.GetListings(6);
        assertNotEquals(carList.size(), 0);
        assertNotEquals(carList.size(), 1);
    }
    @Test
    public void Delete_Booking() { assertTrue(Functions.DeleteAction(2,0)); }
    @Test
    public void Delete_Listing() { assertTrue(Functions.DeleteAction(1,0)); }
}
