package OperationTest;

import java.math.BigDecimal;

import org.example.utils.BinaryOperation;
import org.example.utils.OperationEnum;
import org.junit.jupiter.api.Test;

public class MultiplyTest {

    private static final BinaryOperation op = OperationEnum.MULTIPLY.binary;

    @Test
    public void simpleSucces() {
        TemplateTest.simpleBinaryPass(op, new BigDecimal("10.0"), new BigDecimal("12.0"), new BigDecimal("120.0"));
    }

    @Test
    public void simpleFail() {
        TemplateTest.simpleBinaryFail(op, new BigDecimal("10.0"), new BigDecimal("12.1"), new BigDecimal("120.0"));
    }
}
