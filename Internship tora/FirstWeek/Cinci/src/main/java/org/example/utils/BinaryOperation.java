package org.example.utils;

import java.math.BigDecimal;

@FunctionalInterface
public interface BinaryOperation {
   public BigDecimal result(BigDecimal number1, BigDecimal number2) throws ArithmeticException;
}
