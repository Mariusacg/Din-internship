package OperationTest;

import java.math.BigDecimal;

import org.example.utils.OperationEnum;
import org.example.utils.UnaryOperation;
import org.junit.jupiter.api.Test;

public class SquareRootTest {
    
    private static final UnaryOperation op = OperationEnum.SQRT.unary;

    @Test
    public void simpleSucces() {
        TemplateTest.simpleUnaryPass(op, new BigDecimal("4.0"), new BigDecimal("2.0"));
    }

    @Test
    public void simpleFail() {
        TemplateTest.simpleUnaryFail(op, new BigDecimal("4.0"), new BigDecimal("1.98"));
    }

    @Test
    public void negativeNumberException() {
        TemplateTest.simpleUnaryException(op, new BigDecimal("-100.25"), new ArithmeticException("Attempted square root of negative BigDecimal"));
    }
}
