package OperationTest;

import java.math.BigDecimal;

import org.example.utils.BinaryOperation;
import org.example.utils.OperationEnum;
import org.junit.jupiter.api.Test;

public class MinTest {
        private static final BinaryOperation op = OperationEnum.MIN.binary;

    @Test
    public void simpleSucces() {
        TemplateTest.simpleBinaryPass(op, new BigDecimal("12.1"), new BigDecimal("12.2"), new BigDecimal("12.1"));
    }

    @Test
    public void simpleFail() {
        TemplateTest.simpleBinaryFail(op, new BigDecimal("12.2"), new BigDecimal("12.1"), new BigDecimal("12.2"));
    }
}
