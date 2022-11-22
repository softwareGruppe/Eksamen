import tools.Functions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PayOrderTest {

    @Test
    public void card_number_is_empty(){
        assertEquals(Functions.PayOrderFieldCheck("", "03", "24", "342"), "Cardnumber cannot be empty");
    }


    @Test
    public void expire_month_is_empty(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "", "24", "342"), "Expire Month cannot be empty");
    }

    @Test
    public void expire_year_is_empty(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "03", "", "342"), "Expire Year cannot be empty");
    }

    @Test
    public void cvv_is_empty(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "03", "24", ""), "CVV cannot be empty");
    }

    @Test
    public void card_number_not_16_digts(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658", "03", "24", "342"), "Cardnumber needs to contain 16 digits");
    }

    @Test
    public void card_number_contains_letters(){
        assertEquals(Functions.PayOrderFieldCheck("qwertyuioplkjhgf", "03", "24", "342"), "Cardnumber can only contain numbers");
    }

    @Test
    public void card_number_starts_with_0(){
        assertEquals(Functions.PayOrderFieldCheck("0386291689658267", "03", "24", "342"), "Cardnumber is invalid and cannot start with 0");
    }

    @Test
    public void expire_month_more_than_2_digits(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "243", "24", "342"), "Expire month can only contain 2 digits");
    }

    @Test
    public void expire_month_contains_letters(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "ha", "24", "342"), "Expire month can only contain numbers");
    }

    @Test
    public void expire_year_more_than_2_digits(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "09", "243", "342"), "Expire year can only contain 2 digits");
    }

    @Test
    public void expire_year_contains_letters(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "11", "he", "342"), "Expire year can only contain numbers");
    }

    @Test
    public void card_has_expired(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "10", "22", "342"), "Card has expired");
    }

    @Test
    public void cvv_more_than_3_digits(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "11", "24", "3422"), "CVV can only contain 3 digits");
    }

    @Test
    public void cvv_contains_letters(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "10", "24", "hhk"), "CVV can only contain numbers");
    }

    @Test
    public void cardInformation_is_valid(){
        assertEquals(Functions.PayOrderFieldCheck("2386291689658267", "10", "24", "342"), "");
    }
}