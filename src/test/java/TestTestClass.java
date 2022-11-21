import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTestClass {
    public boolean two_is_not_equal_zero() {
        if (2 != 0) {
            System.out.println("test is complete");
            return true;
        } else {
            System.out.println("test is fail");
            return false;
        }
    }

    @Test
    public void tests() {
        assertEquals(two_is_not_equal_zero(), true);
    }
}
