import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void firstTest() {
        System.out.println("First Test Runs First");
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void secondTest() {
        System.out.println("Second Test Tuns Second");
        assertEquals(4, 2 + 2);
    }

    @Test
    @Order(3)
    public void thirdTest() {
        System.out.println("Third Test Runs Third");
        assertNotNull(new Object());
    }
}