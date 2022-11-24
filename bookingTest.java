import forms.rentYourCarGUI;
import org.junit.jupiter.api.Test;
import tools.Functions;

import static org.junit.jupiter.api.Assertions.*;

public class bookingTest {

    @Test
    public void Booking_Tests() { //13 tester + 1 "suksess"
        Booking_End_Time_Is_Empty();

    }


    @Test
    public void RegNr_isEmpty() {
        assertEquals(Functions.BookListingFieldCheck("", "BMW", "BMW 550D", "2015", "50000", "3000", "25-11-2022", "14:00", "27-11-2022", "14:00"), "Something went wrong, please try again later");

    }

    @Test
    public void brand_isEmpty() {
        assertEquals(Functions.BookListingFieldCheck("Bn12345", "", "BMW 550D", "2015", "50000", "3000", "25-11-2022", "14:00", "27-11-2022", "14:00"), "Something went wrong, please try again later");
    }

    @Test
    public void model_isEmpty() {
        assertEquals(Functions.BookListingFieldCheck("Bn12345", "BMW", "", "2015", "50000", "3000", "25-11-2022", "14:00", "27-11-2022", "14:00"), "Something went wrong, please try again later");
    }

    @Test
    public void year_isEmpty() {
        assertEquals(Functions.BookListingFieldCheck("Bn12345", "BMW", "BMW 550D", "", "50000", "3000", "25-11-2022", "14:00", "27-11-2022", "14:00"), "Something went wrong, please try again later");
    }

    @Test
    public void Booking_End_Time_Is_Empty() {
        assertEquals(Functions.BookListingFieldCheck("B", "B", "B", "B", "B", "B", "B", "B", "B", ""), "Booking end time cannot be empty");
    }

    @Test
    public void Booking_End_Date_Is_Empty() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "25-11-2022", "14:00", "", "14:00"), "Booking Date cannot be empty");
    }

    @Test
    public void Booking_start_time_isEmpty() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "25-11-2022", "", "26-11-2022", "14:00"), "Booking start time cannot be empty");

    }

    @Test
    public void Booking_start_date_isEmpty() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "", "14:00", "26-11-2022", "14:00"), "Booking start date cannot be empty");
    }

    @Test
    public void Start_date_year_isPast(){
        assertEquals(Functions.BookListingFieldCheck("Dn123434","BMW","BMW 550D","2015","50000","3000","25-11-2021","14:00","26-11-2022","14:00"),"StartDate year is in the past");

    }

    @Test
    public void Start_date_month_isPast() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "25-10-2022", "14:00", "26-11-2022", "14:00"), "StartDate month is in the past");
    }

    @Test
    public void End_date_year_isPast() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "25-11-2022", "14:00", "26-11-2021", "14:00"), "EndDate year is in the past");
    }

    @Test
    public void End_month_year_isPast() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "25-11-2022", "14:00", "26-10-2022", "14:00"), "EndDate month is in the past");
    }

    @Test
    public void EndDate_year_is_lower_than_StartDate_year() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "27-11-2023", "14:00", "26-11-2022", "14:00"), "EndDate year is lower than StartDate year");
    }

    @Test
    public void EndDate_month_is_lower_than_StartDate_month() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "10-12-2023", "14:00", "10-11-2023", "14:00"), "EndDate month is lower than StartDate month");
    }
    @Test
    public void EndDate_cannot_be_before_StartDate() {
        assertEquals(Functions.BookListingFieldCheck("Dn123434", "BMW", "BMW 550D", "2015", "50000", "3000", "10-12-2023", "14:00", "08-12-2023", "14:00"), "EndDate cannot be before StartDate");
    }



}







