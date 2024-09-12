package OperationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.example.Operations.Difference;
import org.junit.jupiter.api.Test;

public class DifferenceTest {

    @Test
    public void simpleSucces(){
        assertEquals(100, new Difference().result(175,75));        
    }

    @Test
    public void simpleFail(){
        assertNotEquals(50, new Difference().result(100,20));        
    }
}
