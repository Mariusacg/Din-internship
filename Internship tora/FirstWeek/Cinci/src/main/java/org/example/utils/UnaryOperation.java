package org.example.utils;

import java.math.BigDecimal;

@FunctionalInterface
public interface UnaryOperation {
    public BigDecimal result(BigDecimal number);
}
