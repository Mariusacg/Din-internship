package org.example.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.utils.OperationEnum;
import org.example.utils.Utils;

public class Parser {
    public static String oneOperationParser(String initialString, OperationEnum operation) throws ArithmeticException {
        final String regex = operation.regex;
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(initialString);

        while (matcher.find()) {
            if (matcher.group(0).contains(operation.symbol)) {
                String operationResult = operation.applyOperation(matcher.group(0));
                return initialString.replace(matcher.group(0), operationResult);
            }
        }
        return "";
    }
}
