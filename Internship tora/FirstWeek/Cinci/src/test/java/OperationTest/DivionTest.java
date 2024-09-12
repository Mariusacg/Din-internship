package OperationTest;

import java.math.BigDecimal;

import org.example.utils.BinaryOperation;
import org.example.utils.OperationEnum;
import org.junit.jupiter.api.Test;

public class DivionTest {

    private static final BinaryOperation op = OperationEnum.DIVISION.binary;

    @Test
    public void simpleSucces() {
        TemplateTest.simpleBinaryPass(op, new BigDecimal("12.0"), new BigDecimal("6.0"), new BigDecimal("2.0"));
    }

    @Test
    public void simpleFail() {
        TemplateTest.simpleBinaryFail(op, new BigDecimal("120.69"), new BigDecimal("240.0"), new BigDecimal("2.0"));
    }

    @Test
    public void divisionBy0() {
        TemplateTest.simpleBinaryException(op, new BigDecimal("100"), new BigDecimal("0"), new ArithmeticException("You can't divide by 0!"));
    }
}
