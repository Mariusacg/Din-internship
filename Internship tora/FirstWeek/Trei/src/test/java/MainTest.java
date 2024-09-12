import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    int depaseste= Integer.MAX_VALUE / 2 + 2;

    @Test
    public void merge() {
        try{
            assertEquals(Main.adunare(31, 19), 50);
        }
        catch (Exception e)
        {
        }

    }
    @Test
    public void valNegativa() {
        
        Exception exception = assertThrows(Exception.class,() -> Main.adunare(-321, 12));
        
        String expectedMessage = "Nu se accepta numere negative";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void valPreamare() {

        Exception exception = assertThrows(Exception.class,() -> Main.adunare(depaseste + 123, 12));
        
        String expectedMessage = "Numarul prea mare ca input";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}