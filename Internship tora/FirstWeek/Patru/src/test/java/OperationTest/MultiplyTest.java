package OperationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.example.Operations.Multiply;
import org.junit.jupiter.api.Test;

public class MultiplyTest {

    @Test
    public void simpleSucces(){
        assertEquals(500, new Multiply().result(10,50));        
    }

    @Test
    public void simpleFail(){
        assertNotEquals(15, new Multiply().result(4,4));        
    }
}
