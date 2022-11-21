import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTestClass {
    public boolean two_is_not_equal_zero() {
        if (2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void tests() {
        assertEquals(two_is_not_equal_zero(), true);
    }
}
