package OperationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.example.Operations.Sum;
import org.junit.jupiter.api.Test;

public class SumTest {

    @Test
    public void simpleSucces(){
        assertEquals(25, new Sum().result(12,13));        
    }

    @Test
    public void simpleFail(){
        assertNotEquals(50, new Sum().result(12,13));        
    }
}
