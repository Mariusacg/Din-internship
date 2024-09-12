package OperationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.example.utils.BinaryOperation;
import org.example.utils.UnaryOperation;
import org.junit.jupiter.api.Test;

public class TemplateTest {

    public static void simpleBinaryFail(BinaryOperation op, BigDecimal number1, BigDecimal number2,
            BigDecimal expected) {
        assertNotEquals(expected.setScale(2, RoundingMode.CEILING), op.result(number1, number2).setScale(2, RoundingMode.CEILING));
    }


    public static void simpleBinaryPass(BinaryOperation op, BigDecimal number1, BigDecimal number2,
            BigDecimal expected) {
        assertEquals(expected.setScale(2, RoundingMode.CEILING), op.result(number1, number2).setScale(2, RoundingMode.CEILING));
    }


    public static void simpleUnaryFail(UnaryOperation op, BigDecimal number, BigDecimal expected) {
        assertNotEquals(expected.setScale(2, RoundingMode.CEILING), op.result(number).setScale(2, RoundingMode.CEILING));
    }


    public static void simpleUnaryPass(UnaryOperation op, BigDecimal number, BigDecimal expected) {
        assertEquals(expected.setScale(2, RoundingMode.CEILING), op.result(number).setScale(2, RoundingMode.CEILING));
    }


    public static void simpleBinaryException(BinaryOperation op, BigDecimal number1, BigDecimal number2,
            ArithmeticException e) {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            op.result(number1, number2);
        });
        String expectedMessage = e.getMessage();
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    public static void simpleUnaryException(UnaryOperation op, BigDecimal number, ArithmeticException e) {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            op.result(number);
        });
        String expectedMessage = e.getMessage();
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
