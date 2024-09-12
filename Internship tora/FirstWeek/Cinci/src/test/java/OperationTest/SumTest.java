package OperationTest;

import java.math.BigDecimal;

import org.example.utils.BinaryOperation;
import org.example.utils.OperationEnum;
import org.junit.jupiter.api.Test;

public class SumTest {

    private static final BinaryOperation op = OperationEnum.ADD.binary;

    @Test
    public void simpleSucces() {
        TemplateTest.simpleBinaryPass(op, new BigDecimal("13.2"), new BigDecimal("12.1"), new BigDecimal("25.3"));
    }

    @Test
    public void simpleFail() {
        TemplateTest.simpleBinaryFail(op, new BigDecimal("13.2"), new BigDecimal("12.1"), new BigDecimal("25"));
    }
}
