package org.example.utils;

import java.math.BigDecimal;

public class ExceptionThrower {
    public static BigDecimal arithmeticException(String mesage) throws ArithmeticException{
        throw new ArithmeticException(mesage);
    }
}
