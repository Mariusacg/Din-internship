package OperationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.example.Operations.Division;
import org.junit.jupiter.api.Test;

public class DivionTest {

    @Test
    public void simpleSucces(){
        assertEquals(7, new Division().result(175,25));        
    }

    @Test
    public void simpleFail(){
        assertNotEquals(10, new Division().result(100,20));        
    }

    @Test
    public void divisionBy0(){
        assertEquals(Integer.MAX_VALUE, new Division().result(100,0));        
    }
}
