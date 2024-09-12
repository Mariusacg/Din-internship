package OperationTest;

import java.math.BigDecimal;

import org.example.utils.OperationEnum;
import org.example.utils.UnaryOperation;
import org.junit.jupiter.api.Test;

public class DecrementTest {

    private static final UnaryOperation op = OperationEnum.DECREMENT.unary;

    @Test
    public void simpleSucces() {
        TemplateTest.simpleUnaryPass(op, new BigDecimal("200.0"), new BigDecimal("199.0"));
    }

    @Test
    public void simpleFail() {
        TemplateTest.simpleUnaryFail(op, new BigDecimal("200.0"), new BigDecimal("201.0"));
    }
}
