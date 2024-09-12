package org.example.logic;

import java.math.BigDecimal;
import java.util.Objects;

import org.example.utils.OperationEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperationPriority {
    private static final Logger logger = LoggerFactory.getLogger("InfoLogger");

    public static String calculate(String current) throws ArithmeticException, NumberFormatException {
        current = current.toLowerCase();
        logger.info("Initial operation is " + current);
        String next = null;
        for (OperationEnum operation : OperationEnum.getSortedEnumsByPriority()) {
            while (true) {
                next = Parser.oneOperationParser(current, operation);
                if (Objects.equals(next, "")) {
                    break;
                } else {
                    current = next;
                }
            }
        }
        logger.info("The result is " + current);
        return new BigDecimal(current).toString();
    }
}
